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
});