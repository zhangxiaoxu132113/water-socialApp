<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<%=path%>/asset/css/mrwater.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/common/footer-common.css">
    <%--<link rel="stylesheet" href="<%=path%>/asset/css/common/header-common.css">--%>
    <link rel="stylesheet" href="<%=path%>/asset/css/common/category-common.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/font/iconfont2/iconfont.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/courseDetail.css">
    <style>
        #header{
            height: 28px;
            background: rgb(23, 132, 199);
        }

        .header-nav-inner ul li {
            float: left;
            margin-left: 2em;
            font-size: 12px;
            color: #f9f9f9;
            line-height: 28px;
        }
        .header-user ul li {
            float: right;
            margin-right: 2em;
            font-size:12px;
            color: #f9f9f9;
            line-height: 28px;
        }
        .header-user ul li a:link {
            color: #f9f9f9;
            text-decoration: none;
        }
        .header-user ul li a:visited {
            color: #f9f9f9;
            text-decoration: none;
        }
        #header-middle {
            width: 100%;
            overflow: hidden;
            zoom: 1;
            margin-bottom: 48px;
        }
        #header-middle-inner {
            margin: 0 auto;
            overflow: visible !important;
            position: relative;
            padding: 10px 0 5px;
            zoom: 1;
        }
        .search h3 {
            float: left;
            padding-top: 0.5em;
            padding-bottom: 0.5em;
            font-size: 22px;
            color: #1b95e0;
        }
        .search-input {
            width: 470px;
            height: 34px;
            text-align: center;
            margin-right: -3px;
            cursor: text;
            background: url(/asset/content/nav_bg.png) no-repeat 0 6px;
        }
        .search-input input[type=text]{
            border:none;
            background: #fff;
            width: 96%;
            margin: 0;
            text-align: left;
            height: 30px;
            padding-left: 10px;
            height: 28px\9;
            line-height: 28px\9;
            outline: none;
        }
        .search {
            border-bottom:1px solid #e5ebe4;
        }
        .search-inner {
            width: 950px;
            margin:0 auto;
        }
        .clearfix:after {
            overflow: hidden;
            visibility: hidden;
            display: block;
            font-size: 0;
            content: " ";
            clear: both;
            height: 0;
        }

        #header-middle{
            background-color:#f0f3f5;
        }
        .hot-course-command {
            width: 950px;
            margin:0 auto;
        }
        .hot-course-command ul li {
            float: left;
            margin-right: 1em;
            height: 39px;
            line-height:39px;
        }
        .hot-course-command ul li a:link {
            color:#37a;
            font-size: 13px;
            text-decoration: none;
        }
    </style>
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
    <div id="header-middle">
        <div id="header-middle-inner">
            <div class="search">
                <div class="search-inner clearfix">
                    <h3>教程搜索</h3>
                    <div class="search-input">
                        <input type="text">
                    </div>
                </div>
            </div>
            <div class="hot-course-command">
                <ul class="clearfix">
                    <li>精品教程</li>
                    <li><a href="">java教程</a></li>
                    <li><a href="">mysql教程</a></li>
                    <li><a href="">elasticsearch教程</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div id="main-content">
        <div id="main-content-inner" class="clearfix Grid Grid-withGutter">
            <div class="Grid-cell u-size3of4">
                <div class="main-left-inner">
                    <div class="current-location">
                        <span>当前位置:</span> IT教程 >> Java教程
                    </div>
                    <div class="course-name">${requestScope.courseSubject.name}</div>
                    <div class="course-description">${courseSubject.description}</div>
                    <ul>
                        <c:forEach items="${requestScope.courseDtoList}" var="course" varStatus="status">
                            <li><a href="/course/${requestScope.courseSubject.name}/${course.id}.html">${status.index + 1},${course.title}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="Grid-cell u-size1of4">
                <div class="main-right-inner">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
