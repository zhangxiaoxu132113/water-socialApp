package com.water.db.model.dto;

import com.water.db.model.ITArticle;

import java.util.List;

/**
 * Created by mrwater on 2017/4/5.
 */
public class ITArticleDto extends ITArticle {
    private List<ITArticle> relatedArticles;

    public List<ITArticle> getRelatedArticles() {
        return relatedArticles;
    }

    public void setRelatedArticles(List<ITArticle> relatedArticles) {
        this.relatedArticles = relatedArticles;
    }
}
