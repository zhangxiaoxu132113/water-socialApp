package com.water.db.service.interfaces;

import com.water.uubook.model.TbUbArticle;
import com.water.uubook.model.dto.TbUbArticleDto;

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
    List<TbUbArticleDto> getLatestArticleList();

    /**
     * 获取热门文章
     * @return
     */
    List<TbUbArticleDto> getHotArticleList(Integer cateogry, Integer pageSize);


    List<Map<String,Object>> getArticleByAllCategoryWithCache();
}
