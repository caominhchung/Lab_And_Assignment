$(document).ready(function () {
    $("#btn-login").click(function () {
        var userName = $("#inputUsername").val();
        var password = $("#inputPassword").val();

        $.post({
            url: "/NWEB_M_L201_war_exploded/login",
            data: {
                userName: userName,
                password: password
            },
            success: function (response) {
                // $('html').html(response);
                window.location.href = "/NWEB_M_L201_war_exploded/home";
            }
        });
    });
});