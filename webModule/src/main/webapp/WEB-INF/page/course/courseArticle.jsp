<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编程无忧网_${requestScope.courseName}_${requestScope.article.title}</title>
    <meta name="description" content="${fn:substring(requestScope.article.content, 0, 125)}">
    <meta name="keywords" content="${requestScope.article.title}">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/asset/css/mw-moon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/asset/css/courseArticle.css">
    <jsp:include page="../common/common.jsp"/>
    <jsp:include page="../common/baidu_statistics_code.jsp"/>
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
                        <li>
                            <a href="<%=basePath%>/course/${requestScope.courseName}/${item.articleId}.html">${status.index+1}.${item.title}</a>
                        </li>
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
                <h1 class="course-topic-title">${requestScope.courseName}</h1>
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
</div>

<script src="<%=basePath%>/plugs/mrwater/mw-upload.js"></script>
<script src="<%=basePath%>/asset/js/mw/mw-moon.js"></script>
</body>
</html>

