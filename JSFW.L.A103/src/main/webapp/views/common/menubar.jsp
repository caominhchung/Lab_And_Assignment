<%--
  Created by IntelliJ IDEA.
  User: smurF3r
  Date: 8/6/2021
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="col-md-3 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item border-bottom w-100 px-3 py-2">
                <div class="input-group md-form form-sm form-2 pl-0 p-2">
                    <input class="form-control my-0 py-1" type="text" placeholder="Search"
                           aria-label="Search">
                    <div class="input-group-append">
                                    <span class="input-group-text" id="basic-text1"><i class="fa fa-search text-grey"
                                                                                       aria-hidden="true"></i></span>
                    </div>
                </div>
            </li>
            <li class="nav-item border-bottom w-100 p-0" role="presentation">
                <a class="nav-link active p-3 page-item" href="<c:url value='/home/viewcontent'/>">
                    <i class="fa fa-table" aria-hidden="true"></i> View Contents</a>
            </li>
            <li class="nav-item border-bottom w-100 p-0" role="presentation">
                <a class="nav-link p-3 page-item" href="<c:url value='/home/formcontent'/>">
                    <i class="fa fa-edit " aria-hidden="true"></i> Form content</a>
            </li>
        </ul>
    </div>
</nav>
