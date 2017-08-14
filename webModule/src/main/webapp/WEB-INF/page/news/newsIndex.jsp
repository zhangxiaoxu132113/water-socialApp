<%--
  Created by IntelliJ IDEA.
  User: zhangmiaojie
  Date: 2017/6/21
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
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
        #container {
            background: #f6f6f6;
        }
        #nav-wrap {
            width: 100%;
            z-index: 999;
            height: 73px;
            border-bottom: 1px solid #e5e5e5;
            background: #fff;
        }
        #nav-wrap .nav {
            overflow: visible;
            height: 73px;
            width: 1110px;
            font-size: 20px;
            font-weight: 400;
            padding-bottom: 5px;
            margin: 0 auto;
        }
        #logo {
            float: left;
            width: 178px;
            height: 49px;
            margin-top: 15px;
        }
        .logo-icon {
            height: 44px;
            width: auto;
            vertical-align: middle;
            /*padding-left: 2em;*/
        }
        .nav-inner {
            overflow: visible;
            float: left;
            margin-left: 40px;
        }
        .nav-inner li {
            float: left;
            display: inline-block;
            height: 73px;
            line-height: 73px;
            text-align: center;
            position: relative;
            z-index: 1;
            width: 111px;
        }
        .nav-inner li a {
            display: block;
            color: #333333;
            font-size: 18px;
            text-align: center;
            height: 100%;
            z-index: 9;
            text-decoration: none;
            transition-duration: .3s;
            -webkit-transition: .3s;
        }
        #main-content {
            background:#f6f6f6 ;
        }
        #main-content #main-content-inner {
            padding-top:10px;
            width: 1120px;
            clear: both;
            margin: 0 auto 20px;
            padding: 0;
            position: relative;
        }
        .left-body {
            width: 760px;
            float: left;
        }
        .left-body .art-list {
            position: relative;
            width: 760px;
            overflow: hidden;
            background: #fff;
        }
        .left-body .art-list ul li {
            width: 720px;
            height: auto;
            display: block;
            overflow: hidden;
            padding: 20px 20px 0;
        }
        .lpic {
            float: left;
            width: 200px;
            height: 169px;
            padding-right: 20px;
            position: relative;
            border-bottom: dashed 1px #e5e5e5;
        }
        .left-body .art-list ul li dl {
            float: left;
            width: 500px;
            height: 169px;
            position: relative;
            border-bottom: dashed 1px #e5e5e5;
        }
        .left-body .art-list ul li dl dt{
            width: 100%;
            height: 26px;
            overflow: hidden;
            font-size: 20px;
            font-weight: normal;
        }
        .left-body .art-list ul li dl dt a {
            text-decoration: none;
            color: #333;
        }
        .left-body .art-list ul li dl dd .desc{
            color: #989898;
            margin: 15px 0;
            display: block;
            width: 100%;
            font-size: 14px;
            line-height: 22px;
            overflow: hidden;
            height: 75px;
        }
        .left-body .art-list ul li dl dd .info{

            height: 19px;
            float: left;
        }
        .left-body .art-list ul li dl dd .info .channel a{
            color:#0077dd;
            text-decoration: none;
        }
        .right-body {
            width: 340px;
            float: right;
        }
        .right-body .box {
            padding: 20px;
            height: auto;
            background: #fff;
        }
        .right-body .box .hd {
            text-indent: 10px;
            height: 20px;
            font-size: 18px;
            line-height: 20px;
            color: #0077dd;
            margin-bottom: 20px;
        }
        .right-body .box .bd {
            height: auto;
        }
        .right-body .box .bd ol li {
            height: auto;
            padding: 0 0 0 26px;
            position: relative;
            margin-bottom: 10px;
        }
        .right-body .box .bd ol li em {
            font: italic 18px/20px "Arial";
            color: #999999;
            position: absolute;
            top: 4px;
            left: 0px;
        }
        .right-body .box .bd ol li a {
            color: #000;
            text-decoration: none;
        }
        .right-body .box .bd ol li span {
            font-size: 14px;
            line-height: 24px;
            color: #000;
            height: 24px;
            overflow: hidden;
            display: inline-block;
        }
    </style>
    <link rel="stylesheet" href="<%=path%>/asset/css/new-index.css">
</head>

<body>
    <div id="container">
        <div id="container-inner">
            <div id="header">
                <div id="header-inner">
                    <div class="header-nav">
                        <div class="header-nav-inner">
                            <ul>
                                <li>首页</li>
                                <li>文档库</li>
                                <li>资讯</li>
                                <li>IT教程</li>
                                <li>知识库</li>
                                <li>知识库</li>
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
            <div id="nav-wrap">
                <div class="nav clearfix">
                    <div id="logo">
                        <a href=""><img src="<%=path%>/asset/content/logo.png" class="logo-icon"></a>
                    </div>
                    <div id="jnav">
                        <ul class="nav-inner">
                            <li><a href="">最新资讯</a></li>
                            <li><a href="">业界资讯</a></li>
                            <li><a href="">业界资讯</a></li>
                            <li><a href="">业界资讯</a></li>
                            <li><a href="">业界资讯</a></li>
                            <li><a href="">业界资讯</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="main-content"  class="clearfix">
                <div id="main-content-inner">
                    <div class="left-body">
                        <div class="art-list">
                            <ul>
                                <li>
                                    <i class="lpic"><a href=""><img width="200" height="150" src="http://img.ads.csdn.net/2017/201706081014067064.jpg" alt=""></a></i>
                                    <dl>
                                        <dt><a href="">外媒：无人驾驶客机可能在2025年就会出现</a></dt>
                                        <dd>
                                            <span class="desc">据俄罗斯《生意人报》援引瑞士联合银行集团（UBS）分析师的预测报道，无人驾驶客机可能很快就会成为现实。该报称，第一批地面遥控客机可能在2025年就会出现。...</span>
                                            <p class="info">
                                                <span class="channel"><a href="">数码传奇</a></span>
                                                <span class="date">|&nbsp;&nbsp;2017-08-14 19:15</span>
                                            </p>
                                        </dd>

                                    </dl>
                                </li>
                                <li>
                                    <i class="lpic"><a href=""><img width="200" height="150" src="http://img.ads.csdn.net/2017/201707261739016778.jpg" alt=""></a></i>
                                    <dl>
                                        <dt><a href="">外媒：无人驾驶客机可能在2025年就会出现</a></dt>
                                        <dd>
                                            <span class="desc">据俄罗斯《生意人报》援引瑞士联合银行集团（UBS）分析师的预测报道，无人驾驶客机可能很快就会成为现实。该报称，第一批地面遥控客机可能在2025年就会出现。...</span>
                                            <p class="info">
                                                <span class="channel"><a href="">数码传奇</a></span>
                                                <span class="date">|&nbsp;&nbsp;2017-08-14 19:15</span>
                                            </p>
                                        </dd>

                                    </dl>
                                </li>
                                <li>
                                    <i class="lpic"><a href=""><img width="200" height="150" src="http://img0.pconline.com.cn/pconline/1708/14/g_9779064_1502709286372.jpg" alt=""></a></i>
                                    <dl>
                                        <dt><a href="">外媒：无人驾驶客机可能在2025年就会出现</a></dt>
                                        <dd>
                                            <span class="desc">据俄罗斯《生意人报》援引瑞士联合银行集团（UBS）分析师的预测报道，无人驾驶客机可能很快就会成为现实。该报称，第一批地面遥控客机可能在2025年就会出现。...</span>
                                            <p class="info">
                                                <span class="channel"><a href="">数码传奇</a></span>
                                                <span class="date">|&nbsp;&nbsp;2017-08-14 19:15</span>
                                            </p>
                                        </dd>

                                    </dl>
                                </li>
                                <li>
                                    <i class="lpic"><a href=""><img width="200" height="150" src="http://img0.pconline.com.cn/pconline/1708/14/g_9779064_1502709286372.jpg" alt=""></a></i>
                                    <dl>
                                        <dt><a href="">外媒：无人驾驶客机可能在2025年就会出现</a></dt>
                                        <dd>
                                            <span class="desc">据俄罗斯《生意人报》援引瑞士联合银行集团（UBS）分析师的预测报道，无人驾驶客机可能很快就会成为现实。该报称，第一批地面遥控客机可能在2025年就会出现。...</span>
                                            <p class="info">
                                                <span class="channel"><a href="">数码传奇</a></span>
                                                <span class="date">|&nbsp;&nbsp;2017-08-14 19:15</span>
                                            </p>
                                        </dd>

                                    </dl>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="right-body">
                        <div class="box">
                            <div class="hd">
                                <i></i>
                                热门资讯
                            </div>
                            <div class="bd">
                                <ol>
                                    <li><a href=""><em>1</em><span>不知妻美刘强东！章泽天罕见晒照 深V上装依旧显清纯</span></a></li>
                                    <li><a href=""><em>2</em><span>亚马逊改良语音助手Alexa：或带来全新体验</span></a></li>
                                    <li><a href=""><em>3</em><span>AMD 16核旗舰CPU上市！其散热装置亮瞎眼！</span></a></li>
                                    <li><a href=""><em>4</em><span>索尼PS4 Pro主机性能再次升级：显卡给力！</span></a></li>
                                    <li><a href=""><em>5</em><span>特斯拉成功发行18亿美元债券：超募约4.5倍</span></a></li>
                                    <li><a href=""><em>6</em><span>技术宅打造动漫美少女头像创建工具 AI帮你画萌妹子</span></a></li>
                                    <li><a href=""><em>7</em><span>Moto Mods手柄进行开售：售价不到80美元！</span></a></li>
                                    <li><a href=""><em>8</em><span>奶茶妹妹晒高难度美体健身操：腰腹力量柔韧性惊人</span></a></li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
