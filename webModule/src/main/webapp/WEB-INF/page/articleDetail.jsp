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
    <title>Title</title>
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
</head>
<body>
<div id="container">
    <div id="container-inner">
        <div id="header" style="height: 40px;background: #48525e;position: fixed;top: 0;left: 0;width: 100%;margin-bottom:40px">
            <div id="header-inner">
                <div id="logo" style="line-height: 40px;float: left;font-size: 16px;color: #ccd6dd;margin-left:20px;">知识君</div>
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
                    <div class="summary-content" style="width: 60%;display: inline-block;vertical-align: top;line-height: 1.5em">
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
        <div class="about-article" style="width: 900px;margin: 0 auto;">
            <h4>相关文章推荐</h4>
            <ul>
                <li>GDC 2017 争霸赛，微软发布 Windows10 MR 头显开发者套件</li>
                <li>nunuStudio：一款支持 3D 及 VR 应用的 JS IDE</li>
                <li>【CSDN AI 周刊】第11期 | 周志华提出深度森林 引发持续热议</li>
            </ul>
        </div>
        <div id="footer">

        </div>
    </div>
</div>
</body>
</html>
