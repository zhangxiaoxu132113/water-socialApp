<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 2017/2/1
  Time: 下午5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/asset/css/mrwater.css">
<!--字体图标样式 -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>/asset/css/font/iconfont/iconfont.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/asset/css/font/englishFont/mw-font.css">


<script src="<%=basePath%>/asset/js/jquery.js"></script>
<script src="<%=basePath%>/asset/js/mrwater.js"></script>
