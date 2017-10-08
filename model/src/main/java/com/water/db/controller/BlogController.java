package com.water.db.controller;

import com.water.utils.web.view.ResultView;
import com.water.uubook.model.Category;
import com.water.uubook.model.dto.ArticleDto;
import com.water.uubook.model.dto.CategoryDto;
import com.water.uubook.service.ArticleService;
import com.water.uubook.service.CategoryService;
import com.water.uubook.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Resource
    private TagService tagService;

    /**
     * 标签分类专题页
     *
     * @param tagName
     * @return
     * @throws ExecutionException
     */
    @RequestMapping(value = "/tag/{tagName}")
    public ModelAndView redirect2BlogTagPage(@PathVariable String tagName) throws ExecutionException {
        ModelAndView mav = new ModelAndView();
        CategoryDto category = categoryService.getCategoryByNameWithCache(tagName);
        if (category == null && category.getParentId() == 0) {
            return null;
        }
        List<CategoryDto> categoryDtos = categoryService.getHotCategories();
        int pageSize = 10;
        int currentPage = 1;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setCategory(category.getId());
        String[] queryField = {"id", "title", "viewHits", "tags", "createOn"};
        List<ArticleDto> articleDtoList = articleService.findArticleListByCondition(articleDto, queryField, null, currentPage, pageSize);
        articleDtoList = articleService.getArticleTag(articleDtoList);
        mav.addObject("category", category);
        mav.addObject("categoryDtos", categoryDtos);
        mav.addObject("articleDtoList", articleDtoList);
        mav.setViewName("/article/category");
        return mav;
    }

    /**
     * 异步请求标签下的文章列表（分页）
     * @param tag
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/tag/getTagArticleListWithAjax", method = RequestMethod.GET)
    public ModelAndView getTagArticleListWithAjax(@RequestParam String tag,
                                                  @RequestParam(defaultValue = "1") String currentPage,
                                                  @RequestParam(defaultValue = "10") String pageSize) {
        ModelAndView mav = new ModelAndView("/template/tag_articleList_tmp");
        int pageSizeInt = Integer.parseInt(pageSize);
        int currentPageInt = Integer.parseInt(currentPage);
        ArticleDto model = new ArticleDto();
        model.setTagName(tag);
        String[] queryField = new String[]{"id", "title", "viewHits", "tags", "createOn"};

        List<ArticleDto> articleDtoList = articleService.findArticleListWithTagByCondition(model, queryField, currentPageInt, pageSizeInt);
        articleDtoList = articleService.getArticleTag(articleDtoList);
        mav.addObject("articleDtoList", articleDtoList);


        return mav;
    }

    /**
     * 文档库模块
     * @param category
     * @return
     */
    @RequestMapping(value = "/category/{category}")
    public ModelAndView blogCategory(@PathVariable String category) throws ExecutionException {
        ModelAndView mav = new ModelAndView("/article/categoryModule");
        int categoryId = Integer.parseInt(category);

        ArticleDto model = new ArticleDto();
        model.setParentCategory(categoryId);
        Map<String, String> sortMap = new HashMap<>();
        String[] queryField = new String[]{"id", "title", "viewHits", "description", "createOn"};

        sortMap.put("createOn", "desc");
        List<ArticleDto> newestArticleList = articleService.findArticleListByCondition(model, queryField, sortMap, 1, 15);
        sortMap.put("createOn", "");

        sortMap.put("viewHits", "desc");
        List<ArticleDto> hotArticleList = articleService.findArticleListByCondition(model, queryField, sortMap, 1, 15);

        List<CategoryDto> categoryParentList = categoryService.getAllParentCategories();
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);

        mav.addObject("hotArticleList", hotArticleList);
        mav.addObject("categoryDto", categoryDto);
        mav.addObject("newestArticleList", newestArticleList);
        mav.addObject("categoryParentList", categoryParentList);
        return mav;
    }

    @RequestMapping(value = "/category/getCategoryArticleListWithAjax", method = RequestMethod.GET)
    public ModelAndView getCategoryArticleListWithAjax(@RequestParam String category,
                                                       @RequestParam String sort,
                                                       @RequestParam(defaultValue = "1") String currentPage,
                                                       @RequestParam(defaultValue = "10") String pageSize) {
        ModelAndView mav = new ModelAndView("/template/category_articleList_tmp");

        int pageSizeInt = Integer.parseInt(pageSize);
        int currentPageInt = Integer.parseInt(currentPage);
        ArticleDto model = new ArticleDto();
        Map<String, String> sortMap = new HashMap<>();

        model.setParentCategory(Integer.parseInt(category));
        sortMap.put(sort, "desc");
        String[] queryField = new String[]{"id", "title", "viewHits", "description", "createOn"};

        List<ArticleDto> articleDtoList = articleService.findArticleListByCondition(model, queryField, sortMap, currentPageInt, pageSizeInt);
        articleDtoList = articleService.getArticleTag(articleDtoList);
        mav.addObject("articleDtoList", articleDtoList);

        return mav;
    }
}
