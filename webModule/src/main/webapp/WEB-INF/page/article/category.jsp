<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/asset/css/blog-category.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/font/iconfont/iconfont.css">
    <style>
        .article div span {
            color: #a3b2bb;
        }
        .article .tags {
            color: #333;
        }
        .xuanfu {
            position: fixed;
            bottom: 1px;
            margin-left: 1170px;
        }
        span.scroll-top {
            display: none;
            width: 43px;
            height: 43px;
            text-align: center;
            background: #545e67;
            margin-bottom: 5em;
            border-radius: 3px;
        }
        span.scroll-top:hover {
            cursor: pointer;
        }
        span.scroll-top .top-info {
            font-size: 12px;
            color: #fff;
            padding-top: 5px;
            display: none;
        }
        span.scroll-top .top-icon {
            text-align: center;
            line-height: 43px;
            font-size: 22px;
            color: #fff;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="container-inner">
        <div id="header">
            <div id="header-inner">
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
                            <span class="intro-base-header-img"><img src="<%=path%>/asset/content/regong.jpg"
                                                                     style="border-radius: 50%" alt=""></span>
                                <span class="intro-base-desc">
                                    <span class="name">${category.name}</span>
                                    <span class="name">收录 : ${category.total}</span>
                                </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="main-body">
            <div id="main-body-inner">
                <%--左边内容--%>
                <div id="left-body">
                    <div class="inner">
                        <div class="search-input clearfix">
                            <form action="/article/search" class="search-form" method="get"
                                  style="position: relative">
                                <input type="text" placeholder="搜索" name="keyword">
                                <span class="search_btn"><i class="iconfont">&#xe620;</i></span>
                            </form>
                        </div>
                        <%--相关主题--%>
                        <ul class="all-topics">
                            <li>
                                <span class="about-topic-info">相关主题</span>
                                <c:forEach items="${requestScope.categoryDtos}" var="category" begin="0" end="3">
                                    <dl>
                                        <dt><a href=""><img src="http://www.uubook.net:8080/asset/content/python.jpg" alt=""></a></dt>
                                        <dd>
                                            <h4><a href="<%=path%>/blog/tag/${category.name}">${category.name}</a></h4>
                                            <p>文章收录 : ${category.total}</p>
                                        </dd>
                                    </dl>
                                </c:forEach>
                            </li>
                        </ul>
                        <div class="ad">
                            <%--<div class="ad-img"></div>--%>
                            <img class="ad-img" src="<%=path%>/asset/content/tmp/ad-3.png" alt="">
                        </div>
                    </div>
                </div>
                <%--右边内容--%>
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
                                        <span><i class="iconfont">&#xe771;</i></span>
                                    </div>
                                    <div class="article">
                                        <h3 class="article-title"><a
                                                href="<%=path%>/article/detail/${article.id}.html">${article.title}</a>
                                        </h3>
                                        <div>
                                            <span>${article.createOnStr}</span>
                                            <span class="tags">
                                                &nbsp;&nbsp;
                                                <c:forEach items="${article.tagList}" var="tag" begin="0" end="1">
                                                    <a href="<%=path%>/blog/tag/${tag.name}"></a>${tag.name}&nbsp;&nbsp;
                                                </c:forEach>
                                            </span>
                                            <span>阅读数：${article.viewHits}</span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                        <div class="loading">
                            <img src="<%=path%>/asset/content/loadding.gif" alt="">
                            正在努力加载。。。
                        </div>
                    </div>
                </div>
                <%--悬浮信息--%>
                <div class="xuanfu">
                    <span class="scroll-top">
                        <i class="iconfont top-icon">&#x3467;</i>
                        <span class="top-info">返回<br>顶部</span>
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=path%>/plugs/slider/jquery-2.1.1.min.js"></script>
<script>
    $(function () {
        var pageSize = 10;
        var currentPage = 1;

        /**
         * 绑定滚动事件
         */
        var bindScroll = function () {
            $(window).scroll(function () {
                var bot = 20;
                console.log($(window).height());
                console.log($(document).height());
                if ($(document).scrollTop() >= $(document).height() - $(window).height() - bot) {
                    currentPage++;
                    $(window).unbind('scroll');
                      $('.loading').show();
                    $.ajax({//请求数据
                        url: '/blog/tag/getTagArticleListWithAjax?tag=java&currentPage='+currentPage+'&pageSize=' + pageSize,
                        type: 'GET',
                        async: true,
                        success: function (data) {
                            data = mytrim(data);
                            console.log("data = " +data);
                            $('.loading').hide();
                            if (data == undefined || data == '') {
                                //已经没有数据
                            } else {
                                $('.topic-articles').append(data);
                                bindScroll();
                            }

                        },
                        error: function (xhr, textStatus) {
                            alert("服务器请求异常！");
                            $('.loading').hide();
                        }
                    });
                }
                else if ($(document).scrollTop() >= 425) {
                    if ($('.scroll-top').is(":hidden")) {
                        $('.scroll-top').css("display","block");
                    }
                } else {
                    if ($('.scroll-top').is(":visible")) {
                        $('.scroll-top').css("display","none");
                    }
                }
            });
        };

        $('.scroll-top').click(function() {
            $('html,body').animate({scrollTop:0},'slow');
        });

        $('.scroll-top').hover(
            function(){
                $('.top-icon').hide();
                $(this).css('background','#418ec7');
                $('.top-info').css("display","block");
            },
            function() {
                $('.top-icon').show();
                $(this).css('background','#545e67');
                $('.top-info').css("display","none");
            }
        );
        bindScroll();

        $('.search_btn').click(function () {
            $('.search-form').submit();
        });

        function mytrim(str) {
            return str.replace(/(^\s*)|(\s*$)/g, '');
        }

    });
</script>
</body>
</html>
