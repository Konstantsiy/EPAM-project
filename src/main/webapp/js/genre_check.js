$(document).ready(function () {
    $('#genre_title').blur(function () {
        var title = $('genre_title').val();
        if(title.length > 0) {
            console.log('check genre in ajax');
            $.ajax({
                url: 'check',
                data: {
                    genre_title: title.trim(),
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
                        document.getElementById('btn-add').disabled = false;
                    } else {
                        $('#adding_genre_result')
                            .text(responseText)
                            .removeClass('no-visible')
                            .removeClass('available')
                            .addClass('unavailable');
                        document.getElementById('btn-add').disabled = true;
                    }
                }
            });
        }
    }).focus(function () {
        $('#adding_genre_result').addClass('no-visible');
    });
});