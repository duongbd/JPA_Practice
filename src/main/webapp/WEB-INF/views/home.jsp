<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/22/2021
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ol>
    <c:forEach var="emp" items="${list}">

        <li>${emp.content}</li>
        <br>

    </c:forEach>
</ol>
</body>
</html>
