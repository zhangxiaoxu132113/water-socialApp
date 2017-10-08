<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<c:forEach items="${requestScope.articleDtoList}" var="article">
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
