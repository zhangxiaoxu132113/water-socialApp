<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="<%=basePath%>/asset/img/bitbug_favicon.ico">
    <title>${requestScope.article.title}</title>
    <meta name="description" content="${requestScope.article.description}">
    <meta name="keywords" content="<c:forEach items="${requestScope.article.tagList}" var="tag">${tag.name},</c:forEach>">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/article.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/css/mw-moon.css">
    <style>
        .nav-fixed {
            position: fixed;
            top: 0;
            z-index: 20999;
            background: #fff;
            width: 301px;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="container-inner">
        <div id="header">
            <div id="header-inner">
                <div class="header-nav">
                    <div class="header-nav-inner">
                        <ul>
                            <li><a href="<%=basePath%>/">首页</a></li>
                            <li><a href="<%=basePath%>/blog">文档库</a></li>
                            <li><a href="<%=basePath%>/new">资讯</a></li>
                            <li><a href="<%=basePath%>/course">IT教程</a></li>
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
                    <h2>编程无忧网</h2>
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
                        <li><a href="<%=basePath%>/blog/tag/${category.name}">${category.name}</a></li>
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
                    <span class="relase">发布: ${requestScope.article.createOnStr}</span>
                    <span class="relase">阅读量: ${requestScope.article.viewHits}</span>
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
                            <c:forEach items="${requestScope.article.relatedArticles}" var="article">
                                <li><span class="dot"></span><a href="<%=basePath%>/article/detail/${article.id}.html">${article.title}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <%--猜你喜欢--%>
                    <div class="guess-like">
                        <h3 href="">猜你喜欢</h3>
                        <ul class="clearfix">
                            <li><img src="http://askimg.39.net/jingyan/20151025/61787.jpg" alt="" width="166" height="110"><span>感冒了怎么般</span></li>
                            <li><img src="http://images.csdn.net/20170930/1.png" alt="" width="166" height="110"><span>IBM Application Discovery 产品介绍</span></li>
                            <li><img src="http://images.csdn.net/20170930/20170924143839-17da39c6-me_副本.jpg" alt="" width="166" height="110"><span>IBM Application Discovery 产品介绍</span></li>
                            <li><img src="http://images.csdn.net/20170330/11.png" alt="" width="166" height="110"><span>随机决策树基本方法和理论探讨</span></li>
                            <li><img src="http://img.ads.csdn.net/2017/201709201440397079.jpg" alt="" width="166" height="110"><span>随机决策树基本方法和理论探讨</span></li>
                            <li><img src="http://images.csdn.net/20170704/1.png" alt="" width="166" height="110"><span>Hbase 设计与开发实战</span></li>
                            <li><img src="http://images.csdn.net/20171002/timg.png" alt="" width="166" height="110"><span>Hbase 设计与开发实战</span></li>
                            <li><img src="http://img.ads.csdn.net/2017/201709181754041012.png" alt="" width="166" height="110"><span>IBM Application Discovery 产品介绍</span></li>
                        </ul>
                    </div>
                </div>

                <%--文章主体右边内容--%>
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
                                        <li><span class="dot"></span><a href="<%=basePath%>/course/${course.name}">${course.name}</a></li>
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
                                    <a href=""><img src="<%=basePath%>/asset/content/javase.jpg" alt=""></a>
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
                                    <a href=""><img src="<%=basePath%>/asset/content/regong.jpg" alt=""></a>
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
                                    <a href=""><img src="<%=basePath%>/asset/content/python.jpg" alt=""></a>
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
                                    <a href=""><img src="<%=basePath%>/asset/content/react.jpg" alt=""></a>
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
                    <div class="vedio-course">
                        <a href="<%=basePath%>ad/videoCourseDetail/${requestScope.videoCourseShopList[0].id}">
                            <img src="${requestScope.videoCourseShopList[0].taobaoPicUrl}"
                                 alt="${requestScope.videoCourseShopList[0].name}">
                        </a>
                    </div>
                </div>
            </div>


        </div>
        <div id="footer">
            <div class="copyright">
                编程无忧 ©  2017 uubook.net. 当前呈现版本 1.02.05<br>
                <a rel="nofollow">粤ICP备17130657号</a> &nbsp;
            </div>
        </div>
    </div>
    <input type="hidden" id="article_id" name="" value="${requestScope.article.id}">
</div>
<script src="<%=basePath%>/asset/js/jquery.js"></script>
<script src="<%=basePath%>/asset/js/article/articleDetail.js"></script>
</body>
</html>
