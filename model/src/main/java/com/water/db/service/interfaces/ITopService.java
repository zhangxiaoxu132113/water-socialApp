package com.water.db.service.interfaces;

import com.water.uubook.model.dto.TbUbArticleDto;

import java.util.List;

/**
 * Created by mrwater on 2017/10/21.
 */
public interface ITopService {
    /**
     * 获取热门头条文章
     * @param size
     * @return
     */
    List<TbUbArticleDto> getHotTopArticle(int size);
}
