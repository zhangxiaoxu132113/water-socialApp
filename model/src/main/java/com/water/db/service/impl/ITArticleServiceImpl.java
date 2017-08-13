package com.water.db.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.water.db.service.interfaces.ITArticleService;
import com.water.es.entry.ESDocument;
import com.water.utils.common.Constants;
import com.water.uubook.dao.ArticleMapper;
import com.water.uubook.dao.CourseMapper;
import com.water.uubook.model.Article;
import com.water.uubook.model.User;
import com.water.uubook.model.dto.ArticleDto;
import com.water.uubook.service.TagService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service("iTArticleService")
public class ITArticleServiceImpl implements ITArticleService {
    @Resource
    private ArticleMapper iTArticleMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private TagService tagService;

    private LoadingCache<String, Object> cacheLocal;

    private Log logger = LogFactory.getLog(ITArticleServiceImpl.class);

    @Resource
    private com.water.es.api.Service.IArticleService esArticleService;

    public List<ArticleDto> getGreeArticle() throws ExecutionException {
        List<ArticleDto> articleList = null;
        articleList = (List<ArticleDto>) cacheLocal.get(Constants.CacheKey.GreeArticle);
        if (articleList == null) {
            Map<String, Object> queryParam = new HashMap<String, Object>();
            Article article = new Article();
            article.setModule(0);
            int pageSize = 13;
            int begin = 0;
            queryParam.put("pageSize", pageSize);
            queryParam.put("begin", begin);
            queryParam.put("model", article);
            articleList = iTArticleMapper.findArticleListByCondition(queryParam);
        }
        return articleList;
    }

    public ArticleDto getArticleDetailById(Integer articleId) {
        if (articleId == null || articleId < 0) {
            throw new RuntimeException("文章id不合法！");
        }
        Article article = iTArticleMapper.selectByPrimaryKey(articleId);
        ArticleDto articleDto = null;
        if (article != null) {
            articleDto = new ArticleDto();
            BeanUtils.copyProperties(article, articleDto);
            articleDto.setTagList(tagService.findArticleTags(articleDto.getTags()));
        }
        return articleDto;
    }

    public List<Article> getRelatedArticles(String queryContent, int pageSize) {
        List<Article> articleList = new ArrayList<Article>();
        if (StringUtils.isNotBlank(queryContent)) {
            ESDocument document = esArticleService.searchArticleByMatch("content", queryContent, 0, pageSize);
            List<com.water.es.entry.ITArticle> esArticleList = (List<com.water.es.entry.ITArticle>) document.getResult();
            for (com.water.es.entry.ITArticle esArticle : esArticleList) {
                Article originArticle = new Article();
                BeanUtils.copyProperties(esArticle, originArticle);
                articleList.add(originArticle);
            }
        }

        return articleList;
    }

    public List<ArticleDto> getSoftwareInformations() {
        Map<String, Object> queryParam = new HashMap<String, Object>();
        Article article = new Article();
        article.setModule(1);
        int begin = 0;
        int pageSize = 10;
        queryParam.put("pageSize", pageSize);
        queryParam.put("begin", begin);
        queryParam.put("model", article);
        return iTArticleMapper.findArticleListByCondition(queryParam);
    }

    public List<Article> getRecentlyReadedArticlesByUser(User user) {
        return null;
    }

    public List<Article> getNewArticles() {
        return null;
    }

    public List<Article> getExcellentArticle() {
        return null;
    }

    public Map<String, Object> searchArticleByKeyword(String kw, int begin, int pageSize) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Article> articleList = new ArrayList<>();
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
        int begin = (currentPage-1) * currentPage;
        queryParam.put("pageSize", pageSize);
        queryParam.put("begin", begin);
        List<ArticleDto> itArticleList = iTArticleMapper.findArticleListByCondition(queryParam);
        int totalCount = iTArticleMapper.getTotalCount();
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
        List<Article> articleList = new ArrayList<Article>();
        Map<String, Object> result = new HashMap<>();

        if (StringUtils.isNotBlank(kw)) {
            int begin = (currentPage - 1) * pageSize;
            ESDocument document = esArticleService.searchArticleByMatch("content", kw, begin, pageSize);
            List<com.water.es.entry.ITArticle> esArticleList = (List<com.water.es.entry.ITArticle>) document.getResult();
            for (com.water.es.entry.ITArticle esArticle : esArticleList) {
                Article originArticle = new Article();
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


    private void copyITArticleList(List<Article> articleList, List<com.water.es.entry.ITArticle> esArticleList) {
        for (com.water.es.entry.ITArticle esArticle : esArticleList) {
            Article originArticle = new Article();
            BeanUtils.copyProperties(esArticle, originArticle);
            articleList.add(originArticle);
        }
    }

    @PostConstruct
    public void init() {
        cacheLocal = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.DAYS).build(
                new CacheLoader<String, Object>() {
                    int begin = 0;
                    int pageSize = 0;
                    Article article = null;
                    List<ArticleDto> articleList = null;
                    Map<String, Object> queryParam = null;

                    @Override
                    public List<ArticleDto> load(String key) {
                        switch (key) {
                            case Constants.CacheKey.GreeArticle:
                                queryParam = new HashMap<String, Object>();
                                article = new Article();
                                article.setModule(0);
                                pageSize = 13;
                                begin = 0;
                                queryParam.put("pageSize", pageSize);
                                queryParam.put("begin", begin);
                                queryParam.put("model", article);
                                articleList = iTArticleMapper.findArticleListByCondition(queryParam);
                                return articleList;
                            case Constants.CacheKey.NEWS:
                                queryParam = new HashMap<String, Object>();
                                article = new Article();
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