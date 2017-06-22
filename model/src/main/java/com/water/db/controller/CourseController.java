package com.water.db.controller;

import com.google.common.collect.HashBiMap;
import com.water.db.model.CourseSubject;
import com.water.db.model.ITArticle;
import com.water.db.model.dto.CourseDto;
import com.water.db.model.dto.CourseSubjectDto;
import com.water.db.model.dto.ITArticleDto;
import com.water.db.service.interfaces.CourseService;
import com.water.db.service.interfaces.CourseSubjectService;
import com.water.db.service.interfaces.ITArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private CourseSubjectService courseSubjectService;

    @RequestMapping(value = "/{courseName}")
    public ModelAndView getCourseSubjectListByCourseName(@PathVariable String courseName) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("courseName", courseName);

        List<CourseDto> courseDtoList = courseService.getCatalogByCourseName(courseName);
        CourseSubject courseSubject = courseSubjectService.getCourseSubjectByExample(queryMap);

        mav.addObject("courseDtoList", courseDtoList);
        mav.addObject("courseSubject", courseSubject);
        mav.setViewName("/course/courseDetail");
        return mav;
    }

    @RequestMapping(value = "/{courseName}/{articleId}.html")
    public ModelAndView getArticleDetail(@PathVariable String courseName,
                                         @PathVariable String articleId) {
        ModelAndView mav = new ModelAndView();
        List<CourseDto> catalogTitleList = courseService.getCatalogByCourseName(courseName);
        if (catalogTitleList == null || catalogTitleList.isEmpty()) {
            //todo 返回404
        }

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
