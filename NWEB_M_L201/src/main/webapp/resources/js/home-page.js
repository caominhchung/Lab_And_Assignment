$(document).ready(function () {
    $("#addEmpLink").click(function () {
        $.get({
            url: "/NWEB_M_L201_war_exploded/add-emp",
            success: function (response) {
                $(".container").html(response);
            }
        });
    });

    $("#listEmpsLink").click(function () {
        $.get({
            url: "/NWEB_M_L201_war_exploded/list-employees",
            success: function (response) {
                $(".container").html(response);
            }
        });
    });
});