<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2023/01/04
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Watch</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<h1>List Watch</h1>
<a href="/watches?action=create">Create New Watch</a><br/>
<a href="/Users">HOMEPAGE</a><br/>
<a href="/watches?action=listorder">LIST ORDER</a>
<form method="get">
    <p>Search Product By ID: </p><br/>
    <input type="hidden" name="action" value="viewid">
    <input type="text" name="viewid">
    <input type="submit" value="Search">
</form>
<form method="get">
    <p>Search Product By Name: </p><br/>
    <input type="hidden" name="action" value="viewname">
    <input type="text" name="viewname">
    <input type="submit" value="Search">
</form>

<table class="table table-striped" border="1px" width="80%">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name Watch</th>
        <th scope="col">Price</th>
        <th scope="col">Description</th>
        <th scope="col">Type</th>
        <th scope="col">img</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${requestScope['watchs']}" var="product">
        <tr>
            <th scope="row">${product.getId()}</th>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getType()}</td>
            <td>${product.getImg()}</td>
            <td>
                <a href="/watches?action=edit&id=${product.getId()}">Edit</a>
                <a href="/watches?action=delete&id=${product.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
