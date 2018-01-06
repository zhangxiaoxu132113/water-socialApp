package com.water.db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mrwater on 2018/1/4.
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @RequestMapping(value = "/ajaxRequestArticleList/${category}/${currentPage}")
    public ModelAndView ajaxRquestArticleWithCategory(@PathVariable String category, @PathVariable String currentPage) {
        ModelAndView mav = new ModelAndView();

        return mav;
    }
}
