<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        function validateForm() {
            var admin=document.getElementById("username").valueOf()
            var password1 = document.getElementById("password1").value;
            var password2 = document.getElementById("password2").value;
            if ((password1 !== password2) && admin==="admin") {
                alert("Incorrect data");
                return false;
            }
            return true;
        }
    </script>
</head>


<body>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header bg-dark text-white">Sign Up</div>
                <div class="card-body">
                    <form action="/auth/signup" method="post" onsubmit="return validateForm()">
                        <div class="form-group">
                            <br>
                            <label for="username">Username:</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="form-group">
                            <label for="password1">Password:</label>
                            <input type="password" class="form-control" id="password1" name="password1" required>
                        </div>
                        <div class="form-group">
                            <label for="password2">Confirm Password:</label>
                            <input type="password" class="form-control" id="password2" name="password2" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Sign Up</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<%-- Check if no image is selected, then display default image --%>
    <% String imgFileName = request.getParameter("img"); %>
    <% if (imgFileName == null || imgFileName.isEmpty()) { %>
    <% } %>
</html>
