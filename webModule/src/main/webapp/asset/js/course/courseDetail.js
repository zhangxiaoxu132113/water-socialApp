$(document).ready(function() {
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
});