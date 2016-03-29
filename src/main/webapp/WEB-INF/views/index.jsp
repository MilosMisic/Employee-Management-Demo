<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<script type="text/javascript" src="resources/js/jquery-1.12.2.js"></script>
<link href='https://fonts.googleapis.com/css?family=Montserrat'
	rel='stylesheet' type='text/css'>
<title>Company</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to our store!</title>
</head>
<body>
<h1>meow</h1>
	<div id="inputDataWrapper">
		<a href="#" id="showEmployee">Add Employee</a>
		<div id="employeeDiv">
			<form id="employeeForm" action="addEmployee" method="post">
				<input type="hidden" name="employeeId" id="emId" /><br> <input
					type="text" name="firstName" id="firstName"
					placeholder="First Name" /> <br> <input type="text"
					name="lastName" id="lastName" placeholder="Last Name" /> <br>
				<input type="text" name="salary" id="salary" placeholder="Salary" /><br>
				<select id="company">
				</select> <input type="submit" value="Add" id="addButton" /><br> 
				<input type="submit" value="Save" id="saveButton" /><br> <br>
			</form>
			<button id="cancelEdit" >Cancel</button><br> <br>
		</div>
		<a href="#" id="showCompany">Add Company</a>
		<div id="companyDiv">
			<form action="addCompany" method="post">
				<input type="text" name="name" id="companyName"
					placeholder="Company Name" /> <br> <select
					id="companyCountry">
					<option style="color: gray">Company Country</option>
					<option>ARG</option>
					<option>ANG</option>
					<option>DEN</option>
					<option>FR</option>
					<option>ENG</option>
					<option>RU</option>
					<option>SRB</option>
					<option>USA</option>
				</select> <input type="submit" value="Add" id="addCompany" /><br> <br>
			</form>
		</div>
		<!--input end -->
	</div>
	<div id="wrapper">
		<div id="novi">
			<table>
				<thead>
					<th>Name</th>
					<th>Surname</th>
					<th>Salary</th>
					<th>Company</th>
				</thead>
			</table>
		</div>
	</div>
	<!-- Wrapper end -->
	<script type="text/javascript" src="resources/js/index.js"></script>
</body>
</html>