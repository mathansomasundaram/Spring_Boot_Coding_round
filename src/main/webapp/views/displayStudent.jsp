<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.project.precize.model.Student" %> 

<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h1>Student Details</h1>

    <% 
        Student student = (Student) request.getAttribute("rankdetails");
        
        if (student != null) {
    %>
    <label>Name: <%= student.getName() %></label><br>
    <label>SAT Score: <%= student.getScore() %></label><br>
    <label>Rank: <%= student.getRank() %></label><br>
    <% 
        }
    %>
</body>
</html>
