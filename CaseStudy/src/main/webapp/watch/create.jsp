<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2023/01/04
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Watch</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<h1>Create New Watch</h1><br/>
<a href="/watches">Back to list product</a>
<form method="post">
    <div class="form-group">
        <label >ID</label>
        <input type="text" class="form-control" disabled placeholder="ID auto incremental" aria-describedby="emailHelp" name="id">
    </div>
    <div class="form-group">
        <label >Watch Name</label>
        <input type="text" class="form-control"  name="name">
    </div>
    <div class="form-group">
        <label >Price</label>
        <input type="text" class="form-control"  name="price">
    </div>
    <div class="form-group">
        <label >Description</label>
        <input type="text" class="form-control"  name="description">
    </div>
    <div class="form-group">
        <label >Type</label>
        <input type="text" class="form-control"  name="type">
    </div>
    <div class="form-group">
        <label >Img</label>
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
