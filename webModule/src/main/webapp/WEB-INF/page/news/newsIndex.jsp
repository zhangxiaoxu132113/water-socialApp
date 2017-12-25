<%@ page import="com.water.utils.common.Constants" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<%=path%>/asset/css/new-index.css">
    <jsp:include page="../common/baidu_statistics_code.jsp"/>
</head>

<body>
<div id="container">
    <div id="container-inner">
        <div id="header">
            <div id="header-inner">
                <div class="header-nav">
                    <div class="header-nav-inner">
                        <ul>
                            <li><a href="<%=path%>/">首页</a></li>
                            <li><a href="<%=path%>/blog">文档库</a></li>
                            <li><a href="<%=path%>/new">资讯</a></li>
                            <li><a href="<%=path%>/course">IT教程</a></li>
                            <li>知识库</li>
                            <li>经验</li>
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
        <div id="nav-wrap">
            <div class="nav clearfix">
                <div id="logo">
                    <a href=""><img src="<%=path%>/asset/content/logo.png" class="logo-icon"></a>
                </div>
                <div id="jnav">
                    <ul class="nav-inner">
                        <li><a href="<%=path%>/new">最新资讯</a></li>
                        <li><a href="<%=path%>/new?type=<%=Constants.ARTICLE_MODULE.TOU_TIAO.getIndex()%>">头条</a></li>
                        <li>
                            <a href="<%=path%>/new?type=<%=Constants.ARTICLE_MODULE.RUANJIAN_GENGXIN.getIndex()%>">软件更新</a>
                        </li>
                        <li><a href="<%=path%>/new?type=<%=Constants.ARTICLE_MODULE.IT_HANGYE.getIndex()%>">IT行业</a>
                        </li>
                        <li><a href="">业界资讯</a></li>
                        <li><a href="">业界资讯</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="main-content" class="clearfix">
            <div id="main-content-inner">
                <div class="left-body">
                    <div class="art-list">
                        <ul>
                            <c:forEach items="${requestScope.articleDtoList}" var="article">
                                <li>
                                    <i class="lpic"><a href=""><img width="200" height="150"
                                                                    src="http://img.ads.csdn.net/2017/201706081014067064.jpg"
                                                                    alt=""></a></i>
                                    <dl>
                                        <dt><a href="<%=path%>/new/detail/${article.id}.html">${article.title}</a></dt>
                                        <dd>
                                            <span class="desc">${fn:substring(article.description, 0, 100)}...</span>
                                            <p class="info">
                                                <span class="channel"><a href="">数码传奇</a></span>
                                                <span class="date">|&nbsp;&nbsp;2017-08-14 19:15</span>
                                            </p>
                                        </dd>

                                    </dl>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <%
                        int type = (Integer) request.getAttribute("type");
                        int total = (Integer) request.getAttribute("totalHits");
                        int currentPage = (Integer) request.getAttribute("currentPage");
                        int pageSize = 10;
                        int firstPage = 1;
                        long pageTotal = total / pageSize;
                        long lastPage = pageSize;
                        if (currentPage - 7 >= 0) {
                            firstPage = (currentPage - 7) + 2;
                            lastPage = (currentPage - 6) + lastPage;
                            if (lastPage > pageTotal) lastPage = pageTotal;
                        }
                    %>
                    <div class="page">
                        <%
                            if (currentPage > 1) {
                                int lastPageNum = currentPage - 1;
                        %>
                        <a href="<%=path%>/new?type=<%=type%>&currentPage=<%=lastPageNum%>" class="last-page"><span
                        >&lt;&lt;上一页</span></a>
                        <%
                            }
                            PrintWriter writer = response.getWriter();
                            for (int i = firstPage; i <= lastPage; i++) {
                        %>
                        <a href="<%=path%>/new?type=<%=type%>&currentPage=<%=i%>"><span><%=i%></span></a>
                        <%
                            }
                            if (lastPage < pageTotal) {
                                int nextPageNum = currentPage + 1;
                        %>
                        <a href="<%=path%>/new?type=<%=type%>&currentPage=<%=nextPageNum%>" class="next-page"><span
                        >下一页&gt;&gt;</span></a>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="right-body">
                    <div class="box">
                        <div class="hd">
                            <i></i>
                            热门资讯
                        </div>
                        <div class="bd">
                            <ol>
                                <c:forEach items="${requestScope.hotArticleList}" var="article" varStatus="status">
                                    <li>
                                        <a href="<%=path%>/new/detail/${article.id}.html"><em>${status.index+1}</em><span>${article.title}</span></a>
                                    </li>
                                </c:forEach>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
