package com.water.db.controller;

import com.water.uubook.model.Category;
import com.water.uubook.model.dto.ArticleDto;
import com.water.uubook.service.ArticleService;
import com.water.uubook.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mrwater on 2017/7/18.
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @Resource
    private CategoryService categoryService;

    @Resource
    private ArticleService articleService;

    @RequestMapping(value = "/{categoryStr}")
    public ModelAndView category(@PathVariable String categoryStr) {
        ModelAndView mav = new ModelAndView();
        Category category = categoryService.getCategoryByName(categoryStr);
        if (category == null && category.getParentId() == 0) {
            //return 404
            return null;
        }
        int pageSize = 10;
        int currentPage = 1;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setCategory(category.getId());
        List<ArticleDto> articleDtoList = articleService.findArticleListByCondition(articleDto, new String[]{"id", "title", "view_hits", "tags", "create_on"}, currentPage, pageSize);
        articleDtoList = articleService.getArticleTag(articleDtoList);
        mav.addObject("articleDtoList", articleDtoList);
        mav.setViewName("/article/category");
        return mav;
    }
}
