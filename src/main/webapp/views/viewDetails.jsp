<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Student Details</title>
</head>
<body>
	<h1>Student Details</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>City</th>
			<th>Country</th>
			<th>Pincode</th>
			<th>Score</th>
			<th>Result</th>
		</tr>
		<c:forEach items="${StudentDetails}" var="student">
			<tr>
				<td>${student.studentId}</td>
				<td>${student.name}</td>
				<td>${student.city}</td>
				<td>${student.country}</td>
				<td>${student.pincode}</td>
				<td>${student.score}</td>
				<td>${student.result}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
