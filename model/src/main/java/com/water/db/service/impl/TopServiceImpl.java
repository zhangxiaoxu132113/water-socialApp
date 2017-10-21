package com.water.db.service.impl;

import com.water.db.service.interfaces.ITopService;
import com.water.utils.cache.CacheManager;
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
 * 头条文章业务类
 * Created by mrwater on 2017/10/21.
 */
@Service
public class TopServiceImpl implements ITopService {
    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private CacheManager cacheManager;

    @Override
    public List<ArticleDto> getHotTopArticle(int pageSize) {
        List<ArticleDto> articleDtoList = cacheManager.getList(Constants.CacheKey.HOT_TOP_ARTICLE, ArticleDto.class);
        if (articleDtoList == null) {
            articleDtoList = this.getHotTopArticleWithDB(pageSize);
        }
        return articleDtoList;
    }

    /**
     * 获取热门头条，并设置缓存
     *
     * @param pageSize
     * @return
     */
    private List<ArticleDto> getHotTopArticleWithDB(int pageSize) {
        if (pageSize <= 0) {
            pageSize = 10;
        }
        ArticleDto model = new ArticleDto();
        model.setModule(com.water.utils.common.Constants.ARTICLE_MODULE.TOU_TIAO.index);
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("crateOn", "DESC");
        sortMap.put("viewHits", "DESC");
        String[] cols = new String[]{"id", "title", "view_hits", "description", "create_on"};
        Map<String, Object> queryParam = DBUtil.getParamMap(model, cols, sortMap, pageSize, 1);
        List<ArticleDto> articleDtoList = articleMapper.findArticleListByCondition(queryParam);
        cacheManager.setList(Constants.CacheKey.HOT_TOP_ARTICLE, articleDtoList, 60 * 60, ArticleDto.class);
        return articleDtoList;
    }
}
