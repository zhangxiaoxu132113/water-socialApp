<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
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