// sự kiện click vào các thẻ trên thanh menu
$(document).ready(function() {
    $('.about').on('click', function(event) {
        event.preventDefault();
        $('#content, #slider, .Hocakoi, #blogs-section, #auction-section, #product-section').hide();
        $('#about-section').show();
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
    $('.active, .tieude').click(function (){
        window.location.href = 'index.html';
    })
});

// sự kiện của login
$(document).ready(function () {
    $('.login').click(function (event) {
        event.preventDefault();
        $('#mau_nen').show();
        $('#tk_login').show();
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
