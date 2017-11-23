package com.water.db.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.water.db.service.interfaces.IBlogService;
import com.water.db.service.interfaces.ITArticleService;
import com.water.utils.cache.CacheManager;
import com.water.utils.common.Constants;
import com.water.utils.db.DBUtil;
import com.water.uubook.dao.TbUbArticleMapper;
import com.water.uubook.model.dto.TbUbArticleDto;
import com.water.uubook.model.dto.TbUbCategoryDto;
import com.water.uubook.service.TbUbCategoryService;
import com.water.uubook.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by mrwater on 2017/7/20.
 */
@Service
public class BlogServiceImpl implements IBlogService {

    @Resource
    private TbUbArticleMapper articleMapper;

    @Resource
    private CacheManager cacheManager;

    @Resource(name = "iTArticleService")
    private ITArticleService articleService;

    @Resource
    private TbUbCategoryService categoryService;

    private LoadingCache<String, Object> cacheLocal;

    private static final String ALL_CATEGORY_BLOG = "ALL_CATEGORY_BLOG";

    @Override
    public List<TbUbArticleDto> getLatestArticleList() {
        Map<String, Object> param = DBUtil.getParamMap(new TbUbArticleDto(), new String[]{"id", "title"}, null, 20, 1);
        return articleMapper.findArticleListByCondition(param);
    }

    @Override
    public List<TbUbArticleDto> getHotArticleList(Integer category, Integer pageSize) {
        List<TbUbArticleDto> articleDtoList = cacheManager.getList(Constants.CacheKey.HOT_BLOG_ARTICLE + category,
                TbUbArticleDto.class);
        if (articleDtoList == null) {
            articleDtoList = this.getHotArticleListWithDB(category, pageSize);
        }
        return articleDtoList;
    }

    /**
     * 根据分类获取热门文章
     *
     * @param category
     * @param pageSize
     * @return
     */
    private List<TbUbArticleDto> getHotArticleListWithDB(Integer category, Integer pageSize) {
        TbUbArticleDto model = new TbUbArticleDto();
        if (category != null) {
            if (categoryService.findpParentCategoryById(category) == null) {
                model.setCategory(category);
            } else {
                model.setParentCategory(category);
            }
        }
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("createOn", "DESC");
        sortMap.put("viewHits", "DESC");
        String[] cols = new String[]{"id", "title", "viewHits",  "description", "createOn"};
        Map<String, Object> param = DBUtil.getParamMap(model, cols, sortMap, pageSize, 1);
        List<TbUbArticleDto> articleDtoList = articleMapper.findArticleListByCondition(param);
        articleService.formatArticleList(articleDtoList, DateUtil.DATE_FORMAT_YMD);
        cacheManager.setList(Constants.CacheKey.HOT_BLOG_ARTICLE + category, articleDtoList, 12 * 60 * 60, TbUbArticleDto.class);
        return articleDtoList;
    }

    @Override
    public List<Map<String, Object>> getArticleByAllCategoryWithCache() {
        List<Map<String, Object>> list = null;
        try {
            list = (List<Map<String, Object>>) cacheLocal.get(ALL_CATEGORY_BLOG);
            if (list == null) list = this.getArticleByAllCategory();
        } catch (ExecutionException e) {
            throw new RuntimeException("访问缓存异常！");
        }

        return list;
    }

    private List<Map<String, Object>> getArticleByAllCategory() {
        List<Map<String, Object>> list = new ArrayList<>();
        List<TbUbCategoryDto> categoryDtos = categoryService.getAllParentCategories();
        if (categoryDtos != null && categoryDtos.size() > 8) {
            categoryDtos = categoryDtos.subList(0, 8);
        }
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("createOn", "DESC");
        TbUbArticleDto model = new TbUbArticleDto();
        for (TbUbCategoryDto categoryDto : categoryDtos) {
            model.setModule(Constants.ARTICLE_MODULE.BLOG.getIndex());
            Map<String, Object> param = DBUtil.getParamMap(model, new String[]{"id", "title"}, null, 5, 1);
            List<Integer> categoryIds = new ArrayList<>();
            if (categoryDto.getChildren() != null && categoryDto.getChildren().size() > 0) {
                for (TbUbCategoryDto arg : categoryDto.getChildren()) {
                    categoryIds.add(arg.getId());
                }
            }
            param.put("categories", categoryIds);
            List<TbUbArticleDto> articles = articleMapper.findArticleListInCategory(param);
            if (articles != null && articles.size() > 0) {
                Map<String, Object> articleCategory = new HashMap<>();
                articleCategory.put("articles", articles);
                articleCategory.put("category", categoryDto);
                list.add(articleCategory);
            }

        }

        return list;
    }

    @PostConstruct
    public void init() {
        cacheLocal = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.DAYS).build(
                new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) {
                        switch (key) {
                            case ALL_CATEGORY_BLOG:
                                return getArticleByAllCategory();
                        }
                        return null;
                    }
                }
        );
    }
}
