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
<form action="#" method="post" name="frm-addEmp">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h2>Add a Employee</h2>
            <p style="color: blue">${message}</p>
            <div class="form-group">
                <label for="employeeName">Name:</label>
                <input type="text" class="form-control" id="employeeName"
                       placeholder="Enter name" name="employeeName"
                       value="${employee.employeeName}"/>
            </div>

            <label for="gender">Gender:</label>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="gender"
                           value="1" checked/>Male
                </label>
            </div>

            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="gender"
                           value="0" ${employee.gender==0 ? 'checked' : '' }/>Female
                </label>
            </div>

            <div class="form-group">
                <label for="dateOfBirth">Date of birth:</label>
                <input type="date" class="form-control" id="dateOfBirth"
                       placeholder="Enter date of birth" name="dateOfBirth"
                       value="<fmt:formatDate
					value='${employee.dateOfBirth}' pattern='yyyy-MM-dd' />"/>
            </div>

            <div class="form-group">
                <label for="dept">Department:</label>
                <select class="form-control" id="dept">
                    <c:forEach items="${listOfDepartment}" var="department">
                        <option value="${department.departmentId}" ${department.departmentId == employee.department.departmentId ? 'selected' : '' } >
                                ${department.departmentName}
                        </option>
                    </c:forEach>

                </select>
            </div>
        </div>

    </div>

    <div class="row">
        <div class="col-md-6 offset-md-3">
            <button type="button" id="btn-addEmp" class="btn btn-primary">
                Add Employee
            </button>
        </div>
    </div>
</form>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/add-employee.js"></script>

</body>
</html>
