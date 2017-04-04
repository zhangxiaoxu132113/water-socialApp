<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 2017/4/2
  Time: 下午9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/asset/css/articleList.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/font/iconfont/iconfont.css">
    <style>
        .user-header {
            width: 37px;height: auto;
            vertical-align: middle;border-radius: 4px;
        }
        .index-search-frame {
            display: block;
            margin-top: 15px;
            width: 250px;
            outline: 0;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="header">
        <div id="header-container">
            <div class="header-container-inner">
                <div class="header-logo">
                    <ul>
                        <li class="mw-logo">
                            <!--<span>Crawl</span>-->
                            <img src="<%=path%>/asset/content/logo.png" class="logo-icon">

                        </li>

                    </ul>
                </div>
                <div class="user-info">
                    <ul  style="color: #666">
                        <c:choose>
                            <c:when test="${global_user != null}">
                                <li><input style="display: block;" class="search-input index-search-frame" placeholder="搜索内容"/></li>
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
                    <c:forEach items="${requestScope.tagList}" var="tag">
                        <li>${tag.name}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>

    </div>
    <div id="main-content">
        <div id="main-content-inner">
            <div id="main-content-left">
                <div id="view-info">
                    <div id="view-info-detail" style="display: inline-block;width: 59%">
                        <img src="<%=path%>/asset/content/123.png">
                        <div id="view-info-detail-title"><a>图数据库：大数据时代的高铁</a></div>
                        <div id="view-info-detail-description">
                            如果把关系型数据库比做火车，那么大数据时代，图数据库可比做高铁。它已成为NoSQL中关注度最高，发展趋势最明显的技术
                        </div>
                        <div id="view-info-detail-content">
                            <ul>
                                <c:forEach items="${requestScope.articleList}" begin="10" end="13" var="article">
                                    <li><a href="<%=path%>/article/detail/${article.id}">${article.title}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div id="view-info-list">
                        <ul>
                            <c:forEach items="${requestScope.articleList}" begin="0" end="9" var="article">
                                <li><a href="<%=path%>/article/detail/${article.id}">${article.title}</a></li>
                            </c:forEach>
                            <span style="float: right;padding: 0.5em 0;text-decoration: underline;">更多</span>
                        </ul>
                    </div>
                </div>
                <div>
                    <img src="<%=path%>/asset/content/banner.jpg">
                </div>
                <div id="view-tab">
                    <div id="tab">
                        <ul>
                            <li class="tab-active">最近阅读</li>
                            <li>最新文章</li>
                            <li>精彩文章</li>
                        </ul>
                    </div>
                    <div class="article-list">
                        <div class="article-title-inner">
                            <div class="article-list-item-inner">
                                <section class="article-list-item">
                                    <div class="qa-rank">
                                        <div class="bb">
                                            12
                                            <small style="display: block;font-size: 12px;">笔记</small>
                                        </div>
                                        <div class="aa">
                                            0
                                            <small style="display: block;font-size: 12px">浏览</small>
                                        </div>

                                    </div>
                                    <div class="summary">
                                        <ul class="category-tab">
                                            <li>
                                                <a>陈信宏</a> <span>12/09</span>
                                            </li>
                                        </ul>
                                        <h2 class="title"><a>使用 InfoSphere MDM 工作流执行主数据治理</a></h2>
                                        <ul></ul>
                                    </div>
                                </section>
                                <section class="article-list-item">
                                    <div class="qa-rank">
                                        <div class="bb">
                                            12
                                            <small style="display: block;font-size: 12px;">笔记</small>
                                        </div>
                                        <div class="aa">
                                            0
                                            <small style="display: block;font-size: 12px">浏览</small>
                                        </div>

                                    </div>
                                    <div class="summary">
                                        <ul class="category-tab">
                                            <li>
                                                <a>陈信宏</a> <span>12/09</span>
                                            </li>
                                        </ul>
                                        <h2 class="title"><a>使用 IBM DB2 Recovery Expert 工具高效完成数据库恢复之对象恢复篇</a></h2>
                                        <ul></ul>
                                    </div>
                                </section>
                                <section class="article-list-item">
                                    <div class="qa-rank">
                                        <div class="bb">
                                            12
                                            <small style="display: block;font-size: 12px;">笔记</small>
                                        </div>
                                        <div class="aa">
                                            0
                                            <small style="display: block;font-size: 12px">浏览</small>
                                        </div>

                                    </div>
                                    <div class="summary">
                                        <ul class="category-tab">
                                            <li>
                                                <a>陈信宏</a> <span>12/09</span>
                                            </li>
                                        </ul>
                                        <h2 class="title"><a>使用 InfoSphere CDC 实现 DB2 数据库的 DDL 复制</a></h2>
                                        <ul></ul>
                                    </div>
                                </section>
                                <section class="article-list-item">
                                    <div class="qa-rank">
                                        <div class="bb">
                                            12
                                            <small style="display: block;font-size: 12px;">笔记</small>
                                        </div>
                                        <div class="aa">
                                            0
                                            <small style="display: block;font-size: 12px">浏览</small>
                                        </div>

                                    </div>
                                    <div class="summary">
                                        <ul class="category-tab">
                                            <li>
                                                <a>陈信宏</a> <span>12/09</span>
                                            </li>
                                        </ul>
                                        <h2 class="title"><a>通过 Informix 系统表监控和优化数据库</a></h2>
                                        <ul></ul>
                                    </div>
                                </section>
                                <section class="article-list-item">
                                    <div class="qa-rank">
                                        <div class="bb">
                                            12
                                            <small style="display: block;font-size: 12px;">笔记</small>
                                        </div>
                                        <div class="aa">
                                            0
                                            <small style="display: block;font-size: 12px">浏览</small>
                                        </div>

                                    </div>
                                    <div class="summary">
                                        <ul class="category-tab">
                                            <li>
                                                <a>陈信宏</a> <span>12/09</span>
                                            </li>
                                        </ul>
                                        <h2 class="title"><a>分区数据库环境下 DB2 LOAD 性能调优</a></h2>
                                        <ul></ul>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="main-content-right">
                <div id="new-software-info">
                    <h2>软件更新资讯</h2>
                    <ul>
                        <li>
                            <div class="new-software-item" style="position: relative">
                                <a class="new-info-title-active">
                                    Kotlin 1.1 正式版来了，基于 JVM 的编程语言<br>
                                </a>
                            </div>
                            <span>
                                开发团队宣布，Kotlin 1.1 正式发布。 这是一个很大的进步，使 Kotlin 能在许多新的场景中使用。 Kotlin...
                            </span>

                        </li>
                        <c:forEach items="${requestScope.softwareInformations}" var="article">
                            <li>
                                <div class="new-software-item">
                                    <span class="new-info-title-active">
                                        <a href="<%=path%>/article/detail/${article.id}">${article.title}</a>
                                        <span class="new-info-date">01/12</span>
                                    </span>
                                </div>
                            </li>
                        </c:forEach>
                        <a style="float: right;padding: 0.5em 0;text-decoration: underline;">更多</a>
                    </ul>
                </div>
                <div id="knowdega-info">
                    <h2>知识库</h2>
                    <ul>
                        <li>
                            <!--<img src="img/javase.jpg">Java<span>233篇</span>-->
                            <div class="img-top" style="position: relative">
                                <img src="<%=path%>/asset/content/javase-top.jpg" style="width: 100%;height: auto">
                                <img src="<%=path%>/asset/content/javase.jpg" class="language-icon">
                            </div>
                            <div class="language-info">
                                <div class="language-name">Java SE</div>
                                <div class="language-num">532 收录资源 | 343 关注</div>
                            </div>
                        </li>
                        <li>
                            <div class="img-top" style="position: relative">
                                <img src="<%=path%>/asset/content/regong-bg.jpg" style="width: 100%;height: auto">
                                <img src="<%=path%>/asset/content/regong.jpg" class="language-icon">
                            </div>
                            <div class="language-info">
                                <div class="language-name">人工智能</div>
                                <div class="language-num">532 收录资源 | 343 关注</div>
                            </div>
                        </li>
                        <li>
                            <div class="img-top" style="position: relative">
                                <img src="<%=path%>/asset/content/python-bg.jpg" style="width: 100%;height: auto">
                                <img src="<%=path%>/asset/content/python.jpg" class="language-icon">
                            </div>
                            <div class="language-info">
                                <div class="language-name">python</div>
                                <div class="language-num">532 收录资源 | 343 关注</div>
                            </div>
                        </li>
                        <li>
                            <div class="img-top" style="position: relative">
                                <img src="<%=path%>/asset/content/react-bg.jpg" style="width: 100%;height: auto">
                                <img src="<%=path%>/asset/content/react.jpg" class="language-icon">
                            </div>
                            <div class="language-info">
                                <div class="language-name">React active</div>
                                <div class="language-num">532 收录资源 | 343 关注</div>
                            </div>
                        </li>
                        <li>
                            <div class="img-top" style="position: relative">
                                <img src="<%=path%>/asset/content/python-bg.jpg" style="width: 100%;height: auto">
                                <img src="<%=path%>/asset/content/python.jpg" class="language-icon">
                            </div>
                            <div class="language-info">
                                <div class="language-name">python</div>
                                <div class="language-num">532 收录资源 | 343 关注</div>
                            </div>
                        </li>
                        <li>
                            <div class="img-top" style="position: relative">
                                <img src="<%=path%>/asset/content/react-bg.jpg" style="width: 100%;height: auto">
                                <img src="<%=path%>/asset/content/react.jpg" class="language-icon">
                            </div>
                            <div class="language-info">
                                <div class="language-name">React active</div>
                                <div class="language-num">532 收录资源 | 343 关注</div>
                            </div>
                        </li>

                        <a style="float: right;padding: 0.5em 0;text-decoration: underline;">更多</a>

                    </ul>
                </div>
            </div>
        </div>

    </div>
    <div id="footer">
        <div class="row footer-inner" style="padding: 0 1em;">
            <div class="col-sm-2">
                <dl>
                    <dt>网站相关</dt>
                </dl>
                <dd>
                    <a>关于我们</a>
                </dd>
                <dd>
                    <a>服务条款</a>
                </dd>
                <dd>
                    <a>帮助中心</a>
                </dd>
                <dd>
                    <a>社区服务中心</a>
                </dd>
            </div>
            <div class="col-sm-2">
                <dl>
                    <dt>联系合作</dt>
                </dl>
                <dd>
                    <a>联系我们</a>
                </dd>
                <dd>
                    <a>加入我们</a>
                </dd>
                <dd>
                    <a>合作伙伴</a>
                </dd>
                <dd>
                    <a>媒体介绍</a>
                </dd>
            </div>
            <div class="col-sm-2">
                <dl>
                    <dt>常用链接</dt>
                </dl>
                <dd>
                    <a>ibm开发者社区</a>
                </dd>
                <dd>
                    <a>csdn中文社区</a>
                </dd>
                <dd>
                    <a>开源中国</a>
                </dd>
                <dd>
                    <a>博客园</a>
                </dd>
            </div>
            <div class="col-sm-2">
                <dl>
                    <dt>Github</dt>
                </dl>
                <dd>
                    <a>Twitter</a>
                </dd>
                <dd>
                    <a>新浪微博</a>
                </dd>
                <dd>
                    <a>团队日志</a>
                </dd>
                <dd>
                    <a>产品技术日志</a>
                </dd>
                <dd>
                    <a>社区运营日志</a>
                </dd>
                <dd>
                    <a>市场运营日志</a>
                </dd>
            </div>
            <div class="col-sm-2" style="width: 25%;!important">
                <dl>
                    <dt>内容许可</dt>
                </dl>
                <dd>
                    除特别说明外，用户内容均采用 知识共享署名-非商业性使用-禁止演绎 4.0 国际许可协议 进行许可
                    本站由 又拍云 提供 CDN 存储服务
                </dd>
            </div>
            <div style="clear: both;"></div>
        </div>

        <div class="copyright">
            Copyright © 2011-2017 SegmentFault. 当前呈现版本 17.02.05<br>
            <a rel="nofollow">浙ICP备 15005796号-2</a> &nbsp;
            <a target="_blank" rel="nofollow">浙公网安备 33010602002000号</a>
        </div>
    </div>
</div>
<script src="<%=path%>/asset/js/jquery.js"></script>
<script src="<%=path%>/asset/js/articleList.js"></script>
</body>
</html>
