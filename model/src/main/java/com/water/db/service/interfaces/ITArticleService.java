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
    /**
     * 获取极客头条的文章
     * @return
     * @throws ExecutionException
     */
    List<ArticleDto> getGreeArticle() throws ExecutionException;

    /**
     * 根据文章id获取文章内容
     * @param articleId
     * @return
     */
    ArticleDto getArticleDetailById(Integer articleId);

    List<ArticleDto> getSoftwareInformations();

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