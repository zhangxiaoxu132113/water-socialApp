package com.water.db.controller;

import com.water.db.model.ITArticle;
import com.water.db.model.dto.ITArticleDto;
import com.water.db.service.interfaces.ITArticleService;
import com.water.db.service.interfaces.ITTagService;
import com.water.utils.lang.StringUtil;
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
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 2017/4/2.
 * 技术博文
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    private Log logger = LogFactory.getLog(ArticleController.class);

    @Resource
    private ITTagService tagService;

    @Resource
    private ITArticleService articleService;

    @RequestMapping(value = "/detail/{articleId}.html")
    public ModelAndView getArticleDetail(@PathVariable String articleId) {
        ModelAndView mav = new ModelAndView();
        ITArticleDto article = articleService.getArticleDetailById(articleId);
        if (article != null) {
            List<ITArticle> articleList = articleService.getRelatedArticles(article.getTitle(), 5);
            article.setRelatedArticles(articleList);
        }
        mav.addObject("article", article);
        mav.setViewName("/articleDetail");
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
