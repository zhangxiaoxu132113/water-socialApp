/**
 * Created by mrwater on 2017/10/2.
 */
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
    "selectShare": {"bdContainerClass": null, "bdSelectMiniList": ["qzone", "tsina", "weixin", "tqq", "renren"]}
};
with (document)0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];

$(document).ready(function () {
    // 文章投票（顶）
    $('.voted_up').click(function () {
        vote(1);
    });

    $('.voted_down').click(function () {
        vote(0);
    });

    /**
     * 文章投票
     * @param attitude 0-反对票 | 1-肯定票
     */
    var vote = function (attitude) {
        var article_id = $('#article_id').val();
        $.ajax({
            url: '/article/voted',
            type: 'POST', //GET
            async: true,  //或false,是否异步
            data: {
                articleId: article_id,
                attitude: attitude
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == 0) {//操作成功
                    var voteUpValue = $('.voted_up_value').html();
                    var voteDownValue = $('.voted_down_value').html();
                    if (attitude == 1) {
                        voteUpValue++;
                        if (voteDownValue != 0) voteDownValue--;
                    } else if (attitude == 0) {
                        voteDownValue++;
                        if (voteUpValue != 0) voteUpValue--;
                    }
                    $('.voted_up_value').html(voteUpValue);
                    $('.voted_down_value').html(voteDownValue);
                } else {
                    alert(data.msg);
                }
            },
            error: function (xhr, textStatus) {
                alert("服务器请求异常！");
            }
        });
    };

    var height = $('#header').height() + $('#middle').height() + $('#nav').height() +
        $('#top-header').height() + $('#top-header').height() + $('.bdsharebuttonbox').height() +
        $('.about-course').height() + $('.about-base').height() + 80;

    $(window).scroll(function () {
        if ($(window).scrollTop() >= height) {
            $('.vedio-course').addClass('nav-fixed');
        } else {
            $('.vedio-course').removeClass("nav-fixed");
        }
    });
});
