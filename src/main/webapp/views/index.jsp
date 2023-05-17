<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Menu</title>
</head>
<body>
	<h1>Menu</h1>

	<p>
		<strong>${param.message}</strong>
	</p>
	<form action="process" method="post">
		<p>Select an option:</p>
		<ul>
			<li><input type="radio" name="option" value="insert">Insert
				data</li>
			<li><input type="radio" name="option" value="view">View
				all data</li>
			<li><input type="radio" name="option" value="rank">Get
				rank</li>
			<li><input type="radio" name="option" value="update">Update
				score</li>
			<li><input type="radio" name="option" value="delete">Delete
				one record</li>
		</ul>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
