package com.water.db.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.water.db.dao.WeiboMapper;
import com.water.db.model.User;
import com.water.db.model.Weibo;
import com.water.db.service.interfaces.WeiboService;
import com.water.utils.common.Constants;
import com.water.utils.web.HttpRequestTool;
import com.water.utils.web.MWSessionUtils;
import com.water.utils.web.WebUtils;
import com.water.utils.web.view.ResultView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 2017/2/19.
 */
@RestController
@RequestMapping(value = "/weibo")
public class WeiBoController {

    @Resource
    private WeiboService weiboService;

    @Resource
    private WeiboMapper weiboMapper;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addWeibo(HttpServletRequest request, HttpServletResponse response, Weibo weibo) {
        User user = MWSessionUtils.getUser2Session(request);
        weibo.setUser_id(String.valueOf(user.getId()));
        ResultView resultView = weiboService.addWeibo(weibo);
        WebUtils.sendResult(response, resultView);
    }

    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    public void getAuthCode(HttpServletRequest request) {
        System.out.println(request.getParameter("code"));
        String url = "https://api.weibo.com/2/statuses/user_timeline.json?access_token=%s";
        url = String.format(url, new Object[]{
                Constants.WEIBO_CONFIG.ACCESS_TOKEN
        });
        String result = (String) HttpRequestTool.getRequest(url);
        Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);
        JSONArray weiboList = (JSONArray) resultMap.get("statuses");
        List<Weibo> weiBos = JSONArray.parseArray(weiboList.toJSONString(), Weibo.class);
        System.out.println(weiboList.toJSONString());
        for (Weibo weiBo : weiBos) {
            weiBo.setUser_id("3");
            weiboMapper.insert(weiBo);
        }
    }
}
