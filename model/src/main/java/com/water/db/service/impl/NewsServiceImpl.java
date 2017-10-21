package com.water.db.service.impl;

import com.water.db.service.interfaces.NewsService;
import com.water.utils.common.Constants;
import com.water.utils.db.DBUtil;
import com.water.uubook.dao.ArticleMapper;
import com.water.uubook.model.Article;
import com.water.uubook.model.dto.ArticleDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资讯业务类
 * Created by mrwater on 2017/8/17.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleDto> getHotNewsWithType(int pageSize, int newType) {
        if (pageSize <= 0) {
            pageSize = 10;
        }
        ArticleDto model = new ArticleDto();
        model.setModule(newType);
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("crate_on", "DESC");
        sortMap.put("view_hits", "ASC");
        Map<String, Object> queryMap = DBUtil.getParamMap(model, new String[]{"id", "title", "description"}, sortMap, pageSize, 1);
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
