<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/23/2021
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <input type="text" name="title" name="Form" placeholder="title" required><br>
    <textarea name="content" style="height: 300px;width: 70%" placeholder="content"></textarea><br>
    <input type="text" name="writer" placeholder="writer"><br>
    <input type="submit" value="create" formaction="/newBlog" formmethod="post">
</form>
</body>
</html>
