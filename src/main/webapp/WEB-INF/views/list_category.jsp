<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/26/2021
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;  charset=utf-8">
    <title>2 Column Frames Layout &mdash; Right Menu</title>
    <style type="text/css">

        body {
            margin: 0;
            padding: 0;
            overflow: hidden;
            height: 100%;
            max-height: 100%;
            font-family: Sans-serif;
            line-height: 1.5em;
        }

        #nav {
            position: absolute;
            top: 0;
            bottom: 0;
            right: 0;
            width: 230px; /* Width of navigation frame */
            height: 100%;
            overflow: hidden; /* Disables scrollbars on the navigation frame. To enable scrollbars, change "hidden" to "scroll" */
            background: #eee;
        }

        main {
            position: fixed;
            top: 0;
            left: 0;
            right: 230px; /* Set this to the width of the navigation frame */
            bottom: 0;
            overflow: auto;
            background: #fff;
        }

        .innertube {
            margin: 15px; /* Provides padding for the content */
        }

        p {
            color: #555;
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        nav ul a {
            color: darkgreen;
            text-decoration: none;
        }

        /*IE6 fix*/
        * html body {
            padding: 0 230px 0 0; /* Set the second value to the width of the navigation frame */
        }

        * html main {
            height: 100%;
            width: 100%;
        }

    </style>

</head>

<body>

<main>
    <div class="innertube" >

        <h1><a style="color: aqua" href="http://localhost:8080">Home</a></h1>
        <form>
            <input type="text" name="title" placeholder="title" required>
            <input type="submit" value="Search" formaction="/searchBlog" formmethod="get">
        </form>
        <h3>List Categories</h3>
        <h5>${notFound}</h5>
        <ul>
            <c:forEach var="emp" items="${blogList}">
                <li>
                    <form>
                        <a href="http://localhost:8080/blog/${emp.id}">${emp.title}-${emp.dateCreate}</a>
                        <input type="submit" value="delete" formaction="/blog/delete/${emp.id}" formmethod="post">
                    </form>
                </li>
            </c:forEach>
        </ul>

    </div>
</main>

<nav id="nav">
    <div class="innertube">
        <h3>List Categories</h3>
        <ul>
            <c:forEach var="emp" items="${list}">
                <li>
                    <form>
                        <a href="http://localhost:8080/category/${emp.name}/1"
                        >${emp.name}</a>
                        <input type="submit" value="delete" formaction="category/delete/${emp.name}" formmethod="post">
                    </form>
                </li>
            </c:forEach>
            <li>
                <a href="http://localhost:8080/category/uncategory/1"
                >Non-Category</a>
            </li>
        </ul>

        <form>
            <input type="submit" value="New Category" formaction="category/new" formmethod="get">
            <input type="submit" value="New Blog" formaction="/blog/newBlog" formmethod="get">
        </form>
    </div>
</nav>

</body>
</html>

