package com.water.db.controller;

import com.water.db.model.ITArticle;
import com.water.db.model.dto.CourseDto;
import com.water.db.model.dto.CourseSubjectDto;
import com.water.db.service.interfaces.CourseService;
import com.water.db.service.interfaces.CourseSubjectService;
import com.water.db.service.interfaces.ITArticleService;
import com.water.utils.lang.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

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
    public ModelAndView getCourseSubjectListByCourseName(@PathVariable String courseName) throws UnsupportedEncodingException, ExecutionException {
        Map<String, Object> queryMap = new HashMap<>();
        courseName = StringUtil.transform2utf8(courseName);
        courseName = StringUtil.deconde(courseName);
        queryMap.put("courseName", courseName);

        CourseSubjectDto courseSubjectDto = courseSubjectService.getCourseSubjectByExample(queryMap);
        List<ITArticle> articleList = articleService.getRelatedArticles(courseName, 10);
        List<CourseDto> courseDtoList = courseService.getCatalogByCourseName(courseName);

        ModelAndView mav = new ModelAndView();
        mav.addObject("articleList", articleList);
        mav.addObject("courseDtoList", courseDtoList);
        mav.addObject("courseSubjectDto", courseSubjectDto);
        mav.setViewName("/course/courseDetail");
        return mav;
    }

    @RequestMapping(value = "/{courseName}/{articleId}.html")
    public ModelAndView getArticleDetail(@PathVariable String courseName,
                                         @PathVariable String articleId) throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView();
        courseName = StringUtil.transform2utf8(courseName);
        courseName = StringUtil.deconde(courseName);
        List<CourseDto> catalogTitleList = courseService.getCatalogByCourseName(courseName);
        if (catalogTitleList == null || catalogTitleList.isEmpty()) {
            //todo 返回404
        }

//        ITArticleDto article = articleService.getArticleDetailById(articleId);
//        if (article != null) {
//            List<ITArticle> articleList = articleService.getRelatedArticles(article);
//            article.setRelatedArticles(articleList);
//        }
//        mav.addObject("article", article);
        mav.addObject("catalogTitleList", catalogTitleList);
        mav.setViewName("/course/courseArticle");
        return mav;
    }
}
