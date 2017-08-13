<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 2017/7/18
  Time: 下午10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <style>
        .bread {
            padding:1em 0;
        }
    </style>
    <link rel="stylesheet" href="<%=path%>/asset/css/blog-category.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/font/iconfont/iconfont.css">
</head>
<body>
    <div id="container">
        <div id="container-inner">
            <div id="header">
                <div id="header-inner">
                    <div id="logo">
                        文档库
                    </div>

                    <div id="user-info">
                        <a href="">登录</a>
                        <a href="">注册</a>
                    </div>

                    <div class="search-tag">

                    </div>
                    <div class="more-menu">

                    </div>
                </div>
            </div>
            <div id="main-body">
                <div id="main-body-inner">

                    <div id="left-body">
                        <div class="inner">
                            <div class="topic-intro">
                                <div class="intro-base clearfix">
                                    <span class="intro-base-header-img"><img src="<%=path%>/asset/content/regong.jpg" style="border-radius: 50%" alt=""></span>
                                    <span class="intro-base-desc">
                                        <span class="name">人工智能</span>
                                        <span class="name">贡献值 : 23</span>
                                        <span class="name">等级 : 11</span>
                                    </span>
                                </div>
                                <div class="intro-num">
                                    <div class="intro-num-1">
                                        <span>0</span>
                                        <span>发布</span>
                                    </div>
                                    <div class="intro-num-1">
                                        <span>34</span>
                                        <span>评论</span>
                                    </div>
                                    <div class="intro-num-1">
                                        <span>0</span>
                                        <span>顶</span>
                                    </div>
                                </div>
                            </div>
                            <ul class="all-topics">
                                <li>
                                    <span style="font-size: 1.2em">相关主题</span>
                                    <dl>
                                        <dt><a href=""><img src="<%=path%>/asset/content/react.jpg" alt=""></a></dt>
                                        <dd>
                                            <h4>云计算</h4>
                                            <p>34343, 3230493</p>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt><a href=""><img src="<%=path%>/asset/content/react.jpg" alt=""></a></dt>
                                        <dd>
                                            <h4>云计算</h4>
                                            <p>34343, 3230493</p>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt><a href=""><img src="<%=path%>/asset/content/react.jpg" alt=""></a></dt>
                                        <dd>
                                            <h4>云计算</h4>
                                            <p>34343, 3230493</p>
                                        </dd>
                                    </dl>
                                </li>
                            </ul>
                            <div class="hot-topics">
                                <ul>
                                    <li>
                                        <a href=""><img src="" alt=""></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div id="right-body">
                        <div class="inner">
                            <div class="ad">
                                <a href=""><img src="<%=path%>/asset/content/banner.jpg" alt=""></a>
                            </div>
                            <div class="about-topics">
                                <ul class="clearfix">
                                    <li><a href="">最热</a></li>
                                    <li><a href="">最新</a></li>
                                    <li><a href="">程序人生</a></li>
                                    <li><a href="">大数据</a></li>
                                    <li><a href="">人工智能</a></li>
                                    <li><a href="">物联网</a></li>
                                    <li><a href="">物联网</a></li>
                                    <li><a href="">物联网</a></li>
                                    <li><a href="">物联网</a></li>
                                </ul>
                            </div>
                            <div class="topic-articles">
                                <c:forEach items="${requestScope.articleDtoList}" var="article">
                                    <div class="item">
                                        <div class="views">
                                            <span><i class="iconfont">&#xe76d;</i></span>
                                            <span>0</span>
                                            <span ><i class="iconfont">&#xe771;</i></span>
                                        </div>
                                        <div class="article">
                                            <h3 class="article-title"><a href="<%=path%>/article/detail/${article.id}.html">${article.title}</a></h3>
                                            <div>
                                                <span>3小时</span> <span>云计算</span> <span>阅读数：89</span>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>

    </div>
</body>
</html>
