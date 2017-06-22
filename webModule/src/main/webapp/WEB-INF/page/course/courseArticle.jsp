<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="container">
    <div id="container-inner">
        <jsp:include page="../common/header-v1.jsp"/>
        <jsp:include page="../common/category-nav.jsp"/>
        <div class="main-content">
            <div class="main-content-inner">

                <div class="main-left">
                    <div class="main-left-inner">
                        <%--教程目录--%>
                        <div class="course-catalog">
                            <ul class="catalog-list">
                                <li class="item"></li>
                                <li class="item"></li>
                                <li class="item"></li>
                                <li class="item"></li>
                                <li class="item"></li>
                                <li class="item"></li>
                                <li class="item"></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="main-right">
                    <div class="main-right-inner">
                        <%--文章内容--%>
                        <div class="article-container">
                            <div class="article-title"></div>
                            <div class="article-content"></div>
                        </div>
                        <%--相关文章--%>
                        <div class="relateive-article">
                            <h3>相关文章</h3>
                            <ul>
                                <li><a href=""></a></li>
                                <li><a href=""></a></li>
                                <li><a href=""></a></li>
                                <li><a href=""></a></li>
                                <li><a href=""></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
