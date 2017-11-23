package com.water.db.controller;

import com.water.db.service.interfaces.ITArticleService;
import com.water.uubook.model.TbUbArticle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrwater on 2017/7/21.
 */
@RestController
@RequestMapping(value = "/rest")
public class ResfulController {

    @Resource(name = "iTArticleService")
    private ITArticleService articleService;

    @RequestMapping(value = "/findArticleByPage", method = RequestMethod.POST, produces = "application/json")
    public Map<String, Object> findArticleByPage(HttpServletRequest request, int pageSize, int currentPage) {

         return articleService.findArticlesByPage(pageSize, currentPage);

    }

    @RequestMapping(value = "/findArticleById", method = RequestMethod.GET, produces = "application/json")
    public Map<String, Object> findArticleById(Integer articleId) {
        Map<String, Object> result = new HashMap<>();
        TbUbArticle article = articleService.getArticleDetailById(articleId);
        if (article == null) {
            result.put("code", -1);
            result.put("msg", "请求的数据不存在");
            return result;
        }
        result.put("data", article);
        result.put("code", 0);
        result.put("msg", "success!");
        return result;
    }

    @RequestMapping(value = "/searchArticleByPage", method = RequestMethod.POST, produces = "application/json")
    public Map<String, Object> searchArticleByPage(String kw, int pageSize, int currentPage) {
        Map<String, Object> result = articleService.searchArticleByKeywordV2(kw, currentPage, pageSize);
        return result;
    }

}
