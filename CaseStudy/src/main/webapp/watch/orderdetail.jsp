<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2023/01/09
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>OrderDetail</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<form method="post">
<fieldset>
    <legend><h3>Order Information: </h3></legend>
    <a href="/watches">Back to List Watch</a>
    <a href="/watches?action=listorder">Back to List Order</a>
    <h5>Order ID: ${requestScope['order'].getOrderID()} </h5>
    <h5>Customer Address: ${requestScope['order'].getAddress()} </h5><br/>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th scope="col">Watch ID</th>
        <th scope="col">Watch Name</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
        <th scope="col">Subtotal</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${requestScope['items']}" var="item">
      <tr>
        <th scope="row">${item.getWatch().getId()}</th>
        <td>${item.getWatch().getName()}</td>
        <td>${item.getWatch().getPrice()}</td>
        <td>${item.getQuantity()}</td>
        <td>$${item.getWatch().getPrice() * item.getQuantity()}</td>
      </tr>
      </c:forEach>
      <c:if test="${requestScope['order'].getStatus() == 1}">
          <input type="submit" value="Process">
      </c:if>
      </tbody>
    </table>
  </fieldset>
</form>
</body>
</html>
