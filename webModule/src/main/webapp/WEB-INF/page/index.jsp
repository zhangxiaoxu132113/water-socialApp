<%@ page import="com.water.uubook.model.dto.TbUbArticleDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    List<TbUbArticleDto> topArticleList = (List<TbUbArticleDto>) request.getAttribute("topArticleList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编程无忧网_让编程更加无忧的IT技术网站</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description"
          content="编程无忧网(www.uubook.net)提供了优质的编程技术博文，编程实例教程，软件最新资讯，涵盖编程语言，移动开发，前端开发，数据库，服务器，云计算等各个领域，更多的优质资源尽在编程无忧网">
    <meta name="keywords" content="编程学习,IT技术,软件开发,技术博客,编程教程,软件资讯,软件学习,java架构师教程">
    <meta name="baidu-site-verification" content="YZloLpsXpn"/>
    <meta name="baidu_union_verify" content="b81003967cf3b5919e27af4f74d24cb7">
    <link rel="icon" href="<%=basePath%>/asset/img/bitbug_favicon.ico">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/articleList.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/common/footer-common.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/common/header-common.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/common/category-common.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/font/iconfont/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/plugs/slider/slider.css">
    <jsp:include page="common/baidu_statistics_code.jsp"/>
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
                        <img src="http://img.uubook.net/upload/bmiddle/201801/06/12e6e69e-3dcb-4d73-a5eb-115898534383.png" alt="<%=basePath%>/article/detail/<%=topArticleList.get(0).getTitle()%>" width="370" height="248">
                        <div id="view-info-detail-title"><a
                                href="<%=basePath%>/article/detail/<%=topArticleList.get(0).getId()%>.html"><%=topArticleList.get(0).getTitle() %>
                        </a></div>
                        <div id="view-info-detail-description">
                            ${fn:substring(topArticleList.get(0).getDescription(), 0, 100)}
                        </div>
                        <div id="view-info-detail-content">
                            <ul>
                                <c:forEach items="${requestScope.topArticleList}" begin="10" end="12" var="article">
                                    <li style="margin-top: 5px"><a
                                            href="<%=basePath%>/article/detail/${article.id}.html">${article.title}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div id="view-info-list">
                        <ul>
                            <c:forEach items="${requestScope.topArticleList}" begin="1" end="9" var="article">
                                <li><a href="<%=basePath%>/article/detail/${article.id}.html">${article.title}</a></li>
                            </c:forEach>
                            <span style="float: right;padding: 0.5em 0;text-decoration: underline;"><a
                                    href="<%=basePath%>/blog">更多</a></span>
                        </ul>
                    </div>
                </div>
                <div class="ad" id="long-ad">
                    <script type="text/javascript">
                        var cpro_id = "u3171857";
                    </script>
                    <script type="text/javascript" src="//cpro.baidustatic.com/cpro/ui/c.js"></script>
                </div>
                <div id="view-tab">
                    <div id="category_bar">
                        <div class="wrap" id="wrap">
                            <ul class="tabClick">
                                <li class="active" onclick="click_category(this, -1)">综合</li>
                                <c:forEach items="${requestScope.categoryList}" var="category" begin="0" end="5">
                                    <li onclick="click_category(this, ${category.id})">${category.name}</li>
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
                                                        <li><em>1</em>（干货）：Spark性能优化</li>
                                                        <li><em>2</em>ssm框架系列（1）-环境搭建</li>
                                                        <li><em>3</em>Java集合类操作优化经验总结</li>
                                                        <li><em>4</em>Linux下搭建MySQL集群</li>
                                                        <li><em>5</em>Java进阶书籍推荐</li>
                                                        <li><em>6</em>【教你轻松修改React Native端口】如何同时运行</li>
                                                        <li><em>7</em>引领大数据新未来 斐讯北京数据中心正式开业</li>
                                                        <li><em>8</em>深入理解Ribbon之源码解析</li>
                                                    </ul>
                                                </div>
                                                <div class="left_bottom_ad">
                                                    <script type="text/javascript">
                                                        /*首页左下角广告位-002*/
                                                        var cpro_id = "u3171836";
                                                    </script>
                                                    <script type="text/javascript"
                                                            src="//cpro.baidustatic.com/cpro/ui/c.js"></script>
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
                                                                        <p>${fn:substring(article.description, 0, 80)}...</p>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                    <span class="hot_add_more">加载更多</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <c:forEach items="${requestScope.categoryList}" var="category">
                                        <div class="category-hot-article">
                                            <a href="<%=basePath%>/blog/category/getCategoryArticleListWithAjax?category=${category.id}&sort=viewHits&currentPage=1&pageSize=10"></a>
                                            <ul id="category-article-${category.id}">
                                            </ul>
                                            <div class="load_more" onclick="loadMore(${category.id})">加载更多</div>
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
                            <c:forEach items="${requestScope.adInfoList}" var="adInfo">
                                <li class="slider-item"
                                    style="width: 300px; height: 200px; background-image:url('${adInfo.pic}')"></li>
                            </c:forEach>
                        </ul>
                        <ul class="slider-navigation" data-slidizle-navigation></ul>
                    </section>
                    <script type="text/javascript">
                        var cpro_id = "u3171829";
                    </script>
                    <script type="text/javascript" src="//cpro.baidustatic.com/cpro/ui/i.js"></script>
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
                                            ${fn:substring(article.description, 0, 100)}
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
                <div class="baidu_ad">
                    <script type="text/javascript">
                        var cpro_id = "u3171800";
                    </script>
                    <script type="text/javascript" src="//cpro.baidustatic.com/cpro/ui/c.js"></script>
                </div>
            </div>
        </div>

    </div>
</div>
<%--页脚--%>
<jsp:include page="common/footer.jsp"/>
<script src="<%=basePath%>/plugs/slider/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>/plugs/slider/jquery.slidizle.js"></script>
<script src="<%=basePath%>/asset/js/articleList.js"></script>
</body>
</html>
