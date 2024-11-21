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
    //Sự kiện khi nhấn nút login
    $('.login').click(function (event) {
        event.preventDefault();
        if ($('#tk_login').is(':visible')) {
            $('#mau_nen').hide();
            $('#tk_login').hide(500);
        } else {
            $('#mau_nen').show();
            $('#tk_login').show(500);
            $('#tk_register').hide(500);
        }
    });

    // Thêm sự kiện khi nhấn nút register
    $('.register').click(function (event) {
        event.preventDefault();
        if ($('#tk_register').is(':visible')) {
            $('#mau_nen').hide();
            $('#tk_register').hide(500);
        } else {
            $('#mau_nen').show();
            $('#tk_register').show(500);
            $('#tk_login').hide(500);
        }
    });

    // Sự kiện khi nhấn nút register trong form login
    $('.register_btn_footer').click(function() {
        $('#tk_login').hide(500);
        $('#tk_register').show(500);
    });

    // Sự kiện khi nhấn nút login trong form register
    $('.login_btn_footer').click(function() {
        $('#tk_register').hide(500);
        $('#tk_login').show(500);
    });

    $('#mau_nen').click(function () {
        $(this).hide();
        $('#tk_login').hide();
        $('#tk_register').hide();
    });
});

//sự kiện click menu
// Thay thế đoạn xử lý login_btn hiện tại
$(document).ready(function () {
    $('#loginForm').on('submit', function (event) {
        event.preventDefault();
        
        $.ajax({
            type: 'POST',
            url: '/login',
            data: $(this).serialize(),
            success: function() {
                // Ẩn form login và overlay
                $('#tk_login, #mau_nen').hide();
                
                // Ẩn nút login/register
                $('#login, .register').hide();
                
                // Hiện menu user và thông báo
                $('.menu_bell, .menu_dang_nhap').show();
                $('.bell, .user').show();
                
                // Reload trang để cập nhật UI
                window.location.reload();
            },
            error: function() {
                alert('Invalid username or password');
            }
        });
    });

    // Xử lý đăng xuất
    $('.logout').click(function(e) {
        e.preventDefault();
        $.get('/logout', function() {
            window.location.reload();
        });
    });
    // Chuyển sang form đăng ký khi nhấn nút "Register"
    $('.login_btn_footer').on('click', function () {
        $('#tk_login').show(500);
        $('#tk_register').hide(500);
    });

});

//sự kiện click vào register_btn
$(document).ready(function () {
    $('#register_Form').on('submit', function (event) {
        event.preventDefault();
        
        const formData = {
            firstName: $('#first-name').val(),
            lastName: $('#last-name').val(),
            phoneNumber: $('#phone-number').val(),
            email: $('#email_register').val(),
            password: $('#password').val()
        };
        
        $.ajax({
            type: 'POST',
            url: '/register',
            data: formData,
            success: function(response) {
                alert('Registration successful! Please login.');
                // Chuyển sang form đăng nhập
                $('#tk_register').hide();
                $('#tk_login').show(500);
            },
            error: function(xhr) {
                alert(xhr.responseText || 'Registration failed. Please try again.');
            }
        });
    });

    // Nút "Log In" trong footer để quay lại form đăng nhập
    $('.register_btn_footer').on('click', function () {
        $('#tk_login').hide(500);
        $('#tk_register').show(500); // Hiển thị form đăng ký
    });
});


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

$(document).ready(function() {
    // Xử lý form login
    $('#loginForm').submit(function(e) {
        e.preventDefault();
        
        $.ajax({
            type: 'POST',
            url: '/login',
            data: $(this).serialize(),
            success: function(response) {
                if(response.includes('error=true')) {
                    // Hiển thị thông báo lỗi
                    $('.error-message').show();
                } else {
                    // Ẩn form login và reload trang
                    $('#tk_login').hide();
                    $('#mau_nen').hide();
                    window.location.reload();
                }
            }
        });
    });

    // Ẩn thông báo lỗi khi mở form login
    $('.login').click(function() {
        $('.error-message').hide();
    });
});


