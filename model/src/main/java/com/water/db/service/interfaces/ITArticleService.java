package com.water.db.service.interfaces;

import com.water.utils.web.view.ResultView;
import com.water.uubook.model.Article;
import com.water.uubook.model.User;
import com.water.uubook.model.dto.ArticleDto;
import com.water.uubook.model.dto.ITArticleDto;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface ITArticleService {
    List<ArticleDto> getGreeArticle() throws ExecutionException;

    ArticleDto getArticleDetailById(Integer articleId);

    List<ArticleDto> getSoftwareInformations();

    List<Article> getRecentlyReadedArticlesByUser(User user);

    List<Article> getNewArticles();

    List<Article> getExcellentArticle();

    List<Article> getRelatedArticles(String queryContent, int pageSize);

    Map<String, Object> searchArticleByKeyword(String kw, int begin, int pageSize);

    Map<String, Object> findArticlesByPage(int pageSize, int currentPage);

    Map<String,Object> searchArticleByKeywordV2(String kw, int currentPage, int pageSize);

    /**
     * 文章投票
     * @param ip
     * @param id
     */
    ResultView articleVote(String ip, int id, int attitude);

    /**
     * 文章发布关联投票的缓存数据
     * @param article
     */
    void postArticleAndRecordVoteInfo(Article article);
}