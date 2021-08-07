<%--
  Created by IntelliJ IDEA.
  User: smurF3r
  Date: 8/2/2021
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Login</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"
            integrity="sha512-37T7leoNS06R80c8Ulq7cdCDU5MNQBwlYoy1TX/WUsLFC2eYNqtKlV0QjH7r8JpG/S0GUMZwebnVFLPd6SU5yg=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" type="text/css"/>
</head>

<body>
<div class="page">
    <form action="<c:url value='/login'/>" method="POST" class="login" id="login-form">
        <p>&ensp;Please Sign In</p>
        <div class="form">
            <input type="text" class="text" name="username" placeholder="Username" required>
            <input type="password" class="password" name="password" placeholder="Password" required>
            <div><input type="checkbox" id="cb-remember">
                <label for="cb-remember">Remember Me</label>
            </div>
            <label id="login-error" class="error"></label>
            <button type="submit" class="btn-submit">Login</button>
            <a href="<c:url value="/register"/>">Click here to Register</a>
        </div>
    </form>
</div>
<script type="text/javascript" src="<c:url value='/resources/js/login.js'/>"></script>
</body>

</html>