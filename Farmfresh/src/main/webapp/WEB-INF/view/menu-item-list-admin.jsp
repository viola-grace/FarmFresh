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
<title>Admin Page</title>
<link href="/menu-item-list-admin.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<div id="header">
		<span>
			<p id="menu">
				<a href="myOrders" class="link">My Orders</a>
			</p>
			<p id="menu">
				<a href="viewRate?farmerName=${farmerName}" class="link">View Rating</a>
			</p>
			<p id="menu">
				<a href="/" class="link">Sign out</a>
			</p>
		</span>
		<h1 class="title">Farm Fresh</h1>
		<c:if test="${addItemStatus==true}">
		<h3>Item Added Successfully</h3>
		</c:if>
	</div>


	<ul class="tabs" role="tablist">
		<li><input type="radio" name="tabs" id="tab1" checked /> 
		<label class="labelhead" for="tab1" role="tab" aria-selected="true" aria-controls="panel1"
			tabindex="0">ADD</label>
			<div id="tab-content1" class="tab-content" role="tabpanel"
				aria-labelledby="description" aria-hidden="false">
				<sf:form class="form-group" action="menu-item-list-admin"
					role="form" method="GET" modelAttribute="hai">

						<div class="form-group row">
							<label class="col-sm-2" for="farmerName">Farmer Name:</label>
							<div class="col-sm-10">
								<sf:input type="text" path="farmerName" name="farmerName" value="${farmerName}" required="true"/>
								
							</div>
							</div>
						
							<div class="form-group row">
							<label class="control-label col-sm-2" for="location">Location:</label>
							<div class="col-sm-10">
								<sf:input type="text" path="location" name="location" placeholder="Eg.No.x, yy street,zzz" required="true"/>
								<sf:errors path="location" cssClass="error"/>
							</div>
							</div>

						<div class="form-group row">
							<label class="control-label col-sm-2" for="category"> Category</label>
							<div class="col-sm-10">
								<sf:select path="category" >
									<option value="Vegetable">Vegetable</option>
									<option value="Fruit">Fruit</option>
								</sf:select>
								<sf:errors path="category" cssClass="error"/>
							</div>
							</div>
							
							<div class="form-group row">
								<label class="control-label col-sm-2" for="itemName">Item Name:</label>
								<div class="col-sm-10 col-sm-2">
									<sf:input type="text" path="itemName" name="itemName" required="true" placeholder="Eg.Tomato" />
									<sf:errors path="itemName" cssClass="error"/>
								</div>
							</div>
							
							<div class="form-group row">
								<label class="control-label col-sm-2" for="price">Price:</label>

								<div class="col-sm-10">
									<sf:input type="number" path="price" name="price" step="0.01" required="true"/>
									<sf:errors path="price" cssClass="error"/>
								</div>
							</div>
						
						
					<sf:input type="hidden" path="quantity" id="quantity" name="quantity" value="1" />
							

						<div class="form-group row">
							<label class="control-label col-sm-2" for="active">Stock:</label>
							<div class="col-sm-10">
								<sf:input type="number" path="stock" name="stock" step="0.01" required="true"/>
								<sf:errors path="stock" cssClass="error"/>
							</div>

						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-info">
									Submit
								</button>
							</div>
						</div>
				</sf:form>

			</div></li>

		<li><input type="radio" name="tabs" id="tab2" /> 
		<label class="labelhead" for="tab2" role="tab" aria-selected="false" aria-controls="panel2"
			tabindex="0">View my account</label>
			<div id="tab-content2" class="tab-content" role="tabpanel"
				aria-labelledby="specification" aria-hidden="true">
				<div class="table-responsive-xl">
					<table class="table table-striped">
						<tr>
						<th>Farmer Name</th>
							<th>Item Name</th>
							<th>Price</th>
							<th>Category</th>
							<th>Stock</th>
							<th>Location</th>
							<th>Action</th>
						</tr>
						<c:forEach var="menu" items="${menuItem}">
							<tr>
								<td>${menu.farmerName}</td>
								<td>${menu.itemName}</td>
								<td>${menu.price}</td>
								<td>${menu.category}</td>
								<td>${menu.stock}</td>
								<td>${menu.location}</td>
								<td><a href="show-edit-menu-item?menuItemId=${menu.id}" id="edit">EDIT</a></td>
								<c:if test="${menu.stock==0}">
									<td><h3>
										Stock empty
									</h3></td>
								</c:if>
							</tr>			
						</c:forEach>
					</table>
				</div>
			</div></li>
			
			
	</ul>
	
</body>
</html>