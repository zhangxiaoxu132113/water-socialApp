<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title></title>
  <style>

  </style>
  <link rel="stylesheet" href="<%=path%>/asset/css/courseIndex.css">
</head>
<body>
  <div id="container">
    <jsp:include page="../common/header-v1.jsp"/>
    <jsp:include page="../common/category-nav.jsp"/>
    <div class="main-content">
      <div class="main-content-inner">
        <div class="main-left">
          <div class="main-left-inner">
            <%--所有分类--%>
            <div class="all-category">
              <ul>
                <li class="header">全部分类</li>
                <li>java技术 (<span>45</span>)</li>
                <li>java技术 (<span>45</span>)</li>
                <li>java技术 (<span>45</span>)</li>
                <li>java技术 (<span>45</span>)</li>
                <li>java技术 (<span>45</span>)</li>
                <li>java技术 (<span>45</span>)</li>
                <li>java技术 (<span>45</span>)</li>
                <li>java技术 (<span>45</span>)</li>
              </ul>
            </div>
            <%--广告--%>
            <div class="ad-content"></div>
          </div>
        </div>

        <div class="main-right">
          <div class="main-right-inner">
            <div class="list">
              <div class="list-item">
                <h4>java技术</h4>
                <div class="list-item-content">
                  <ul>
                    <li>
                      <div class="course-name">Docker教程</div>
                      <div class="course-description">Docker是一个开源的引擎，可以轻松的为任何应用创建一个轻量级的、可移植的、自给自足的容</div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="list-item">
                <h4>java技术</h4>
                <div class="list-item-content">
                  <ul>
                    <li>
                      <div class="course-name">Docker教程</div>
                      <div class="course-description">Docker是一个开源的引擎，可以轻松的为任何应用创建一个轻量级的、可移植的、自给自足的容</div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="list-item">
                <h4>java技术</h4>
                <div class="list-item-content">
                  <ul>
                    <li>
                      <div class="course-name">Docker教程</div>
                      <div class="course-description">Docker是一个开源的引擎，可以轻松的为任何应用创建一个轻量级的、可移植的、自给自足的容</div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="list-item">
                <h4>java技术</h4>
                <div class="list-item-content">
                  <ul>
                    <li>
                      <div class="course-name">Docker教程</div>
                      <div class="course-description">Docker是一个开源的引擎，可以轻松的为任何应用创建一个轻量级的、可移植的、自给自足的容</div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="list-item">
                <h4>java技术</h4>
                <div class="list-item-content">
                  <ul>
                    <li>
                      <div class="course-name">Docker教程</div>
                      <div class="course-description">Docker是一个开源的引擎，可以轻松的为任何应用创建一个轻量级的、可移植的、自给自足的容</div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="list-item">
                <h4>java技术</h4>
                <div class="list-item-content">
                  <ul>
                    <li>
                      <div class="course-name">Docker教程</div>
                      <div class="course-description">Docker是一个开源的引擎，可以轻松的为任何应用创建一个轻量级的、可移植的、自给自足的容</div>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>
  </div>
</body>
</html>
