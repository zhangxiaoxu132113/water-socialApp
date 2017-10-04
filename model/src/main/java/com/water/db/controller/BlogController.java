package com.water.db.controller;

import com.water.uubook.model.dto.ArticleDto;
import com.water.uubook.model.dto.CategoryDto;
import com.water.uubook.service.ArticleService;
import com.water.uubook.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 博客板块
 * Created by mrwater on 2017/7/18.
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @Resource
    private CategoryService categoryService;

    @Resource
    private ArticleService articleService;

    /**
     * 标签分类专题页
     * @param categoryStr
     * @return
     * @throws ExecutionException
     */
    @RequestMapping(value = "/{categoryStr}")
    public ModelAndView category(@PathVariable String categoryStr) throws ExecutionException {
        ModelAndView mav = new ModelAndView();
        CategoryDto category = categoryService.getCategoryByNameWithCache(categoryStr);
        if (category == null && category.getParentId() == 0) {
//            return 404
            return null;
        }
        List<CategoryDto> categoryDtos = categoryService.getHotCategories();
        int pageSize = 10;
        int currentPage = 1;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setCategory(category.getId());
        String[] queryField = {"id", "title", "view_hits", "tags", "create_on"};
        List<ArticleDto> articleDtoList = articleService.findArticleListByCondition(articleDto, queryField, currentPage, pageSize);
        articleDtoList = articleService.getArticleTag(articleDtoList);
        mav.addObject("categoryDtos", categoryDtos);
        mav.addObject("articleDtoList", articleDtoList);
        mav.setViewName("/article/category");
        return mav;
    }

    /**
     * 文档库模块
     * @param category
     * @return
     */
    @RequestMapping(value = "/category/{category}")
    public ModelAndView blogCategory(@PathVariable String category) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/article/categoryModule");
        return mav;
    }
}
