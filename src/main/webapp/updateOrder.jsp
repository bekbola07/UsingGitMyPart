<%@ page import="org.example.usinggitmypart.entity.OrderStatus" %>
<%@ page import="org.example.usinggitmypart.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.UUID" %>
<%@ page import="org.example.usinggitmypart.repo.OrderRepo" %><%--
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
    <%
        // Assuming you have a method to retrieve order by ID from OrderRepo
        UUID orderId = UUID.fromString(request.getParameter("id"));
        Order order = new OrderRepo().getById(orderId);

        // Assuming you have a method to get all order status values
        List<OrderStatus> orderStatusValues = List.of(OrderStatus.values());
    %>
</head>
<body>
<div class="container">
    <h2>Update Order</h2>
    <form action="updateOrder" method="post">
        <div class="form-group">
            <input type="hidden" class="form-control" id="id" name="id" value="<%= order.getId() %>" readonly>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="<%= order.getName() %>">
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <select class="form-control" id="status" name="status">
                <% for (OrderStatus status : orderStatusValues) { %>
                <option value="<%= status %>" <%= (status == order.getOrderStatus()) ? "selected" : "" %>><%= status %></option>
                <% } %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>

</body>
</html>
