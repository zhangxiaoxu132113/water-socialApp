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
                                        <dt><a href="<%=path%>/new/detail/23.html">外媒：无人驾驶客机可能在2025年就会出现</a></dt>
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
