$(document).ready(function() {
    $('.about').on('click', function(event) {
        event.preventDefault();
        $('#content, #slider, #footer, .Hocakoi, #blogs-section, #contact-section, #auction-section, #product-section').hide();
        $('#about-section').show();
    });

    $('.blogs').on('click', function(event) {
        event.preventDefault();
        $('#content, #slider, #footer, .Hocakoi, #about-section, #contact-section, #auction-section, #product-section').hide();
        $('#blogs-section').show();
    });

    $('.contact').on('click', function(event) {
        event.preventDefault();
        $('#content, #slider, #footer, .Hocakoi, #about-section, #blogs-section, #auction-section, #product-section').hide();
        $('#contact-section').show();
    });

    $('.auction').on('click', function(event) {
        event.preventDefault();
        $('#content, #slider, #footer, .Hocakoi, #about-section, #blogs-section, #contact-section, #product-section').hide();
        $('#auction-section').show();
    });

    $('.product').on('click', function(event) {
        event.preventDefault();
        $('#content, #slider, #footer, .Hocakoi, #about-section, #blogs-section, #contact-section, #auction-section').hide();
        $('#product-section').show();
    });
});
