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
        #header {
            z-index: 10001;
        }
        .bread {
            padding:1em 0;
        }
        .profile-canopy-headerBg {
            position: absolute;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;
            z-index: 1000;
            overflow: hidden
        }

        .profile-canopy-headerBg img.profile-bg-img {
            position: absolute;
            left: 0;
            right: 0;
            top: -9999px;
            bottom: -9999px;
            margin: auto 0;
            width: 100%;
        }
        #middle {

        }
        #middle #middle-inner {
            padding-top: 28px;
            position: relative;
            height: 110px;
        }
        .topic-intro {
            padding-top: 3em;
            position: absolute;
            left: 46%;
            width: 180px;
        }
        .about-topic-info {
            font-size: 1.2em;
            padding: 0.25em 0 0.25em 0;
            display: block;
            font-size: 1.2em;
            border-bottom: 2px solid #ccc;
        }
        .topic-articles .item:hover {
            background: #f9fafc;
        }
        #left-body .inner .search-input {
            margin: 2em 0 3.2em 0;
        }
        #left-body .inner .search-input input[type=text] {
            display: inline-block;
            width: 185px;
            height: 35px;
            vertical-align: middle;
            border: none;
            background: #f5f6f8;
            font-size: 14px;
            color: #8a99a4;
            padding-left: 10px;
            outline: none;
            float: left;
        }
        #left-body .inner .search-input .search_btn {
            width: 35px;
            height: 35px;
            background: #4b98c8;
            float: left;
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
                    <%--<div id="logo">--%>
                        <%--Java - 文档库--%>
                    <%--</div>--%>
                    <div class="nav-menu">
                        <ul>
                            <li><a href="<%=path%>/">首页</a></li>
                            <li><a href="<%=path%>/blog">文档库</a></li>
                            <li><a href="<%=path%>/new">资讯</a></li>
                            <li><a href="<%=path%>/course">IT教程</a></li>
                            <li><a href="<%=path%>/base">知识库</a></li>
                        </ul>
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
            <div id="middle">
                <div id="middle-inner">
                    <div class="profile-canopy-headerBg">
                        <img class="profile-bg-img" src="/asset/content/user_bg.jpeg" style="transform: none">
                        <div class="topic-intro">
                            <div class="intro-base clearfix">
                                <span class="intro-base-header-img"><img src="<%=path%>/asset/content/regong.jpg" style="border-radius: 50%" alt=""></span>
                                    <span class="intro-base-desc">
                                        <span class="name">人工智能</span>
                                        <span class="name">文章收录 : 23</span>
                                    </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="main-body">
                <div id="main-body-inner">

                    <div id="left-body">
                        <div class="inner">
                            <div class="search-input clearfix">
                                <input type="text" placeholder="搜索" >
                                <span class="search_btn"></span>
                            </div>
                            <%--相关主题--%>
                            <ul class="all-topics">
                                <li>
                                    <span class="about-topic-info">相关主题</span>
                                    <dl>
                                        <dt><a href=""><img src="http://www.uubook.net:8080/asset/content/python.jpg" alt=""></a></dt>
                                        <dd>
                                            <h4>Python</h4>
                                            <p>文章收录 : 2334</p>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt><a href=""><img src="http://www.uubook.net:8080/asset/content/javase.jpg" alt=""></a></dt>
                                        <dd>
                                            <h4>java</h4>
                                            <p>文章收录 : 1923</p>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt><a href=""><img src="<%=path%>/asset/content/react.jpg" alt=""></a></dt>
                                        <dd>
                                            <h4>react</h4>
                                            <p>文章收录 : 23</p>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt><a href=""><img src="http://img.bss.csdn.net/201704250917048986.png" alt=""></a></dt>
                                        <dd>
                                            <h4>云计算</h4>
                                            <p>文章收录 : 983</p>
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
                                    <c:forEach items="${requestScope.categoryDtos}" var="category">
                                        <li><a href="<%=path%>/blog/${category.name}">${category.name}</a></li>
                                    </c:forEach>
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
