<%@ page import="com.water.uubook.model.dto.ArticleDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    List<ArticleDto> topArticleList = (List<ArticleDto>) request.getAttribute("topArticleList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编程无忧网_编程更加无忧的的IT技术网站</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="编程无忧网(www.uubook.net)提供了优质的编程技术博文，编程实例教程，软件最新资讯，涵盖编程语言，移动开发，前端开发，数据库，服务器，云计算等各个领域，更多的优质资源尽在编程无忧网">
    <meta name="keywords" content="编程学习,IT技术,软件开发,技术博客,编程教程,软件资讯,软件学习,java架构师教程">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/articleList.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/common/footer-common.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/common/header-common.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/common/category-common.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/font/iconfont/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/plugs/slider/slider.css">
    <link rel="icon" href="<%=path%>/asset/img/bitbug_favicon.ico">
</head>
<body>
<div id="container">
    <jsp:include page="common/header-v1.jsp"/>
    <jsp:include page="common/category-nav.jsp"/>
    <div id="main-content">
        <div id="main-content-inner">
            <div id="main-content-left">
                <div id="view-info">
                    <div id="view-info-detail" style="display: inline-block;width: 59%; padding-right: 1em">
                        <img src="<%=basePath%>/asset/content/123.png" width="370" height="248">
                        <div id="view-info-detail-title"><a
                                href="<%=basePath%>/article/detail/<%=topArticleList.get(0).getId()%>.html"><%=topArticleList.get(0).getTitle() %>
                        </a></div>
                        <div id="view-info-detail-description">
                            <%=topArticleList.get(0).getDescription() %>
                        </div>
                        <div id="view-info-detail-content">
                            <ul>
                                <c:forEach items="${requestScope.topArticleList}" begin="9" end="11" var="article">
                                    <li><a href="<%=basePath%>/article/detail/${article.id}.html">${article.title}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div id="view-info-list">
                        <ul>
                            <c:forEach items="${requestScope.topArticleList}" begin="1" end="8" var="article">
                                <li><a href="<%=basePath%>/article/detail/${article.id}.html">${article.title}</a></li>
                            </c:forEach>
                            <span style="float: right;padding: 0.5em 0;text-decoration: underline;"><a
                                    href="<%=basePath%>/blog">更多</a></span>
                        </ul>
                    </div>
                </div>
                <div class="ad">
                    <img src="<%=basePath%>/asset/content/banner.jpg">
                </div>
                <div id="view-tab">
                    <div id="category_bar">
                        <div class="wrap" id="wrap">
                            <ul class="tabClick">
                                <li class="active">综合</li>
                                <c:forEach items="${requestScope.categoryList}" var="category" begin="0" end="5">
                                    <li>${category.name}</li>
                                </c:forEach>
                            </ul>
                            <div class="tabCon">
                                <div class="tabBox">
                                    <div class="selected_div">
                                        <div id="article-list">
                                            <div class="left">
                                                <div id="subject-list">
                                                    <div class="header-info">
                                                        <h2 class="h2-header-info">经验</h2>
                                                        <div class="red_bottom"></div>
                                                    </div>
                                                    <ul>
                                                        <li><em>1</em><a href="">（干货）：Spark性能优化</a></li>
                                                        <li><em>2</em><a href="">ssm框架系列（1）-环境搭建</a></li>
                                                        <li><em>3</em><a href="">Java集合类操作优化经验总结</a></li>
                                                        <li><em>4</em><a href="">Linux下搭建MySQL集群</a></li>
                                                        <li><em>5</em><a href="">Java进阶书籍推荐</a></li>
                                                        <li><em>6</em><a href="">【教你轻松修改React Native端口】如何同时运行</a></li>
                                                        <li><em>7</em><a href="">引领大数据新未来 斐讯北京数据中心正式开业</a></li>
                                                        <li><em>8</em><a href="">深入理解Ribbon之源码解析</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="right">
                                                <div id="recently-article-list">
                                                    <div class="header-info">
                                                        <h2 class="h2-header-info">最新热门</h2>
                                                        <div class="red_bottom"></div>
                                                    </div>
                                                    <ul>
                                                        <c:forEach items="${requestScope.hotBlogArticle}" var="article">
                                                            <li>
                                                                <a href="<%=basePath%>/article/detail/${article.id}.html">
                                                                    <h3>${article.title}</h3></a>
                                                                <c:choose>
                                                                    <c:when test="${not empty article.picUrl}">
                                                                        <img src="${article.picUrl}" alt="" width="390"
                                                                             height="200">
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <p>${article.description}</p>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <c:forEach items="${requestScope.categoryList}" var="category">
                                        <div class="category-hot-article">
                                            <ul>
                                                <c:forEach items="${category.hotArticles}" var="article">
                                                    <li>
                                                        <div class="topic-img">
                                                            <img src="https://static.oschina.net/uploads/user/1459/2918182_50.jpeg?t=1484105851000"
                                                                 alt="">
                                                        </div>
                                                        <div class="topic-info">
                                                            <h3>
                                                                <a href="<%=basePath%>/article/detail/${article.id}.html">${article.title}</a>
                                                            </h3>
                                                            <p>${fn:substring(article.description, 0, 100)}</p>
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
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="main-content-right">
                <div id="test">
                    <section class="sample slider--animated" data-slidizle data-slidizle-timeout="4000"
                             data-slidizle-loop="true" data-slidizle-pause-on-hover="true">
                        <ul class="slider-content" data-slidizle-content>
                            <li class="slider-item"
                                style="width: 300px; height: 200px; background-image:url('http://localhost:8080/upload/2017-08-26%2023-56-34/2fd9ecf2-6b77-4075-8843-0ed5c58b320b.jpg')"></li>
                            <li class="slider-item"
                                style="width: 300px; height: 200px; background-image:url('http://localhost:8080/upload/2017-08-27%2010-24-57/34498587-d70e-4924-938b-a96b2760199f.jpg')"></li>
                            <li class="slider-item"
                                style="width: 300px; height: 200px; background-image:url('http://localhost:8080/upload/2017-08-27%2017-37-42/df3357c3-dad8-4507-8e8e-27004cb871bd.jpg')"></li>
                        </ul>
                        <ul class="slider-navigation" data-slidizle-navigation></ul>
                    </section>
                </div>
                <div id="new-software-info">
                    <div class="header-info">
                        <h2 class="h2-header-info">软件更新资讯</h2>
                        <div class="red_bottom"></div>
                    </div>
                    <ul>
                        <c:forEach items="${requestScope.softwareInformations}" var="article" varStatus="status">
                            <li>
                                <div class="new-software-item">
                                    <span class="new-info-title-active">
                                        <a
                                                <c:if test="${status.index == 0}">class="new-info-title-active"</c:if>
                                                href="<%=basePath%>/new/detail/${article.id}.html">${article.title}</a>
                                    </span>
                                </div>
                                <c:if test="${status.index == 0}">
                                    <span>
                                        ${article.description}
                                        开发团队宣布，Kotlin 1.1 正式发布。 这是一个很大的进步，使 Kotlin 能在许多新的场景中使用。 Kotlin...
                                    </span>
                                </c:if>
                            </li>
                        </c:forEach>
                        <a style="float: right;padding: 0.5em 0;text-decoration: underline;">更多</a>
                    </ul>
                </div>
                <div id="course-info">
                    <div class="header-info">
                        <h2 class="h2-header-info">热门教程</h2>
                        <div class="red_bottom"></div>
                    </div>
                    <ul>
                        <c:forEach items="${requestScope.courseSubjectList}" var="courseSubject">
                            <li>
                                <img src="http://img.bss.csdn.net/201704250917048986.png" alt=""
                                     style="float: left;width: 90px;height: 60px;margin-right: 10px">
                                <h4><a href="<%=basePath%>/course/${courseSubject.name}">${courseSubject.name}</a></h4>
                                <p>${courseSubject.description}</p>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div id="knowdega-info">
                    <div class="header-info">
                        <h2 class="h2-header-info">知识库</h2>
                        <div class="red_bottom"></div>
                    </div>
                    <ul>
                        <li>
                            <div class="base-img">
                                <a href=""><img src="<%=basePath%>/asset/content/javase.jpg" alt=""></a>
                            </div>
                            <div class="base-desc">
                                <div class="base-name">Java EE 知识库</div>
                                <div class="base-attendtion">
                                    <span>2323</span> 关注 | <span>1234</span> 收录
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="base-img">
                                <a href=""><img src="<%=basePath%>/asset/content/regong.jpg" alt=""></a>
                            </div>
                            <div class="base-desc">
                                <div class="base-name">人工智能</div>
                                <div class="base-attendtion">
                                    <span>2323</span> 关注 | <span>1234</span> 收录
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="base-img">
                                <a href=""><img src="<%=basePath%>/asset/content/python.jpg" alt=""></a>
                            </div>
                            <div class="base-desc">
                                <div class="base-name">Python</div>
                                <div class="base-attendtion">
                                    <span>2323</span> 关注 | <span>1234</span> 收录
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="base-img">
                                <a href=""><img src="<%=basePath%>/asset/content/react.jpg" alt=""></a>
                            </div>
                            <div class="base-desc">
                                <div class="base-name">React 教程</div>
                                <div class="base-attendtion">
                                    <span>2323</span> 关注 | <span>1234</span> 收录
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
        <%--页脚--%>
        <jsp:include page="common/footer.jsp"/>
    </div>
</div>
<script src="<%=basePath%>/plugs/slider/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>/plugs/slider/jquery.slidizle.js"></script>
<script src="<%=basePath%>/asset/js/articleList.js"></script>
<script>
    jQuery(function ($) {
        $('[data-slidizle]').slidizle({
            beforeChange: function (api) {
            }
        });

        $("ul.tabClick li").hover(function () {
            $(this).addClass("active").siblings().removeClass("active"); //切换选中的按钮高亮状态
            var index = $(this).index(); //获取被按下按钮的索引值，需要注意index是从0开始的
            $('.lineDiv').css('margin-left', (index * 140) + 'px');
            $(".tabBox > div").eq(index).show().siblings().hide(); //在按钮选中时在下面显示相应的内容，同时隐藏不需要的框架内容
        });
    });
</script>
</body>
</html>
