<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div id="category-nav">
    <div id="category-nav-inner">
        <ul>
            <li class="all-category">
                全部分类
                <div class="all-category-inner">
                    <ul>
                        <c:forEach items="${requestScope.categoryList}" var="category">
                            <li>
                                <span>${category.name}</span>

                                <div style="margin-left: -1.2em">
                                    <div class="category-panel">
                                        <c:forEach items="${category.children}" var="categoryChildren">
                                            <span><a href="<%=basePath%>/blog/tag/${categoryChildren.name}">${categoryChildren.name}</a></span>
                                        </c:forEach>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </li>
            <li><a href="<%=path%>/blog">文档库</a></li>
            <li><a href="<%=path%>/new">资讯</a></li>
            <li><a href="<%=path%>/course">IT教程</a></li>
            <li>知识库</li>
            <li>经验</li>
            <li>资源下载</li>
        </ul>
    </div>
</div>
