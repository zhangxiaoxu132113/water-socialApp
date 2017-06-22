<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Miaojie Zhang">
    <title>MrWater 主页</title>
    <jsp:include page="../common/common.jsp"/>
    <link rel="stylesheet" type="text/css" href="/asset/css/mrwater.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/font/iconfont/iconfont.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/index.css">
</head>
<body>
<div class="doc">
    <!-- topbar -->
    <div class="topbar">
        <div class="global_nav">
            <div class="global_nav_inner">
                <div class="container">
                    <div class="nav">
                        <ul id="global_actions">
                            <li>
                                <a>
                                    <span class="text"><i class="iconfont" style="margin-right: 0.25em;">&#xe6ca;</i>主页</span>
                                </a>
                            </li>
                            <li>
                                <a>
                                    <span><i class="iconfont" style="margin-right: 0.25em;">&#xe639;</i>通知</span>
                                </a>
                            </li>
                            <li>
                                <a>
                                    <span>关于</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <span class="Icon mr-logo" style="position: absolute;right:50%;width: 74px;margin-right: -37px">MrWater</span>
                    <ul style="float: right;line-height: 46px">

                        <li style="float: right;">
                            <button style="height: 32px!important;" class="sendBtn mr-primary-btn mr-btn">发文<i
                                    class="iconfont"
                                    style="margin-left: 0.25em;">&#xe6b0;</i>
                            </button>
                        </li>
                        <li style="float: right;margin-right: 1em">
                            <span><img class="litle-header-img" src="/asset/content/User_header.jpg"/></span>
                        </li>
                        <li style="float: right;position:relative;margin-right: 1em">
                            <span id="search">
                                <form style="width: 221px">
                                    <input class="search-input" placeholder="搜索内容"/>
                                    <span class="search-btn"><button class="iconfont">&#xe620;</button></span>
                                </form>
                            </span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- main body -->
    <div id="page-outer">
        <div id="page-container" class="AppContent">
            <div class="profile-canopy profile-canopy-widthNav">
                <div class="profile-canopy-inner">
                    <!-- profile-canopy-header -->
                    <div class="profile-canopy-header" style="margin-top: 0">
                        <div class="profile-canopy-headerBg">
                            <img class="profile-bg-img" src="/asset/content/user_bg.jpeg" style="transform: none">
                        </div>
                        <!-- 用户头像 -->
                        <div class="AppContainer">
                            <div class="ProfileCanopy-avatar">
                                <div class="ProfileAvatar">
                                    <a style="outline: 0">
                                        <img src="/asset/content/User_header.jpg" class="ProfileAvatar-img">
                                    </a>
                                </div>

                            </div>
                        </div>
                    </div>
                    <!-- profile-canopy-header end ! -->
                    <!-- profile-canopy-navber -->
                    <div class="profile-canopy-navBar">
                        <div class="AppContainer">
                            <div class="Grid Grid-withGutter">
                                <div class="Grid-cell u-size1of4">
                                    <div class="profile-canopy-card">
                                        <div class="profile-card-mini">
                                            <a class="profile-card-mini-avatar">
                                                <img src="/asset/content/User_header.jpg"
                                                     class="profile-card-mini-avatar-img">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="Grid-cell u-size3of4">
                                    <div class="profileCanopy-nav">
                                        <div class="profileNav" role="navigation">
                                            <ul class="profileNav-list">
                                                <li class="profileNav-item ">
                                                    <a class="profileNav-start is-Active">
                                                        <span class="profileNav-label">最新动态</span>
                                                        <span class="profileNav-value">1</span>
                                                    </a>
                                                </li>
                                                <li class="profileNav-item">
                                                    <a class="profileNav-start" href="/user/emotionRecord">
                                                        <span class="profileNav-label">心情</span>
                                                        <span class="profileNav-value">34</span>
                                                    </a>
                                                </li>
                                                <li class="profileNav-item">
                                                    <a class="profileNav-start">
                                                        <span class="profileNav-label">日志</span>
                                                        <span class="profileNav-value">13</span>
                                                    </a>
                                                </li>
                                                <li class="profileNav-item">
                                                    <a class="profileNav-start">
                                                        <span class="profileNav-label">相册</span>
                                                        <span class="profileNav-value">19</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- profile-canopy-navbar end ! -->
                </div>
            </div>
            <div class="AppContainer-bg"
                 style="margin:0;padding:0;background: rgb(245,248,250);height:auto;width: 100%">
                <div class="AppContainer">
                    <div class="main-Content">
                        <div class="Grid Grid--withGutter">
                            <!-- 左边的内容 -->
                            <div class="Grid-cell u-size1of4">
                                <div class="Grid Grid-withGutter">
                                    <div class="Grid-cell">
                                        <div class="profile-SiderBar">
                                            <!-- 跟人的详细信息 -->
                                            <div class="profile-headerCard">
                                                <h1 class="profile-headerCard-name">
                                                    <a href="#" class="profile-headerCard-nameLink">MrWater</a>
                                                </h1>

                                                <h2 class="profile-headerCard-screenName">
                                                    <a>@<span>136218949Mr</span></a></h2>
                                                <ul>
                                                    <li class="profile-headerCard-bio">等风来!</li>
                                                    <li style="color: #8899a6;"><i class="iconfont"
                                                                                   style="margin-right:0.25em;">
                                                        &#xe768;</i>广东 广州
                                                    </li>
                                                    <li style="color: #8899a6;"><i class="iconfont"
                                                                                   style="margin-right:0.25em;">
                                                        &#xe74f;</i>出生于 1993年12月01日
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="profile-photo"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- 右边的内容 -->
                            <div class="Grid-cell u-size3of4">
                                <div class="Grid Grid-withGutter">
                                    <div class="Grid-cell">
                                        <div class="Grid-cell u-lg-size2of3">
                                            <!-- profile Heading -->
                                            <div class="profileHeading">
                                                <div class="profileHeading-spacer"></div>
                                                <div class="profileHeading-content">
                                                    <h2 id="content-main-heading"
                                                        class="profileheading-title u-hiddenVisually">最新动态</h2>
                                                    <ul class="profileheading-toggle">
                                                        <li class="ProfileHeading-toggleItem is-Active">最新动态</li>
                                                        <li class="ProfileHeading-toggleItem u-textUserColor"><a
                                                                href="/user/emotionRecord">心情</a></li>
                                                        <li class="ProfileHeading-toggleItem u-textUserColor"><a>日志</a>
                                                        </li>
                                                    </ul>

                                                </div>
                                                <!-- profile Heading end -->
                                                <!-- timeline  -->
                                                <div id="timeline" class="ProfileTimeline">
                                                    <div class="stream-container">
                                                        <div class="stream">
                                                            <ol class="stream-items" id="stream-items-id">
                                                                <c:forEach items="${requestScope.weiboList}" var="weibo"
                                                                           varStatus="status">
                                                                    <li class="stream-item before-append">
                                                                        <div class="tweet">
                                                                            <div class="user-header-info">
                                                                                <img src="/asset/content/User_header.jpg"
                                                                                     style="width: 48px;height: 48px;border-radius: 5px;">
                                                                            </div>
                                                                            <div class="content">
                                                                                <div class="stream-item-header">
                                                                                    <a>MrWater @136218949Mr.</a>
                                                                                    <small><a><span>5月6日</span></a>
                                                                                    </small>
                                                                                </div>
                                                                                <div>
                                                                                    <p class="Tweet-TextSize--26">
                                                                                            ${weibo.text}
                                                                                    </p>

                                                                                </div>
                                                                                <div class="AdaptiveMedia">
                                                                                    <div>
                                                                                        <div class="AdaptiveMedia-singlePhoto">
                                                                                            <div class="AdaptiveMedia-photoContainer">
                                                                                                <img src="/asset/content/test-content.jpg"
                                                                                                     style="width: 100%;top:-0px">

                                                                                            </div>

                                                                                        </div>

                                                                                    </div>

                                                                                </div>

                                                                            </div>

                                                                        </div>
                                                                        <div class="tweet-bottom">
                                                                            <ul>
                                                                                <li>
                                                                                    <i class="iconfont">
                                                                                        &#xe6a5;</i>转发<span>${weibo.reposts_count}</span>
                                                                                </li>
                                                                                <li>
                                                                                    <i class="iconfont">
                                                                                        &#xe6ad;</i>评论<span>${weibo.comments_count}</span>
                                                                                </li>
                                                                                <li>
                                                                                    <i class="iconfont">
                                                                                        &#xe794;</i>点赞<span>${weibo.attitudes_count}</span>
                                                                                </li>
                                                                            </ul>
                                                                        </div>
                                                                    </li>
                                                                </c:forEach>
                                                            </ol>
                                                        </div>

                                                    </div>

                                                </div>
                                                <!-- timeline end -->
                                            </div>

                                        </div>
                                        <div class="Grid-cell u-lg-size1of3" style="width: 32%!important;">
                                            <div style="margin-top: 10px" class="learm-task-list">
                                                <h3><i class="iconfont"></i>任务列表</h3>
                                                <ul>
                                                    <li>学习es</li>
                                                    <li>学习mysql</li>
                                                    <li>设计方案</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 发表个人心情的模钛窗口-->
<jsp:include page="../sendFrame.jsp"/>
<script src="/asset/js/mw/index.js"></script>
</body>
</html>
