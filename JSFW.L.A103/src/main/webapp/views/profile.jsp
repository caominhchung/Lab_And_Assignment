<%--
  Created by IntelliJ IDEA.
  User: smurF3r
  Date: 8/2/2021
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>

    <link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>" type="text/css"/>

    <script src="https://use.fontawesome.com/08e9c13d0e.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"
            integrity="sha512-37T7leoNS06R80c8Ulq7cdCDU5MNQBwlYoy1TX/WUsLFC2eYNqtKlV0QjH7r8JpG/S0GUMZwebnVFLPd6SU5yg=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/main.js'/>"></script>
</head>

<body>
<%@ include file="/views/common/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="/views/common/menubar.jsp" %>

        <main role="main" class="col-md-7 ml-sm-auto col-lg-9 px-4 py-5">
            <div class="container" id="page-contents">
                <div class="row">
                    <p class="h1">Edit Profile</p>
                    <div class="card col-md-12 bg-white p-0 mt-5">
                        <div class="card-header ">
                            Profile Form Elements
                        </div>
                        <div class="card-body">

                            <form id="profile-form" method="get" action="profile.html">

                                <div class="form-group">
                                    <span class="">First Name</span>
                                    <div class="">
                                        <input name="firstName" type="text" placeholder="Type your first name" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <span class="">Last Name</span>
                                    <div class="">
                                        <input name="lastName" type="text" placeholder="Type your last name" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <span class="">Email</span>
                                    <div class="">
                                        <input type="Email" name="email" value="your_email@example.com" placeholder="Email"
                                               class="form-control" readonly>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <span class="">Phone</span>
                                    <div class="">
                                        <input type="text" name="phone" placeholder="Enter your phone number" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="description">Description</label>
                                    <textarea class="form-control" name="description" id="description" rows="3"></textarea>
                                </div>
                                <div class="form-group d-flex justify-content-start">
                                    <button type="submit" class="btn btn-outline-success">Submit Button</button>
                                    <button type="reset" class="btn btn-outline-success ml-2" id="btn-reset">Reset Button</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>
