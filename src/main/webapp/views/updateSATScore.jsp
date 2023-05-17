<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page import="com.project.precize.model.Student" %> 
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update Score</title>
</head>
<body>
	<h1>Update SAT Score</h1>
	<form action="updateData" method="post">
		<% 
        Student student = (Student) request.getAttribute("studentDetailsForUpdate");
           
        %>
		<p>Name:</p>
		<input type="text" name="name" value="<%= student.getName() %>" readonly style="background-color: lightgray;">
		<p>Address:</p>
		<p>City:</p>
		<input type="text" name="city" value="<%= student.getCity() %>" readonly style="background-color: lightgray;">
		<p>Country:</p>
		<input type="text" name="country" value="<%= student.getCountry() %>" readonly style="background-color: lightgray;">
		<p>Pin Code:</p>
		<input type="text" name="pincode" value="<%= student.getPincode() %>" readonly style="background-color: lightgray;">
		<p>SAT Score:</p>
		<input type="text" name="score" value="<%= student.getScore() %>">
		<br><br>
		<input type="submit" value="Insert">
	</form>
</body>
</html>
