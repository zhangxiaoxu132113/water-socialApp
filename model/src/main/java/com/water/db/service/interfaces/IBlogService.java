package com.water.db.service.interfaces;

import com.water.uubook.model.Article;
import com.water.uubook.model.dto.ArticleDto;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 2017/7/20.
 */
public interface IBlogService {

    /**
     * 获取最新文章
     * @return
     */
    List<ArticleDto> getLatestArticleList();

    /**
     * 获取热门文章
     * @return
     */
    List<ArticleDto> getHotArticleList();


    List<Map<String,Object>> getArticleByAllCategoryWithCache();
}
