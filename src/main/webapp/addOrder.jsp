<%--
  Created by IntelliJ IDEA.
  User: OSIYOcomputers
  Date: 11.05.2024
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Add</title>
    <link rel="stylesheet" href="static/bootstrap.css">

</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header bg-dark text-white">
                    Order
                </div>
                <div class="card-body">
                    <form action="/add_order" method="POST">
                        <div class="form-group">
                            <label>Order Name</label>
                            <label>
                                <input type="text" class="form-control"  name="name" required placeholder="Name">
                            </label>
                        </div>
                        <button type="submit" class="btn btn-primary">Add Order</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
