<%@ page import="com.water.utils.common.Constants" %><%--
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
        .crumb {
            margin-bottom: 0.5em;
            margin-top: -1em;
            color:#989898;
        }
        .crumb a {
            text-decoration: none;
            font-size: 15px;
            color:#989898;
        }
        .remen {
            margin-top: 1em;
        }
        .art-info {
            height: 34px;
            text-align: center;
            color: #989898;
        }
        .content-info {
            margin-bottom: 24px;
            
        }
        .content-info span {
            margin-right: 0.5em;
        }
        .num-active {
            color: #ff8800!important;
        }
        .qrcode {
            margin-top: 1em;
        }
    </style>
    <link rel="stylesheet" href="<%=path%>/asset/css/new-index.css">
    <link rel="stylesheet" href="<%=path%>/asset/css/font/iconfont/iconfont.css">
    <script src="<%=path%>/asset/js/jquery.js"></script>
    <jsp:include page="../common/baidu_statistics_code.jsp"/>
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
                            <li>知识库</li>
                            <li>经验</li>
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
                        <li><a href="<%=path%>/new">最新资讯</a></li>
                        <li><a href="<%=path%>/new?type=<%=Constants.ARTICLE_MODULE.TOU_TIAO.getIndex()%>">头条</a></li>
                        <li>
                            <a href="<%=path%>/new?type=<%=Constants.ARTICLE_MODULE.RUANJIAN_GENGXIN.getIndex()%>">软件更新</a>
                        </li>
                        <li><a href="<%=path%>/new?type=<%=Constants.ARTICLE_MODULE.IT_HANGYE.getIndex()%>">IT行业</a>
                        </li>
                        <li><a href="">业界资讯</a></li>
                        <li><a href="">业界资讯</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="main-content"  class="clearfix">
            <div id="main-content-inner">
                <div class="left-body">
                    <div class="crumb">
                        <a href="">首页</a> >
                        <a href="">头条资讯</a> >
                        <a href="">${requestScope.article.title}</a>
                    </div>
                    <div class="art">
                        <h3 class="title">${requestScope.article.title}</h3>
                        <div class="art-info">
                            <div class="content-info">
                                <span class="public_time">2017-08-12 09:34</span>
                                <span><i class="iconfont">&#xe739;</i></span>
                                <span class="view_count"><i class="iconfont">&#xe65e;</i> 54</span>
                            </div>
                        </div>
                        <div class="content">
                            <div class="editor-viewer text clear">${requestScope.article.content}</div>
                            首先是Android SVP Hiroshi Lockheimer的推文，他在7月份发贴了一张Orangina菜单照片，并且附带“#nocomment”的字样。

                            另外，The Verge今天早些时候收到了Best Buy的内部客户培训系统截图，其中也有Android 8.0 Orangina的字样，也许百思买知道我们不知道的东西，而Android O真的是Android Orangina。

                            尽管如此，它可能不会被称为Orangina。首先，Orangina，而一个美味可口的橙色饮料，不是一个甜点食物，这将粉碎Android命名方案。最后，Orangina是Pepper Snapple集团拥有的专有饮料，如果Google愿意与公司实体取得授权使用名称，类似于Android KitKat，那么逻辑上它会采用Oreo奥立奥，它是人们广泛认认可和喜爱的甜点食物。

                            Android O可能命名为Orangina 8月底发布

                            Android O可能命名为Orangina 8月底发布


                        </div>
                        <style>
                            .bdsharebuttonbox {
                                background: rgba(246, 246, 246, 0.68);
                                margin: 20px auto 0;
                                padding: 10px;
                                width: 100%;
                                box-sizing: border-box;
                                width: 690px;
                            }
                            .bdsharebuttonbox a:link {
                                text-decoration: none;
                            }
                        </style>
                        <div class="bdsharebuttonbox">
                            <a href="#" class="bds_more" data-cmd="more">分享到：</a>
                            <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间">QQ空间</a>
                            <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博">新浪微博</a>
                            <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博">腾讯微博</a>
                            <a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网">人人网</a>
                            <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信">微信</a>
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
                                <i class="lpic"><a href=""><img width="200" height="150" src="http://images.csdn.net/20170804/默认标题_自定义px_2017.08.04.jpg" alt=""></a></i>
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
                    <div class="box qrcode clearfix">
                        <img src="http://image.39.net/wap/ask/images/wx_rk_13.jpg" width="60" height="60"  alt="" style="float: left;margin-right: 1em">
                        <span style="font-size: 16px;padding-top:1em;color:#0b90dc">查看更多资讯内容<br/>请关注uubook微信公众号</span>
                    </div>
                    <div class="box remen">
                        <div class="hd">
                            <i></i>
                            热门资讯
                        </div>
                        <div class="bd">
                            <ol>
                                <li class="clearfix">
                                    <img src="http://images.csdn.net/20170817/567.jpg" width="120" height="90" alt="" style="float: left;margin-right: 1em"><em class="num-active">1</em><a href="">${requestScope.hotArticleList[0].title}</a>
                                </li>
                                <c:forEach items="${requestScope.hotArticleList}" begin="1" var="article" varStatus="status">
                                    <li><a href="<%=path%>/new/detail/${article.id}.html"><em <c:if test="${status.index == 1 || status.index == 2}">class="num-active"</c:if>>${status.index + 1}</em><span>${article.title}</span></a></li>
                                </c:forEach>
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
                                <c:forEach items="${requestScope.newestArticleList}" var="article" varStatus="status">
                                    <li><a href="<%=path%>/new/detail/${article.id}.html"><em <c:if test="${status.index == 0 || status.index == 1 || status.index == 2}">class="num-active"</c:if>>${status.index + 1}</em><span>${article.title}</span></a></li>
                                </c:forEach>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
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

</html>
