package com.water.db.service.impl;

import com.water.db.dao.ITArticleMapper;
import com.water.db.model.ITArticle;
import com.water.db.model.ITArticleCriteria;
import com.water.db.service.interfaces.ITArticleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

@Service("iTArticleService")
public class ITArticleServiceImpl implements ITArticleService {
    @Resource
    private ITArticleMapper iTArticleMapper;

    public List<ITArticle> getNewArticle() {
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

    public ITArticle getArticleDetailById(String articleId) {
        if (StringUtils.isBlank(articleId)) {
            throw new RuntimeException("文章id不合法！");
        }
        ITArticle article = iTArticleMapper.selectByPrimaryKey(articleId);
        return article;
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
}