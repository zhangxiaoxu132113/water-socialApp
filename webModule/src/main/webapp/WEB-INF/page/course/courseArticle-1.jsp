<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/asset/css/mrwater.css">
</head>
<body>
<div id="container">
    <div id="header">
        <div id="header-inner">
            <div class="header-nav">
                <div class="header-nav-inner">
                    <ul>
                        <li>uubook</li>
                        <li>博客</li>
                        <li>软件资讯</li>
                        <li>IT教程</li>
                        <li>知识库</li>
                        <li>知识库</li>
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
    <div id="main-content">
        <div id="main-content-inner" class="clearfix Grid Grid-withGutter">
            <div class="Grid-cell">
                <div class="catalog-list">
                    <ul>
                        <li><a href=""></a></li>
                        <li><a href=""></a></li>
                        <li><a href=""></a></li>
                    </ul>
                </div>
            </div>

            <div class="Grid-cell">
                <div class="main-content">
                    <div class="main-content-inner">
                        <div class="location">
                            <span>当前位置：</span> <span>IT教程</span>
                        </div>
                        <div class="article">
                            <div class="article-title">文章的标题</div>
                            <div class="article-content"></div>
                            <div class="enjoy-article">
                                分享文章
                            </div>
                        </div>
                        <div class="about-article">
                            <div class="about-article-inner">
                                <h3>相关文章</h3>
                                <ul>
                                    <li><a href=""></a></li>
                                    <li><a href=""></a></li>
                                    <li><a href=""></a></li>
                                    <li><a href=""></a></li>
                                    <li><a href=""></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="ad">
                            <div class="ad-inner">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="Grid-cell">
                <div class="main-right">
                    <div class="main-right-inner">
                        <div class="about-course">
                            <h3>相关教程</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
