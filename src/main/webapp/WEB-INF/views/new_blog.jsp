<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/23/2021
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <input type="text" name="title" placeholder="title" required><br>
    <textarea name="content" style="height: 300px;width: 70%" placeholder="content"></textarea><br>
    <select id="nameCategory" name="nameCategory" style="width: 100px; margin: 10px">
        <c:forEach var="emp" items="${categoryList}">
            <option value=${emp.name}>${emp.name}</option>
        </c:forEach>
        <option value="">None</option>
    </select>
    <input type="text" name="writer" placeholder="writer"><br><br>
    <input type="submit" value="create" formaction="/blog/newBlog" formmethod="post">
</form>
<h3 style="color: red">${err}</h3>
</body>
</html>
