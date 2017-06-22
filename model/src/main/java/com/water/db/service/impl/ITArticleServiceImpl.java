package com.water.db.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.water.db.dao.CourseMapper;
import com.water.db.dao.ITArticleMapper;
import com.water.db.model.ITArticle;
import com.water.db.model.User;
import com.water.db.model.dto.ITArticleDto;
import com.water.db.service.interfaces.ITArticleService;
import com.water.es.entry.ESDocument;
import com.water.utils.common.Constants;
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
    private ITArticleMapper iTArticleMapper;

    @Resource
    private CourseMapper courseMapper;

    private LoadingCache<String, Object> cacheLocal;

    private Log logger = LogFactory.getLog(ITArticleServiceImpl.class);

    @Resource
    private com.water.es.api.Service.IArticleService esArticleService;

    public List<ITArticle> getGreeArticle() throws ExecutionException {
        List<ITArticle> articleList = null;
        articleList = (List<ITArticle>) cacheLocal.get(Constants.CacheKey.GreeArticle);
        if (articleList == null) {
            Map<String, Object> queryParam = new HashMap<String, Object>();
            ITArticle article = new ITArticle();
            article.setModule(0);
            int pageSize = 13;
            int begin = 0;
            queryParam.put("pageSize", pageSize);
            queryParam.put("begin", begin);
            queryParam.put("model", article);
            articleList = iTArticleMapper.getArticle(queryParam);
        }
        return articleList;
    }

    public ITArticleDto getArticleDetailById(String articleId) {
        if (StringUtils.isBlank(articleId)) {
            throw new RuntimeException("文章id不合法！");
        }
        ITArticle article = iTArticleMapper.selectByPrimaryKey(articleId);
        ITArticleDto articleDto = new ITArticleDto();
        BeanUtils.copyProperties(article, articleDto);
        return articleDto;
    }

    public List<ITArticle> getRelatedArticles(ITArticle article) {
        List<ITArticle> articleList = new ArrayList<ITArticle>();

        if (article == null) {
            throw new RuntimeException("对象不能为空！");
        }
        ESDocument document = esArticleService.searchArticleByMatch("content", article.getTitle(), 0, 5);
        List<com.water.es.entry.ITArticle> esArticleList = (List<com.water.es.entry.ITArticle>) document.getResult();
        for (com.water.es.entry.ITArticle esArticle : esArticleList) {
            ITArticle originArticle = new ITArticle();
            BeanUtils.copyProperties(esArticle, originArticle);
            articleList.add(originArticle);
        }
        return articleList;
    }

    public List<ITArticle> getSoftwareInformations() {
        Map<String, Object> queryParam = new HashMap<String, Object>();
        ITArticle article = new ITArticle();
        article.setModule(1);
        int begin = 0;
        int pageSize = 10;
        queryParam.put("pageSize", pageSize);
        queryParam.put("begin", begin);
        queryParam.put("model", article);
        return iTArticleMapper.getArticle(queryParam);
    }

    public List<ITArticle> getRecentlyReadedArticlesByUser(User user) {
        return null;
    }

    public List<ITArticle> getNewArticles() {
        return null;
    }

    public List<ITArticle> getExcellentArticle() {
        return null;
    }

    public Map<String, Object> searchArticleByKeyword(String kw, int begin, int pageSize) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<ITArticle> articleList = new ArrayList<ITArticle>();
        ESDocument document = esArticleService.searchArticleByMatchWithHighLight(new String[]{"content", "title"}, kw, begin, pageSize);
        List<com.water.es.entry.ITArticle> esArticleList = (List<com.water.es.entry.ITArticle>) document.getResult();
        copyITArticleList(articleList, esArticleList);
        resultMap.put("data", articleList);
        resultMap.put("took", document.getTook());
        resultMap.put("totalHits", document.getTotalHits());
        return resultMap;
    }


    private void copyITArticleList(List<ITArticle> articleList, List<com.water.es.entry.ITArticle> esArticleList) {
        for (com.water.es.entry.ITArticle esArticle : esArticleList) {
            ITArticle originArticle = new ITArticle();
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
                    ITArticle article = null;
                    List<ITArticle> articleList = null;
                    Map<String, Object> queryParam = null;

                    @Override
                    public List<ITArticle> load(String key) {
                        switch (key) {
                            case Constants.CacheKey.GreeArticle:
                                queryParam = new HashMap<String, Object>();
                                article = new ITArticle();
                                article.setModule(0);
                                pageSize = 13;
                                begin = 0;
                                queryParam.put("pageSize", pageSize);
                                queryParam.put("begin", begin);
                                queryParam.put("model", article);
                                articleList = iTArticleMapper.getArticle(queryParam);
                                return articleList;
                            case Constants.CacheKey.NEWS:
                                queryParam = new HashMap<String, Object>();
                                article = new ITArticle();
                                article.setModule(1);
                                begin = 0;
                                pageSize = 10;
                                queryParam.put("pageSize", pageSize);
                                queryParam.put("begin", begin);
                                queryParam.put("model", article);
                                return iTArticleMapper.getArticle(queryParam);
                        }
                        return null;
                    }
                }
        );
    }
}