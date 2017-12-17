<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    Random random = new Random(5);
%>
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
                    <c:forEach items="${article.tagList}" var="tag" begin="0"
                               end="<%=random.nextInt(4)%>">
                        <a class="tag tag_<%=random.nextInt(4)%>"
                           href="<%=basePath%>/blog/tag/${tag.name}">${tag.name}&nbsp;</a>
                    </c:forEach>
                </span>
            </div>
        </div>
    </div>
</c:forEach>