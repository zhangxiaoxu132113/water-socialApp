<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>编程无忧网_教程_${courseSubjectDto.name}</title>
    <meta name="description" content="${courseSubjectDto.description}">
    <meta name="keywords" content="${courseSubjectDto.name}">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/mrwater.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/common/footer-common.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/common/category-common.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/font/iconfont2/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/courseDetail.css">
</head>
<body>
<div id="container">
    <div id="header">
        <div id="header-inner">
            <div class="header-nav">
                <div class="header-nav-inner">
                    <ul>
                        <li><a href="<%=basePath%>">uubook</a></li>
                        <li><a href="<%=basePath%>/blog/">博客</a></li>
                        <li><a href="<%=basePath%>/new/">软件资讯</a></li>
                        <li><a href="<%=basePath%>/course/">IT教程</a></li>
                        <li><a href="">知识库</a></li>
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
                        <input type="text" placeholder="Java 教程, Mysql 教程">
                    </div>
                    <div class="search-btn">
                        <input type="submit"/>
                    </div>
                </div>
            </div>
            <div class="hot-course-command">
                <ul class="clearfix">
                    <li>精品教程</li>
                    <li><a href="">java教程</a></li>
                    <li><a href="">mysql教程</a></li>
                    <li><a href="">elasticsearch教程</a></li>
                    <li><a href="">react native教程</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id="main-content">
        <div id="main-content-inner" class="clearfix Grid Grid-withGutter">
            <div class="Grid-cell u-size3of4">
                <div class="main-left-inner">
                    <div class="current-location">
                        <span><i class="iconfont">&#xf0295;</i>当前位置:</span> <a href="">IT教程</a> > <a href="">${requestScope.courseSubjectDto.partentCourseSubject.name}</a> > <a href="">${requestScope.courseSubjectDto.name}</a>
                    </div>
                    <div class="course-main-body">
                        <div class="course-name">
                            ${requestScope.courseSubjectDto.name}<span class="course-score">(评分：<span class="allStart allStart45"></span>8分)</span>
                            <span style="float: right" class="sc-btn"><i class="iconfont">&#xf00b1;</i>收藏</span>
                        </div>
                        <div class="course-description">${courseSubjectDto.description}</div>
                        <ul class="catalog-list">
                            <c:forEach items="${requestScope.courseDtoList}" var="course" varStatus="status">
                                <c:if test="${course.id != ''}">
                                    <li><a href="/course/${requestScope.courseSubjectDto.name}/${course.articleId}.html">${status.index + 1},${course.title}</a></li>
                                </c:if>
                            </c:forEach>
                        </ul>

                        <div class="bdsharebuttonbox">
                            <style>
                                .bdsharebuttonbox {
                                    background: #f2f7f6;
                                    padding: 0.25em;
                                    padding-left: 0.5em;
                                    border-radius: 3px;
                                    margin-top: 0.5em;
                                }
                                .bdsharebuttonbox a:link {
                                    text-decoration: none;
                                }
                            </style>
                            <a href="#" class="bds_more" data-cmd="more">分享到：</a>
                            <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间">QQ空间</a>
                            <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博">新浪微博</a>
                            <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博">腾讯微博</a>
                            <a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网">人人网</a>
                            <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信">微信</a>
                        </div>
                    </div>
                    <div class="ad-2">
                        <img src="/asset/content/tmp/ad-1.png" alt="" width="100%" height="auto"/>
                    </div>
                    <c:if test="${requestScope.articleList != null}">
                        <div class="about-article">
                            <div class="about-article-title">
                                <h3>猜你在找</h3>
                            </div>
                            <ul>
                                <c:forEach items="${requestScope.articleList}" var="article" begin="0" end="4">
                                    <li><a href="<%=basePath%>/article/detail/${article.id}.html"><em>•</em>${article.title}</a></li>
                                </c:forEach>
                            </ul>
                            <ul>
                                <c:forEach items="${requestScope.articleList}" var="article" begin="5" end="9">
                                    <li><a href="<%=basePath%>/article/detail/${article.id}.html"><em>•</em>${article.title}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>

                </div>
            </div>
            <div class="Grid-cell u-size1of4">
                <div class="main-right-inner">
                    <div class="jili">
                        <p><i class="iconfont" style="color: #438ae4;font-size: 22px">&#xf00f5;</i>人生是场穷游，偶尔也需要一场暴走</p>
                    </div>
                    <c:if test="${requestScope.courseSubjectDto.partentCourseSubject.sonCourseSubjectList != null}">
                        <div class="about-course clearfix">
                            <div class="about-course-title">
                                <h3><em class="iconfont" style="margin-right: 0.5em">&#xf00b1;</em>相关教程</h3>
                            </div>
                            <ul>
                                <c:forEach items="${requestScope.courseSubjectDto.partentCourseSubject.sonCourseSubjectList}" var="courseSub" begin="0" end="7">
                                    <li><a href="<%=basePath%>/course/${courseSub.name}"><em class="iconfont">.</em>${courseSub.name}</a></li>
                                </c:forEach>
                            </ul>
                            <span style="float: right;padding:1em 0 0"><a href="">查看更多</a></span>
                        </div>
                    </c:if>

                    <div class="ad-3">
                        <img src="<%=basePath%>/asset/content/tmp/ad-3.png" alt="" width="100%" height="auto"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="footer">
        <div class="copyright">
            编程无忧 ©  2017 uubook.net. 当前呈现版本 1.02.05<br>
            <a rel="nofollow">粤ICP备17130657号</a> &nbsp;
        </div>
    </div>
</div>
<script src="<%=basePath%>/asset/js/jquery.js"></script>
<script src="<%=basePath%>/asset/js/"></script>
</body>
</html>
