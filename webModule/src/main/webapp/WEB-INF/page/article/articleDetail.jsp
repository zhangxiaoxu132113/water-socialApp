<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 2017/4/3
  Time: 下午4:47
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
    <title>${requestScope.article.title}</title>
    <link rel="stylesheet" href="<%=path%>/asset/css/article.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/mw-moon.css">
    <style>

    </style>
    <script src="<%=path%>/asset/js/jquery.js"></script>
</head>
<body>
<div id="container">
    <div id="container-inner">
        <div id="header">
            <div id="header-inner">
                <div class="header-nav">
                    <div class="header-nav-inner">
                        <ul>
                            <li><a href="<%=path%>/">首页</a></li>
                            <li><a href="<%=path%>/blog">文档库</a></li>
                            <li><a href="<%=path%>/new">资讯</a></li>
                            <li><a href="<%=path%>/course">IT教程</a></li>
                            <li><a>知识库</a></li>
                            <li>经验</li>
                            <li>兴趣&生活</li>
                        </ul>
                    </div>
                </div>
                <div class="header-user">
                    <div class="header-user-inner">
                        <ul>
                            <li><a href="/login">登录</a></li>
                            <li><a href="/user/register">注册</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="middle">
            <div class="middel-inner clearfix">
                <div class="logo">
                    <p><img src="<%=path%>/asset/content/logo.png" class="logo-icon"></p>
                </div>
                <div class="search">
                    <div class="search-inner clearfix">
                        <h4>文章搜索</h4>
                        <div class="search-input">
                            <input type="text" placeholder="Java 教程, Mysql 教程">
                        </div>
                        <div class="search-btn">
                            <input type="submit"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="nav" style="margin-top: 1px" class="clearfix">
            <div id="nav-inner">
                <ul class="clearfix">
                    <li style="color:#fff">全部文库分类</li>
                    <c:forEach items="${requestScope.categoryDtos}" var="category">
                        <li><a href="<%=path%>/blog/${category.name}">${category.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div id="top-header">
            <div id="top-header-inner">
                <div class="header-left">
                    <div class="breader">
                        <span>全部分类</span> > <span>${requestScope.category.parent.name}</span> > <span>${requestScope.category.name}</span>
                    </div>
                    <div class="title">${requestScope.article.title}</div>
                    <span class="relase">2017-07-26 15:53:19 发布</span>
                    <span class="tags">
                        <c:forEach items="${requestScope.article.tagList}" var="tag">
                            <span class="tag">${tag.name}</span>
                        </c:forEach>
                    </span>
                </div>
                <div class="header-right">

                </div>
            </div>
        </div>
        <div id="main-body">
            <div id="main-body-inner">
                <div class="main-body-left">
                    <div class="content">
                        ${requestScope.article.content}
                        <jsp:include page="../common/shareToolBar.jsp"/>
                        <div class="tags">
                            <span>标签：</span>
                            <c:forEach items="${requestScope.article.tagList}" var="tag">
                                <span>${tag.name}</span>
                            </c:forEach>
                        </div>
                        <div class="voted">
                            <div class="voted_up">
                                <span>顶</span>
                                <span class="voted_up_value">0</span>
                            </div>
                            <div class="voted_down">
                                <span>踩</span>
                                <span class="voted_down_value">0</span>
                            </div>
                        </div>
                    </div>
                    <%--相关文章--%>
                    <div class="about-articles">
                        <a href="" style="position: absolute;right: 20px;top: 25px">查看更多</a>
                        <h3>相关文章</h3>
                        <ul class="clearfix">
                            <c:forEach items="${requestScope.relatedArticles}" var="article">
                                <li><span class="dot"></span><a href="<%=path%>/article/detail/${article.id}.html">${article.title}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="main-body-right">
                    <div class="bdsharebuttonbox">
                        <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间">QQ空间</a>
                        <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博">新浪微博</a>
                        <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博">腾讯微博</a>
                        <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信">微信</a>
                    </div>

                    <div class="about-course">
                        <h3>相关教程</h3>
                        <ul>
                            <c:choose>
                                <c:when test="${requestScope.recommendCourses != null}">
                                    <c:forEach items="${requestScope.recommendCourses}" var="course">
                                        <li><span class="dot"></span><a href="<%=path%>/course/${course.name}">${course.name}</a></li>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <li>暂无内容</li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                    <div class="about-base">
                        <h3>热门知识库</h3>
                        <ul>
                            <li>
                                <div class="base-img">
                                    <a href=""><img src="<%=path%>/asset/content/javase.jpg" alt=""></a>
                                </div>
                                <div class="base-desc">
                                    <div class="base-name">Java EE 知识库</div>
                                    <div class="base-attendtion">
                                        <span>2323</span> 关注 | <span>1234</span> 收录
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="base-img">
                                    <a href=""><img src="<%=path%>/asset/content/regong.jpg" alt=""></a>
                                </div>
                                <div class="base-desc">
                                    <div class="base-name">人工智能</div>
                                    <div class="base-attendtion">
                                        <span>2323</span> 关注 | <span>1234</span> 收录
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="base-img">
                                    <a href=""><img src="<%=path%>/asset/content/python.jpg" alt=""></a>
                                </div>
                                <div class="base-desc">
                                    <div class="base-name">Python</div>
                                    <div class="base-attendtion">
                                        <span>2323</span> 关注 | <span>1234</span> 收录
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="base-img">
                                    <a href=""><img src="<%=path%>/asset/content/react.jpg" alt=""></a>
                                </div>
                                <div class="base-desc">
                                    <div class="base-name">React 教程</div>
                                    <div class="base-attendtion">
                                        <span>2323</span> 关注 | <span>1234</span> 收录
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="baidu_ad" style="background: red;height: 100px">

                    </div>
                </div>
            </div>


        </div>
        <%--<div id="main-body">--%>
            <%--<div class="article-header-info" style="background:#32353e;height: 86px;">--%>
                <%--<div class="article-header-info-inner" style="margin: 0 auto;width: 900px;position: relative">--%>
                    <%--<a style="padding:10px 0 5px;display: block" class="title">${requestScope.article.title}</a>--%>

                    <%--<div class="tablist">--%>
                        <%--<span class="tab-label">云计算</span>--%>
                        <%--<span class="tab-label">HBase</span>--%>
                    <%--</div>--%>
                    <%--<div class="pviews" style="color:#8a99a4;font-size:14px;position: absolute;right: 0;bottom: 0;">--%>
                        <%--阅读量<span>1433</span></div>--%>
                <%--</div>--%>

            <%--</div>--%>
            <%--<div class="summary" style="background:#eee;padding:10px 0">--%>
                <%--<div class="summary-inner" style="margin: 0 auto;width: 900px;">--%>
                    <%--<div class="summary-content"--%>
                         <%--style="width: 60%;display: inline-block;vertical-align: top;line-height: 1.5em">--%>
                        <%--<h4 style="font-weight: 500;font-size: 22px;padding-bottom: 1em;">简介</h4>--%>

                        <%--<p>${requestScope.article.description}</p>--%>
                    <%--</div>--%>
                    <%--<!--<div style="width: 34%;display: inline-block;padding:0 15px 0;box-sizing: border-box">-->--%>
                    <%--<!--<img src="img/baidulianmeng.png" alt="" style="width: 100%">-->--%>
                    <%--<!--</div>-->--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="content" style="margin: 0 auto;width: 900px;padding-top: 15px;">--%>
                <%--${article.content}--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="about-article" style="width: 900px;margin: 0 auto;">--%>
            <%--<h4>相关文章推荐</h4>--%>
        <style>
            #footer {
                padding-top: 3em;
                background: #f9fafc;
            }
            #footer p {
                padding-top: 0.5em;
                text-align: center;
            }
            #footer p a {
                padding-right: 10px;
                padding-left: 10px;
                border-right: 1px solid #9c9693;
            }
            #footer p a:last-child {
                border-right: 0;
            }
        </style>
        <div id="footer">
            <p>
                <a href="">广告服务</a>
                <a href="">联系我们</a>
                <a href="">友情链接</a>
                <a href="">版权纠纷</a>
            </p>
            <p>© 2003-2017 ITeye.com. [ 京ICP证070598号 京公网安备11010502027441 ]</p>
            <p>北京创新乐知信息技术有限公司 版权所有</p>
        </div>
    </div>
    <input type="hidden" id="article_id" name="" value="${requestScope.article.id}">
</div>

<script src="<%=path%>/asset/js/article/articleDetail.js"></script>

</body>
</html>
