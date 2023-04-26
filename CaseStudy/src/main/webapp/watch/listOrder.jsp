<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2023/01/09
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Order</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<h1>List Order</h1>
<a href="/watches">Back to list watch</a><br/>

<table class="table table-sm table-dark">
  <thead>
  <tr>
    <th scope="col">OrderID</th>
    <th scope="col">Date</th>
    <th scope="col">Address Customer</th>
    <th scope="col">Total Price</th>
    <th scope="col">Status</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${requestScope['orders']}" var="orderdetail">
  <tr>
    <th scope="row">
      <a href="/watches?action=orderdetail&id=${orderdetail.getOrderID()}">${orderdetail.getOrderID()}</a>
        </th>
    <td>${orderdetail.getDate()}</td>
    <td>${orderdetail.getAddress()}</td>
    <td>$${orderdetail.getTotal()}</td>
    <td>
      <c:choose>
        <c:when test="${orderdetail.getStatus() == 0}">
          Processed
        </c:when>
        <c:when test="${orderdetail.getStatus() == 1}">
          Not processed yet
        </c:when>
      </c:choose>
    </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
