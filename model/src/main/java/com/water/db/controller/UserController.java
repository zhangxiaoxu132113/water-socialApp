package com.water.db.controller;

import com.water.db.model.User;
import com.water.db.service.interfaces.UserService;
import com.water.utils.common.Constants;
import com.water.utils.web.MWLoginUtils;
import com.water.utils.web.MWSessionUtils;
import com.water.utils.web.WebUtils;
import com.water.utils.web.view.ResultView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * @description 用户登录授权
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
        if (redirect_after_login != null && StringUtils.isNotBlank(redirect_after_login)) {
            resultView.createResultData().set("redirect_url", redirect_after_login).build();
        }
        resultView.createResultData().set("redirect_url", "/" + (String) user.getAccount() + "/home").build();
        resultView.setCode(Constants.STATUS_CODE.SUCCESS);
        resultView.setMsg("登录成功！");
        WebUtils.sendResult(response, resultView);
    }
}
