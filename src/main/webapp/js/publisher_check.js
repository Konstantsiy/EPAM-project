$(document).ready(function () {
    $('#p_title').blur(function () {
        console.log('check genre in ajax');
        $.ajax({
            url: 'check',
            data: {
                p_title: $('#p_title').val().trim(),
                command: "check_genre"
            },
            success: function (responseText) {
                if (responseText === "Available") {
                    $('#adding_p_result')
                        .text(responseText)
                        .removeClass('no-visible')
                        .removeClass('unavailable')
                        .addClass('available');
                } else {
                    $('#adding_p_result')
                        .text(responseText)
                        .removeClass('no-visible')
                        .removeClass('available')
                        .addClass('unavailable');
                }
            }
        })
    }).focus(function () {
        $('#adding_p_result').addClass('no-visible');
    })
})