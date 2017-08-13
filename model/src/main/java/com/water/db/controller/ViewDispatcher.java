package com.water.db.controller;

import com.water.db.service.interfaces.IBlogService;
import com.water.db.service.interfaces.ITArticleService;
import com.water.db.service.interfaces.ITTagService;
import com.water.utils.cache.CacheManager;
import com.water.utils.web.CategoryHelper;
import com.water.utils.web.MWSessionUtils;
import com.water.utils.web.vo.Category;
import com.water.uubook.model.Article;
import com.water.uubook.model.User;
import com.water.uubook.model.dto.ArticleDto;
import com.water.uubook.model.dto.CourseSubjectDto;
import com.water.uubook.model.dto.ITTagDto;
import com.water.uubook.service.CourseSubjectService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by mrwater on 16/6/4.
 * 视图转发器
 */
@Controller
public class ViewDispatcher {
    private Log logger = LogFactory.getLog(ViewDispatcher.class);

    @Resource(name = "iTTagService")
    private ITTagService tagService;

    @Resource(name = "iTArticleService")
    private ITArticleService articleService;

    @Resource
    private CourseSubjectService courseSubjectService;


    @Resource
    private CacheManager cacheManager;

    @Resource
    private IBlogService blogService;

    @Resource
    private CategoryHelper categoryHelper;

    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws ExecutionException {
        ModelAndView mav = new ModelAndView();
        User user = MWSessionUtils.getUser2Session(request);

        List<Category> categoryList = categoryHelper.getAllCategories();
        mav.addObject("categoryList", categoryList);

        List<ITTagDto> tagList = tagService.getAllTags();
        mav.addObject("tagList", tagList);

        List<ArticleDto> articleList = articleService.getGreeArticle();
        mav.addObject("greeArticleList", articleList);  //头条文章

        List<ArticleDto> softwareInformations = articleService.getSoftwareInformations();
        mav.addObject("softwareInformations", softwareInformations);    //软件资讯

        List<Article> recentlyReadArticles = null;
        if (user != null) {
            recentlyReadArticles = articleService.getRecentlyReadedArticlesByUser(user);
        }
        mav.addObject("recentlyReadArticles", recentlyReadArticles);    //用户最近阅读的文章

        List<Article> newItArticleList = articleService.getNewArticles();
        mav.addObject("newItArticleList", newItArticleList);    //最新文章

        List<Article> excellentItArticleList = articleService.getExcellentArticle();
        mav.addObject("excellentItArticleList", excellentItArticleList);    //最新文章

        mav.setViewName("/index");
        return mav;
    }

    @RequestMapping(value = "/course")
    public ModelAndView course(HttpServletRequest request, HttpServletResponse response) throws ExecutionException {
        ModelAndView mav = new ModelAndView();
        List<CourseSubjectDto> courseSubjectList = courseSubjectService.findAllCourseSubject();

        mav.addObject("courseSubjects", courseSubjectList);
        mav.setViewName("/course/courseIndex");
        return mav;
    }

    /**
     * @description 跳转到用户的首页
     * @time 2016-06-04
     */
    @RequestMapping(value = "/{account}/home")
    public ModelAndView redirect2homePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        User user = MWSessionUtils.getUser2Session(request);
        modelAndView.setViewName("/personal/personalHome");
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginView(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String redirectAfterLogin = request.getHeader("Referer");
        if (StringUtils.isNotBlank(redirectAfterLogin)) {
            mav.addObject("redirect_after_login", redirectAfterLogin);
        }
        mav.setViewName("/login");
        return mav;
    }

    @RequestMapping(value = "/blog")
    public ModelAndView blog() {
        ModelAndView mav = new ModelAndView();
        List<ArticleDto> latestArticleList = blogService.getLatestArticleList();
        List<ArticleDto> hotArticleList = blogService.getHotArticleList();
        List<Map<String, Object>> blogCategory = blogService.getArticleByAllCategoryWithCache();

        mav.addObject("latestArticleList", latestArticleList != null ? latestArticleList : new ArrayList<>());
        mav.addObject("hotArticleList", hotArticleList != null ? hotArticleList : new ArrayList<>());
        mav.addObject("blogCategory", blogCategory != null ? blogCategory : new ArrayList<>());
        mav.setViewName("/article/index");
        return mav;
    }
}
