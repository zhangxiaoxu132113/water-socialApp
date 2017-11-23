package com.water.db.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.water.db.service.interfaces.ITArticleService;
import com.water.es.entry.ESDocument;
import com.water.utils.SerializeHelper;
import com.water.utils.cache.CacheManager;
import com.water.utils.common.CacheKey;
import com.water.utils.common.Constants;
import com.water.utils.web.view.ResultView;
import com.water.uubook.dao.TbUbArticleMapper;
import com.water.uubook.dao.TbUbCourseMapper;
import com.water.uubook.model.TbUbArticle;
import com.water.uubook.model.TbUbUser;
import com.water.uubook.model.dto.TbUbArticleDto;
import com.water.uubook.service.TbUbTagService;
import com.water.uubook.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service("iTArticleService")
public class ITArticleServiceImpl implements ITArticleService {
    @Resource
    private TbUbArticleMapper iTArticleMapper;

    @Resource
    private CacheManager cacheManager;

    @Resource
    private TbUbTagService tagService;

    private LoadingCache<String, Object> cacheLocal;

    private static final Log logger = LogFactory.getLog(ITArticleServiceImpl.class);

    @Resource
    private com.water.es.api.Service.IArticleService esArticleService;

    public TbUbArticleDto getArticleDetailById(Integer articleId) {
        if (articleId == null || articleId < 0) {
            throw new RuntimeException("文章id不合法！");
        }
        TbUbArticle article = iTArticleMapper.selectByPrimaryKey(articleId);
        TbUbArticleDto articleDto = null;
        if (article != null) {
            articleDto = new TbUbArticleDto();
            BeanUtils.copyProperties(article, articleDto);
            articleDto.setTagList(tagService.findArticleTags(articleDto.getTags()));
            articleDto.setCreateOnStr(DateUtil.DATE_FORMAT_YMD.format(new Date(article.getCreateOn())));
        }
        return articleDto;
    }

    public List<TbUbArticle> getRelatedArticles(String queryContent, int pageSize) {
        List<TbUbArticle> articleList = new ArrayList<>();
        if (StringUtils.isNotBlank(queryContent)) {
            ESDocument document = esArticleService.searchArticleByMatch("content", queryContent, 0, pageSize);
            List<com.water.es.entry.ITArticle> esArticleList = (List<com.water.es.entry.ITArticle>) document.getResult();
            for (com.water.es.entry.ITArticle esArticle : esArticleList) {
                TbUbArticle originArticle = new TbUbArticle();
                BeanUtils.copyProperties(esArticle, originArticle);
                articleList.add(originArticle);
            }
        }

        return articleList;
    }

    public Map<String, Object> searchArticleByKeyword(String kw, int begin, int pageSize) {
        Map<String, Object> resultMap = new HashMap<>();
        List<TbUbArticle> articleList = new ArrayList<>();
        ESDocument document = esArticleService.searchArticleByMatchWithHighLight(new String[]{"content"}, kw, begin, pageSize);
        List<com.water.es.entry.ITArticle> esArticleList = (List<com.water.es.entry.ITArticle>) document.getResult();
        copyITArticleList(articleList, esArticleList);
        resultMap.put("data", articleList);
        resultMap.put("took", document.getTook());
        resultMap.put("totalHits", document.getTotalHits());
        return resultMap;
    }

    @Override
    public Map<String, Object> findArticlesByPage(int pageSize, int currentPage) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> queryParam = new HashMap<String, Object>();
        int begin = (currentPage - 1) * currentPage;
        queryParam.put("pageSize", pageSize);
        queryParam.put("begin", begin);
        List<TbUbArticleDto> itArticleList = iTArticleMapper.findArticleListByCondition(queryParam);
        int totalCount = iTArticleMapper.getTotalCount(queryParam);
        if (itArticleList == null) {
            itArticleList = new ArrayList<>();
        }
        result.put("data", itArticleList);
        result.put("code", 0);
        result.put("total", totalCount);
        result.put("msg", "success!");
        return result;
    }

    @Override
    public Map<String, Object> searchArticleByKeywordV2(String kw, int currentPage, int pageSize) {
        List<TbUbArticle> articleList = new ArrayList<TbUbArticle>();
        Map<String, Object> result = new HashMap<>();

        if (StringUtils.isNotBlank(kw)) {
            int begin = (currentPage - 1) * pageSize;
            ESDocument document = esArticleService.searchArticleByMatch("content", kw, begin, pageSize);
            List<com.water.es.entry.ITArticle> esArticleList = (List<com.water.es.entry.ITArticle>) document.getResult();
            for (com.water.es.entry.ITArticle esArticle : esArticleList) {
                TbUbArticle originArticle = new TbUbArticle();
                BeanUtils.copyProperties(esArticle, originArticle);
                articleList.add(originArticle);
            }
            result.put("data", articleList);
            result.put("code", 0);
            result.put("result", 0);
            result.put("took", document.getTook());
            result.put("totalHits", document.getTotalHits());

            return result;
        }
        return null;
    }

    @Override
    public void formatArticleList(List<TbUbArticleDto> articleDtoList, DateFormat dateFormat) {
        articleDtoList.stream().forEach(p -> {
            p.setCreateOnStr(dateFormat.format(new Date(p.getCreateOn())));
        });
    }

    @Override
    public ResultView articleVote(String ip, int articleId, int attitude) {
        ResultView resultView = new ResultView(ResultView.SUCCESS_CODE, ResultView.SUCCESS_MSG);

        int ONE_YEAR_IN_SECONDS = 365 * 24 * 60 * 60;
        int VOTE_SCORE = 432;
        long cutOff = DateUtil.getSecondTimestamp() - ONE_YEAR_IN_SECONDS;

        String articleKey = String.format(CacheKey.ARTICLE, articleId);
        if (!cacheManager.exists(articleKey)) {
            TbUbArticle article = this.getArticleDetailById(articleId);
            postArticleAndRecordVoteInfo(article);
        }
        if (cacheManager.zscore(CacheKey.ARTICLE_RELASE_TIME, articleKey) < cutOff) { //不能对发布超过一年的文章进行投票
            resultView.setCode(ResultView.FAIL_CODE);
            resultView.setMsg("文章已经超过了投票时间");
            return resultView;
        }
        if (attitude == 0) {// 反对票
            if (cacheManager.sismember(String.format(CacheKey.VOTED_YES, articleId), ip)) {// 查看用户是否投了肯定票
                cacheManager.hincrBy(articleKey, "vote_yes", -1);
                cacheManager.srem(String.format(CacheKey.VOTED_YES, articleId), ip);
            }
            if (cacheManager.sadd(String.format(CacheKey.VOTED_NO, articleId), ip) == 0) { //同一个ip地址不能对文章进行重复投票
                resultView.setCode(ResultView.FAIL_CODE);
                resultView.setMsg("您已经投票过，不能重复投票");
                return resultView;
            }
            cacheManager.zincrby(CacheKey.ARTICLE_VOTED_SCORE, -VOTE_SCORE, articleKey);
            cacheManager.hincrBy(articleKey, "vote_no", 1);

        } else if (attitude == 1) {// 肯定票
            if (cacheManager.sismember(String.format(CacheKey.VOTED_NO, articleId), ip)) {// 查看用户是否投了反对票
                cacheManager.hincrBy(articleKey, "vote_no", -1);
                cacheManager.srem(String.format(CacheKey.VOTED_NO, articleId), ip);
            }
            if (cacheManager.sadd(String.format(CacheKey.VOTED_YES, articleId), ip) == 0) { //同一个ip地址不能对文章进行重复投票
                resultView.setCode(ResultView.FAIL_CODE);
                resultView.setMsg("您已经投票过，不能重复投票");
                return resultView;
            }

            cacheManager.zincrby(CacheKey.ARTICLE_VOTED_SCORE, VOTE_SCORE, articleKey);
            cacheManager.hincrBy(articleKey, "vote_yes", 1);
        }

        return resultView;
    }

    public void postArticleAndRecordVoteInfo(TbUbArticle article) {
        int VOTE_SCORE = 432;
        int ONE_YEAR_IN_SECONDS = 365 * 24 * 60 * 60;
        int now = DateUtil.getSecondTimestamp(new Date(article.getCreateOn()));

        String articleVoteYesKey = String.format(CacheKey.VOTED_YES, article.getId());
        String articleVoteNoKey = String.format(CacheKey.VOTED_NO, article.getId());
        String articleKey = String.format(CacheKey.ARTICLE, article.getId());

        cacheManager.expire(articleVoteYesKey, ONE_YEAR_IN_SECONDS);
        cacheManager.expire(articleVoteNoKey, ONE_YEAR_IN_SECONDS);

        Map<String, String> param = new HashMap<>();
        param.put("title", article.getTitle());
        param.put("link", "");
        param.put("time", String.valueOf(now));
        param.put("vote_yes", "0");
        param.put("vote_no", "0");
        cacheManager.hmset(articleKey, param);
        cacheManager.zadd(CacheKey.ARTICLE_VOTED_SCORE, articleKey, now + VOTE_SCORE);
        cacheManager.zadd(CacheKey.ARTICLE_RELASE_TIME, articleKey, now);
    }

    private void copyITArticleList(List<TbUbArticle> articleList, List<com.water.es.entry.ITArticle> esArticleList) {
        for (com.water.es.entry.ITArticle esArticle : esArticleList) {
            TbUbArticle originArticle = new TbUbArticle();
            BeanUtils.copyProperties(esArticle, originArticle);
            articleList.add(originArticle);
        }
    }

    /**
     * 从缓存获取 首页 - 文章列表
     *
     * @param module
     * @return
     */
    private List<TbUbArticleDto> getCacheModuleArticle(int module) {
        String redis_key = "static_index_module_%s";
        redis_key = String.format(redis_key, module);

        List<TbUbArticleDto> articleDtoList = new ArrayList<>();
        List<byte[]> byteValues = cacheManager.lrange(redis_key.getBytes(), 0, -1);
        if (byteValues != null && byteValues.size() > 0) {
            for (byte[] byteValue : byteValues) {
                TbUbArticleDto articleDto = (TbUbArticleDto) SerializeHelper.unserialize(byteValue);
                articleDtoList.add(articleDto);
            }
        }

        return articleDtoList;
    }

    @PostConstruct
    public void init() {
        cacheLocal = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.DAYS).build(
                new CacheLoader<String, Object>() {
                    int begin = 0;
                    int pageSize = 0;
                    TbUbArticle article = null;
                    List<TbUbArticleDto> articleList = null;
                    Map<String, Object> queryParam = null;

                    @Override
                    public List<TbUbArticleDto> load(String key) {
                        switch (key) {
                            case "static_index_module_" + 0:
                                queryParam = new HashMap<String, Object>();
                                article = new TbUbArticle();
                                article.setModule(0);
                                pageSize = 11;
                                begin = 0;
                                queryParam.put("pageSize", pageSize);
                                queryParam.put("begin", begin);
                                queryParam.put("model", article);
                                articleList = iTArticleMapper.findArticleListByCondition(queryParam);
                                return articleList;
                            case Constants.CacheKey.NEWS:
                                queryParam = new HashMap<String, Object>();
                                article = new TbUbArticle();
                                article.setModule(1);
                                begin = 0;
                                pageSize = 10;
                                queryParam.put("pageSize", pageSize);
                                queryParam.put("begin", begin);
                                queryParam.put("model", article);
                                return iTArticleMapper.findArticleListByCondition(queryParam);
                        }
                        return null;
                    }
                }
        );
    }
}