<%@ page import="com.water.uubook.model.dto.ArticleDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 2017/4/2
  Time: 下午9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<ArticleDto> articleDtoList = (List<ArticleDto>) request.getAttribute("greeArticleList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/asset/css/articleList.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/common/footer-common.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/common/header-common.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/common/category-common.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/font/iconfont/iconfont.css">
</head>
<body>
<div id="container">
    <jsp:include page="common/header-v1.jsp"/>
    <jsp:include page="common/category-nav.jsp"/>
    <div id="main-content">
        <div id="main-content-inner">
            <div id="main-content-left">
                <div id="view-info">
                    <div id="view-info-detail" style="display: inline-block;width: 59%">
                        <img src="<%=path%>/asset/content/123.png">

                        <div id="view-info-detail-title"><a><%=articleDtoList.get(0).getTitle() %></a></div>
                        <div id="view-info-detail-description">
                            <%=articleDtoList.get(0).getDescription() %>
                        </div>
                        <div id="view-info-detail-content">
                            <ul>
                                <c:forEach items="${requestScope.greeArticleList}" begin="9" end="11" var="article">
                                    <li><a href="<%=path%>/article/detail/${article.id}.html">${article.title}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div id="view-info-list">
                        <ul>
                            <c:forEach items="${requestScope.greeArticleList}" begin="1" end="8" var="article">
                                <li><a href="<%=path%>/article/detail/${article.id}.html">${article.title}</a></li>
                            </c:forEach>
                            <span style="float: right;padding: 0.5em 0;text-decoration: underline;">更多</span>
                        </ul>
                    </div>
                </div>
                <div>
                    <img src="<%=path%>/asset/content/banner.jpg">
                </div>
                <div id="view-tab">
                    <div id="article-list">
                        <div class="left">
                            <div id="subject-list">
                                <h2 class="h2-header-info">经验</h2>
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
                                <h2 class="h2-header-info">最新热门</h2>
                                <ul>
                                    <li>
                                        <a href=""><h3>遍地喧嚣的智能音箱战场，究竟谁能做出中国的 Echo？</h3></a>
                                        <img src="http://img.bss.csdn.net/201705091704076904.jpg" alt="">
                                    </li>
                                    <li>
                                        <a href=""><h3>知道了Youtube的算法原理，会不会成为下一个视频网红呢？</h3></a>
                                        <img src="http://images.csdn.net/20170818/p.jpg" alt="">
                                    </li>
                                    <li>
                                        <a href=""><h3>Apache Flink 技术解读之分布式运行时环境</h3></a>
                                        <p>
                                            在实际的分布式计算环境中，Flink 会将多个运算子任务链接到分布式计算任务中。每个线程执行一个计算任务。将运算符链接到计算任务中对于系统性能的提升有很大的帮助：它降低了线程间切换与缓冲的开销，并且在降低延时的...
                                        </p>
                                    </li>
                                    <li>
                                        <a href=""><h3>Apache Flink 技术解读之分布式运行时环境</h3></a>
                                        <p>
                                            在实际的分布式计算环境中，Flink 会将多个运算子任务链接到分布式计算任务中。每个线程执行一个计算任务。将运算符链接到计算任务中对于系统性能的提升有很大的帮助：它降低了线程间切换与缓冲的开销，并且在降低延时的...
                                        </p>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="main-content-right">
                <div id="new-software-info">
                    <h2>软件更新资讯</h2>
                    <ul>
                        <li>
                            <div class="new-software-item" style="position: relative">
                                <a class="new-info-title-active">
                                    Kotlin 1.1 正式版来了，基于 JVM 的编程语言<br>
                                </a>
                            </div>
                            <span>
                                开发团队宣布，Kotlin 1.1 正式发布。 这是一个很大的进步，使 Kotlin 能在许多新的场景中使用。 Kotlin...
                            </span>

                        </li>
                        <c:forEach items="${requestScope.softwareInformations}" var="article">
                            <li>
                                <div class="new-software-item">
                                    <span class="new-info-title-active">
                                        <a href="<%=path%>/article/detail/${article.id}">${article.title}</a>
                                    </span>
                                </div>
                            </li>
                        </c:forEach>
                        <a style="float: right;padding: 0.5em 0;text-decoration: underline;">更多</a>
                    </ul>
                </div>
                <div id="course-info">
                    <h2 class="h2-header-info">热门教程</h2>
                    <ul>
                        <c:forEach items="${requestScope.courseSubjectDtos}" var="courseSubject">
                            <li>
                                <img src="http://img.bss.csdn.net/201704250917048986.png" alt="" style="float: left;width: 90px;height: 60px;margin-right: 10px">
                                <h4>${courseSubject.name}</h4>
                                <p>${courseSubject.description}</p>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div id="knowdega-info">
                    <h2 class="h2-header-info">知识库</h2>
                    <%--<ul>--%>
                        <%--<li>--%>
                            <%--<!--<img src="img/javase.jpg">Java<span>233篇</span>-->--%>
                            <%--<div class="img-top" style="position: relative">--%>
                                <%--<img src="<%=path%>/asset/content/javase-top.jpg" style="width: 100%;height: auto">--%>
                                <%--<img src="<%=path%>/asset/content/javase.jpg" class="language-icon">--%>
                            <%--</div>--%>
                            <%--<div class="language-info">--%>
                                <%--<div class="language-name">Java SE</div>--%>
                                <%--<div class="language-num">532 收录资源 | 343 关注</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<div class="img-top" style="position: relative">--%>
                                <%--<img src="<%=path%>/asset/content/regong-bg.jpg" style="width: 100%;height: auto">--%>
                                <%--<img src="<%=path%>/asset/content/regong.jpg" class="language-icon">--%>
                            <%--</div>--%>
                            <%--<div class="language-info">--%>
                                <%--<div class="language-name">人工智能</div>--%>
                                <%--<div class="language-num">532 收录资源 | 343 关注</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<div class="img-top" style="position: relative">--%>
                                <%--<img src="<%=path%>/asset/content/python-bg.jpg" style="width: 100%;height: auto">--%>
                                <%--<img src="<%=path%>/asset/content/python.jpg" class="language-icon">--%>
                            <%--</div>--%>
                            <%--<div class="language-info">--%>
                                <%--<div class="language-name">python</div>--%>
                                <%--<div class="language-num">532 收录资源 | 343 关注</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<div class="img-top" style="position: relative">--%>
                                <%--<img src="<%=path%>/asset/content/react-bg.jpg" style="width: 100%;height: auto">--%>
                                <%--<img src="<%=path%>/asset/content/react.jpg" class="language-icon">--%>
                            <%--</div>--%>
                            <%--<div class="language-info">--%>
                                <%--<div class="language-name">React active</div>--%>
                                <%--<div class="language-num">532 收录资源 | 343 关注</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<div class="img-top" style="position: relative">--%>
                                <%--<img src="<%=path%>/asset/content/python-bg.jpg" style="width: 100%;height: auto">--%>
                                <%--<img src="<%=path%>/asset/content/python.jpg" class="language-icon">--%>
                            <%--</div>--%>
                            <%--<div class="language-info">--%>
                                <%--<div class="language-name">python</div>--%>
                                <%--<div class="language-num">532 收录资源 | 343 关注</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<div class="img-top" style="position: relative">--%>
                                <%--<img src="<%=path%>/asset/content/react-bg.jpg" style="width: 100%;height: auto">--%>
                                <%--<img src="<%=path%>/asset/content/react.jpg" class="language-icon">--%>
                            <%--</div>--%>
                            <%--<div class="language-info">--%>
                                <%--<div class="language-name">React active</div>--%>
                                <%--<div class="language-num">532 收录资源 | 343 关注</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>

                        <%--<a style="float: right;padding: 0.5em 0;text-decoration: underline;">更多</a>--%>

                    <%--</ul>--%>
                    <ul>
                        <li>
                            <div class="base-img">
                                <a href=""><img src="<%=path%>/asset/content/javase.jpg" alt=""></a>
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
                                <a href=""><img src="<%=path%>/asset/content/regong.jpg" alt=""></a>
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
                                <a href=""><img src="<%=path%>/asset/content/python.jpg" alt=""></a>
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
                                <a href=""><img src="<%=path%>/asset/content/react.jpg" alt=""></a>
                            </div>
                            <div class="base-desc">
                                <div class="base-name">React 教程</div>
                                <div class="base-attendtion">
                                    <span>2323</span> 关注 | <span>1234</span> 收录
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="base-img">
                                <a href=""><img src="<%=path%>/asset/content/react.jpg" alt=""></a>
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
<script src="<%=path%>/asset/js/jquery.js"></script>
<script src="<%=path%>/asset/js/articleList.js"></script>
</body>
</html>
