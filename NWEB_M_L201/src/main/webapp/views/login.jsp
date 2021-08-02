<%--
  Created by IntelliJ IDEA.
  User: smurF3r
  Date: 8/2/2021
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>


    <title>Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>
</head>

<body>

<div class="container">
    <div class="row justify-content-sm-center">
        <p class="h1 my-sm-5">Login</p>
    </div>
    <form>
        <div class="form-group row justify-content-md-center">
            <label for="inputUsername" class="col-sm-2 col-form-label">User Name<span> * </span></label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="inputUsername" placeholder="Enter your User Name"
                       name="userName" required/>
            </div>
        </div>
        <div class="form-group row justify-content-md-center">
            <label for="inputPassword" class="col-sm-2 col-form-label">Password<span>*</span></label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="inputPassword" placeholder="Enter Password"
                       name="password" required/>
            </div>
        </div>
        <div class="form-group row justify-content-md-center">
            <div class="col-sm-3"></div>
            <div class="col-sm-3">
                <button type="button" class="btn btn-primary" id="btn-login">Login</button>
                <a href="#" class="ml-3">Click Here To Register</a>
            </div>
            <div class="col-sm-4">
            </div>
        </div>
    </form>

</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/login.js"></script>
</body>

</html>