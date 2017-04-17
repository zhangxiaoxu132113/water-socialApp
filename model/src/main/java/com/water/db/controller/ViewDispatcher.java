package com.water.db.controller;

import com.water.db.model.ITArticle;
import com.water.db.model.User;
import com.water.db.model.Weibo;
import com.water.db.model.dto.ITTagDto;
import com.water.db.service.interfaces.ITArticleService;
import com.water.db.service.interfaces.ITTagService;
import com.water.db.service.interfaces.WeiboService;
import com.water.utils.web.MWSessionUtils;
import com.water.utils.web.WebUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by mrwater on 16/6/4.
 * 视图转发器
 */
@Controller
public class ViewDispatcher {
    private Log logger = LogFactory.getLog(ViewDispatcher.class);

    @Resource
    private ITTagService tagService;

    @Resource
    private ITArticleService articleService;

    @Resource
    private WeiboService weiboService;

    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        User user = MWSessionUtils.getUser2Session(request);
        List<ITTagDto> tagList = tagService.getAllTags();
        mav.addObject("tagList", tagList);

        List<ITArticle> articleList = articleService.getGreeArticle();
        mav.addObject("greeArticleList", articleList);  //头条文章

        List<ITArticle> softwareInformations = articleService.getSoftwareInformations();
        mav.addObject("softwareInformations", softwareInformations);    //软件资讯

        List<ITArticle> recentlyReadArticles = null;
        if (user != null) {
            recentlyReadArticles = articleService.getRecentlyReadedArticlesByUser(user);
        }
        mav.addObject("recentlyReadArticles", recentlyReadArticles);    //用户最近阅读的文章

        List<ITArticle> newItArticleList = articleService.getNewArticles();
        mav.addObject("newItArticleList", newItArticleList);    //最新文章

        List<ITArticle> excellentItArticleList = articleService.getExcellentArticle();
        mav.addObject("excellentItArticleList", excellentItArticleList);    //最新文章

        mav.setViewName("/articleIndex");
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
        List<Weibo> weiboList = weiboService.getWeiboByUserid(String.valueOf(user.getId()));
        modelAndView.addObject("weiboList", weiboList);
        modelAndView.setViewName("/index");
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
}
