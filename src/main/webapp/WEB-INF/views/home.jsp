<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/22/2021
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>List Blogs</h3>
<ol>
    <c:forEach var="emp" items="${list}">
        <li></p><a href="http://localhost:8080/${emp.id}">${emp.title}-${emp.date_create}</a></li>
    </c:forEach>
</ol>
<form>
<input type="submit" value="new" formaction="/newBlog" formmethod="get" >
</form>
</body>
</html>
