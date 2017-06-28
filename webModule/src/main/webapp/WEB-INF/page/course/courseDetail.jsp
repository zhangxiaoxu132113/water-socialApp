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
    <script src="<%=path%>/asset/js/jquery.js"></script>
    <style>

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
                    <%--<div class="ad-1">--%>
                        <%--<img src="/asset/content/tmp/TB10kZnQVXXXXagXXXXXXXXXXXX-800-50.jpg" alt="" width="100%" height="auto"/>--%>
                    <%--</div>--%>
                    <div class="course-main-body">
                        <div class="course-name">
                            ${requestScope.courseSubjectDto.name}<span class="course-score">(评分：<span class="allStart allStart45"></span>8分)</span>
                            <span style="float: right" class="sc-btn"><i class="iconfont">&#xf00b1;</i>收藏</span>
                        </div>
                        <div class="course-description">${courseSubjectDto.description}</div>
                        <ul class="catalog-list">
                            <c:forEach items="${requestScope.courseDtoList}" var="course" varStatus="status">
                                <li><a href="/course/${requestScope.courseSubjectDto.name}/${course.id}.html">${status.index + 1},${course.title}</a></li>
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
                                    <li><a href=""><em>•</em>${article.title}</a></li>
                                </c:forEach>
                            </ul>
                            <ul>
                                <c:forEach items="${requestScope.articleList}" var="article" begin="5" end="9">
                                    <li><a href=""><em>•</em>${article.title}？</a></li>
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
                                    <li><a href=""><em class="iconfont">.</em>${courseSub.name}</a></li>
                                </c:forEach>
                            </ul>
                            <span style="float: right;padding:1em 0 0"><a href="">查看更多</a></span>
                        </div>
                    </c:if>

                    <div class="ad-3">
                        <img src="/asset/content/tmp/ad-3.png" alt="" width="100%" height="auto"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="footer" style="margin-top:2em;">
        <div id="footer-inner">
            <p>这是页面的底部了</p>
        </div>
    </div>
</div>
<script>
    //全局变量，动态的文章ID
    var ShareId = "";
    //绑定所有分享按钮所在A标签的鼠标移入事件，从而获取动态ID
    $(function () {
        $(".bdsharebuttonbox a").mouseover(function () {
            ShareId = $(this).attr("data-id");
        });
    });

    /*
     * 设置分享的url连接地址
     */
    function SetShareUrl(cmd, config) {
        config.bdUrl = document.URL;
        config.bdText = $('title').text();
        config.bdDesc = "用户将网站内容分享到第三方网站，第三方网站的用户点击专有的分享链接，从第三方网站带来社会化流量";
        config.bdPic = "";

        console.log(config.bdUrl);
        console.log(config.bdText);
        console.log(config.bdDesc);
        return config;
    }

    window._bd_share_config = {
        "common": {
            onBeforeClick: SetShareUrl,
            "bdSnsKey": {},
            "bdMini": "2",
            "bdMiniList": false,
            "bdStyle": "1",
            "bdSize": "16"
        },
        "share": {"bdSize": 16},
        "image": {"viewList": ["qzone", "tsina", "weixin", "tqq", "renren"], "viewText": "分享到：", "viewSize": "16"},
        "selectShare": {"bdContainerClass": null, "bdSelectMiniList": ["qzone", "tsina", "weixin", "tqq", "renren"]}
    };
    with (document)0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
</script>

</body>
</html>
