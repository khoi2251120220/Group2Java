// sự kiện click vào các thẻ trên thanh menu và thông tin tài khoản
$(document).ready(function() {
    $('.about').click( function(event) {
        event.preventDefault();
        $('#content, #slider, .Hocakoi, #blogs-section, #auction-section, #product-section,#thbao_section,#thtoan_section,#setting_section,#tk_section').hide();
        $('#about-section,#footer').show();
    });

    $('.blogs').click( function(event) {
        event.preventDefault();
        $('#content, #slider, .Hocakoi, #about-section, #auction-section, #product-section,#thbao_section,#thtoan_section,#setting_section,#tk_section').hide();
        $('#blogs-section').show();
    });

    $('.auction').click( function(event) {
        event.preventDefault();
        $('#content, #slider, .Hocakoi, #about-section, #blogs-section, #product-section,#thbao_section,#thtoan_section,#setting_section,#tk_section').hide();
        $('#auction-section').show();
    });

    $('.product').click( function(event) {
        event.preventDefault();
        $('#content, #slider,.Hocakoi, #about-section, #blogs-section,#auction-section,#thbao_section,#thtoan_section,#setting_section,#tk_section').hide();
        $('#product-section').show();
    });
    $('.contact').click( function(event) {
        event.preventDefault();
        $('#product-section,#about-section, #blogs-section,#auction-section,#thbao_section,#thtoan_section,#setting_section,#tk_section').hide();
        $('#content,#slider,.Hocakoi,#footer,#contact-section').show();
        $('html, body').animate({
            scrollTop: $('#contact-section').offset().top
        });
    });
    $('.thanh_toan').click(function (event){
        event.preventDefault();
        $('#content, #slider,.Hocakoi, #about-section, #blogs-section,#auction-section,.profile_menu,#thbao_section,#setting_section,#tk_section').hide();
        $('#thtoan_section').show();
    })
    $('.thong_bao').click(function (event){
        event.preventDefault();
        $('#content, #slider,.Hocakoi, #about-section, #blogs-section,#auction-section,.profile_menu,#thtoan_section,#setting_section,#tk_section').hide();
        $('#thbao_section').show();
    })
    $('.setting').click(function (event){
        event.preventDefault();
        $('#content, #slider,.Hocakoi, #about-section, #blogs-section,#auction-section,.profile_menu,#thbao_section,#tk_section,#thtoan_section').hide();
        $('#setting_section').show();
    })
    $('.tt_tai_khoan').click(function (event){
        event.preventDefault();
        $('#content, #slider,.Hocakoi, #about-section, #blogs-section,#auction-section,.profile_menu,#thbao_section,#thtoan_section,#setting_section').hide();
        $('#tk_section').show();
    })
    $(document).ready(function() {
        $('.active,.tieude').click(function() {
            $('#auction-section,#about-section,#blogs-section,#product-section,#thbao_section,#thtoan_section,#setting_section,#tk_section').hide();
            $('#slider,#content,.Hocakoi,#footer').show();

        });
    });
});

// sự kiện của login
$(document).ready(function () {
    $('.login').click(function (event) {
        event.preventDefault();
        $('#mau_nen').toggle();
        $('#tk_login').toggle();
    });
    $('#mau_nen').click(function () {
        $(this).hide();
        $('#tk_login').hide();
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
        $('.user').show();
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
})
$(document).ready(function (){
    $('.logout').click(function (event){
        event.preventDefault()
        window.location.reload();

    })
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
})


