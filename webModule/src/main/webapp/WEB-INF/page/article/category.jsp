<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    Random random = new Random(5);
%>
<html>
<head>
    <title>编程无忧网_文档库_${category.name}分类</title>
    <link rel="stylesheet" href="<%=basePath%>/asset/css/blog-category.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/font/iconfont/iconfont.css">

</head>
<body>
<div id="container">
    <div id="container-inner">
        <div id="header">
            <div id="header-inner">
                <div class="nav-menu">
                    <ul>
                        <li><a href="<%=basePath%>/">首页</a></li>
                        <li><a href="<%=basePath%>/blog/">文档库</a></li>
                        <li><a href="<%=basePath%>/new/">资讯</a></li>
                        <li><a href="<%=basePath%>/course/">IT教程</a></li>
                        <li><a href="<%=basePath%>/base/">知识库</a></li>
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
                    <img class="profile-bg-img" src="/asset/content/category_${category.parentId}.jpg" style="transform: none">
                    <div class="topic-intro">
                        <div class="intro-base clearfix">
                            <span class="intro-base-header-img"><img src="${category.picUrl}"
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
                                        <dt><a href=""><img src="${category.picUrl}" alt=""></a></dt>
                                        <dd>
                                            <h4><a href="<%=basePath%>/blog/tag/${category.name}">${category.name}</a></h4>
                                            <p>文章收录 : ${category.total}</p>
                                        </dd>
                                    </dl>
                                </c:forEach>
                            </li>
                        </ul>
                        <div class="ad">
                            <%--<div class="ad-img"></div>--%>
                            <img class="ad-img" src="<%=basePath%>/asset/content/tmp/ad-3.png" alt="">
                        </div>
                    </div>
                </div>
                <%--右边内容--%>
                <div id="right-body">
                    <div class="inner">
                        <div class="ad">
                            <a href=""><img src="<%=basePath%>/asset/content/banner.jpg" alt=""></a>
                        </div>
                        <div class="about-topics">
                            <ul class="clearfix">
                                <li><a href="">最热</a></li>
                                <li><a href="">最新</a></li>
                                <c:forEach items="${requestScope.categoryDtos}" var="category">
                                    <li><a href="<%=basePath%>/blog/tag/${category.name}">${category.name}</a></li>
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
                                        <c:if test="${not empty article.picUrl}">
                                            <img class="article_pic_url" src="${article.picUrl}" alt="" width="200"
                                                 height="112">
                                        </c:if>
                                        <h3 class="article-title"><a
                                                href="<%=basePath%>/article/detail/${article.id}.html">${article.title}</a>
                                        </h3>
                                        <div class="article_desc">
                                            <p>${fn:substring(article.description, 0, 120)}</p>
                                        </div>
                                        <div style="font-size: 13px">
                                            <span>${article.createOnStr}</span>
                                            <span>阅读数：${article.viewHits}</span>
                                            <span class="tags">
                                                &nbsp;&nbsp;
                                                <c:forEach items="${article.tagList}" var="tag" begin="0" end="<%=random.nextInt(4)%>">
                                                    <a class="tag tag_<%=random.nextInt(4)%>" href="<%=basePath%>/blog/tag/${tag.name}">${tag.name}&nbsp;</a>
                                                </c:forEach>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                        <div class="loading">
                            <img src="<%=basePath%>/asset/content/loadding.gif" alt="">
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
<script src="<%=basePath%>/plugs/slider/jquery-2.1.1.min.js"></script>
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
