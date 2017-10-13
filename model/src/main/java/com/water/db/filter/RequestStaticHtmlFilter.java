package com.water.db.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrwater on 2017/10/12.
 */
public class RequestStaticHtmlFilter implements Filter {

    private static String staticHtmlPath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        staticHtmlPath = "/Users/mrwater/Documents/untitled.html";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestUri = request.getRequestURI();
        //1, 定义一个输入流
        if (this.isDetailPage(requestUri)) {
            //如果是详情页面，则先从本地找静态页面,如果找到则

        } else {
            //如果不是详情页面，则试着从缓存查找数据
        }

        filterChain.doFilter(request, response);

    }

    /**
     * 通过请求url的后缀是否是html结尾，来判断是否是详情页
     * @param requestUrl
     * @return
     */
    private boolean isDetailPage(String requestUrl) {
        if (requestUrl.lastIndexOf("html") != -1) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
