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
            <c:forEach items="${requestScope.tagList}" var="tag">
              <li>
                <span>${tag.name}</span>
                <div style="margin-left: -1.2em">
                  <div class="category-panel">
                    <c:forEach items="${tag.children}" var="tagChildren">
                      <span><a>${tagChildren.name}</a></span>
                    </c:forEach>
                  </div>
                </div>
              </li>
            </c:forEach>
          </ul>
        </div>
      </li>
      <c:forEach items="${requestScope.categoryList}" var="category">
        <li><a href="<%=path%>/course">${category.name}</a></li>
      </c:forEach>
    </ul>
  </div>
</div>
