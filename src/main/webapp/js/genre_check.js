$(document).ready(function () {
    $('#genre_title').blur(function () {
        console.log('check genre in ajax');
        $.ajax({
            url: 'check',
            data: {
                genre_title: $('#genre_title').val().trim(),
                command: "check_genre"
            },
            type: 'get',
            success: function (responseText) {
                if (responseText === "Available") {
                    $('#adding_genre_result')
                        .text(responseText)
                        .removeClass('no-visible')
                        .removeClass('unavailable')
                        .addClass('available');
                } else {
                    $('#adding_genre_result')
                        .text(responseText)
                        .removeClass('no-visible')
                        .removeClass('available')
                        .addClass('unavailable');
                }
            }
        });
    }).focus(function () {
        $('#adding_genre_result').addClass('no-visible');
    });
});