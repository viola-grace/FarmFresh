<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/success.css" rel="stylesheet"/>
<meta name="viewport" content="width=device-width, initial-scale=1" /> 
</head>
<body>
<h2>Successful</h2>
<div class="container" id="container">
	<div class="form-container sign-up-container">
	<div class="section">
	<center>
	<h1>Thank you !! ${name}</h1>
	<h2>Click here</h2>
	<button><a href="LoginCustomer">Login</a></button>
	</center>
	</div>
	</div>
	</div>
</body>
</html>