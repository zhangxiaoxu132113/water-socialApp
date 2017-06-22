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
    <style>
        .title {
            font-size: 22px;
            color: #f5f6f8;
            word-wrap: break-word;
        }

        .tab-label {
            display: inline-block;
            background-color: #545e66;
            font: 1em/1 'microsoft yahei';
            margin: 5px;
            padding: 4px 12px;
            border-radius: 10px;
            cursor: pointer;
            color: #f5f6f8;
            font-size: 14px;
        }
    </style>
    <script src="<%=path%>/asset/js/jquery.js"></script>
</head>
<body>
<div id="container">
    <div id="container-inner">
        <div id="header"
             style="height: 40px;background: #48525e;position: fixed;top: 0;left: 0;width: 100%;margin-bottom:40px">
            <div id="header-inner">
                <div id="logo" style="line-height: 40px;float: left;font-size: 16px;color: #ccd6dd;margin-left:20px;">
                    知识君
                </div>
                <div id="user-info" style="float: right;margin-right: 20px;line-height: 40px">
                    <ul>
                        <li><span class="username"><a href="">Mr Water</a></span></li>
                    </ul>

                </div>
            </div>
        </div>
        <div id="main-body" style="margin-top: 40px">
            <div class="article-header-info" style="background:#32353e;height: 86px;">
                <div class="article-header-info-inner" style="margin: 0 auto;width: 900px;position: relative">
                    <a style="padding:10px 0 5px;display: block" class="title">${requestScope.article.title}</a>

                    <div class="tablist">
                        <span class="tab-label">云计算</span>
                        <span class="tab-label">HBase</span>
                    </div>
                    <div class="pviews" style="color:#8a99a4;font-size:14px;position: absolute;right: 0;bottom: 0;">
                        阅读量<span>1433</span></div>
                </div>

            </div>
            <div class="summary" style="background:#eee;padding:10px 0">
                <div class="summary-inner" style="margin: 0 auto;width: 900px;">
                    <div class="summary-content"
                         style="width: 60%;display: inline-block;vertical-align: top;line-height: 1.5em">
                        <h4 style="font-weight: 500;font-size: 22px;padding-bottom: 1em;">简介</h4>

                        <p>${requestScope.article.description}</p>
                    </div>
                    <!--<div style="width: 34%;display: inline-block;padding:0 15px 0;box-sizing: border-box">-->
                    <!--<img src="img/baidulianmeng.png" alt="" style="width: 100%">-->
                    <!--</div>-->
                </div>
            </div>
            <div class="content" style="margin: 0 auto;width: 900px;padding-top: 15px;">
                ${article.content}
            </div>
        </div>
        <div class="bdsharebuttonbox">
            <style>
                .bdsharebuttonbox a:link {
                    text-decoration: none;
                }
            </style>
            <a href="#" class="bds_more" data-cmd="more">分享到：</a>
            <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间">QQ空间</a>
            <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博">新浪微博</a>
            <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博">腾讯微博</a>
            <a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网">人人网</a>
            <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信">微信</a>
        </div>

        <div class="about-article" style="width: 900px;margin: 0 auto;">
            <h4>相关文章推荐</h4>
            <ul>
                <c:choose>
                    <c:when test="${requestScope.article.relatedArticles != null}">
                        <c:forEach items="${requestScope.article.relatedArticles}" var="article">
                            <li><a href="<%=path%>/article/detail/${article.id}">${article.title}</a></li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <li>暂无内容</li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <div id="footer">

        </div>
    </div>
</div>
<script>
    //全局变量，动态的文章ID
    var ShareId = "";
    //绑定所有分享按钮所在A标签的鼠标移入事件，从而获取动态ID
    $(function () {
        $(".bdsharebuttonbox a").mouseover(function () {
            ShareId = $(this).attr("data-id");
        });
    });

    /*
     * 设置分享的url连接地址
     */
    function SetShareUrl(cmd, config) {
        config.bdUrl = document.URL;
        config.bdText = $('title').text();
        config.bdDesc = "用户将网站内容分享到第三方网站，第三方网站的用户点击专有的分享链接，从第三方网站带来社会化流量";
        config.bdPic = "";

        console.log(config.bdUrl);
        console.log(config.bdText);
        console.log(config.bdDesc);
        return config;
    }

    window._bd_share_config = {
        "common": {
            onBeforeClick: SetShareUrl,
            "bdSnsKey": {},
            "bdMini": "2",
            "bdMiniList": false,
            "bdStyle": "1",
            "bdSize": "16"
        },
        "share": {"bdSize": 16},
        "image": {"viewList": ["qzone", "tsina", "weixin", "tqq", "renren"], "viewText": "分享到：", "viewSize": "16"},
        "selectShare": {"bdContainerClass": null, "bdSelectMiniList": ["qzone", "tsina", "weixin", "tqq", "renren"]}
    };
    with (document)0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
</script>

</body>
</html>
