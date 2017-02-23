$(document).ready(function(){
    var sliderBarW = 385;
    var sliderDurationT = 600;
    var zeroW = 0;
    //展示左边的工具栏
    $('.directory-btn').bind('click',function(){
        $('#doc').css('right','auto');
        $('footer').css('right','auto');
        if ($('.slider-bar-left').is(":hidden")) {
            //左边的slider bar显示出来
            $('#doc').animate({'left':sliderBarW+'px'},sliderDurationT);
            $('footer').animate({'left':sliderBarW+'px'},sliderDurationT);
            $('.slider-bar-left').css('display','block');
            $('.slider-bar-left').animate({'left':0+'px'},sliderDurationT);
        } else {
            //左边的slider bar隐藏掉
            $('footer').animate({'left':zeroW+'px'},sliderDurationT);
            $('.slider-bar-left').animate({'left':-sliderBarW+'px'},sliderDurationT);
            $('#doc').animate({'left':zeroW+'px'},sliderDurationT,function(){
                $('.slider-bar-left').css('display','none');
            });

        }
    });

    //展示右边的留言信息栏
    $('.message-btn').bind('click',function(){
        $('#doc').css('left','auto');
        $('footer').css('left','auto');
        if ($('.slider-bar-right').is(":hidden")) {
            //左边的slider bar显示出来
            $('.slider-bar-right').css('display','block');
            $('.slider-bar-right').animate({'width':sliderBarW+'px'},sliderDurationT);
            $('footer').animate({'right':sliderBarW+'px'},sliderDurationT);
            $('#doc').animate({'right':sliderBarW+'px'},sliderDurationT);
        } else {
            //左边的slider bar隐藏掉
            $('.slider-bar-right').animate({'width':zeroW+'px'},sliderDurationT);
            $('footer').animate({'right':zeroW+'px'},sliderDurationT);
            $('#doc').animate({'right':zeroW+'px'},sliderDurationT,function(){
                $('.slider-bar-right').css('display','none');
            });

        }
    });



    /*显示发表心情的模态窗口*/
    $('.write-btn').bind('click',function() {
        _background('show');
        $('.mw-popup').fadeToggle();
    });

    /*taglist的item点击事件,改变active的状态*/
    $('.taglist').find('li').each(function(index,element){
       $(element).bind("click",function(){
           $('.taglist').find('li.active').removeClass("active");
           $(this).addClass("active");
       });
    });

});