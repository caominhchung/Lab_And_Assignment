// $(document).ready(function () {
//     $.ajax({
//         type: "GET",
//         url: "https://forbes400.herokuapp.com/api/forbes400?limit=400",
//         dataType: 'json',
//         beforeSend: function () { // Before we send the request, remove the .hidden class from the spinner and default to inline-block.
//             $("#content-page").hide();
//             $("#loading-screen").show();
//
//         },
//         success: function (data) {
//             setTimeout(() => {
//                 $("#content-page").show();
//                 $("#loading-screen").hide();
//             }, 5000);
//         },
//         complete: function () { // Set our complete callback, adding the .hidden class and hiding the spinner.
//         },
//     })
// });