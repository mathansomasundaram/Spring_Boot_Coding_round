<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 --%>    
<!DOCTYPE html>
<html>
  <head>
    <title>Menu</title>
  </head>
  <body>
    <h1>Menu</h1>
   <%--  <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if> --%>
    <form action="process" method="post">
      <p>Select an option:</p>
      <ul>
        <li><input type="radio" name="option" value="insert">Insert data</li>
        <li><input type="radio" name="option" value="view">View all data</li>
        <li><input type="radio" name="option" value="rank">Get rank</li>
        <li><input type="radio" name="option" value="update">Update score</li>
        <li><input type="radio" name="option" value="delete">Delete one record</li>
      </ul>
      <input type="submit" value="Submit">
    </form>
  </body>
</html>
