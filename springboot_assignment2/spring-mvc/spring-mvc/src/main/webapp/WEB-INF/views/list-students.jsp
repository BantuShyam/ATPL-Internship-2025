<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h2>Students</h2>
<a href="${pageContext.request.contextPath}/students/add">Add Student</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.course}</td>
            <td>
                <a href="${pageContext.request.contextPath}/students/update?id=${student.id}">Edit</a> |
                <a href="${pageContext.request.contextPath}/students/delete?id=${student.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>