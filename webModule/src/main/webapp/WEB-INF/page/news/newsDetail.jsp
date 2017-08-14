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
        .art {
            position: relative;
            width: 760px;
            overflow: hidden;
            background: #fff;
            margin-bottom: 20px;
            padding-bottom: 30px;
        }
        .art .title {
            font-size: 28px;
            margin: 0 auto 20px;
            padding-top: 30px;
            text-align: center;
            width: 710px;
        }
        .art .content {
            width: 690px;
            font-size: 16px;
            line-height: 30px;
            zoom: 1;
            overflow: hidden;
            margin: 20px auto 0;
        }
        .art-list .hd {
            text-indent: 10px;
            height: 20px;
            font-size: 18px;
            line-height: 20px;
            color: #0077dd;
            /* margin-bottom: 20px; */
            margin-top: 20px;
            padding-left: 0.5em;
        }
        .zuixin {
            margin-top: 20px;
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
                    <div class="art">
                        <h3 class="title">外媒：无人驾驶客机可能在2025年就会出现</h3>
                        <p></p>
                        <div class="content">
                            <div class="editor-viewer text clear">
                                <p>EMQ R2.3-beta.2 版本正式发布！该版本新增HTTP管理API，支持集群粒度的连接与会话管理，集群节点的性能指标监控，并支持节点、插件配置通过命令行热更新。</p><p>支持配置热更新的插件包括:</p><ul class=" list-paddingleft-2"><li><p>emq-stomp</p></li><li><p>emq-coap</p></li><li><p>emq-sn</p></li><li><p>emq-lwm2m</p></li><li><p>emq-dashboard</p></li><li><p>emq-retainer</p></li><li><p>emq-recon</p></li><li><p>emq-web-hook</p></li><li><p>emq-auth-jwt</p></li><li><p>emq-auth-http</p></li><li><p>emq-auth-mongo</p></li><li><p>emq-auth-mysql</p></li><li><p>emq-auth-pgsql</p></li><li><p>emq-auth-redis</p></li></ul><h4>功能与改进</h4><ol class=" list-paddingleft-2"><li><p>新增集群粒度的HTTP管理API</p></li><li><p>HTTP Publish接口支持ClientId参数</p></li><li><p>支持配置Keepalive超时检测周期</p></li><li><p>删除连接、会话的默认fullsweep_after参数，以降低在高消息吞吐下的CPU使用率</p></li><li><p>支持通过ClientId认证HTTP Publish请求</p></li></ol><h4>emq-sn 插件 (emq-sn#49)</h4><ol class=" list-paddingleft-2"><li><p>Support CONNECT message in connected/wait_for_will_topic/wait_for_will_msg states.</p></li><li><p>Clean registered topic for a restarted client.</p></li><li><p>Bug fix of not clearing buffered PUBLISH messages received during asleep state as those messages are sent to client when client wakes up.</p></li></ol><h4>emq-auth-ldap Plugin (emq-auth-ldap#21)</h4><p>Improve the design LDAP authentication.</p><h4>emq-coap Plugin (emq-coap#51)</h4><p>Support CoAP PubSub Specification (<a data-cke-saved-href="https://www.ietf.org/id/draft-ietf-core-coap-pubsub-02.txt" href="https://www.ietf.org/id/draft-ietf-core-coap-pubsub-02.txt">https://www.ietf.org/id/draft-ietf-core-coap-pubsub-02.txt</a>)</p>


                            </div>
                        </div>
                    </div>
                    <div class="art-list">
                        <div class="hd">
                            <i></i>
                            相关文章
                        </div>
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
                    <div class="box remen">
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
                    <div class="box zuixin">
                        <div class="hd">
                            <i></i>
                            最新资讯
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
