package com.water.db.controller;

import com.water.uubook.model.Article;
import com.water.uubook.model.CourseSubject;
import com.water.uubook.model.ITArticle;
import com.water.uubook.model.Tag;
import com.water.uubook.model.dto.*;
import com.water.db.service.interfaces.ITArticleService;
import com.water.db.service.interfaces.ITTagService;
import com.water.utils.lang.StringUtil;
import com.water.uubook.service.CategoryService;
import com.water.uubook.service.CourseService;
import com.water.uubook.service.CourseSubjectService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by mrwater on 2017/4/2.
 * 技术博文
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    private Log logger = LogFactory.getLog(ArticleController.class);

    @Resource(name = "iTTagService")
    private ITTagService tagService;

    @Resource(name = "iTArticleService")
    private ITArticleService articleService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private CourseSubjectService courseSubjectService;

    @RequestMapping(value = "/detail/{articleId}.html")
    public ModelAndView getArticleDetail(@PathVariable int articleId) throws ExecutionException {
        ModelAndView mav = new ModelAndView();
        List<Article> articleList = new ArrayList<>();
        ArticleDto article = articleService.getArticleDetailById(articleId);
        if (article != null) {
            articleList = articleService.getRelatedArticles(article.getTitle(), 10);
            article.setRelatedArticles(articleList);
        }
        CategoryDto categoryDto = categoryService.getCategoryById(article.getCategory());
        List<CategoryDto> categoryDtos = categoryService.getHotCategories();

        List<CourseSubjectDto> recommendCourses = new ArrayList<>();
        String[] tagArray = new String[5];
        List<Tag> tags = article.getTagList();
        if (tags != null && tags.size() > 0) {
            for (int i=0; i<tags.size(); i++) {
                tagArray[i] = tags.get(i).getName();
            }
        }
        recommendCourses = courseSubjectService.getRecommendCourseSubjectByTags(tagArray);

        mav.addObject("article", article);
        mav.addObject("category", categoryDto);
        mav.addObject("categoryDtos", categoryDtos);
        mav.addObject("relatedArticles", articleList);
        mav.addObject("recommendCourses", recommendCourses);
        mav.setViewName("/article/articleDetail");
        return mav;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchArticle(@RequestParam(defaultValue = "") String keyword,
                                      @RequestParam(defaultValue = "1") int currentPage,
                                      @RequestParam(defaultValue = "10") int pageSize) throws UnsupportedEncodingException {
        keyword = StringUtil.transform2utf8(keyword);
        keyword = StringUtil.deconde(keyword);
        ModelAndView mav = new ModelAndView();
        int begin = (currentPage - 1) * pageSize;
        Map<String, Object> resultMap = articleService.searchArticleByKeyword(keyword, begin, pageSize);
        List<ITArticle> articleList = (List<ITArticle>) resultMap.get("data");
        Long took = (Long) resultMap.get("took");
        Long totalHits = (Long) resultMap.get("totalHits");

        mav.addObject("currentPage", currentPage);
        mav.addObject("took", took);
        mav.addObject("totalHits", totalHits);
        mav.addObject("articleList", articleList);
        mav.addObject("keyword", keyword);
        mav.setViewName("/searchPage");


        return mav;
    }
}
