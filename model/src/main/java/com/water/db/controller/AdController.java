package com.water.db.controller;

import com.water.uubook.dao.VideoCourseShopMapper;
import com.water.uubook.model.VideoCourseShop;
import com.water.uubook.model.dto.VideoCourseShopDto;
import com.water.uubook.service.VideoCourseShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by mrwater on 2017/10/28.
 */
@Controller
@RequestMapping(value = "/ad")
public class AdController {
    @Resource
    private VideoCourseShopMapper videoCourseShopMapper;
    @Resource
    private VideoCourseShopService videoCourseShopService;

    /**
     * 教程视频商店列表
     *
     * @return
     */
    @RequestMapping(value = "/videoCourseShop/list", method = RequestMethod.GET)
    public ModelAndView videoCourseShop() {
        return null;
    }

    /**
     * 获取教程文章列表
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/videoCourseDetail/{id}", method = RequestMethod.GET)
    public ModelAndView videoCourseDetail(@PathVariable String id) {
        ModelAndView mav = new ModelAndView();
        VideoCourseShopDto videoCourseShopDto = videoCourseShopService.getVideoCourseById(Integer.valueOf(id));
        videoCourseShopDto.setVisitedCount(videoCourseShopDto.getVisitedCount() + 1);
        videoCourseShopMapper.updateByPrimaryKeySelective(videoCourseShopDto);
        mav.addObject("videoCourse", videoCourseShopDto);
        mav.setViewName("/shop/vedioCourseDetail");
        return mav;
    }

}
