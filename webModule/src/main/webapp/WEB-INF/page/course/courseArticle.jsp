<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <jsp:include page="../common/common.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="<%=path%>/asset/css/mw-moon.css">
    <style>
        body {
            font-family:"Helvetica Neue",Helvetica,Arial,sans-serif
        }
        .header-inner {
            padding: 1em 1em 1em 2em;
            position: relative;
        }
        #tool-bar {
            position: absolute;
            z-index: 1;
        }
        #tool-bar ul li {
            float: left;
            margin-right: 1.5em;
        }
        #tool-bar ul li a{
            /*color: #d2d2d2;*/
            color: #bdbcbc;
            font-weight: bolder;
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
        .page-wrapper {

        }
        .page-inner {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px 0 40px 0;
        }
        .page-inner h1.article-title {
            padding-bottom: .3em;
            margin-bottom: 16px;
            font-size: 2.25em;
            line-height: 1.2;
            border-bottom: 1px solid #eee;
            color:#333;
            font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
        }
        .article-content p{
            margin-bottom: 8px;
        }
        .article-content h2 {
            font-size: 18px;
            font-weight: 700;
            margin: 12px 0;
            border-bottom: 1px solid #eaeaea;
            padding-bottom: 10px;
            padding-top: 12px;
        }
        .catalog .active {
            color:#1a97fe
        }
        .catalog a:hover {
            color:#008cff
        }
        .catalog .driver {
            height: 1px;
            margin: 7px 0;
            overflow: hidden;
            background: rgba(0,0,0,0.07);
        }
        .catalog ul li a{
            display: block;
            padding: 10px 15px;
            border-bottom: 0;
            color: #fff;
            background: transparent;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
            position: relative;
            font-size: 14px;
            font-weight: 300;
            font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
        }
        .slider-bar-inner {
            width: 300px;
        }
        /**控制翻页按钮*/
        .turn-right-btn {
            position: fixed;
            right: 1em;
            color: #ccc;
            top: 48%;
            z-index: 10002;
        }
        .turn-right-btn i, .turn-left-btn i {
            font-size: 29px;

        }
        .turn-left-btn {
            position: fixed;
            left: 1em;
            color: #ccc;
            top: 48%;
            z-index: 10002;
        }
        .turn-right-btn:hover, .turn-left-btn:hover {
            cursor: pointer;
            color: #333;
        }
        .course-topic-title {
            margin: 0;
            font-size: 20px;
            font-weight: 200;
            text-align: center;
            padding: 0;
            vertical-align: top;
            color: #7e888b;
            font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
            transition: opacity ease .4s;
            opacity: 0;
        }
        .course-topic-title:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<!-- slider bar  -->
<div class="slider-bar-left">
    <div class="slider-bar-inner">
        <div>
            <div class="catalog">
                <ul>
                    <li><a href="">${requestScope.courseName}</a></li>
                    <li class="driver"></li>
                    <c:forEach items="${requestScope.catalogTitleList}" var="item" varStatus="status">
                        <li><a href="<%=path%>/course/${requestScope.courseName}/${item.articleId}.html">${status.index+1}.${item.title}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="slider-bar-right">
    <div class="slider-bar-inner">
        <!-- operator slider  -->
        <div></div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>

</div>
<div class="controller-page">
    <div class="turn-right">
        <a href="javascript:void(0)" class="turn-right-btn"><i class="iconfont">&#xe775</i></a>
    </div>
    <div class="turn-left">
        <a href="javascript:void(0)" class="turn-left-btn"><i class="iconfont">&#xe779;</i></a>
    </div>
</div>
<div id="doc-left" style="width: 300px;display: none;height: 100%"></div>
<!-- page container -->
<div id="doc">
    <!-- header content -->
    <header class="header">
        <div class="header-inner clearfix">
            <div id="tool-bar">
                <ul>
                    <li><a class="directory-btn" href="javascript:void(0)"><i class="iconfont">&#xe790;</i></a></li>
                    <li><a href="javascript:void(0)"><i class="iconfont">&#xe693;</i></a></li>
                    <li><a href="javascript:void(0)"><i class="iconfont">&#xe62c;</i></a></li>
                </ul>
            </div>
            <div class="course-topic">
                <h1 class="course-topic-title">大数据挖掘教程</h1>
            </div>
        </div>
    </header>
    <!-- header end -->

    <!-- main content -->
    <div class="page-container">
        <div class="page-wrapper">
            <div class="page-inner">
                <h1 class="article-title">${requestScope.article.title}</h1>
                <div class="article-content">
                    ${requestScope.article.content}
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="footer-inner">
        </div>
        <div style="clear: both"></div>
    </footer>
    <!-- 发表个人心情的模钛窗口-->
    <jsp:include page="../common/sendFrame.jsp"></jsp:include>
</div>
<!--<div id="map" style="width: 800px;height: 500px;z-index: 10000">-->

</div>
<script src="/plugs/mrwater/mw-upload.js"></script>
<script src="/asset/js/mw/mw-moon.js"></script>
</body>
</html>

