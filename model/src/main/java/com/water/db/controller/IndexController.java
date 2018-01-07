package com.water.db.controller;

import com.water.db.service.interfaces.IBlogService;
import com.water.db.service.interfaces.ITArticleService;
import com.water.db.service.interfaces.ITopService;
import com.water.db.service.interfaces.NewsService;
import com.water.quartz.WebSiteGeneratorTask;
import com.water.utils.common.Constants;
import com.water.utils.db.DBUtil;
import com.water.utils.web.CategoryHelper;
import com.water.utils.web.PageConstants;
import com.water.utils.web.vo.AdInfo;
import com.water.utils.web.vo.Category;
import com.water.uubook.dao.TbUbArticleMapper;
import com.water.uubook.model.dto.TbUbArticleDto;
import com.water.uubook.model.dto.TbUbCategoryDto;
import com.water.uubook.model.dto.CourseSubjectDto;
import com.water.uubook.service.TbUbCategoryService;
import com.water.uubook.service.TbUbCourseSubjectService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/6/4.
 * 首页
 */
@Controller
public class IndexController {
    @Resource
    private TbUbCategoryService categoryService;
    @Resource
    private ITopService topService;
    @Resource
    private TbUbCourseSubjectService courseSubjectService;
    @Resource
    private NewsService newsService;
    @Resource
    private CategoryHelper categoryHelper;
    @Resource
    private IBlogService blogService;

    @RequestMapping(value = {"/", "/index", "/index.html"})
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();

        List<Category> menuList = categoryHelper.getAllCategories();
        mav.addObject(PageConstants.INDEX.MENUS, menuList);//导航栏菜单

        List<TbUbCategoryDto> categoryList = categoryService.getAllParentCategories();
        mav.addObject(PageConstants.INDEX.CATEGORIES, categoryList);//栏目分类
//        this.setHotArticleWithCategory(categoryList);//设置每一个栏目下的热门文章

        List<TbUbArticleDto> topArticleList = topService.getHotTopArticle(12);
        mav.addObject(PageConstants.INDEX.HOT_TOP_ARTICLES, topArticleList);//头条文章

        List<TbUbArticleDto> softwareInformations = newsService.getHotNewsWithType(10,
                Constants.ARTICLE_MODULE.RUANJIAN_GENGXIN.index);
        mav.addObject(PageConstants.INDEX.NEW_SOFT_ARTICLES, softwareInformations);//软件资讯

        List<CourseSubjectDto> courseSubjectList = courseSubjectService.getHotCourseSubjectWithSize(4);
        mav.addObject(PageConstants.INDEX.COURSE_ARTICLES, courseSubjectList);//热门教程

        List<TbUbArticleDto> hotBlogArticle = blogService.getHotArticleList(null, 10);
        mav.addObject(PageConstants.INDEX.HOT_BLOG_ARTICLES, hotBlogArticle);

        List<AdInfo> adInfoList = this.getIndexPageAd();
        mav.addObject(PageConstants.INDEX.AD_INFOS, adInfoList);
        mav.setViewName("/index");
        return mav;
    }

    /**
     * 根据分类获取每一个分类下的热门文章
     * @param categoryList
     */
    private void setHotArticleWithCategory(List<TbUbCategoryDto> categoryList) {
        int pageSize = 10;
        categoryList.stream().forEach(p -> {
            Integer categoryId = p.getId();
            List<TbUbArticleDto> articleList = blogService.getHotArticleList(categoryId, pageSize);
            p.setHotArticles(articleList);
        });
    }

    private List<AdInfo> getIndexPageAd() {
        List<AdInfo> adInfoList = new ArrayList<>();
        AdInfo adInfo = new AdInfo();
        adInfo.setPic("http://img.uubook.net/upload/bmiddle/201801/06/910c8940-f0fb-4408-ad78-44e8b6c59544.png");
        adInfo.setUrl("/shop/python");

        AdInfo adInfo1 = new AdInfo();
        adInfo1.setPic("http://img.uubook.net/upload/bmiddle/201801/06/793d98b3-821c-47cf-a6ca-310bc3f27d5b.jpg");
        adInfo1.setUrl("");

        adInfoList.add(adInfo);
        adInfoList.add(adInfo1);
        return adInfoList;
    }

}
