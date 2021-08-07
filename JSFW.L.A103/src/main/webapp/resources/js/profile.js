$(document).ready(function () {
    $("#profile-form").validate({
        rules: {
            firstName: {
                required: true,
                minlength: 3,
                maxlength: 30
            },
            lastName: {
                required: true,
                minlength: 3,
                maxlength: 30
            },
            phone: {
                required: true,
                digits: true,
                minlength: 9,
                maxlength: 13
            },
            description: {
                maxlength: 200
            }
        },
        message: {
            firstName: {
                required: "First Name  can't blank",
                minlength: "First Name must be at least 3 characters",
                maxlength: "First Name must be at less than 30 characters"
            },
            lastName: {
                required: "Last Name can't blank",
                minlength: "Last Name must be at least 3 characters",
                maxlength: "Last Name must be at less than 30 characters"
            },
            phone: {
                required: "Phone can't blank",
                digits: "Your input must be numbers",
                minlength: "Phone must be at least 9 number",
                maxlength: "Phone must be at less than 13 number"
            },
            description: {
                maxlength: "Description must be at less than 200 characters"
            },
        },
        errorElement: "em",

        errorPlacement: function (error, element) {
            // Add the `invalid-feedback` class to the error element
            error.addClass("invalid-feedback");
            error.insertAfter(element);
        },
        highlight: function (element, errorClass, validClass) {
            $(element).addClass("is-invalid").removeClass("is-valid");
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).addClass("is-valid").removeClass("is-invalid");
        },
        submitHandler: function (form) {
            $.ajax({
                url: form.action,
                type: form.method,
                data: $(form).serialize(),
                success: function (response) {
                    alert("Edit profile success");
                }
            });
        }
    });

    // Form Reset
    $("#btn-reset").click(function () {
        var form = $(this).closest("form"),
            validator = form.validate();
        console.log(validator);

        validator.resetForm();
        form.find(".form-control").removeClass("is-valid is-invalid");

        $("form").trigger("reset");
    });

});