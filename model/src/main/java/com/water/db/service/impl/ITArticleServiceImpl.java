package com.water.db.service.impl;

import com.water.db.dao.ITArticleMapper;
import com.water.db.model.ITArticle;
import com.water.db.model.ITArticleCriteria;
import com.water.db.model.User;
import com.water.db.model.dto.ITArticleDto;
import com.water.db.service.interfaces.ITArticleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.water.es.entry.ESDocument;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service("iTArticleService")
public class ITArticleServiceImpl implements ITArticleService {
    @Resource
    private ITArticleMapper iTArticleMapper;

    @Resource
    private com.water.es.api.Service.IArticleService esArticleService;

    public List<ITArticle> getGreeArticle() {
        Map<String, Object> queryParam = new HashMap<String, Object>();
        ITArticle article = new ITArticle();
        article.setModule(0);
        int pageSize = 13;
        int begin = 0;
        queryParam.put("pageSize", pageSize);
        queryParam.put("begin", begin);
        queryParam.put("model", article);
        List<ITArticle> articleList = iTArticleMapper.getArticle(queryParam);
        return articleList;
    }

    public ITArticleDto getArticleDetailById(String articleId) {
        if (StringUtils.isBlank(articleId)) {
            throw new RuntimeException("文章id不合法！");
        }
        ITArticle article = iTArticleMapper.selectByPrimaryKey(articleId);
        ITArticleDto articleDto = new ITArticleDto();
        BeanUtils.copyProperties(article, articleDto);
        List<ITArticle> articleList = getRelatedArticles(article);
        articleDto.setRelatedArticles(articleList);
        return articleDto;
    }

    private List<ITArticle> getRelatedArticles(ITArticle article) {
        List<ITArticle> articleList = new ArrayList<ITArticle>();

        if (article == null) {
            throw  new RuntimeException("对象不能为空！");
        }
        ESDocument document = esArticleService.searchArticleByMatch("content", article.getTitle(),0,5);
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
        ESDocument document = esArticleService.searchArticleByMatchWithHighLight(new String[]{"content","title"}, kw, begin, pageSize);
        List<com.water.es.entry.ITArticle> esArticleList = (List<com.water.es.entry.ITArticle>) document.getResult();
        copyITArticleList(articleList, esArticleList);
        resultMap.put("data",articleList);
        resultMap.put("took",document.getTook());
        resultMap.put("totalHits",document.getTotalHits());
        return resultMap;
    }

    private void copyITArticleList(List<ITArticle> articleList, List<com.water.es.entry.ITArticle> esArticleList) {
        for (com.water.es.entry.ITArticle esArticle : esArticleList) {
            ITArticle originArticle = new ITArticle();
            BeanUtils.copyProperties(esArticle, originArticle);
            articleList.add(originArticle);
        }
    }
}