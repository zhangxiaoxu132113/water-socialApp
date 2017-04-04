package com.water.db.service.interfaces;

import com.water.db.model.ITArticle;

import java.util.List;

public interface ITArticleService {
    List<ITArticle> getNewArticle();

    ITArticle getArticleDetailById(String articleId);

    List<ITArticle> getSoftwareInformations();
}