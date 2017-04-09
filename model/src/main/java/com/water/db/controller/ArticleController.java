package com.water.db.controller;

import com.water.db.model.ITArticle;
import com.water.db.model.ITTag;
import com.water.db.model.User;
import com.water.db.model.dto.ITArticleDto;
import com.water.db.model.dto.ITTagDto;
import com.water.db.service.interfaces.ITArticleService;
import com.water.db.service.interfaces.ITTagService;
import com.water.utils.web.MWSessionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by mrwater on 2017/4/2.
 */
@Controller
public class ArticleController {
    private Log logger = LogFactory.getLog(ArticleController.class);

    @Resource
    private ITTagService tagService;

    @Resource
    private ITArticleService articleService;

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public ModelAndView articleIndex(HttpServletRequest request) {
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

    @RequestMapping(value = "/article/detail/{articleId}")
    public ModelAndView getArticleDetail(@PathVariable String articleId) {
        ModelAndView mav = new ModelAndView();
        ITArticleDto article = articleService.getArticleDetailById(articleId);
        mav.addObject("article", article);
        mav.setViewName("/articleDetail");
        return mav;
    }

    @RequestMapping(value = "/article/search", method = RequestMethod.GET)
    public ModelAndView searchArticle(@RequestParam(defaultValue = "") String keyword,
                                      @RequestParam(defaultValue = "0") int begin,
                                      @RequestParam(defaultValue = "10") int pageSize) {
        ModelAndView mav = new ModelAndView();
        List<ITArticle> articleList = articleService.searchArticleByKeyword(keyword, begin, pageSize);
        mav.addObject("articleList", articleList);
        mav.setViewName("/searchPage");
        return mav;
    }
}
