<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.project.precize.model.Student" %> 
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>

    <table border="1">
        <tr>
            <th>Name</th>
            <th>City</th>
            <th>Country</th>
            <th>Pin Code</th>
            <th>SAT Score</th>
            <th>Result</th>
        </tr>
        
        <% 
            List<Student> studentList = (List<Student>) request.getAttribute("StudentDetails");
            
            for (Student student : studentList) {
        %>
        <tr>
            <td align="left"><%= student.getName().toUpperCase() %></td>
            <td align="left"><%= student.getCity().toUpperCase() %></td>
            <td align="left"><%= student.getCountry().toUpperCase() %></td>
            <td align="left"><%= student.getPincode() %></td>
            <td align="left"><%= student.getScore() %></td>
            <td align="left"><%= student.getResult().toUpperCase() %></td>
        </tr>
        <% 
            }
        %>
    </table>
</body>
</html>
