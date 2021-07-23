<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/22/2021
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ol>
    <c:forEach var="emp" items="${list}">
        <a href="http://localhost:8080/blog/${emp.id}">${emp.title}</a>
    </c:forEach>
</ol>

</body>
</html>
