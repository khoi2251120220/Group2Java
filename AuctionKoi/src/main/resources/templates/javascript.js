// sự kiện click vào các thẻ trên thanh menu
$(document).ready(function() {
    $('.about').on('click', function(event) {
        event.preventDefault();
        $('#content, #slider, .Hocakoi, #blogs-section, #auction-section, #product-section').hide();
        $('#about-section,#footer').show();
    });

    $('.blogs').on('click', function(event) {
        event.preventDefault();
        $('#content, #slider, #footer, .Hocakoi, #about-section, #auction-section, #product-section').hide();
        $('#blogs-section').show();
    });

    $('.auction').on('click', function(event) {
        event.preventDefault();
        $('#content, #slider, #footer, .Hocakoi, #about-section, #blogs-section, #product-section').hide();
        $('#auction-section').show();
    });

    $('.product').on('click', function(event) {
        event.preventDefault();
        $('#content, #slider, #footer, .Hocakoi, #about-section, #blogs-section,#auction-section').hide();
        $('#product-section').show();
    });
    $(document).ready(function() {
        $('.active,.tieude').click(function() {
            $('#auction-section,#about-section,#blogs-section,#product-section').hide(); // Ẩn phần khác
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
        $('.user,.profile_menu').hide();
        $('.login,.register').show();
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

