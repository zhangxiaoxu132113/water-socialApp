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
            padding-bottom: 1em;
            font-size: 22px;
            color: #1b95e0;
            font-weight: 500;
        }
        .search-input {
            width: 470px;
            height: 34px;
            padding-top: 0.5em;
            text-align: center;
            float: left;
            margin-right: -3px;
            cursor: text;
            margin-left: 2em;
            background: url(/asset/content/nav_bg.png) no-repeat 0 7px;
        }
        .search-input input[type=text]{
            border:none;
            background: #fff;
            width: 96%;
            margin: 0;
            text-align: left;
            height: 30px;
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
            margin-right: 2em;
            height: 39px;
            line-height:39px;
        }
        .hot-course-command ul li a:link {
            color:#37a;
            font-size: 13px;
            text-decoration: none;
        }
        .search-btn {
            position: relative;
            left: -1px;
            width: 37px;
            height: 34px;
            zoom: 1;
            overflow: hidden;
            padding-top:0.5em;
        }
        .search-btn input[type=submit] {
            background: url(/asset/content/nav_bg.png) no-repeat 0 -40px;
            width: 100%;
            height: 100%;
            font-size: 0;
            padding: 35px 0 0 0;
            overflow: hidden;
            color: transparent;
            cursor: pointer;
            border: none;
        }
        #main-content {
            padding-top: 2em;
        }
        #main-content-inner {
            width: 950px;
            margin: 0 auto;
        }
        .u-size3of4 {width: 600px!important;}
        .current-location {
            padding-bottom: 0.5em;
            border-bottom: 1px solid #eaeaea;
            margin-bottom: 0.5em;
        }
        .current-location span:first-child {
            color: #333;
        }
        .current-location span:first-child i {
            margin-right: 0.5em;
            font-weight: 600;
            color: #6b6a6a;
        }
        .course-name {
            font-size: 18px;
            padding-bottom: 1em;
            font-weight: bold;
            color: #333;
        }
        .course-name span {
            margin-left: 0.25em;
            font-size: 12px;
            font-weight: 500;
        }
        .course-description {
            padding-bottom: 1em;
        }
        .course-main-body ul li a {
            line-height: 2em;
        }
        .allStart {
            width: 60px;
            height: 10px;
            display: inline-block;
            zoom: 1;
        }
        .allStart50 {
            background: url(/asset/content/ic_rating_s.png) no-repeat 0px -1px;
        }
        .allStart45 {
            background: url(/asset/content/ic_rating_s.png) no-repeat 0px -11px;
        }
        .allStart40 {
            background: url(/asset/content/ic_rating_s.png) no-repeat 0px -23px;
        }
        .allStart35 {
            background: url(/asset/content/ic_rating_s.png) no-repeat 0px -33px;
        }
        .allStart30 {
            background: url(/asset/content/ic_rating_s.png) no-repeat 0px -44px;
        }
        .allStart25 {
            background: url(/asset/content/ic_rating_s.png) no-repeat 0px -55px;
        }
        .allStart20 {
            background: url(/asset/content/ic_rating_s.png) no-repeat 0px -66px;
        }
        .allStart15 {
            background: url(/asset/content/ic_rating_s.png) no-repeat 0px -77px;
        }
        .allStart10 {
            background: url(/asset/content/ic_rating_s.png) no-repeat 0px -88px;
        }
        .allStart5 {
            background: url(/asset/content/ic_rating_s.png) no-repeat 0px -99px;
        }
        .course-main-body {
            margin-bottom: 1em;
            padding-bottom: 1em;
            border-bottom: 1px solid #eeeeee;
        }
        .about-article {
            padding: 0.5em;
            border: 1px solid #ccc;
            margin-top: 0.5em;
            border-radius: 2px;
        }
        .about-article ul {
            display: inline-block;
            width: 49%;
        }
        .about-article-title {
            margin-bottom: 0.25em;
            border-bottom: 1px solid #ccc;
        }
        .about-article-title h3 {
            color:#333;
            display: inline-block;
            padding-bottom: 0.5em;
            border-bottom: 2px solid #1784c7;
            margin-bottom: -1px;
            font-weight: 500;
        }
        .sc-btn {
            float: right;
            color: #fff;
            background: rgba(0, 119, 34, 0.69);
            /*rgba(255, 172, 45, 0.87)*/
            font-size: 12px;
            border-radius: 3px;
            padding: 0px 7px;
        }
        .about-article ul li {

        }
        .about-article ul li a {
            text-decoration: none;
            color: #333;
        }
        .about-article ul li a em {
            display: inline-block;
            margin-right: 10px;
            color: #333;
        }
        .u-size1of4 {
            width: auto!important;
        }

        .main-right-inner {
            padding-left: 1.5em;
        }
        .jili {
            background: #f2f7f6;
            color: #3377aa;
            border-radius: 4px;
            margin-bottom: 1em;
        }
        .jili p {
            padding: 12px 0 12px 18px;
        }
        .about-course-title {
            border-bottom: 1px solid #e5ebe4;
        }
        .about-course-title h3 {
            display: inline-block;
            padding-bottom: 1em;
            border-bottom: 2px solid #1784c7;
            margin-bottom: -1px;
            color: #333;
            font-weight: 500;
        }
        .about-course {
            padding: 1em;
            box-sizing: border-box;
            border: 1px solid #e5ebe4;
            border-radius: 4px;
            margin-bottom: 1em;
        }
        .about-course ul li a {
            height: 30px;
            line-height: 30px;
            text-decoration: none;
            display: inline-block;
            width: 100%;
            border-bottom: 1px solid #e5ebe4;
            color: #333;
        }
        .about-course ul li a em {
            margin-right: 1em;
        }
        .catalog-list {
            padding: 1em;
            background: rgba(242, 247, 246, 0.54);
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
                        <span><i class="iconfont">&#xf0295;</i>当前位置:</span> <a href="">IT教程</a> >> <a href="">Java教程</a> >> <a href="">数据挖掘</a>
                    </div>
                    <%--<div class="ad-1">--%>
                        <%--<img src="/asset/content/tmp/TB10kZnQVXXXXagXXXXXXXXXXXX-800-50.jpg" alt="" width="100%" height="auto"/>--%>
                    <%--</div>--%>
                    <div class="course-main-body">
                        <div class="course-name">
                            ${requestScope.courseSubject.name}<span class="course-score">(评分：<span class="allStart allStart45"></span>8分)</span>
                            <span style="float: right" class="sc-btn"><i class="iconfont">&#xf00b1;</i>收藏</span>
                        </div>
                        <div class="course-description">${courseSubject.description}</div>
                        <ul class="catalog-list">
                            <c:forEach items="${requestScope.courseDtoList}" var="course" varStatus="status">
                                <li><a href="/course/${requestScope.courseSubject.name}/${course.id}.html">${status.index + 1},${course.title}</a></li>
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
                    <div class="about-article">
                        <div class="about-article-title">
                            <h3>猜你在找</h3>
                        </div>
                        <ul>
                            <li><a href=""><em>•</em>数据挖掘概述，什么是数据挖掘？</a></li>
                            <li><a href=""><em>•</em>数据挖掘分类与预测</a></li>
                            <li><a href=""><em>•</em>数据挖掘集群分析</a></li>
                            <li><a href=""><em>•</em>数据挖掘 - 挖掘互联网</a></li>
                            <li><a href=""><em>•</em>数据挖掘 - 应用与趋势</a></li>
                        </ul>
                        <ul>
                            <li><a href=""><em>•</em>数据挖掘概述，什么是数据挖掘？</a></li>
                            <li><a href=""><em>•</em>数据挖掘分类与预测</a></li>
                            <li><a href=""><em>•</em>数据挖掘集群分析</a></li>
                            <li><a href=""><em>•</em>数据挖掘 - 挖掘互联网</a></li>
                            <li><a href=""><em>•</em>数据挖掘 - 应用与趋势</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="Grid-cell u-size1of4">
                <div class="main-right-inner">
                    <div class="jili">
                        <p><i class="iconfont" style="color: #438ae4;font-size: 22px">&#xf00f5;</i>人生是场穷游，偶尔也需要一场暴走</p>
                    </div>
                    <div class="about-course">
                        <div class="about-course-title">
                            <h3><em class="iconfont">&#xf00b1;</em>J相关教程</h3>
                        </div>
                        <ul>
                            <li><a href=""><em class="iconfont">.</em>JavaEE教程</a></li>
                            <li><a href=""><em class="iconfont">.</em>Java并发编程教程</a></li>
                            <li><a href=""><em class="iconfont">.</em>JavaFX教程</a></li>
                            <li><a href=""><em class="iconfont">.</em>MyBatis教程</a></li>
                            <li><a href=""><em class="iconfont">.</em>JDBC教程</a></li>
                        </ul>
                        <span><a href="">查看更多</a></span>
                    </div>
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
