<%--
  Created by IntelliJ IDEA.
  User: OSIYOcomputers
  Date: 12.05.2024
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update order</title>
    <link rel="stylesheet" href="static/bootstrap.css">
</head>
<body>
<div class="container">
    <h2>Update Order</h2>
    <form action="updateOrder" method="post">
        <div class="form-group">
            <label for="orderId">Order ID:</label>
            <input type="text" class="form-control" id="orderId" name="orderId" value="${order.id}" readonly>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${order.name}">
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <select class="form-control" id="status" name="status">
                <option value="CREATED" <c:if test="${order.orderStatus == 'CREATED'}">selected</c:if>>Created</option>
                <option value="PROCESSING" <c:if test="${order.orderStatus == 'PROCESSING'}">selected</c:if>>Processing</option>
                <option value="COMPLETED" <c:if test="${order.orderStatus == 'COMPLETED'}">selected</c:if>>Completed</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>

</body>
</html>
