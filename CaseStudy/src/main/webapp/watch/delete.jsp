<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2023/01/04
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Watch</title>
</head>
<body>
<h1>Delete Watch</h1>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Watch information</legend>
        <table>
            <tr>
                <td>ID: ${requestScope["product"].getId()} </td>
            </tr>
            <tr>
                <td>Name: ${requestScope["product"].getName()} </td>
            </tr>
            <tr>
                <td>Price: ${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Description: ${requestScope["product"].getDescription()}</td>
            </tr>
            <tr>
                <td>Maker: ${requestScope["product"].getImg()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete"></td>
                <td><a href="/watches">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
    <c:if test="${requestScope['message'] !=null}">
        <script>
            alert("Successful deleted")
        </script>
    </c:if>
</form>
</body>
</html>
