<%--
  Created by IntelliJ IDEA.
  User: smurF3r
  Date: 8/2/2021
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
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

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand" href="#">
        <i class="fa fa-home"></i> Home Page

    </a>
    <div id="navbarNavDropdown" class="navbar-collapse collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#" id="addEmpLink">Add an Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="listEmpsLink" href="#">List Employees
                </a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" style="color: yellow" href="#">
                    <i class="fa fa-user-circle-o"></i>
                    ${userLogin.userName}
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/logout">
                    <i class="fa fa-user-times"></i> Logout
                </a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h4>Welcome to Employee Management System</h4>
</div>

<div class="row fixed-bottom" style="border-top: 1px solid #ccc; background-color: #222">
    <div class="col-md-12">
        <p style="margin: 10px auto; text-align: center; color: #ccc">&copy;
            Copyright Fresher Academy 2018
        </p>
    </div>
</div>
<script type="text/javascript"
        src="<%=request.getContextPath()%>/resources/js/home-page.js"></script>
</body>
</html>
