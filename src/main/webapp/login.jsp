<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Login</title>

</head>

<body>

	<h2>User Login</h2>

	<!--
    Sends login details to LoginServlet
-->

	<form action="login" method="post">
s
		Email : <input type="email" name="email"> <br>
		<br> Password : <input type="password" name="password"> <br>
		<br> <input type="submit" value="Login">

	</form>

	<br> New User?

	<a href="signup.jsp">Register Here</a>

</body>

</html>