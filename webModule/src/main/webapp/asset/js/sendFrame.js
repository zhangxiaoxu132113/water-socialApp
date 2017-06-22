/**
 * Created by mrwater on 2017/2/19.
 */
$(document).ready(function () {
    /*关闭发表心情魔胎窗口的事件*/
    $('.closeBtn').bind('click', function () {
        _background('hidden');
        $('.mw-popup').fadeToggle();
    });

    /*添加图片*/
    $('.addPhoto').bind('click', function () {
        if ($('.add-content').is(':hidden')) {
            if ($('.added-img-list').find('img').length > 0) {
                $('.add-content').slideToggle('fast', function () {
                    controlBtnStatus('.add-content', '.addPhoto');
                });
            } else {
                $('.uploadFiles').click();
            }
        } else {
            $('.add-content').slideToggle('fast', function () {
                controlBtnStatus('.add-content', '.addPhoto');
            });
        }

    });

    /*发送按钮的事件*/
    $('.sendContBtn').bind('click', function () {
        $.ajax({
            url: "/weibo/add",
            method: "POST",
            data: {
                "text": $('.moon-content').html()
            },
            success: function (result) {
                if (result.code == 0) {
                    $('.closeBtn').click();
                    setTimeout(function () {
                        swal("发表成功", "", "success");
                    }, 250);
                } else {
                    alert("添加失败!");
                }
            }
        });

    });

    $('.addImageBtn').bind('click', function () {
        $('.uploadFiles').click();
    });

    /*file input表单的事件*/
    $('.uploadFiles').bind('change', function () {
        //显示隐藏的图片列表 添加节点
        var imgSrc = "/asset/img/commons/loading/loading_8.gif";
        $('.addImageBtn').before("<span class='img-panel-item' style='position: relative'>" +
        "<span class='img-hover-bg'><i class='iconfont'>&#xe659;</i></span>" +
        "<img src='/asset/img/commons/loading/loading_8.gif' />" +
        "</span>");
        if ($('.add-content').is(':hidden')) {
            $('.add-content').slideToggle('fast', function () {
                controlBtnStatus('.add-content', '.addPhoto');
            });
        }

        //提交表单,获取表单返回过来的数据,并设置图片的src属性值
        setJsonBySubmit($('#uploadMultiFiles'), "hidden_frame", function (obj) {
            var imgSrc = obj.imgSrc;
            var len = $('.img-panel-item').length;
            $('.img-panel-item').each(function (index, element) {
                if (index == (len - 1)) {
                    //获取得到最后一个元素
                    console.log('one time');
                    $(element).find('img').each(function () {
                        $(this).attr('src', imgSrc);
                    })
                }
            });
            console.log("execute here");
        });
    });
    /*图片获取焦点 \ 失去焦点*/
    // 注: 使用代理的方式可以使得jquery动态创建出来的元素可以绑定事件
    $(document).delegate('.img-panel-item', 'mouseover', function () {
        $(this).find('span:first-child').each(function () {
            $(this).css('display', 'block');
        });
    });
    $(document).delegate('.img-panel-item', 'mouseout', function () {
        $(this).find('span:first-child').each(function () {
            $(this).css('display', 'none');
        });
    });
    /*移除上传的图片*/
    $(document).delegate('.img-hover-bg', 'click', function () {
        $(this).parent('.img-panel-item').remove();
    });
    /*改变按钮处于linked or active 的颜色*/
    var controlBtnStatus = function (flagObj, targetObj) {
        if ($(flagObj).is(':hidden')) {
            $(targetObj).css('color', '#66757f');
        } else {
            $(targetObj).css('color', '#1b95e0');
        }
    }

});