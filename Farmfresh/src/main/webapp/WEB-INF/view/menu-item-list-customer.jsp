<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Items</title>
<link href="/menu-item-list-customer.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
	<div id="header">
		<span>
			<p class="menu">
				<a href="/" class="link">Sign out</a>
				<a href="/show-cart?userId=${userId}" class="link">Cart</a>
			</p> <a href="/EnterRate" class="menu">Rate a farmer</a>
		</span>
		<h1>Farm Fresh</h1>
		<c:if test="${addCartStatus==true}">
			<h2>
				Item Added Successfully
			</h2>
		</c:if>
		<c:if test="${addCartStatus==false}">
			<h2>${alert}</h2>
		</c:if>
	</div>
	<div class="mapsection">
	<p>Click on View larger map to search in google maps</p>
	<iframe
				src="https://maps.google.com/maps?q=chicago&t=&z=13&ie=UTF8&iwloc=&output=embed"
				frameborder="0" style="border: 0; position:absolute; right:20px;" width="350px" height="50px;" allowfullscreen></iframe>
	</div>
	<div class="list-content">
	<ul class="tabs" role="tablist">
		<li><input type="radio" name="tabs" id="tab1" checked /> <label
			for="tab1" role="tab" aria-selected="true" aria-controls="panel1"
			tabindex="0">Vegetables</label>
			<div id="tab-content1" class="tab-content" role="tabpanel"
				aria-labelledby="description" aria-hidden="false">
				<div class="table-responsive-xl">
					<table class="table table-striped">
						<tr>
							<th>Farmer Name</th>
							<th>Item Name</th>
							<th>Price</th>
							<th>Category</th>
							<th>Location</th>
							<th>Quantity</th>
							<th>Review</th>

						</tr>
						<c:forEach var="menu" items="${menuItemVeg}">
							<tr>
								<td>${menu.farmerName}</td>
								<td>${menu.itemName}</td>
								<td>${menu.price}</td>
								<td>${menu.category}</td>
								<td>${menu.location}</td>
								<td>
									<form action="add-to-cart">
										<input type="hidden" name="id" value="${menu.id}">
										<div class="col-sm-2">
											<input type="text" name="quantity"
												placeholder="available stock ${menu.stock}Kg"/>
										</div>
										<div class="col-sm-2">
											<input type="submit" value="ADD TO CART">
										</div>
									</form>
								</td>
								<td><a href="/viewRate?farmerName=${menu.farmerName}">View
										review</a></td>
							</tr>

						</c:forEach>
					</table>
				</div>
			</div></li>

		<li><input type="radio" name="tabs" id="tab2" /> 
		<label for="tab2" role="tab" aria-selected="false" aria-controls="panel2"
			tabindex="0">Fruits</label>
			<div id="tab-content2" class="tab-content" role="tabpanel"
				aria-labelledby="specification" aria-hidden="true">
				<div class="table-responsive-xl">
					<table class="table table-striped">
						<tr>
							<th>Farmer Name</th>
							<th>Item Name</th>
							<th>Price</th>
							<th>Category</th>
							<th>Location</th>
							<th>Quantity</th>
							<th>Review</th>
						</tr>
						<c:forEach var="menu" items="${menuItemFruit}">
							<tr>
								<td>${menu.farmerName}</td>
								<td>${menu.itemName}</td>
								<td>${menu.price}</td>
								<td>${menu.category}</td>
								<td>${menu.location}</td>
								<td>
									<form action="add-to-cart">
										<input type="hidden" name="id" value="${menu.id}">
										<div class="col-sm-2">
											<input type="text" name="quantity"
												placeholder="available stock ${menu.stock}Kg"/>
										</div>
										<div class="col-sm-2">
											<input type="submit" value="ADD TO CART">
										</div>
									</form>
								</td>
								<td><a href="/viewRate?farmerName=${menu.farmerName}">View
										review</a></td>
							</tr>

						</c:forEach>
					</table>

				</div>
			</div></li>
	</ul>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>