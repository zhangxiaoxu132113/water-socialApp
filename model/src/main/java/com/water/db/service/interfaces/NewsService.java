package com.water.db.service.interfaces;

import com.water.uubook.model.dto.ArticleDto;

import java.util.List;

/**
 * Created by mrwater on 2017/8/17.
 */
public interface NewsService {
    List<ArticleDto> getHotNews();

    List<ArticleDto> getNewsByPage(int currentPage, int size, int module);

    Integer countNewsTotal(Integer type);
}
