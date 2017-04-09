<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 2017/4/9
  Time: 下午7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/asset/css/searchPage.css">
</head>
<body>
<div id="container">
    <div id="container-inner">
        <div class="header">
            <div class="header-inner">
                <div class="logo" style="float: left">
                    <img src="<%=path%>/asset/content/logo.png" alt="" class="logo-img">
                </div>
                <div class="search-frame">
                    <form action="/article/search" method="get">
                        <input type="text" class="search-input-text" name="keyword">
                        <input class="search-btn" value="搜索" type="submit">
                        <%--<a class="search-btn">搜索</a>--%>
                    </form>
                </div>
                <div class="userinfo" style="float: right">
                    <ul>
                        <li><a href="">首页</a></li>
                        <li>设置</li>
                        <li>登录</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="search-nav">
            <div class="search-nav-inner">
                <ul>
                    <li class="active">全部</li>
                    <li>IT文章</li>
                    <li>资讯</li>
                    <li>教程</li>
                </ul>
            </div>
        </div>
        <div class="main-content">
            <div class="main-content-inner">
                <div class="search-content">
                    <div class="search-total">为你找到相关搜索:<span>3400</span>个</div>
                    <c:forEach items="${requestScope.articleList}" var="article">
                        <div class="search-item">
                            <div class="article-title">${article.title}</div>
                            <div class="article-content">
                                    ${article.description}
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="bailianmeng" style="padding: 2em;box-sizing: border-box">
                    <img src="./img/baidulianmeng.png" alt="" width="100%">
                </div>
            </div>
            <div class="page">
                <span>&lt;&lt;上一页</span>
                <span>1</span>
                <span>2</span>
                <span>3</span>
                <span>4</span>
                <span>5</span>
                <span>下一页&gt;&gt;</span>
            </div>
            <div style="clear: both"></div>
        </div>

        <div class="footer">
            <div class="footer-inner">
                <a href="">建议</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
