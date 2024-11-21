// sự kiện click vào các thẻ trên thanh menu và thông tin tài khoản
$(document).ready(function () {
    $('.about').click(function (event) {
        event.preventDefault();
        window.location.href = '/about';

    });

    $('.blogs').click(function (event) {
        event.preventDefault();
        window.location.href = '/blog';
    });

    $('.auction').click(function (event) {
        event.preventDefault();
        window.location.href = '/auction';
    });
    $('.contact').click(function (event) {
        event.preventDefault(); // Ngừng hành động mặc định của liên kết

        // Lưu vị trí cuộn
        sessionStorage.setItem('scrollToContact', true);

        // Điều hướng về trang index
        window.location.href = '/';
    });
    $(document).ready(function () {
        // Kiểm tra nếu có giá trị 'scrollToContact' trong sessionStorage
        if (sessionStorage.getItem('scrollToContact') === 'true') {
            // Cuộn trang xuống #contact-section
            $('html, body').animate({
                scrollTop: $('#contact-section').offset().top
            }, 1000); // 1000 là thời gian cuộn (1 giây)

            // Xóa giá trị trong sessionStorage để không cuộn lại khi tải lại trang sau
            sessionStorage.removeItem('scrollToContact');
        }
    });


    $('.thanh_toan').click(function (event) {
        event.preventDefault();
        window.location.href = '/thanh_toan';
    })
    $('.setting').click(function (event) {
        event.preventDefault();
        window.location.href = '/setting';
    })
    $('.tt_tai_khoan').click(function (event) {
        event.preventDefault();
        window.location.href = '/account';

    })

});
$(document).ready(function () {
    $('.tb1, .tb2, .tb3, .tb4, .tb5').click(function () {
        var target = $(this).data('target'); // Lấy giá trị từ data-target


        $('html, body').animate({
            scrollTop: $(target).offset().top - 50// Cuộn đến mục tiêu
        });
    });
});

$(document).ready(function () {
    // Sự kiện khi nhấn nút login
    $('.login').click(function (event) {
        // Ngăn chặn hành vi mặc định nếu đây là thẻ <a> hoặc <button>
        event.preventDefault();

        // Chuyển hướng đến trang đăng nhập
        window.location.href = '/login';
    });


    // Thêm sự kiện khi nhấn nút register
    $('.register').click(function (event) {
        event.preventDefault();
        window.location.href = '/register';
    });




});


//sự kiện click menu



    $(document).ready(function () {
    // Khi click vào bất kỳ mục nào trên thanh header
    $(' .menu_item').on('click', function () {
        // Xóa lớp 'active' khỏi tất cả các nút
        $('.menu_item').removeClass('active');

        // Thêm lớp 'active' vào nút vừa được click
        $(this).addClass('active');
    });
});


// Thay thế đoạn xử lý login_btn hiện tại
$(document).ready(function () {
    $('#loginForm').on('submit', function (event) {
        event.preventDefault();

        $.ajax({
            type: 'POST',
            url: '/login',
            data: $(this).serialize(),
            success: function () {

                // Ẩn nút login/register
                $('#login, .register').hide();

                // Hiện menu user và thông báo
                $('.menu_bell, .menu_dang_nhap').show();
                $('.bell, .user').show();

                // Reload trang để cập nhật UI
                window.location.href = '/';
            },
            error: function () {
                alert('Invalid username or password');
            }
        });
    });

    // Xử lý đăng xuất
    $('.logout').click(function (e) {
        e.preventDefault();
        $.get('/logout', function () {
            window.location.reload();
        });
    });
    // Chuyển sang form đăng ký khi nhấn nút "Register"

});

//sự kiện click vào register_btn
$(document).ready(function () {
    $('#registerForm').on('submit', function (event) {
        event.preventDefault();

        const formData = {
            username: $('#username').val(),
            fullName: $('#fullName').val(),
            phoneNumber: $('#phoneNumber').val(),
            email: $('#email').val(),
            password: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/register',
            data: formData,
            success: function () {
                // Hiển thị phản hồi từ server, ví dụ: "Registration successful!"
                window.location.href = '/login'; // Chuyển hướng sang trang đăng nhập
            },
            error: function (xhr) {
                alert(xhr.responseText || 'Registration failed. Please try again.');
            }
        });
    });

});

$(document).ready(function () {
    $('.user').on('click', function (event) {
        event.preventDefault();
        $('.profile_menu').toggle(500);
    });
    $(document).on('click', function (event) {
        if (!$(event.target).closest('.profile_menu, .user').length) {
            $('.profile_menu').hide(500);
        }
    });
    $('.tongquat').on('click', function (event) {
        event.preventDefault();
        $('.profile_menu_bell').toggle(500);
        window.location.href = '/notification';

    })
    $(document).on('click', function (event) {
        if (!$(event.target).closest('.profile_menu_bell, .bell').length) {
            $('.profile_menu_bell').hide(500);
        }
    });
})
$(document).ready(function () {
    $('.bell').on('click', function (event) {
        event.preventDefault();
        $('.profile_menu_bell').toggle(500);
    });
    $(document).on('click', function (event) {
        if (!$(event.target).closest('.profile_menu, .bell').length) {
            $('.profile_menu_bell').hide(500);
        }
    });
})

$(document).ready(function () {
    $('.p1').click(function (event) {
        event.preventDefault()
        $('.p1_1').toggle(1000);
        $('.p2_2,.p3_3,.p4_4,.p5_5').hide();
    })
    $('.p2').click(function (event) {
        event.preventDefault()
        $('.p2_2').toggle(1000);
        $('.p1_1,.p3_3,.p4_4,.p5_5').hide();
    })
    $('.p3').click(function (event) {
        event.preventDefault()
        $('.p3_3').toggle(1000);
        $('.p2_2,.p1_1,.p4_4,.p5_5').hide();
    })
    $('.p4').click(function (event) {
        event.preventDefault()
        $('.p4_4').toggle(1000);
        $('.p2_2,.p3_3,.p1_1,.p5_5').hide();
    })
    $('.p5').click(function (event) {
        event.preventDefault()
        $('.p5_5').toggle(1000);
        $('.p2_2,.p3_3,.p4_4,.p1_1').hide();
    })
    $('.logout').click(function (event) {
        event.preventDefault()
        window.location.reload();
    })
})
$(document).on("scroll", function () {
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

$(document).ready(function () {
    // Xử lý form login
    $('#loginForm').submit(function (e) {
        e.preventDefault();

        $.ajax({
            type: 'POST',
            url: '/login',
            data: $(this).serialize(),
            success: function (response) {
                if (response.includes('error=true')) {
                    // Hiển thị thông báo lỗi
                    $('.error-message').show();
                } else {
                    window.location.reload();
                }
            }
        });
    });

    // Ẩn thông báo lỗi khi mở form login
    $('.login').click(function () {
        $('.error-message').hide();
    });
});

$(document).ready(function () {
    // Xử lý nút Register trên header
    $('.Register, .register').click(function () {
        $('#mau_nen').show();
        $('#tk_register').show();
        $('#tk_login').hide(); // Ẩn form login nếu đang mở
    });

    // Xử lý nút Login trên header
    $('.Log.in, .login').click(function () {
        $('#mau_nen').show();
        $('#tk_login').show();
        $('#tk_register').hide(); // Ẩn form register nếu đang mở
    });

    // Xử lý nút Log In trong form register
    $('.login_btn_footer').click(function () {
        $('#tk_register').hide();
        $('#tk_login').show();
    });

    // Xử lý nút Register trong form login
    $('.register_btn_footer').click(function () {
        $('#tk_login').hide();
        $('#tk_register').show();
    });

    // Xử lý form đăng ký
    $('#registerForm').on('submit', function (e) {
        e.preventDefault();

        $.ajax({
            type: 'POST',
            url: '/register',
            data: $(this).serialize(),
            success: function (response) {
                // Ẩn form và nền
                $('#tk_register').hide();
                $('#mau_nen').hide();

                // Reset form
                $('#registerForm')[0].reset();

                // Reload trang để cập nhật trạng thái đăng nhập
                window.location.reload();
            },
            error: function (xhr, status, error) {
                console.log('Registration failed:', error);
            }
        });
    });

    // Xử lý form login
    $('#loginForm').on('submit', function (e) {
        e.preventDefault();
        // ... code xử lý đăng nhập ...
    });

    // Xử lý click vào nền đen để đóng form
    $('#mau_nen').click(function () {
        $('#mau_nen').hide();
        $('#tk_login').hide();
        $('#tk_register').hide();
    });
});
