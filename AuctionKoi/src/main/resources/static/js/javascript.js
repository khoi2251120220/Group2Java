// sự kiện click vào các thẻ trên thanh menu và thông tin tài khoản
$(document).ready(function() {
    $('.about').click( function(event) {
        event.preventDefault();
        $('#content, #slider, .Hocakoi, #blogs-section, #auction-section, #product-section,' +
            '#thbao_section,#thtoan_section,#setting_section,#tk_section,#tk_login,#mau_nen,#tk_register').hide();
        $('#about-section,#footer').show();
    });

    $('.blogs').click( function(event) {
        event.preventDefault();
        $('#content, #slider, .Hocakoi, #about-section, #auction-section, #product-section,' +
            '#thbao_section,#thtoan_section,#setting_section,#tk_section,#tk_login,#mau_nen,#tk_register').hide();
        $('#blogs-section').show();
    });

    $('.auction').click( function(event) {
        event.preventDefault();
        $('#content, #slider, .Hocakoi, #about-section, #blogs-section, #product-section,' +
            '#thbao_section,#thtoan_section,#setting_section,#tk_section,#tk_login,#mau_nen,#tk_register').hide();
        $('#auction-section').show();
    });
    $('.contact').click( function(event) {
        event.preventDefault();
        $('#product-section,#about-section, #blogs-section,#auction-section,#thbao_section,' +
            '#thtoan_section,#setting_section,#tk_section,#tk_login,#mau_nen,#tk_register').hide();
        $('#content,#slider,.Hocakoi,#footer,#contact-section').show();
        $('html, body').animate({
            scrollTop: $('#contact-section').offset().top
        });
    });
    $('.thanh_toan').click(function (event){
        event.preventDefault();
        $('#content, #slider,.Hocakoi, #about-section, #blogs-section,#auction-section,' +
            '.profile_menu,#thbao_section,#setting_section,#tk_section').hide();
        $('#thtoan_section').show();
    })
    $('.setting').click(function (event){
        event.preventDefault();
        $('#content, #slider,.Hocakoi, #about-section, #blogs-section,#auction-section,' +
            '.profile_menu,#thbao_section,#tk_section,#thtoan_section').hide();
        $('#setting_section').show();
    })
    $('.tt_tai_khoan').click(function (event){
        event.preventDefault();
        $('#content, #slider,.Hocakoi, #about-section, #blogs-section,#auction-section,' +
            '.profile_menu,#thbao_section,#thtoan_section,#setting_section').hide();
        $('#tk_section').show();
    })
    $(document).ready(function() {
        $('.active,.tieude').click(function() {
            $('#auction-section,#about-section,#blogs-section,#product-section,' +
                '#thbao_section,#thtoan_section,#setting_section,#tk_section,#tk_login,#mau_nen,#tk_register').hide();
            $('#slider,#content,.Hocakoi,#footer').show();

        });
    });
});
$(document).ready(function () {
    $('.tb1, .tb2, .tb3, .tb4, .tb5').click(function () {
        var target = $(this).data('target'); // Lấy giá trị từ data-target
        $('#thbao_section').show();
        $('#content, #slider, .Hocakoi, #about-section, #blogs-section, #auction-section, .profile_menu, #thtoan_section, #setting_section, #tk_section').hide();

        $('html, body').animate({
            scrollTop: $(target).offset().top - 50// Cuộn đến mục tiêu
        });
    });
});

$(document).ready(function () {
    // Sự kiện khi nhấn nút login
    $('.login').click(function (event) {
        event.preventDefault();
        if ($('#tk_login').is(':visible')) {
            $('#mau_nen').hide();
            $('#tk_login').hide(500);
        } else {
            $('#mau_nen').show();
            $('#tk_login').show(500);
            $('#tk_register').hide();
        }
    });

    // Sự kiện khi nhấn nút register
    $('.register').click(function (event) {
        event.preventDefault();

        if ($('#tk_register').is(':visible')) {
            $('#mau_nen').hide();
            $('#tk_register').hide(500);
        } else {
            $('#mau_nen').show();
            $('#tk_register').show(500);
            $('#tk_login').hide();
        }
    });
    $('#mau_nen').click(function () {
        $(this).hide();
        $('#tk_login').hide();
        $('#tk_register').hide();
    });
});

// sự kiện click menu
$(document).ready(function() {
    $('.menu_item').click(function() {
        $('.menu_item').removeClass('active');
        $(this).addClass('active');
    });
});
// sự kiện click vào user
$(document).ready(function (){
    $('.login_btn').on('click',function (event){
        event.preventDefault();
        $('.login,.register,.modal').hide();
        $('.user,.bell').show();
    })
})
$(document).ready(function (){
    $('.user').on('click',function (event){
        event.preventDefault();
        $('.profile_menu').toggle(500);
    });
    $(document).on('click', function (event) {
        if (!$(event.target).closest('.profile_menu, .user').length) {
            $('.profile_menu').hide(500);
        }
    });
    $('.tongquat').on('click',function (event){
        event.preventDefault();
        $('.profile_menu_bell').toggle(500);
        $('#thbao_section').show();
        $('#content, #slider,.Hocakoi, #about-section, #blogs-section,#auction-section,.profile_menu,#thtoan_section,#setting_section,#tk_section').hide();
    })
    $(document).on('click', function (event) {
        if (!$(event.target).closest('.profile_menu_bell, .bell').length) {
            $('.profile_menu_bell').hide(500);
        }
    });
})
$(document).ready(function (){
    $('.bell').on('click',function (event){
        event.preventDefault();
        $('.profile_menu_bell').toggle(500);
    });
    $(document).on('click', function (event) {
        if (!$(event.target).closest('.profile_menu, .bell').length) {
            $('.profile_menu_bell').hide(500);
        }
    });
})

$(document).ready(function (){
    $('.p1').click(function (event){
        event.preventDefault()
        $('.p1_1').toggle(1000);
        $('.p2_2,.p3_3,.p4_4,.p5_5').hide();
    })
    $('.p2').click(function (event){
        event.preventDefault()
        $('.p2_2').toggle(1000);
        $('.p1_1,.p3_3,.p4_4,.p5_5').hide();
    })
    $('.p3').click(function (event){
        event.preventDefault()
        $('.p3_3').toggle(1000);
        $('.p2_2,.p1_1,.p4_4,.p5_5').hide();
    })
    $('.p4').click(function (event){
        event.preventDefault()
        $('.p4_4').toggle(1000);
        $('.p2_2,.p3_3,.p1_1,.p5_5').hide();
    })
    $('.p5').click(function (event){
        event.preventDefault()
        $('.p5_5').toggle(1000);
        $('.p2_2,.p3_3,.p4_4,.p1_1').hide();
    })
    $('.logout').click(function (event){
        event.preventDefault()
        window.location.reload();
    })
})
$(document).on("scroll", function() {
    var $adviceSection = $(".advice-section");
    var $footer = $("#footer");

    // Vị trí của footer và advice section
    var footerOffset = $footer.offset().top;
    var adviceSectionHeight = $adviceSection.outerHeight();
    var scrollTop = $(window).scrollTop();
    var windowHeight = $(window).height();

    // Kiểm tra nếu phần advice-section chạm tới footer
    if (scrollTop + windowHeight > footerOffset) {
        $adviceSection.css({
            position: "absolute",
            top: footerOffset - adviceSectionHeight + 65
        });
    } else {
        $adviceSection.css({
            position: "fixed",
            top: "165px"
        });
    }
});


