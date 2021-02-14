// $(document).ready(function () { todo
//     const pattern_person = /^([a-zA-Z '-]){2,30}$/i;
//
//     $('#bio_eng').blur(function () {
//         console.log("start of checking in ajax");
//         let name = $('#author_name').val();
//         let surname = $('#author_surname').val();
//         if(name > 0 && surname > 0) {
//             if(pattern_person.test(name) && pattern_person.test(surname)) {
//                 $.ajax({
//                     url: 'check',
//                     data: {
//                         name: name,
//                         surname: surname,
//                         command: 'check_author',
//                         source: 'ajax'
//                     },
//                     method: 'get',
//                     success: function (responseText) {
//                         if(responseText === "Available") {
//                             $('#result_name')
//                                 .text(responseText)
//                                 .removeClass('no-visible')
//                                 .removeClass('unavailable')
//                                 .addClass('available');
//                             $('#result_surname')
//                                 .text(responseText)
//                                 .removeClass('no-visible')
//                                 .removeClass('unavailable')
//                                 .addClass('available');
//                             $('#btn-add').show();
//                         } else {
//                             $('#result_name')
//                                 .text(responseText)
//                                 .removeClass('no-visible')
//                                 .removeClass('available')
//                                 .addClass('unavailable');
//                             $('#result_surname')
//                                 .text(responseText)
//                                 .removeClass('no-visible')
//                                 .removeClass('available')
//                                 .addClass('unavailable');
//                             $('#btn-add').hide();
//                         }
//                     }
//                 });
//             }
//         }
//     });
// });