package com.water.db.controller;

import org.elasticsearch.common.collect.HppcMaps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhangmiaojie on 2017/6/21.
 * 新闻资讯
 */
@Controller
@RequestMapping(value = "/new")
public class NewsController {


    @RequestMapping(value = "/detail/{articleId}.html")
    public ModelAndView getDetailArticle(@PathVariable Integer articleId) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/news/newsDetail");
        return mav;
    }

}
