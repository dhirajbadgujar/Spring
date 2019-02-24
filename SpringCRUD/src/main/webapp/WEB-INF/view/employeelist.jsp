<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>Employee Records</title>
	    <style>
	        tr:first-child{
	            font-weight: bold;
	            background-color: #C6C9C4;
	        }
	    </style>
	</head>
<body>
<h2>List of Employees</h2>  
    <table>
        <tr>
            <td>ID</td><td>NAME</td><td>Joining Date</td><td>Salary</td><td></td>
        </tr>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
            	<td>${employee.id}</td>
            	<td>${employee.name}</td>
            	<td>${employee.joiningDate}</td>
            	<td>${employee.salary}</td>
            	<td><a href="<c:url value='/delete/${employee.id}' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Employee</a>
</body>
</html>