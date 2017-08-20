package com.water.db.service.impl;

import com.water.db.service.interfaces.NewsService;
import com.water.utils.common.Constants;
import com.water.uubook.dao.ArticleMapper;
import com.water.uubook.model.Article;
import com.water.uubook.model.dto.ArticleDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 2017/8/17.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleDto> getHotNews() {
        Map<String, Object> queryMap = new HashMap<>();
        int begin = 0;
        int pageSize = 10;
        ArticleDto model = new ArticleDto();
        model.setModule(Constants.ARTICLE_MODULE.ZI_XUN.getIndex());
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("crate_on", "DESC");
        sortMap.put("view_hits", "ASC");

        queryMap.put("model", model);
        queryMap.put("begin", begin);
        queryMap.put("sortMap", sortMap);
        queryMap.put("pageSize", pageSize);
        queryMap.put("cols", new String[]{"id", "title"});
        List<ArticleDto> articleDtoList = articleMapper.findArticleListByCondition(queryMap);
        return articleDtoList;
    }

    @Override
    public List<ArticleDto> getNewsByPage(int currentPage, int pageSize, int module) {
        Map<String, Object> queryMap = new HashMap<>();
        int begin = (currentPage - 1) * pageSize;
        ArticleDto model = new ArticleDto();
        model.setModule(module);

        queryMap.put("model", model);
        queryMap.put("begin", begin);
        queryMap.put("pageSize", pageSize);
        queryMap.put("cols", new String[]{"id", "title"});
        List<ArticleDto> articleDtoList = articleMapper.findArticleListByCondition(queryMap);
        return articleDtoList;
    }

    @Override
    public Integer countNewsTotal(Integer type) {
        Map<String, Object> queryMap = new HashMap<>();
        Article model = new Article();
        model.setModule(type);

        Integer total = articleMapper.getTotalCount(queryMap);
        return total;
    }
}
