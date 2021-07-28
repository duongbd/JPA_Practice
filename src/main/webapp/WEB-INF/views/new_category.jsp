<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/27/2021
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <input type="text" name="nameCategory" placeholder="name" required><br>
    <input type="submit" value="create" formaction="/category/new" formmethod="post">
</form>
<h3 style="color: red">${err}</h3>
</body>
</html>
