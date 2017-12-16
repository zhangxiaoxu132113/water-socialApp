package com.water.db.controller;

import com.water.db.service.interfaces.ITArticleService;
import com.water.db.service.interfaces.ITTagService;
import com.water.es.entry.ITArticle;
import com.water.utils.lang.StringUtil;
import com.water.utils.web.WebUtils;
import com.water.utils.web.view.ResultView;
import com.water.uubook.dao.TbUbArticleMapper;
import com.water.uubook.model.TbUbArticle;
import com.water.uubook.model.TbUbTag;
import com.water.uubook.model.TbUbVedioCourseShop;
import com.water.uubook.model.dto.TbUbArticleDto;
import com.water.uubook.model.dto.TbUbCategoryDto;
import com.water.uubook.model.dto.CourseSubjectDto;
import com.water.uubook.service.TbUbCategoryService;
import com.water.uubook.service.TbUbCourseSubjectService;
import com.water.uubook.service.TbUbVideoCourseShopService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    private TbUbCategoryService categoryService;

    @Resource
    private TbUbCourseSubjectService courseSubjectService;

    @Resource
    private TbUbArticleMapper articleMapper;

    @Resource
    private TbUbVideoCourseShopService videoCourseShopService;

    /**
     * 根据id获取文章详情
     *
     * @param articleId
     * @return
     * @throws ExecutionException
     */
    @RequestMapping(value = "/detail/{articleId}.html")
    public ModelAndView getArticleDetail(@PathVariable int articleId) throws ExecutionException {
        ModelAndView mav = new ModelAndView();
        List<TbUbArticle> articleList = new ArrayList<>();
        TbUbArticleDto article = articleService.getArticleDetailById(articleId);
        if (article == null) {
            //抛出404
            return null;
        }
        article.setRelatedArticles(articleService.getRelatedArticles(article.getTitle(), 12)); //设置相关文章
        TbUbCategoryDto categoryDto = categoryService.getCategoryById(article.getCategory());
        List<TbUbCategoryDto> categoryDtos = categoryService.getHotCategories();
        //获取相关文章
        String[] tagArray = new String[5];
        List<TbUbTag> tags = article.getTagList();
        if (tags != null && tags.size() > 0) {
            for (int i = 0; i < tags.size(); i++) {
                tagArray[i] = tags.get(i).getName();
            }
        }
        List<CourseSubjectDto> recommendCourses = courseSubjectService.getRecommendCourseSubjectByTags(tagArray);
        //更新文章阅读量
        article.setViewHits(article.getViewHits() + 1);
        articleMapper.updateByPrimaryKeySelective(article);
        //查询视频教程广告
//        List<TbUbVedioCourseShop> videoCourseShopList = videoCourseShopService.findVideoCourseByCategory(article.getCategory());

        mav.addObject("article", article);
        mav.addObject("category", categoryDto);
        mav.addObject("categoryDtos", categoryDtos);
        mav.addObject("relatedArticles", articleList);
        mav.addObject("recommendCourses", recommendCourses);
//        mav.addObject("videoCourseShopList", videoCourseShopList);
        mav.setViewName("/article/articleDetail");
        return mav;
    }

    /**
     * 根据关键词搜索相关文章
     *
     * @param keyword
     * @param currentPage
     * @param pageSize
     * @return
     * @throws UnsupportedEncodingException
     */
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

    /**
     * 文章投票
     *
     * @param request
     * @param articleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/voted", method = RequestMethod.POST)
    public ResultView voted(HttpServletRequest request, int articleId,
                            @RequestParam(defaultValue = "1") int attitude) {
        return articleService.articleVote(WebUtils.getRemortIP(request), articleId, attitude);
    }
}
