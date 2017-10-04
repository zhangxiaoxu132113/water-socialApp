<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 2017/7/15
  Time: 下午8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/asset/css/blog-index.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/mw-moon.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/common/footer-common.css">
</head>
<body>
<div id="container">
    <div id="header">
        <div id="header-inner">
            <div class="header-nav">
                <div class="header-nav-inner">
                    <ul>
                        <li><a href="<%=path%>/">首页</a></li>
                        <li><a href="<%=path%>/blog">文档库</a></li>
                        <li><a href="<%=path%>/new">资讯</a></li>
                        <li><a href="<%=path%>/course">IT教程</a></li>
                        <li><a href="<%=path%>/base">知识库</a></li>
                    </ul>
                </div>
            </div>
            <div class="header-user">
                <div class="header-user-inner">
                    <ul>
                        <li><a href="/login">登录</a></li>
                        <li><a href="/user/register">注册</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div id="middle">
        <div class="middel-inner clearfix">
            <div class="logo">
                <p><img src="<%=path%>/asset/content/logo.png" class="logo-icon"></p>
            </div>
            <div class="search">
                <div class="search-inner clearfix">
                    <h4>文章搜索</h4>
                    <div class="search-input">
                        <input type="text" placeholder="Java 教程, Mysql 教程">
                    </div>
                    <div class="search-btn">
                        <input type="submit"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="left-content">
                <div class="tatest-article">
                    <div class="tatest-article-inner">
                        <div class="tatest-article-header">
                            <h4>最新文章</h4>
                            <a href="<%=path%>/blog/java">查看更多</a>
                        </div>
                        <div class="tatest-article-items">
                            <div class="clearfix">
                                <%--显示10条--%>
                                <c:forEach items="${requestScope.latestArticleList}" var="article">
                                    <div class="col-md-6 item">
                                        <span class="dot" style="top: 0.85rem"></span>
                                        <a href="<%=path%>/article/detail/${article.id}.html">${article.title}</a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <%--显示各个模块--%>
                <div class="category-item">
                    <c:forEach items="${requestScope.blogCategory}" var="item">
                        <div class="item">
                            <div class="header">
                                <h4>${item.category.name}</h4>
                                <a href="<%=path%>/blog/${item.category.name}">查看更多</a>
                            </div>
                            <section class="content">
                                <c:forEach items="${item.articles}" var="article">
                                    <div class="article-item">
                                        <h2 class="title">
                                            <a href="<%=path%>/article/detail/${article.id}.html">${article.title}</a>
                                        </h2>
                                        <div class="article-intro">
                                            <span class="tag"><a href="">java</a></span>
                                            <span class="time">by <span>2017-07-13 22:24</span></span>
                                            <a href="<%=path%>/article/detail/${article.id}.html"> 详细内容</a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </section>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="right-content">
                <%--热门文章 xq：显示11篇文章--%>
                <div class="hot-article">
                    <div class="title">
                        <h3>热门文章</h3>
                    </div>
                    <ul>
                        <c:forEach items="${requestScope.hotArticleList}" var="article">
                            <li><span class="dot"></span><a href="<%=path%>/article/detail/${article.id}.html">${article.title}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%--页脚--%>
    <div id="footer">
        <div id="footer-inner">
            <p>
                Copyright © 2017-now uubook.net 当前呈现版本 1.0.0
            </p>
            <p>
                浙ICP备 15005796号-2   浙公网安备 33010602002000号
            </p>
        </div>
    </div>
</div>
</body>
</html>
