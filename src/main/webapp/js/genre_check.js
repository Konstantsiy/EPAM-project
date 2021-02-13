$(document).ready(function () {
    $('#title_eng').blur(function () {
        $.ajax({
            url: 'check',
            data: {
                title: $('#title_eng').val(),
                command: "check_genre",
                lang: "eng",
                source: "ajax"
            },
            type: 'get',
            success: function (responseText) {
                if (responseText === "Available") {
                    $('#adding_genre_result_eng')
                        .text(responseText)
                        .removeClass('no-visible')
                        .removeClass('unavailable')
                        .addClass('available');
                } else {
                    $('#adding_genre_result_eng')
                        .text(responseText)
                        .removeClass('no-visible')
                        .removeClass('available')
                        .addClass('unavailable');
                }
            }
        });
    }).focus(function () {
        $('#adding_genre_result_eng').addClass('no-visible');
    });
    $('#title_rus').blur(function () {
        $.ajax({
            url: 'check',
            data: {
                title: $('#title_rus').val(),
                command: "check_genre",
                lang: "rus",
                source: "ajax"
            },
            type: 'get',
            success: function (responseText) {
                if (responseText === "Available") {
                    $('#adding_genre_result_rus')
                        .text(responseText)
                        .removeClass('no-visible')
                        .removeClass('unavailable')
                        .addClass('available');
                } else {
                    $('#adding_genre_result_rus')
                        .text(responseText)
                        .removeClass('no-visible')
                        .removeClass('available')
                        .addClass('unavailable');
                }
            }
        });
    }).focus(function () {
        $('#adding_genre_result_rus').addClass('no-visible');
    });
});