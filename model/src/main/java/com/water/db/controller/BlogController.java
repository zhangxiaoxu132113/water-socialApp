package com.water.db.controller;

import com.water.db.service.interfaces.IBlogService;
import com.water.uubook.model.dto.TbUbArticleDto;
import com.water.uubook.model.dto.TbUbCategoryDto;
import com.water.uubook.service.TbUbArticleService;
import com.water.uubook.service.TbUbCategoryService;
import com.water.uubook.service.TbUbTagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    private TbUbCategoryService categoryService;

    @Resource
    private TbUbArticleService articleService;

    @Resource
    private TbUbTagService tagService;

    @Resource
    private IBlogService blogService;

    @RequestMapping(value = "")
    public ModelAndView blog() {
        ModelAndView mav = new ModelAndView();
        List<TbUbArticleDto> latestArticleList = blogService.getLatestArticleList();
        List<TbUbArticleDto> hotArticleList = blogService.getHotArticleList(null, 10);
        List<Map<String, Object>> blogCategory = blogService.getArticleByAllCategoryWithCache();

        mav.addObject("latestArticleList", latestArticleList != null ? latestArticleList : new ArrayList<>());
        mav.addObject("hotArticleList", hotArticleList != null ? hotArticleList : new ArrayList<>());
        mav.addObject("blogCategory", blogCategory != null ? blogCategory : new ArrayList<>());
        mav.setViewName("/article/index");
        return mav;
    }

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
        TbUbCategoryDto category = categoryService.getCategoryByNameWithCache(tagName);
        if (category == null && category.getParentId() == 0) {
            return null;
        }
        List<TbUbCategoryDto> categoryDtos = categoryService.getHotCategories();
        int pageSize = 10;
        int currentPage = 1;
        TbUbArticleDto articleDto = new TbUbArticleDto();
        articleDto.setCategory(category.getId());
        String[] queryField = {"id", "title", "viewHits", "description", "picUrl", "tags", "createOn"};
        List<TbUbArticleDto> articleDtoList = articleService.findArticleListByCondition(articleDto, queryField, null, currentPage, pageSize);
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
        TbUbArticleDto model = new TbUbArticleDto();
        model.setTagName(tag);
        String[] queryField = new String[]{"id", "title", "viewHits", "description", "picUrl", "tags", "createOn"};
        List<TbUbArticleDto> articleDtoList = articleService.findArticleListWithTagByCondition(model, queryField, currentPageInt, pageSizeInt);
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
    public ModelAndView blogCategory(@PathVariable String category,
                                     HttpServletRequest request) throws ExecutionException {

        ModelAndView mav = new ModelAndView("/article/categoryModule");
        int categoryId = Integer.parseInt(category);

        TbUbArticleDto model = new TbUbArticleDto();
        model.setParentCategory(categoryId);
        Map<String, String> sortMap = new HashMap<>();
        String[] queryField = new String[]{"id", "title", "viewHits", "description", "createOn"};

        sortMap.put("createOn", "desc");
        List<TbUbArticleDto> newestArticleList = articleService.findArticleListByCondition(model, queryField, sortMap, 1, 15);
        sortMap.put("createOn", "");

        sortMap.put("viewHits", "desc");
        List<TbUbArticleDto> hotArticleList = articleService.findArticleListByCondition(model, queryField, sortMap, 1, 15);

        List<TbUbCategoryDto> categoryParentList = categoryService.getAllParentCategories();
        TbUbCategoryDto categoryDto = categoryService.getCategoryById(categoryId);

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
        TbUbArticleDto model = new TbUbArticleDto();
        Map<String, String> sortMap = new HashMap<>();

        model.setParentCategory(Integer.parseInt(category));
        sortMap.put(sort, "desc");
        String[] queryField = new String[]{"id", "title", "viewHits", "description", "createOn"};

        List<TbUbArticleDto> articleDtoList = articleService.findArticleListByCondition(model, queryField, sortMap, currentPageInt, pageSizeInt);
        articleDtoList = articleService.getArticleTag(articleDtoList);
        mav.addObject("articleDtoList", articleDtoList);

        return mav;
    }
}
