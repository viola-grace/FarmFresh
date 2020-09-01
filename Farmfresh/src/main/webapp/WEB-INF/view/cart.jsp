<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" /> 
<title>My cart</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link href="/cart.css" rel="stylesheet"/>
</head>
<body>
	<div id="header">
		<span>
			<p id="menu">
				<a href="/menu-item-list-customer">Menu</a>
			</p>
		</span>
		<h1 class="title">Items in your cart<h1>
		</div>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
							<th>Farmer Name</th>
							<th>Item Name</th>
							<th>Price</th>
							<th>Category</th>
							<th>Quantity</th>
							<th>Location</th>
							<th>Bill amount</th>
							<th></th>
						</tr>
			<c:forEach var="menu" items="${menuItem}">
								<tr>
									<td>${menu.farmerName}</td>
									<td>${menu.itemName}</td>
									<td>${menu.price}</td>
									<td>${menu.category}</td>
									<td>${menu.quantity}</td>
									<td>${menu.location}</td>
									<td>${menu.price*menu.quantity}</td>
									<td><a id="edit" href="remove-cart-item?menuItemId=${menu.id}">DELETE</a></td>
								</tr>
						</c:forEach>
			</table>
			</div>
			<div class="total">
			<h6>Pay Bill on delivery</h6></p>
			<h3><a class="exit" href="/">Click here to Exit</a> </h3>
			</div>
			
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>