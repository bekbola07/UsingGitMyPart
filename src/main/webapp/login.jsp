<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="static/bootstrap.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col text-right mt-3">
            <a href="/" class="btn btn-primary mr-2">Go home</a>
            <a href="/signup.jsp" class="btn btn-success">Sign up</a>
        </div>
    </div>
    <div class="card w-50 mx-auto my-5">
        <div class="card-header bg-dark text-white">Login</div>
        <div class="card-body">
            <form action="/auth/login" method="post">
                <div class="form-group">
                    <input class="form-control" type="text" placeholder="Login" name="login">
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" placeholder="Password" name="password">
                </div>
                <button type="submit" class="btn btn-dark">Login</button>
            </form>
        </div>
    </div>
</div>
</body>


</html>
