<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<%=path%>/asset/css/mrwater.css">
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
            <div class="Grid-cell u-size3of4">
                <div class="main-left-inner">

                </div>
            </div>
            <div class="Grid-cell u-size1of4">
                <div class="main-right-inner">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
