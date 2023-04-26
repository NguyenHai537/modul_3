<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2023/01/04
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Watch</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<h1>Update Information Watch</h1>
<a href="/watches">Back to list product</a>
<form method="post">
    <div class="form-group">
        <label >ID</label>
        <input type="text" class="form-control" disabled placeholder="${requestScope['product'].getId()}" aria-describedby="emailHelp" name="id">
    </div>
    <div class="form-group">
        <label > New Watch Name</label>
        <input type="text" class="form-control"  name="name">
    </div>
    <div class="form-group">
        <label > New Price</label>
        <input type="text" class="form-control"  name="price">
    </div>
    <div class="form-group">
        <label > New Description</label>
        <input type="text" class="form-control"  name="description">
    </div>
    <div class="form-group">
        <label >New Image</label>
        <input type="text" class="form-control"  name="img">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>

    <h3>
        <c:if test="${requestScope['message'] != null}">
            ${requestScope["message"]}
        </c:if>
    </h3>
</form>
</body>
</html>
