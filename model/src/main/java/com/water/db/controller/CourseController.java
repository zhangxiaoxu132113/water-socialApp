package com.water.db.controller;

import com.water.uubook.model.TbUbArticle;
import com.water.uubook.model.dto.TbUbArticleDto;
import com.water.uubook.model.dto.TbUbCourseDto;
import com.water.uubook.model.dto.CourseSubjectDto;
import com.water.db.service.interfaces.ITArticleService;
import com.water.utils.lang.StringUtil;
import com.water.uubook.service.TbUbCourseService;
import com.water.uubook.service.TbUbCourseSubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Resource(name = "iTArticleService")
    private ITArticleService articleService;

    @Resource
    private TbUbCourseService courseService;

    @Resource
    private TbUbCourseSubjectService courseSubjectService;

    @RequestMapping(value = "")
    public ModelAndView course(HttpServletRequest request, HttpServletResponse response) throws ExecutionException {
        ModelAndView mav = new ModelAndView();
        List<CourseSubjectDto> courseSubjectList = courseSubjectService.findAllCourseSubject();

        mav.addObject("courseSubjects", courseSubjectList);
        mav.setViewName("/course/courseIndex");
        return mav;
    }

    @RequestMapping(value = "/{courseName}")
    public ModelAndView getCourseSubjectListByCourseName(@PathVariable String courseName) throws UnsupportedEncodingException, ExecutionException {
        Map<String, Object> queryMap = new HashMap<>();
        courseName = StringUtil.transform2utf8(courseName);
        courseName = StringUtil.deconde(courseName);
        queryMap.put("courseName", courseName);

        CourseSubjectDto courseSubjectDto = courseSubjectService.getCourseSubjectByExample(queryMap);
        List<TbUbArticle> articleList = articleService.getRelatedArticles(courseName, 10);
        List<TbUbCourseDto> courseDtoList = courseService.getCatalogByCourseName(courseName);

        ModelAndView mav = new ModelAndView();
        mav.addObject("articleList", articleList);
        mav.addObject("courseDtoList", courseDtoList);
        mav.addObject("courseSubjectDto", courseSubjectDto);
        mav.setViewName("/course/courseDetail");
        return mav;
    }

    @RequestMapping(value = "/{courseName}/{articleId}.html")
    public ModelAndView getArticleDetail(@PathVariable String courseName,
                                         @PathVariable Integer articleId) throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView();
        courseName = StringUtil.transform2utf8(courseName);
        courseName = StringUtil.deconde(courseName);
        List<TbUbCourseDto> catalogTitleList = courseService.getCatalogByCourseName(courseName);
        if (catalogTitleList == null || catalogTitleList.isEmpty()) {
            //todo 返回404
        }

        TbUbArticleDto article = articleService.getArticleDetailById(articleId);
//        if (article != null) {
//            List<TbUbArticle> articleList = articleService.getRelatedArticles(article);
//            article.setRelatedArticles(articleList);
//        }
        mav.addObject("courseName", courseName);
        mav.addObject("article", article);
        mav.addObject("catalogTitleList", catalogTitleList);
        mav.setViewName("/course/courseArticle");
        return mav;
    }
}
