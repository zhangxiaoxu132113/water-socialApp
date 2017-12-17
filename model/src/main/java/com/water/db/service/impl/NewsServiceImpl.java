package com.water.db.service.impl;

import com.water.db.service.interfaces.NewsService;
import com.water.utils.common.Constants;
import com.water.utils.db.DBUtil;
import com.water.uubook.dao.TbUbArticleMapper;
import com.water.uubook.model.TbUbArticle;
import com.water.uubook.model.dto.TbUbArticleDto;
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
    private TbUbArticleMapper articleMapper;

    @Override
    public List<TbUbArticleDto> getHotNewsWithType(int pageSize, int newType) {
        if (pageSize <= 0) {
            pageSize = 10;
        }
        TbUbArticleDto model = new TbUbArticleDto();
        model.setModule(newType);
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("crate_on", "DESC");
        sortMap.put("view_hits", "ASC");
        Map<String, Object> queryMap = DBUtil.getParamMap(model, new String[]{"id", "title", "description"}, sortMap, pageSize, 1);
        List<TbUbArticleDto> articleDtoList = articleMapper.findArticleListByCondition(queryMap);
        return articleDtoList;
    }

    @Override
    public List<TbUbArticleDto> getNewsByPage(int currentPage, int pageSize, int module) {
        Map<String, Object> queryMap = new HashMap<>();
        int begin = (currentPage - 1) * pageSize;
        TbUbArticleDto model = new TbUbArticleDto();
        model.setModule(module);

        queryMap.put("model", model);
        queryMap.put("begin", begin);
        queryMap.put("pageSize", pageSize);
        queryMap.put("cols", new String[]{"id", "title", "description"});
        List<TbUbArticleDto> articleDtoList = articleMapper.findArticleListByCondition(queryMap);
        return articleDtoList;
    }

    @Override
    public Integer countNewsTotal(Integer type) {
        Map<String, Object> queryMap = new HashMap<>();
        TbUbArticle model = new TbUbArticle();
        model.setModule(type);

        Integer total = articleMapper.getTotalCount(queryMap);
        return total;
    }
}
