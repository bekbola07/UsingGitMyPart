<%@ page import="org.example.usinggitmypart.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.usinggitmypart.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="static/bootstrap.css">
    <style>
        .navbar-nav {
            margin-left: auto;
        }
    </style>
</head>
<body>
<%
    User currentUser = (User) session.getAttribute("currentUser");
    System.out.println(currentUser);

    List<Order> orders = new ArrayList<>();

    if (currentUser!=null && currentUser.getOrder()!=null) {
        orders=currentUser.getOrder();
        System.out.println(currentUser);
    }else {
    }
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="navbar-nav ml-auto">
        <a class="nav-item nav-link" href="/signup.jsp">Sign Up</a>
        <a class="nav-item nav-link" href="/login.jsp">Login</a>
    </div>
</nav>

<div class="container mt-4">
    <h2>Orders</h2>
    <div class="mb-2">
        <a href="addOrder.jsp" class="btn btn-success">Create Order</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>Order Name</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% for (Order order : orders) { %>
        <tr>
            <td><%= order.getName() %></td>
            <td><%= order.getOrderStatus()  %></td>
            <td>
                <button type="button" class="btn btn-primary">View</button>
                <button type="button" class="btn btn-danger">Delete</button>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

</body>
</html>