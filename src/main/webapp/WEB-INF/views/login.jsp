<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to our store!</title>
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<script type="text/javascript" src="resources/js/jquery-1.12.2.js"></script>
<script type="text/javascript" src="resources/js/login.js"></script>
<link href='https://fonts.googleapis.com/css?family=Montserrat'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<div id="loginWrapper">

		<div id="login">
			<form action="validateLogin" method="post">
				<input type="text" name="username" id="usernameLog"
					placeholder="username" /> <br> <input type="password"
					name="password" id="passwordLog" placeholder="password" /> <br>
				<input type="submit" value="Login" id="loginButton" /><br> <br>
			</form>
			<a href="#" id="createNew">Create new account</a>
		</div>
		<!-- /Login-->
		<div id="register">
			<form action="addUser" method="post">
				<input type="text" name="username" id="username"
					placeholder="Username" /> <br> <input type="password"
					name="password" id="password" placeholder="Password" /> <br>
				<input type="submit" value="Register" id="registerButton" /><br>
				<br>
			</form>
			<form:errors path="user.*" id="error" />
			<a href="#" id="backToLogin">Back to login</a>
			<div id="success">
				<img id="slika" src="resources/images/success.png" />
			</div>
		</div>
		<!-- /Register-->
	</div>
	<!-- /loginWrapper-->
</body>
</html>