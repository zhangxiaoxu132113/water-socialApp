package com.water.db.controller;

import com.alibaba.dubbo.container.page.Page;
import com.water.db.service.interfaces.IBlogService;
import com.water.db.service.interfaces.ITArticleService;
import com.water.db.service.interfaces.ITopService;
import com.water.db.service.interfaces.NewsService;
import com.water.utils.common.Constants;
import com.water.utils.web.CategoryHelper;
import com.water.utils.web.MWSessionUtils;
import com.water.utils.web.PageConstants;
import com.water.utils.web.vo.Category;
import com.water.uubook.model.Article;
import com.water.uubook.model.User;
import com.water.uubook.model.dto.ArticleDto;
import com.water.uubook.model.dto.CategoryDto;
import com.water.uubook.model.dto.CourseSubjectDto;
import com.water.uubook.service.CategoryService;
import com.water.uubook.service.CourseSubjectService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by mrwater on 16/6/4.
 * 首页
 */
@Controller
public class IndexController {
    private Log logger = LogFactory.getLog(IndexController.class);
    @Resource
    private CategoryService categoryService;
    @Resource(name = "iTArticleService")
    private ITArticleService articleService;
    @Resource
    private ITopService topService;
    @Resource
    private CourseSubjectService courseSubjectService;
    @Resource
    private NewsService newsService;
    @Resource
    private CategoryHelper categoryHelper;
    @Resource
    private IBlogService blogService;

    @RequestMapping(value = {"/", "/index", "/index.html"})
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws ExecutionException {
        ModelAndView mav = new ModelAndView();

        List<Category> menuList = categoryHelper.getAllCategories();
        mav.addObject(PageConstants.INDEX.MENUS, menuList);//导航栏菜单

        List<CategoryDto> categoryList = categoryService.getAllParentCategories();
        mav.addObject(PageConstants.INDEX.CATEGORIES, categoryList);//栏目分类
        this.setHotArticleWithCategory(categoryList);//设置每一个栏目下的热门文章

        List<ArticleDto> topArticleList = topService.getHotTopArticle(11);
        mav.addObject(PageConstants.INDEX.HOT_TOP_ARTICLES, topArticleList);//头条文章

        List<ArticleDto> softwareInformations = newsService.getHotNewsWithType(10,
                Constants.ARTICLE_MODULE.RUANJIAN_GENGXIN.index);
        mav.addObject(PageConstants.INDEX.NEW_SOFT_ARTICLES, softwareInformations);//软件资讯

        List<CourseSubjectDto> courseSubjectList = courseSubjectService.getHotCourseSubjectWithSize(4);
        mav.addObject(PageConstants.INDEX.COURSE_ARTICLES, courseSubjectList);//热门教程

        List<ArticleDto> hotBlogArticle = blogService.getHotArticleList(null, 10);
        mav.addObject(PageConstants.INDEX.HOT_BLOG_ARTICLES, hotBlogArticle);

        mav.setViewName("/index");
        return mav;
    }

    /**
     * 根据分类获取每一个分类下的热门文章
     * @param categoryList
     */
    private void setHotArticleWithCategory(List<CategoryDto> categoryList) {
        int pageSize = 10;
        categoryList.stream().forEach(p -> {
            Integer categoryId = p.getId();
            List<ArticleDto> articleList = blogService.getHotArticleList(categoryId, pageSize);
            p.setHotArticles(articleList);
        });
    }


}
