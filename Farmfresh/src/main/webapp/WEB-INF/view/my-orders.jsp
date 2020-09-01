<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>My Orders</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link href="/myOrders.css" rel="stylesheet" />
</head>
<body>
	<div id="header">
		<span>
			<p id="menu">
				<a href="/menu-item-list-admin">Menu</a>
			</p>
		</span>
		<h1>
			Items in your cart
			<h1>
	</div>
	<div class="table-responsive">
		<table class="table table-striped">
			<tr>
				<th>Customer Name</th>
				<th>Items</th>
				<th>Delivery Status</th>
			</tr>
			<c:forEach var="entry" items="${myMap}">
				<tr>
					<td> <c:out value="${entry.key}" /></td>
					<td> <c:out value="${entry.value}" /></td>
					<td><form action="orderStatus">
					<input type="text" placeholder="Enter yes or no"  name="status" id="status"/>
					<input type="hidden" value="${entry.key}" name="cname" id="cname">
					<input type="submit" value="update" onclick="myFunction()">
					</form>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	
	<script>
function myFunction() {
  alert("Order successfully updated");
}
</script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>