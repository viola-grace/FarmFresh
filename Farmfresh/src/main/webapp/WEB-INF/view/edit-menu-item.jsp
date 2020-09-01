<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" /> 
<title>Edit</title>
<link href="/edit-menu-item.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
	<div id="header">
		<span>
			<p id="menu">
				<a href="/menu-item-list-admin">Menu</a>
			</p>
		</span>
		<h1>FreshFarm</h1>
	</div>
	<div class="container">
	<h1>Menu</h1>
	<sf:form class="form-horizontal" action="edit-menu-item1"
					role="form" method="post" modelAttribute="hai">
						<div class="form-group row">
							<label class="col-sm-2" for="farmerName">Farmer Name:</label>
							<div class="col-sm-10">
								<sf:input type="text" path="farmerName" name="farmerName" />
								<sf:errors path="farmerName"></sf:errors>	
							</div>
							</div>
						
							<div class="form-group row">
							<label class="control-label col-sm-2" for="location">Location:</label>
							<div class="col-sm-10">
								<sf:input type="text" path="location" value="${menuItemObj.location}" name="location" />
								<sf:errors path="location"></sf:errors>
							</div>
							</div>

						<div class="form-group row">
							<label class="control-label col-sm-2" for="category">Category</label>
							<div class="col-sm-10">
								<sf:select path="category" value="${menuItemObj.category}">
									<option value="Vegetable">Vegetable</option>
									<option value="Fruit">Fruit</option>
								</sf:select>
								<sf:errors path="category"></sf:errors>
							</div>
							</div>
							
							<div class="form-group row">
								<label class="control-label col-sm-2" for="itemName">Item Name:</label>
								<div class="col-sm-10 col-sm-2">
									<sf:input type="text" path="itemName" name="itemName" value="${menuItemObj.itemName}" />
									<sf:errors path="itemName"></sf:errors>
								</div>
							</div>
							
							<div class="form-group row">
								<label class="control-label col-sm-2" for="price">Price:</label>

								<div class="col-sm-10">
									<sf:input type="number" path="price" name="price" step="0.01" value="${menuItemObj.price}"/>
									<sf:errors path="price"></sf:errors>
								</div>
							</div>
						

					<sf:input type="hidden" path="quantity" id="quantity" name="quantity" value="1"/>
							

						<div class="form-group row">
							<label class="control-label col-sm-2" for="stock">Stock:</label>
							<div class="col-sm-10">
								<sf:input type="number" path="stock" name="stock" step="0.01" value="${menuItemObj.stock}" />
								<sf:errors path="stock"></sf:errors>
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

	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>	
</body>
</html>