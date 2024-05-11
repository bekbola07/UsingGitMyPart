<%@ page import="org.example.usinggitmypart.repo.OrderRepo" %>
<%@ page import="org.example.usinggitmypart.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%
    OrderRepo orderRepo = new OrderRepo();
    List<Order> all = orderRepo.getAll();
    for (Order order : all) {
        System.out.println(order);
    }
%>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>