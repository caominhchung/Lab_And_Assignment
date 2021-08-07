<%--
  Created by IntelliJ IDEA.
  User: smurF3r
  Date: 8/6/2021
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg fixed-top navbar-light bg-light db-highlight border">
    <a href="<c:url value='/home'/>" class="navbar-brand h1">CMS</a>
    <ul class="navbar-nav ml-auto ">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
               aria-haspopup="true" aria-expanded="false">
                <i class="fa fa fa-user" aria-hidden="true"></i>  ${username}
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <a class="dropdown-item page-item" href="<c:url value='/home/profile'/>" data-source="profile.html">
                    <i class="fa fa fa-user" aria-hidden="true"></i>  User Profile
                </a>
                <a class="dropdown-item" href="<c:url value='/logout'/>">
                    <i class="fa fa-sign-out" aria-hidden="true"></i>  Logout
                </a>
            </div>
        </li>
    </ul>
</nav>