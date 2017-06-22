<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>IT教程_uubook</title>
    <meta name="Keywords"
          content="<c:forEach items="${requestScope.courseSubjects}" var="item">${item.name}教程,</c:forEach>等"/>
    <meta name="description"
          content="<c:forEach items="${requestScope.courseSubjects}" var="item">${item.name}教程,</c:forEach>等"/>
    <link rel="stylesheet" href="<%=path%>/asset/css/mrwater.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/courseIndex.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/common/footer-common.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/common/header-common.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/common/category-common.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/font/iconfont2/iconfont.css">
</head>
<body>
<div id="container">
    <jsp:include page="../common/header-v1.jsp"/>
    <jsp:include page="../common/category-nav.jsp"/>
    <div id="main-content">
        <div id="main-content-inner" class="clearfix Grid Grid-withGutter">
            <%--主体-左边内容--%>
            <div class="Grid-cell u-size1of4">
                <div class="main-left-inner">
                    <%--所有分类--%>
                    <div class="all-course-category">
                        <ul>
                            <li class="header">全部分类</li>
                            <c:forEach items="${requestScope.courseSubjects}" var="item">
                                <li><a href="">${item.name}(<span>${item.sonCourseSubjectList.size()}</span>)</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <%--广告--%>
                    <div class="ad-content"></div>
                </div>
            </div>
            <%--主体-右边内容--%>
            <div class="Grid-cell u-size3of4">
                <div class="main-right-inner">
                    <div class="list">
                        <c:forEach items="${requestScope.courseSubjects}" var="item">
                            <div class="list-item">
                                <h4><i class="iconfont" style="margin-right: 0.5em">&#xf0025;</i>${item.name}</h4>

                                <div class="list-item-content">
                                    <ul>
                                        <c:forEach items="${item.sonCourseSubjectList}" var="sonItem">
                                            <li>
                                                <div class="course-name">
                                                    <a href="javascript:void(0);" target="_self"
                                                       onclick="window.open('<%=path%>/course/' + encodeURI('${sonItem.name}'));">${sonItem.name}</a>
                                                </div>
                                                <div class="course-description">${fn:substring(sonItem.description,0,100)}</div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>
</div>
</body>
</html>
