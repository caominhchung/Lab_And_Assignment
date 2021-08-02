<%--
  Created by IntelliJ IDEA.
  User: smurF3r
  Date: 8/2/2021
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>


    <title>Add Employee</title>
</head>
<body>
<br/>
<h2>List of Employees</h2>
<br/>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Employee Name</th>
        <th>Gender</th>
        <th>Date of birth</th>
        <th>Department Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listOfEmployee}" var="employee">
        <tr>
            <td>${employee.employeeId}</td>
            <td>${employee.employeeName}</td>
            <td>${employee.gender == 1 ? 'Male' : 'Female'}</td>
            <td>${employee.dateOfBirth}</td>
            <td>${employee.department.departmentName}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>


</body>
</html>
