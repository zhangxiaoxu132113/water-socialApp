<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div id="header">
  <div id="header-container">
    <div class="header-container-inner">
      <div class="header-logo">
        <ul>
          <li class="mw-logo">
            <img src="<%=path%>/asset/content/logo.png" class="logo-icon">
          </li>
        </ul>
      </div>
      <div class="user-info">
        <ul  style="color: #666">
          <c:choose>
            <c:when test="${global_user != null}">
              <li>
                <form action="/article/search" class="search-form" method="get" style="position: relative">
                  <input type="text" style="display: block;" name="keyword" class="search-input index-search-frame" placeholder="搜索内容"/>
                  <label>
                    <a class="search-btn-a"><i class="iconfont search-btn-icon"  style="font-weight: bold;">&#xe620;</i></a>
                  </label>
                </form>
              </li>
              <li class="user-info-news">
                <span>
                    <a style="position: relative">
                      <i class="iconfont" style="font-size: 18px">&#xe639;</i>
                      <span>通知</span>
                      <ul style="position: absolute;display: none">
                        <li><a href="/${global_user.id}/home">我的主页</a></li>
                        <li>注销</li>
                      </ul>
                    </a>
                </span>
              </li>
              <li class="user-info-name">
                <span>
                    <a style="position: relative">
                      <img src="<%=path%>/asset/content/be3489c6jw8fd6m9eofq2j20ku0kuta9.jpg" class="user-header"/>
                      <ul style="position: absolute;display: none">
                        <li><a href="/${global_user.id}/home"><span class="nickname">${global_user.nickname}</span></a></li>
                        <li>注销</li>
                      </ul>
                    </a>
                </span>
              </li>
            </c:when>
            <c:otherwise>
              <li>你还未登录！<a href="<%=path%>/login">登录</a></li>
            </c:otherwise>
          </c:choose>
        </ul>
      </div>
    </div>
  </div>
  <div style="margin-top: 60px;position: relative">
  </div>
</div>
