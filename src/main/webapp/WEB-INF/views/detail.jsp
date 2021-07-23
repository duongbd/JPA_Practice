<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/22/2021
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${list.title}</h3>
<form action="/modify/${list.id}" method="post">
    <textarea name="content" style="height: 300px;width: 70%">${list.content}</textarea><br>
    <input type="submit" value="modify">
</form>
<p>Writer: ${list.writer}</p>
<form>
<input type="submit" value="delete" formaction="/delete/${list.id}" formmethod="post">
<input type="submit" value="back" formaction="/" formmethod="get">
</form>
</body>
</html>
