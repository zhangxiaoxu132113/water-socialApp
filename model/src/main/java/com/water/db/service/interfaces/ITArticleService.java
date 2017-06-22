package com.water.db.service.interfaces;

import com.water.db.model.ITArticle;
import com.water.db.model.User;
import com.water.db.model.dto.ITArticleDto;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface ITArticleService {
    List<ITArticle> getGreeArticle() throws ExecutionException;

    ITArticleDto getArticleDetailById(String articleId);

    List<ITArticle> getSoftwareInformations();

    List<ITArticle> getRecentlyReadedArticlesByUser(User user);

    List<ITArticle> getNewArticles();

    List<ITArticle> getExcellentArticle();

    List<ITArticle> getRelatedArticles(ITArticle article);

    Map<String, Object> searchArticleByKeyword(String kw, int begin, int pageSize);


}