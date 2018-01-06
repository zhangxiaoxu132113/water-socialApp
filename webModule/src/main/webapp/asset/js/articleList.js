$(document).ready(function () {
    $('.all-category').hover(
        function () {
            $('.all-category-inner').css('display', 'block');
        }, function () {
            $('.all-category-inner').css('display', 'none');
        });

    $('.all-category ul li').hover(
        function () {
            $(this).find('div.category-panel').first().css('display', 'block');
        }, function () {
            $(this).find('div.category-panel').first().css('display', 'none');
        }
    );

    $('.search-btn-a').click(function () {
        $('.search-form').submit();
    });

    $('[data-slidizle]').slidizle({
        beforeChange: function (api) {
        }
    });
    $(window).scroll(function () {
        var height = $('#header').height() + $('#category-nav').height() + $('#view-info').height() + $('#long-ad').height() + 30;
        if ($(window).scrollTop() >= height) {
            $('.tabClick').addClass('nav-fixed');
        } else {
            $('.tabClick').removeClass("nav-fixed");
        }
    });

});

var pageCategoryObj = new Object();

function click_category(obj,category) {

    $(obj).addClass("active").siblings().removeClass("active"); //切换选中的按钮高亮状态
    var index = $(obj).index(); //获取被按下按钮的索引值，需要注意index是从0开始的
    $('.lineDiv').css('margin-left', (index * 140) + 'px');
    $(".tabBox > div").eq(index).show().siblings().hide(); //在按钮选中时在下面显示相应的内容，同时隐藏不需要的框架内容
    if (category == -1) {
        return;
    }
    if (pageCategoryObj["category_" + category] != undefined) {
        return;
    } else {
        pageCategoryObj["category_" + category] = 1;
    }

    $.ajax({
        url: '<%=basePath%>/blog/category/getCategoryArticleListWithAjax?category='+category+'&sort=viewHits&currentPage='+ pageCategoryObj["category_" + category] +'&pageSize=' + pageSize,
        method: "GET",
        async: true,
        success: function (result) {
            $('#category-article-'+category).append(result);
        }
    });
}

$('.hot_add_more').bind('click', function(){
});

var pageSize = 10;
function loadMore(category) {
    pageCategoryObj["category_" + category] += 1;
    var currentPage = pageCategoryObj["category_" + category];
    $.ajax({
        url: '<%=basePath%>/blog/category/getCategoryArticleListWithAjax?category='+category+'&sort=viewHits&currentPage='+ currentPage++ +'&pageSize=' + pageSize,
        method: "GET",
        async: true,
        success: function (result) {
            $('#category-article-'+category).append(result);
        }
    });
}