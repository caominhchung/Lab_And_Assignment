$(document).ready(function () {
    let result;
    $.validator.addMethod("uniqueUsername",
        function (value, element) {
            $.ajax({
                type: "POST",
                url: "register/checkMember",
                data: {"username":value},
                dataType: "html",
                statusCode: {
                    200:function(msg){
                        result = true;
                    },
                    204:function(msg){
                        result = false;
                    }
                },
                success: function (msg) {
                    //If username exists, set response to true
                },

            });
            return result;
        },
        "Username is Already Taken"
    );

    $.validator.addMethod(
        "uniqueEmail",
        function (value, element) {
            $.ajax({
                type: "POST",
                url: "register/checkMember",
                data: {"email":value},
                dataType: "html",
                statusCode: {
                    200:function(msg){
                        result = true;
                    },
                    204:function(msg){
                        result = false;
                    }
                },
                success: function (msg) {
                    //If username exists, set response to true

                }
            });
            return result;
        },
        "Email is Already Taken"
    );

    $("#register-form").validate({
        rules: {
            username: {
                required: true,
                minlength: 5,
                maxlength: 50,
                uniqueUsername:true
            },
            email: {
                required: true,
                minlength: 5,
                email: true,
                uniqueEmail: true
            },
            password: {
                required: true,
                minlength: 8,
                maxlength: 30
            },
            rePassword: {
                required: true,
                minlength: 8,
                maxlength: 30,
                equalTo: "#password"
            }
        },
        message: {
            username: {
                required: "Input Your Username",
                minlength: "Username must be at least 5 characters",
                maxlength: "Username must be at less than 50 characters",
                uniqueUsername:"Username is Already Taken"
            },
            email: {
                required: "Input Your Email",
                minlength: "Email must be at least 5 characters",
                email: "Email Invalid",
                uniqueEmail:"Email is Already Taken"
            },
            password: {
                required: "Input Your Password",
                minlength: "Password must be at least 8 characters",
                maxlength: "Password must be at less than 30 characters"
            },
            rePassword: {
                required: "Input Your RePassword",
                minlength: "RePassword must be at least 8 characters",
                maxlength: "RePassword must be at less than 30 characters",
                equalTo: "Please enter the same password as above"
            }
        },
        submitHandler: function (form) {
            $.ajax({
                url: form.action,
                type: form.method,
                data: $(form).serialize(),
                statusCode: {
                    204:function(response){
                        $("#register-error").show();
                        $("#register-error").html("Register Failed.");
                    },
                    200:function(response){
                        $("#register-error").hide();
                        window.location.href = "/JSFW_L_A103/login";
                    }
                },
                success: function (response) {

                }
            });
        }
    })

});