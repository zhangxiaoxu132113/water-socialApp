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
        .load-more {
            text-align: center;
            margin-top: 2em;
        }
        .load-more .load-more-btn {
            width: 100px;
            height: 36px;
            margin: 0 auto;
            line-height: 36px;
            background-color: #999;
            color: #fff;
        }
        .load-more .load-more-btn:hover {
            cursor: pointer;
        }
        .load-more-info {  display: none;  }
        .load-more-img {width: 25px;height: 25px;vertical-align: middle}
    </style>
    <jsp:include page="../common/baidu_statistics_code.jsp"/>
</head>
<body>
<div id="container">
    <div id="container-inner">
        <%--头部信息--%>
        <div id="header">
            <div id="header-inner">
                <div class="nav-menu">
                    <ul class="clearfix">
                        <li><a href="/">首页</a></li>
                        <li><a href="<%=basePath%>blog/">文档库</a></li>
                        <li><a href="<%=basePath%>new/">资讯</a></li>
                        <li><a href="<%=basePath%>course/">教程</a></li>
                        <li><a href="<%=basePath%>base/">知识库</a></li>
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
                    <h3>文档库 - ${categoryDto.name}</h3>
                </div>
                <div class="search">
                    <div class="search-inner clearfix">
                        <form action="/article/search" class="search-form" method="get"
                              style="position: relative">
                            <div class="search-input">
                                <input type="text" placeholder="Java 教程, Mysql 教程" name="keyword">
                            </div>
                            <div class="search-btn">
                                <input type="submit"/>
                            </div>
                        </form>

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
                                    <img src="https://static.oschina.net/uploads/img/201704/01163516_oNF6.png"
                                         width="260" height="150" alt="">
                                    <h3><a href="">大数据存储与分析 - IBM DB2 与 Graphite</a></h3>
                                </li>
                                <li>
                                    <img src="https://static.oschina.net/uploads/space/2017/0921/194320_Rxrd_2663968.jpg"
                                         width="260" height="150" alt="">
                                    <h3><a href="">使用 Java、Weka 和 dashDB 服务构建一个数据挖掘应用程序</a></h3>
                                </li>
                                <li>
                                    <img src="https://static.oschina.net/uploads/img/201704/01163228_NmPR.png"
                                         width="260" height="150" alt="">
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
                                        <div class="selected_div">
                                            <ul>
                                                <c:forEach items="${requestScope.hotArticleList}" var="article">
                                                    <li>
                                                        <div class="topic-img">
                                                            <img src="https://static.oschina.net/uploads/user/1459/2918182_50.jpeg?t=1484105851000"
                                                                 alt="">
                                                        </div>
                                                        <div class="topic-info">
                                                            <h3>
                                                                <a href="<%=path%>/article/detail/${article.id}.html">${article.title}</a>
                                                            </h3>
                                                            <p>${article.description}</p>
                                                            <div class="detail">
                                                                <span>发布于：${article.createOnStr}</span>
                                                                <span>阅读量：${article.viewHits}</span>
                                                                <span>点赞:34</span>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                            <div class="load-more">
                                                <div class="load-more-btn">
                                                    加载更多
                                                </div>
                                                <div class="load-more-info">
                                                    <img class="load-more-img" src="<%=path%>/asset/content/loadding.gif" alt="">
                                                    正在加载更多。。。
                                                </div>
                                            </div>
                                        </div>
                                        <div>
                                            <ul>
                                                <c:forEach items="${requestScope.newestArticleList}" var="article">
                                                    <li>
                                                        <div class="topic-img">
                                                            <img src="https://static.oschina.net/uploads/user/1459/2918182_50.jpeg?t=1484105851000"
                                                                 alt="">
                                                        </div>
                                                        <div class="topic-info">
                                                            <h3>
                                                                <a href="<%=path%>/article/detail/${article.id}.html">${article.title}</a>
                                                            </h3>
                                                            <p>${article.description}</p>
                                                            <div class="detail">
                                                                <span>发布于：${article.createOnStr}</span>
                                                                <span>阅读量：${article.viewHits}</span>
                                                                <span>点赞:34</span>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                        <div>
                                            dfdf
                                        </div>
                                        <div>
                                            3333
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
                                <c:forEach items="${requestScope.categoryParentList}" var="category">
                                    <li
                                            <c:if test="${category.id == requestScope.categoryDto.id}">class="active"</c:if> >
                                        <a href="<%=path%>/blog/category/${category.id}">${category.name}</a>
                                    </li>
                                </c:forEach>
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
            <div class="copyright">
                编程无忧 ©  2017 uubook.net. 当前呈现版本 1.02.05<br>
                <a rel="nofollow">粤ICP备17130657号</a> &nbsp;
            </div>
        </div>
    </div>
</div>
<script src="<%=path%>/plugs/slider/jquery-2.1.1.min.js"></script>
<script>
    $(function () {
        var pageSize = 10;
        var currentPage = 1;
        var bot = 150;

        $("ul.tabClick li").click(function () {
            $(this).addClass("active").siblings().removeClass("active"); //切换选中的按钮高亮状态
            var index = $(this).index(); //获取被按下按钮的索引值，需要注意index是从0开始的
            $('.lineDiv').css('margin-left', (index * 140) + 'px');
            $(".tabBox > div").eq(index).addClass("selected_div").show().siblings().hide().removeClass("selected_div"); //在按钮选中时在下面显示相应的内容，同时隐藏不需要的框架内容
        });


        var bindScroll = function () {
            $(window).scroll(function () {
                if ($(document).scrollTop() > $('#middle-content').height() + $('.all-category').height() + 20) {
                    if ($(document).scrollTop() > $(document).height() - 300) {
                        $('.ad-info').removeClass("fixed-position");
                    } else {
                        $('.ad-info').addClass("fixed-position");
                    }
                } else {
                    $('.ad-info').removeClass("fixed-position");
                }
            });
        };

        bindScroll(); //绑定滚动事件
        /**
         * 搜索内容
         */
        $('.search_btn').click(function () {
            $('.search-form').submit();
        });

        /**
         * 字符格式化
         * @param str
         * @returns {XML|string|{state, paramExpr}|*|void}
         */
        function mytrim(str) {
            return str.replace(/(^\s*)|(\s*$)/g, '');
        }

        /**
         * 点击加载更多按钮
         */
        $('.load-more-btn').click(function(){
            currentPage++;
            $('.load-more-info').show();
            $('.load-more-btn').hide();
            $.ajax({//请求数据
                url: '/blog/category/getCategoryArticleListWithAjax?category=1&sort=viewHits&currentPage='+currentPage+'&pageSize=' + pageSize,
                type: 'GET',
                async: true,
                success: function (data) {
                    data = mytrim(data);
                    $('.load-more-btn').show();
                    $('.load-more-info').hide();
                    if (data == undefined || data == '') {
                        //已经没有数据
                    } else {
                        $('.selected_div > ul').append(data);
                        bindScroll();
                    }

                },
                error: function (xhr, textStatus) {
                    alert("服务器请求异常！");
                    $('.loading').hide();
                }
            });
        });
    });
</script>
</body>
</html>
