<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" /> 
<title>Cart Empty</title>
<link href="/cart-empty.css" rel="stylesheet"/>
</head>
<body>
	<div id="header">
		<span>
			<p id="menu">
				<a href="/menu-item-list-customer">Menu</a>
				<a href="/show-cart?userId=${userId}">Cart</a>
			</p>
		</span>
		<h1>Cart<h1>
			</div>
		<h1>Cart is empty. Click to add to cart <a id="edit" href="menu-item-list-customer">Menu-item-list</a></h1>
	
</body>

</html>