<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<h2>Student Form</h2>
<form:form action="${pageContext.request.contextPath}/students/save" modelAttribute="student" method="post">
    <form:hidden path="id"/>
    Name: <form:input path="name"/> <form:errors path="name"/><br>
    Email: <form:input path="email"/> <form:errors path="email"/><br>
    Course: <form:input path="course"/><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>