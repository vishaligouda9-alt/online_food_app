<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>

<body>

    <h2>User Registration</h2>

    <!--
        This form sends the user data to RegisterServlet.
        method="post" is used because we are inserting data.
    -->
    <form action="register" method="post">

        Name :
        <input type="text" name="fullName">
        <br><br>

        Email :
        <input type="email" name="email">
        <br><br>

        Password :
        <input type="password" name="password">
        <br><br>

        Phone :
        <input type="text" name="phone">
        <br><br>

        Address :
        <textarea name="address"></textarea>
        <br><br>

        <input type="submit" value="Register">

    </form>

    <br>

    Already Registered?

    <a href="login.jsp">Login Here</a>

</body>
</html>