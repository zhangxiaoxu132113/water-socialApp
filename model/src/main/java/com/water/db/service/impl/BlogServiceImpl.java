package com.water.db.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.water.db.service.interfaces.IBlogService;
import com.water.db.service.interfaces.ITTagService;
import com.water.utils.common.Constants;
import com.water.uubook.dao.ArticleMapper;
import com.water.uubook.model.Article;
import com.water.uubook.model.dto.ArticleDto;
import com.water.uubook.model.dto.CategoryDto;
import com.water.uubook.model.dto.ITTagDto;
import com.water.uubook.service.CategoryService;
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
    private ArticleMapper articleMapper;

    @Resource(name = "iTTagService")
    private ITTagService tagService;

    @Resource
    private CategoryService categoryService;

    private LoadingCache<String, Object> cacheLocal;

    private static final String ALL_CATEGORY_BLOG = "ALL_CATEGORY_BLOG";

    @Override
    public List<ArticleDto> getLatestArticleList() {
        Map<String, Object> param = this.getParamMap(new Article(), new String[] {"id", "title"}, null, 20, 1);
        return articleMapper.findArticleListByCondition(param);
    }

    @Override
    public List<ArticleDto> getHotArticleList() {
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("crate_on", "DESC");
        sortMap.put("view_hits", "ASC");
        Map<String, Object> param = this.getParamMap(new Article(), new String[] {"id", "title", "view_hits", "create_on"}, sortMap, 11, 1);
        return articleMapper.findArticleListByCondition(param);
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
        List<CategoryDto> categoryDtos = categoryService.getAllParentCategories();
        if (categoryDtos != null && categoryDtos.size() > 8) {
            categoryDtos = categoryDtos.subList(0, 8);
        }
        Map<String, String> sortMap = new HashMap<>();
        sortMap.put("createOn", "DESC");
        Article model = new Article();
        for (CategoryDto categoryDto : categoryDtos) {
            model.setModule(Constants.ARTICLE_MODULE.BLOG.getIndex());
            Map<String, Object> param = this.getParamMap(model, new String[] {"id", "title"}, null, 5, 1);
            List<Integer> categoryIds = new ArrayList<>();
            if (categoryDto.getChildren() != null &&  categoryDto.getChildren().size() > 0) {
                for (CategoryDto arg : categoryDto.getChildren()) {
                    categoryIds.add(arg.getId());
                }
            }
            param.put("categories", categoryIds);
            List<ArticleDto> articles = articleMapper.findArticleListInCategory(param);
            if (articles != null && articles.size() > 0) {
                Map<String, Object> articleCategory = new HashMap<>();
                articleCategory.put("articles", articles);
                articleCategory.put("category", categoryDto);
                list.add(articleCategory);
            }

        }

        return list;
    }

    private Map<String, Object> getParamMap(Article model, String[] cols, Map<String, String> sortMap, Integer size, Integer currentPage) {
        Map<String, Object> param = new HashMap<>();
        int begin = 0;
        int pageSize = 10;
        if (size != null && currentPage != null) {
            pageSize = size;
            begin = (currentPage -1) * pageSize;
        }
        if (sortMap != null && sortMap.size() > 0) {
            param.put("sortMap", sortMap);
        }

        if (model != null) {
            model.setModule(Constants.ARTICLE_MODULE.BLOG.getIndex());
            param.put("model", model);
        }

        if (cols != null) {
            param.put("cols", cols);

        }

        param.put("begin", begin);
        param.put("pageSize", pageSize);
        return param;
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
