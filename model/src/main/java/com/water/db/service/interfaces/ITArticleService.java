package com.water.db.service.interfaces;

import com.water.utils.web.view.ResultView;
import com.water.uubook.model.TbUbArticle;
import com.water.uubook.model.dto.TbUbArticleDto;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;

public interface ITArticleService {

    /**
     * 根据文章id获取文章内容
     * @param articleId
     * @return
     */
    TbUbArticleDto getArticleDetailById(Integer articleId);

    List<TbUbArticle> getRelatedArticles(String queryContent, int pageSize);

    Map<String, Object> searchArticleByKeyword(String kw, int begin, int pageSize);

    Map<String, Object> findArticlesByPage(int pageSize, int currentPage);

    Map<String,Object> searchArticleByKeywordV2(String kw, int currentPage, int pageSize);

    void formatArticleList(List<TbUbArticleDto> articleDtoList, DateFormat dateFormat);

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
    void postArticleAndRecordVoteInfo(TbUbArticle article);

}