<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert Data</title>
</head>
<body>
	<h1>Insert Data</h1>
	<form action="insertData" method="post">
		<p>Name:</p>
		<input type="text" name="name">
		<p>Address:</p>
		<p>City:</p>
		<input type="text" name="city">
		<p>Country:</p>
		<input type="text" name="country">
		<p>Pin Code:</p>
		<input type="text" name="pincode">
		<p>SAT Score:</p>
		<input type="text" name="score">
		<br><br>
		<input type="submit" value="Insert">
	</form>
</body>
</html>
