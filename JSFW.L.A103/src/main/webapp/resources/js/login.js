$(document).ready(function () {
    $("#login-form").validate({
        rules: {
            username: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            password: {
                required: true,
                minlength: 8,
                maxlength: 30
            }
        },
        message: {
            username: {
                required: "Input Your Username",
                minlength: "Username must be at least 5 characters",
                maxlength: "Username must be at less than 50 characters"
            },
            password: {
                required: "Input Your Password",
                minlength: "Password must be at least 8 characters",
                maxlength: "Password must be at less than 30 characters"
            }
        },
        submitHandler: function (form) {
            $.ajax({
                url: form.action,
                type: form.method,
                data: $(form).serialize(),
                statusCode: {
                    204:function(response){
                        $("#login-error").show();
                        $("#login-error").html("Username Or Password Not True.");
                    },
                    200:function(response){
                        $("#login-error").hide();
                        window.location.href = "/JSFW_L_A103/home";
                    }
                },
                success: function (response) {

                }
            });
        }
    })

});