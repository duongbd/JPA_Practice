<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/22/2021
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>List Blogs For ${name}</h3>
<ul>
    <c:forEach var="emp" items="${list}">
        <li><form><a href="http://localhost:8080/blog/${emp.id}">${emp.title}-${emp.dateCreate}</a>

            <input type="submit" value="delete" formaction="/blog/delete/${emp.id}" formmethod="post">
            </form>
        </li>
    </c:forEach>
</ul>
<c:forEach var="emp" items="${count}">
       <a href="http://localhost:8080/category/${name}/${emp}">${emp}</a>
</c:forEach>

</body>
</html>
