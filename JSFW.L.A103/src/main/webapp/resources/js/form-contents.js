$(document).ready(function () {

    $("#contents-form").validate({
        rules: {
            title: {
                required: true,
                minlength: 10,
                maxlength: 200
            },
            brief: {
                required: true,
                minlength: 30,
                maxlength: 150
            },
            content: {
                required: true,
                minlength: 50,
                maxlength: 1000
            }
        },
        message: {
            title: {
                required: "Title can't blank",
                minlength: "Title must be at least 10 characters",
                maxlength: "Title must be at less than 200 characters"
            },
            brief: {
                required: "Brief can't blank",
                minlength: "Brief must be at least 30 characters",
                maxlength: "Title must be at less than 150 characters"
            },
            content: {
                required: "Content can't blank",
                minlength: "Brief must be at least 50 characters",
                maxlength: "Title must be at less than 1000 characters"
            }
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