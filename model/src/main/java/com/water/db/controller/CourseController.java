package com.water.db.controller;

import com.water.db.model.ITArticle;
import com.water.db.model.dto.CourseDto;
import com.water.db.model.dto.ITArticleDto;
import com.water.db.service.interfaces.CourseService;
import com.water.db.service.interfaces.ITArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangmiaojie on 2017/6/21.
 * 教程
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController {
    @Resource
    private ITArticleService articleService;

    @Resource
    private CourseService courseService;

    @RequestMapping(value = "/{courseName}/{articleId}.html")
    public ModelAndView getArticleDetail(@PathVariable String courseName,
                                         @PathVariable String articleId) {
        List<CourseDto> catalogTitleList = courseService.getCatalogByCourseName(courseName);
        if (catalogTitleList == null || catalogTitleList.isEmpty()) {
            //todo 返回404
        }
        ModelAndView mav = new ModelAndView();
        ITArticleDto article = articleService.getArticleDetailById(articleId);
        if (article != null) {
            List<ITArticle> articleList = articleService.getRelatedArticles(article);
            article.setRelatedArticles(articleList);
        }
        mav.addObject("article", article);
        mav.addObject("catalogTitleList", catalogTitleList);
        mav.setViewName("/course/articleDetail");
        return mav;
    }
}
