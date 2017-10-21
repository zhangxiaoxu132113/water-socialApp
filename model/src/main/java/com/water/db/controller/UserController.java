package com.water.db.controller;

import com.water.uubook.model.User;
import com.water.db.service.interfaces.UserService;
import com.water.utils.common.Constants;
import com.water.utils.web.MWLoginUtils;
import com.water.utils.web.MWSessionUtils;
import com.water.utils.web.WebUtils;
import com.water.utils.web.view.ResultView;
import com.water.utils.web.vo.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrwater on 16/6/4.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/emotionRecord", method = RequestMethod.GET)
    public ModelAndView emotion() {
        return new ModelAndView("/emotionRecord");
    }

    /**
     * @Description 用户登录授权
     * @time 2016-06-04
     */
    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public void authorize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultView resultView = new ResultView();
        String login_username = request.getParameter("login_name");
        String login_password = request.getParameter("login_pwd");
        String redirect_after_login = request.getParameter("redirect_after_login");

        User user = userService.findUserByNameAndPwd(login_username, login_password);
        if (user == null) {
            resultView.setCode(Constants.STATUS_CODE.FAILURE);
            resultView.setMsg("用户不存在!登陆失败");
            WebUtils.sendResult(response, resultView);
        }
        MWLoginUtils.addCookie(login_username, login_password, request, response); //是否要添加cookie
        MWSessionUtils.addUser2Session(request, user); //将用户对象添加到Session中
        //跳转视图
        resultView.setCode(Constants.STATUS_CODE.SUCCESS);
        resultView.setMsg("登录成功！");
        if (redirect_after_login != null && StringUtils.isNotBlank(redirect_after_login)) {
            resultView.createResultData().set("redirect_url", redirect_after_login).build();
        } else {
            resultView.createResultData().set("redirect_url", "/" + (String) user.getAccount() + "/home").build();
        }
        WebUtils.sendResult(response, resultView);
    }

    /**
     * @Description 用户注册
     * @time 2017-01-25
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response, UserDto userDto) {
        ResultView resultView = new ResultView();
        userService.addUser(userDto);
        System.out.println("register!");
        resultView.setCode(Constants.STATUS_CODE.SUCCESS);
        resultView.setMsg("注册成功！");
        WebUtils.sendResult(response, resultView);
    }

    /**
     * @description 跳转到用户的首页
     * @time 2016-06-04
     */
    @RequestMapping(value = "/{account}/home")
    public ModelAndView redirect2homePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        User user = MWSessionUtils.getUser2Session(request);
        modelAndView.setViewName("/personal/personalHome");
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginView(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String redirectAfterLogin = request.getHeader("Referer");
        if (StringUtils.isNotBlank(redirectAfterLogin)) {
            mav.addObject("redirect_after_login", redirectAfterLogin);
        }
        mav.setViewName("/login");
        return mav;
    }
}
