<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <jsp:include page="../common/common.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="<%=path%>/asset/css/mw-moon.css">
</head>
<body>
<!-- slider bar  -->
<div class="slider-bar-left">
    <div class="slider-bar-inner">
        <div>
            <!-- operator slider  -->
            <div class="tagheader"><a>全部(140)<i class="iconfont">&#xe6b9;</i></a></div>
            <div class="tag-content">
                <ul class="taglist">
                    <c:forEach items="${requestScope.catalogTitleList}" var="catalog" varStatus="cStatus">
                        <li class="active"><a><span class="number">${cStatus.index+1}</span> <span class="title">${catalog.title}</span></a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>


</div>
<div class="slider-bar-right">
    <div class="slider-bar-inner">
        <!-- operator slider  -->
        <div></div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>

</div>
<!-- page container -->
<div id="doc">
    <!-- header content -->
    <header class="header">
        <div class="header-inner">
            <!-- logo -->
            <!--<h1 class="logo"><a>MrWater<sup>mood</sup></a></h1>-->
            <h1 class="logo"><a>Mr Water<sup>mood</sup></a></h1>
            <!-- tools bar -->
            <div class="main-nav">
                <div class="nav-inner">
                    <div class="nav-controler-wrap">
                        <ul class="nav-controler-wrap-items">
                            <li class="prev"><a href="#" title="上一页"><i class="iconfont">&#xe650;</i></a></li>
                            <li class="shuffle"><a href="#" title="随机"><i class="iconfont">&#xe69b;</i></a></li>
                            <li class="next"><a href="#" title="下一页"><i class="iconfont">&#xe651;</i></a></li>
                        </ul>
                    </div>
                    <div class="nav-feature-wrap">
                        <ul>
                            <li><a class="directory-btn" href="#" title=""><i class="iconfont">&#xe790;</i></a></li>
                            <li><a class="write-btn" href="#" title=""><i class="iconfont">&#xe6b0;</i></a></li>
                            <li><a class="message-btn" href="#" title=""><i class="iconfont">&#xe6ad;</i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- tools bar end -->
        </div>
    </header>
    <!-- header end -->

    <!-- main content -->
    <div class="page-container">
        <div class="app-content">
            <div class="Grid Grid-withGutter">
                <div class="Grid-cell u-lg-size3of5">
                    <div class="content-detail">
                        <!--<img src="../asset/img/login/mw-login-bg01.jpg" class="mr-img-responsive">-->
                        <h2>
                            <span class=""><span>No.</span></span>65
                        </h2>

                        <p class="face-text">
                            <!--Hello!My name is Zhang Miaojie.I like drawing and ...let me think ! oh No,I don't kown what i like.-->
                            With Herb Lubalin as editor and designer, ITC began publishing “U&lc” in 1973 to market the
                            company’s typefaces.

                        </p>
                        <p class="face-text">
                            <!--Hello!My name is Zhang Miaojie.I like drawing and ...let me think ! oh No,I don't kown what i like.-->
                            With Herb Lubalin as editor and designer, ITC began publishing “U&lc” in 1973 to market the
                            company’s typefaces.

                        </p>
                        <p class="face-text">
                            <!--Hello!My name is Zhang Miaojie.I like drawing and ...let me think ! oh No,I don't kown what i like.-->
                            With Herb Lubalin as editor and designer, ITC began publishing “U&lc” in 1973 to market the
                            company’s typefaces.

                        </p>
                        <p class="face-text">
                            <!--Hello!My name is Zhang Miaojie.I like drawing and ...let me think ! oh No,I don't kown what i like.-->
                            With Herb Lubalin as editor and designer, ITC began publishing “U&lc” in 1973 to market the
                            company’s typefaces.

                        </p>
                        <p class="face-text">
                            <!--Hello!My name is Zhang Miaojie.I like drawing and ...let me think ! oh No,I don't kown what i like.-->
                            With Herb Lubalin as editor and designer, ITC began publishing “U&lc” in 1973 to market the
                            company’s typefaces.

                        </p>
                        <p class="face-text">
                            <!--Hello!My name is Zhang Miaojie.I like drawing and ...let me think ! oh No,I don't kown what i like.-->
                            With Herb Lubalin as editor and designer, ITC began publishing “U&lc” in 1973 to market the
                            company’s typefaces.

                        </p>

                        <div class="meta">
                            <ul>
                                <li>
                                    <span class="meta-icon"><i class="iconfont">
                                        &#xe62a;</i></span><span>陆丰市甲子镇元高管区</span>
                                </li>
                                <li>
                                    <span class="meta-icon"><i class="iconfont">&#xe74f;</i></span><span
                                        style="font-family: sans-serif;">2016-06-30 : 17:10:10</span>
                                </li>
                            </ul>

                        </div>
                    </div>

                </div>
                <div class="Grid-cell u-lg-size2of5">
                    <div class="media-content">
                        <img src="/asset/img/commons/user_image.jpg" class="mr-img-responsive">
                        <!--<img src="../asset/tmp/liliqun.jpg" class="mr-img-responsive">-->
                    </div>
                </div>
            </div>

        </div>

    </div>
    <!-- 内容主体 end -->
    <footer>
        <div class="footer-inner">
            <div class="footer-left">
                <p>©2016 Mr Water ™ Images are ™© of their respective owners.</p>
            </div>
            <div class="footer-right">
                <p>know more</p>
            </div>
        </div>
        <div style="clear: both"></div>
    </footer>
    <!-- 发表个人心情的模钛窗口-->
    <jsp:include page="../common/sendFrame.jsp"></jsp:include>
</div>
<!--<div id="map" style="width: 800px;height: 500px;z-index: 10000">-->

</div>
<script src="/plugs/mrwater/mw-upload.js"></script>
<script src="/asset/js/mw/mw-moon.js"></script>
</body>
</html>

