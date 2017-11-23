package com.water.db.controller;

import com.water.db.service.interfaces.NewsService;
import com.water.utils.common.Constants;
import com.water.uubook.model.dto.TbUbArticleDto;
import com.water.uubook.service.TbUbArticleService;
import org.elasticsearch.common.collect.HppcMaps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangmiaojie on 2017/6/21.
 * 新闻资讯
 */
@Controller
@RequestMapping(value = "/new")
public class NewsController {

    @Resource
    private TbUbArticleService articleService;

    @Resource
    private NewsService newsService;


    @RequestMapping(value = "")
    public ModelAndView index(@RequestParam(defaultValue = "1") Integer type, @RequestParam(defaultValue = "1") Integer currentPage) {
        int pageSize = 15;
        ModelAndView mav = new ModelAndView();
        List<TbUbArticleDto> articleDtoList = newsService.getNewsByPage(currentPage, pageSize, type);
        Integer totalHits = newsService.countNewsTotal(type);
        List<TbUbArticleDto> hotArticleList = newsService.getHotNewsWithType(10, Constants.ARTICLE_MODULE.RUANJIAN_GENGXIN.index);

        mav.addObject("type", type);
        mav.addObject("totalHits", totalHits);
        mav.addObject("currentPage", currentPage);
        mav.addObject("articleDtoList", articleDtoList);
        mav.addObject("hotArticleList", hotArticleList);
        mav.setViewName("/news/newsIndex");
        return mav;
    }

    @RequestMapping(value = "/detail/{articleId}.html")
    public ModelAndView getDetailArticle(@PathVariable Integer articleId) {
        ModelAndView mav = new ModelAndView();
        TbUbArticleDto articleDto = articleService.findArticleById(articleId);
        List<TbUbArticleDto> hotArticleList = newsService.getHotNewsWithType(10, Constants.ARTICLE_MODULE.RUANJIAN_GENGXIN.index);
        List<TbUbArticleDto> newestArticleList = newsService.getNewsByPage(1, 10, 12);

        mav.addObject("article", articleDto);
        mav.addObject("hotArticleList", hotArticleList);
        mav.addObject("newestArticleList", newestArticleList);
        mav.setViewName("/news/newsDetail");
        return mav;
    }

}
