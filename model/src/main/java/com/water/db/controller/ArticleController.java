package com.water.db.controller;

import com.water.db.model.ITArticle;
import com.water.db.model.ITTag;
import com.water.db.model.dto.ITTagDto;
import com.water.db.service.interfaces.ITArticleService;
import com.water.db.service.interfaces.ITTagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mrwater on 2017/4/2.
 */
@Controller
public class ArticleController {
    @Resource
    private ITTagService tagService;

    @Resource
    private ITArticleService articleService;

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public ModelAndView articleIndex() {
        ModelAndView mav = new ModelAndView();
        List<ITTagDto> tagList = tagService.getAllTags();
        mav.addObject("tagList", tagList);

        List<ITArticle> articleList = articleService.getNewArticle();
        mav.addObject("articleList", articleList);

        List<ITArticle> softwareInformations = articleService.getSoftwareInformations();
        mav.addObject("softwareInformations", softwareInformations);

        mav.setViewName("/articleIndex");
        return mav;
    }

    @RequestMapping(value = "/article/detail/{articleId}")
    public ModelAndView getArticleDetail(@PathVariable String articleId) {
        ModelAndView mav = new ModelAndView();
        ITArticle article = articleService.getArticleDetailById(articleId);
        mav.addObject("article", article);
        mav.setViewName("/articleDetail");
        return mav;
    }
}
