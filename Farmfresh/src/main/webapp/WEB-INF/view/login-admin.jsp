<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/LoginCustomer.css" rel="stylesheet"/>
<meta name="viewport" content="width=device-width, initial-scale=1" /> 
</head>
<body>



<h2>FarmFresh Sign in/up Form</h2>
<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form action="success" method="post">
			<h1>Create Account</h1>
			UserName<input type="text" pattern=".{3,}" placeholder="UserName" id="username" name="username"/>
			Email<input type="email" pattern=".{4,}" placeholder="Email" id="email" name="email"/>
			Password<input type="password" pattern=".{1,}" placeholder="Password" id="pswd" name="pswd"/>
			<button type="submit">Signup</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="loginAdmin" method="post">
			<h1>Sign in</h1>
			<div class="error">
			<h1>${msg}</h1>
			</div>
			UserName<input type="username" placeholder="username" id="username" name="username"/>
			Password<input type="password" placeholder="Password" id="password" name="password"/>
			<button type="submit">Sign in</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome</h1>
				<p>To keep connected with us please login with your personal info</p>
				<button class="ghost" id="signIn">Sign in</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Welcome</h1>
				<p>Enter your details to register</p>
				<button class="ghost" id="signUp">Sign up</button>
			</div>
		</div>
	</div>
</div>
<script>
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});
</script>
</body>
</html>
