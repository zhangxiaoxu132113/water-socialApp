<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 2017/4/9
  Time: 下午7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/asset/css/searchPage.css">
</head>
<body>
<div id="container">
    <div id="container-inner">
        <div class="header">
            <div class="header-inner">
                <div class="logo" style="float: left">
                    <img src="<%=path%>/asset/content/logo.png" alt="" class="logo-img">
                </div>
                <div class="search-frame">
                    <form action="/article/search" method="get">
                        <input type="text" class="search-input-text" name="keyword" value="${requestScope.keyword}">
                        <input class="search-btn" value="搜索" type="submit">
                        <%--<a class="search-btn">搜索</a>--%>
                    </form>
                </div>
                <div class="userinfo" style="float: right">
                    <ul>
                        <li><a href="">首页</a></li>
                        <li>设置</li>
                        <li>登录</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="search-nav">
            <div class="search-nav-inner">
                <ul>
                    <li class="active">全部</li>
                    <li>IT文章</li>
                    <li>资讯</li>
                    <li>教程</li>
                </ul>
            </div>
        </div>
        <div class="main-content">
            <div class="main-content-inner">
                <div class="search-content">
                    <div class="search-total">
                        为你找到相关搜索:<span>${requestScope.totalHits}</span>篇文章，耗时<span>${requestScope.took}</span>毫秒
                    </div>
                    <c:forEach items="${requestScope.articleList}" var="article">
                        <div class="search-item">
                            <div class="article-title"><a
                                    href="<%=path%>/article/detail/${article.id}">${article.title}</a></div>
                            <div class="article-content">
                                    ${article.description}
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="bailianmeng" style="padding: 2em;box-sizing: border-box">
                    <img src="./img/baidulianmeng.png" alt="" width="100%">
                </div>
            </div>
            <%
                String kw = (String) request.getAttribute("keyword");
                long total = (Long) request.getAttribute("totalHits");
                int currentPage = (Integer) request.getAttribute("currentPage");
                String pageLink = path + "/article/search?keyword=%s&currentPage=%s";
                int pageSize = 10;
                int firstPage = 1;
                long pageTotal = total / pageSize;
//                long lastPage = pageSize > pageTotal ? pageTotal : pageSize;
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
                %>
                <a href="<%String.format(pageLink,kw,currentPage-1);%>"><span class="last-page">&lt;&lt;上一页</span></a>
                <%
                    }
                    PrintWriter writer = response.getWriter();
                    for (int i = firstPage; i <= lastPage; i++) {
                        %>
                            <a href="<%=path%>/article/search?keyword=<%=kw%>&currentPage=<%=i%>"><span><%=i%></span></a>
                        <%
                    }
                    if (lastPage < pageTotal) {
                %>
                <a href="<%String.format(pageLink,kw,currentPage+1);%>"><span class="next-page">下一页&gt;&gt;</span></a>
                <%
                    }
                %>
            </div>
            <div style="clear: both"></div>
        </div>

        <div class="footer">
            <div class="footer-inner">
                <a href="">建议</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
