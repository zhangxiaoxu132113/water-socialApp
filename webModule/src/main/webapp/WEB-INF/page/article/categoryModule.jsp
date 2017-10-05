<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/asset/css/categoryModule.css">
    <style>
        #middle-content {
            position: relative;
            height: 80px;
            background: rgba(211, 241, 251, 0.15);
        }
        #middle-content #middle-inner {
            position: relative;
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
            opacity: 0.35;
            top: -9999px;
            bottom: -9999px;
            margin: auto 0;
            width: 100%;
        }

        #middle-inner .category-module-intro {
            position: absolute;
            left:0;
            font-size: 20px;
        }
        #middle-inner .search {
            position: absolute;
            right:0;
            z-index: 1001;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="container-inner">
        <%--头部信息--%>
        <div id="header">
            <div id="header-inner">
                <div class="nav-menu">
                    <ul class="clearfix">
                        <li><a href="">首页</a></li>
                        <li><a href="">文档库</a></li>
                        <li><a href="">资讯</a></li>
                        <li><a href="">教程</a></li>
                        <li><a href="">知识库</a></li>
                    </ul>
                </div>
                <div class="user-info">
                    <ul>
                        <li><a href="">登录</a></li>
                        <li><a href="">注册</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="middle-content">
            <div class="profile-canopy-headerBg">
                <img class="profile-bg-img" src="<%=path%>/asset/content/blog-index-bg.jpeg" style="transform: none">
            </div>
            <div id="middle-inner">
                <div class="category-module-intro">
                    <h3>文档库 - 编程语言</h3>
                </div>
                <div class="search">
                    <div class="search-inner clearfix">
                        <div class="search-input">
                            <input type="text" placeholder="Java 教程, Mysql 教程">
                        </div>
                        <div class="search-btn">
                            <input type="submit"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="main-content">
            <div id="main-content-inner" class="clearfix">
                <div id="left-body">
                    <div id="left-body-inner">
                        <%--精彩阅读--%>
                        <div class="jingcai-article">
                            <h3>推荐阅读</h3>
                            <ul class="clearfix">
                                <li>
                                    <img src="https://static.oschina.net/uploads/img/201704/01163516_oNF6.png" width="260" height="150" alt="">
                                    <h3><a href="">大数据存储与分析 - IBM DB2 与 Graphite</a></h3>
                                </li>
                                <li>
                                    <img src="https://static.oschina.net/uploads/space/2017/0921/194320_Rxrd_2663968.jpg" width="260" height="150" alt="">
                                    <h3><a href="">使用 Java、Weka 和 dashDB 服务构建一个数据挖掘应用程序</a></h3>
                                </li>
                                <li>
                                    <img src="https://static.oschina.net/uploads/img/201704/01163228_NmPR.png" width="260" height="150" alt="">
                                    <h3><a href="">Informix 物联网应用示例</a></h3>
                                </li>
                            </ul>
                        </div>
                        <%--文章列表--%>
                        <div class="main-article-list">
                            <div class="wrap" id="wrap">
                                <ul class="tabClick">
                                    <li class="active">最新推荐</li>
                                    <li>最新文章</li>
                                    <li>热门文章</li>
                                    <li>本周热门</li>
                                </ul>
                                <div class="lineBorder">
                                    <div class="lineDiv"><!--移动的div--></div>
                                </div>
                                <div class="tabCon">
                                    <div class="tabBox">
                                        <div class="tabList">
                                            <ul>
                                                <li>
                                                    <div class="topic-img">
                                                        <img src="https://static.oschina.net/uploads/user/1459/2918182_50.jpeg?t=1484105851000" alt="">
                                                    </div>
                                                    <div class="topic-info">
                                                        <h3><a href="">快速了解人工智能结晶之语音转换文字</a></h3>
                                                        <p>
                                                            随着深度学习的快速发展以及技术的开源，越来越多的人开始接触和了解深度学习，
                                                            也出现了越来越多的开源的深度学习项目。其中不乏一些非常有意思的项目，在帮助用户了解深度学习原理的同时，
                                                        </p>
                                                        <div class="detail">
                                                            <span>发布于：2017-08-09</span>
                                                            <span>阅读量：923</span>
                                                            <span>点赞:34</span>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="topic-img">
                                                        <img src="https://static.oschina.net/uploads/user/1491/2982602_50.jpeg?t=1477365605000" alt="">
                                                    </div>
                                                    <div class="topic-info">
                                                        <h3><a href="">这个六足机器人想成为你的朋友和舞伴</a></h3>
                                                        <p>
                                                            “20年前我们做网站开发，后来是手机应用，科技创新的下一个阶段会发生在机器人平台上”
                                                            身为Vincross首席运营官的徐凯强说道。Vincross是一家北京的机器人创业公司，三年前刚刚成立。
                                                        </p>
                                                        <div class="detail">
                                                            <span>发布于：2017-08-09</span>
                                                            <span>阅读量：923</span>
                                                            <span>点赞:34</span>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="topic-img">
                                                        <img src="https://static.oschina.net/uploads/user/1491/2982602_50.jpeg?t=1477365605000" alt="">
                                                    </div>
                                                    <div class="topic-info">
                                                        <h3><a href="">这个六足机器人想成为你的朋友和舞伴</a></h3>
                                                        <p>
                                                            “20年前我们做网站开发，后来是手机应用，科技创新的下一个阶段会发生在机器人平台上”
                                                            身为Vincross首席运营官的徐凯强说道。Vincross是一家北京的机器人创业公司，三年前刚刚成立。
                                                        </p>
                                                        <div class="detail">
                                                            <span>发布于：2017-08-09</span>
                                                            <span>阅读量：923</span>
                                                            <span>点赞:34</span>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="topic-img">
                                                        <img src="https://static.oschina.net/uploads/user/1491/2982602_50.jpeg?t=1477365605000" alt="">
                                                    </div>
                                                    <div class="topic-info">
                                                        <h3><a href="">这个六足机器人想成为你的朋友和舞伴</a></h3>
                                                        <p>
                                                            “20年前我们做网站开发，后来是手机应用，科技创新的下一个阶段会发生在机器人平台上”
                                                            身为Vincross首席运营官的徐凯强说道。Vincross是一家北京的机器人创业公司，三年前刚刚成立。
                                                        </p>
                                                        <div class="detail">
                                                            <span>发布于：2017-08-09</span>
                                                            <span>阅读量：923</span>
                                                            <span>点赞:34</span>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="topic-img">
                                                        <img src="https://static.oschina.net/uploads/user/1491/2982602_50.jpeg?t=1477365605000" alt="">
                                                    </div>
                                                    <div class="topic-info">
                                                        <h3><a href="">这个六足机器人想成为你的朋友和舞伴</a></h3>
                                                        <p>
                                                            “20年前我们做网站开发，后来是手机应用，科技创新的下一个阶段会发生在机器人平台上”
                                                            身为Vincross首席运营官的徐凯强说道。Vincross是一家北京的机器人创业公司，三年前刚刚成立。
                                                        </p>
                                                        <div class="detail">
                                                            <span>发布于：2017-08-09</span>
                                                            <span>阅读量：923</span>
                                                            <span>点赞:34</span>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="topic-img">
                                                        <img src="https://static.oschina.net/uploads/user/1491/2982602_50.jpeg?t=1477365605000" alt="">
                                                    </div>
                                                    <div class="topic-info">
                                                        <h3><a href="">这个六足机器人想成为你的朋友和舞伴</a></h3>
                                                        <p>
                                                            “20年前我们做网站开发，后来是手机应用，科技创新的下一个阶段会发生在机器人平台上”
                                                            身为Vincross首席运营官的徐凯强说道。Vincross是一家北京的机器人创业公司，三年前刚刚成立。
                                                        </p>
                                                        <div class="detail">
                                                            <span>发布于：2017-08-09</span>
                                                            <span>阅读量：923</span>
                                                            <span>点赞:34</span>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div>
                                            00000
                                        </div>
                                        <div>
                                            1111
                                        </div>
                                        <div>
                                            dfdf
                                        </div>
                                        <div>
                                            3333
                                        </div>
                                        <div>
                                            vvvv
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="right-body">
                    <div id="right-body-inner">
                        <%--文档库分类--%>
                        <div class="all-category">
                            <ul>
                                <li><a href="">全部</a></li>
                                <li class="active"><a href="">开发语言</a></li>
                                <li><a href="">前端开发</a></li>
                                <li><a href="">数据库</a></li>
                                <li><a href="">移动开发</a></li>
                                <li><a href="">服务器</a></li>
                                <li><a href="">云计算</a></li>
                                <li><a href="">开发工具</a></li>
                                <li><a href="">软件开发</a></li>
                            </ul>
                        </div>
                        <%--广告投放位置--%>
                        <div class="ad-info">
                            <img src="https://tpc.googlesyndication.com/simgad/17324602141506657397" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="footer">
            <p>
                <a href="">广告服务</a>
                <a href="">联系我们</a>
                <a href="">友情链接</a>
                <a href="">版权纠纷</a>
            </p>
            <p>© 2003-2017 ITeye.com. [ 京ICP证070598号 京公网安备11010502027441 ]</p>
            <p>北京创新乐知信息技术有限公司 版权所有</p>
        </div>

    </div>
</div>
<script src="<%=path%>/plugs/slider/jquery-2.1.1.min.js"></script>
<script>
    $(function(){
        $("ul.tabClick li").click(function(){
            $(this).addClass("active").siblings().removeClass("active"); //切换选中的按钮高亮状态
            var index=$(this).index(); //获取被按下按钮的索引值，需要注意index是从0开始的
            $('.lineDiv').css('margin-left', (index * 140) + 'px');
            $(".tabBox > div").eq(index).show().siblings().hide(); //在按钮选中时在下面显示相应的内容，同时隐藏不需要的框架内容
        });
    });
</script>
</body>
</html>
