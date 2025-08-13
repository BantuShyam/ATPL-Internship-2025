<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error - Student Management System</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8d7da; color: #721c24; text-align: center; padding-top: 50px; }
        h1 { font-size: 3em; }
        p { font-size: 1.2em; }
        a { text-decoration: none; color: #004085; }
    </style>
</head>
<body>
    <h1>Oops! Something went wrong</h1>
    <p>${message != null ? message : "An unexpected error occurred."}</p>
    <a href="/students">Back to Student List</a>
</body>
</html>