package com.water.db.service.interfaces;

import com.water.uubook.model.dto.TbUbArticleDto;

import java.util.List;

/**
 * Created by mrwater on 2017/8/17.
 */
public interface NewsService {
    /**
     * 获取热门资讯
     * @param pageSize 获取文章数量
     * @param newType  资讯类型
     * @return
     */
    List<TbUbArticleDto> getHotNewsWithType(int pageSize, int newType);

    List<TbUbArticleDto> getNewsByPage(int currentPage, int size, int module);

    Integer countNewsTotal(Integer type);
}
