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
<title>Rate A Farmer</title>
<link href="/rate.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
<div id="header">
		<span>
			<p id="menu">
				<a href="/menu-item-list-customer" class="link">Menu</a>
			</p>
		</span>
		<p id="description">We appreciate you for taking the time to
	complete this survey</p>
	
	</div>

<sf:form id="survey-form" action="/rate" modelAttribute="rating" method="GET">
<div class="form-group row">
		<label for="cname" class="col-sm-2" id="name-label">Your Name</label>
		<div class="col-sm-10">
		 <sf:input id="cname" name="cname"
			type="text" path="cname"  placeholder="CustomerName"
			required="true" />
			</div>
	</div>
	<div class="form-group row">
		<label for="fname" class="col-sm-2" id="name-label">Farmer's Name</label> 
		<div class="col-sm-10">
		<sf:input id="fname"
			type="text" path="fname" name="fname"  placeholder="FarmerName"
			required="true" />
			</div>
	</div>

	<div class="form-group row">
		<label for="email" class="col-sm-2"  id="email-label">Email</label>
		<div class="col-sm-10">
		 <sf:input id="email"
			type="email" path="email" name="email" required="true" placeholder="your email" />
			</div>
	</div>



	<div class="form-group row">
		<label for="rateService" class="col-sm-2"  id="rateService">Rate the service</label>
			<div class="col-sm-10">
	<sf:select
			name="rateService" path="rateService" id="rateService" required="true">
			<option value="3" disabled>--select an
				option--</option>
			<option value="1">1(Average)</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5" selected>5(Excellant)</option>
		</sf:select>
		</div>
	</div>

	<div class="form-group row">
		<label for="pros" class="col-sm-2">Pros</label>
			<div class="col-sm-10">
		<sf:input type="text" name="pros" path="pros" id="pros" placeholder="Enter pros here..."
			class="form-control form-control-lg" required="true"></sf:input>
			</div>
	</div>

	<div class="form-group row">
		<label for="cons"  class="col-sm-2">Cons</label>
			<div class="col-sm-10">
		<textarea id="cons" name="cons" placeholder="Enter cons here..."
			class="input-textarea"></textarea>
			</div>
	</div>

	<div class="form-group row">
		<label for="comments"class="col-sm-10" >Any comments or suggestions?</label>
		 <div class="col-sm-10">
		<sf:input type="text" path="comments" name="comments" id="comments" placeholder="Enter comments here..."
			class="form-control form-control-lg"></sf:input>
			</div>
	</div>
	<div class="form-group row"> 
		<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-info" onclick="myFunction()">
									Submit
								</button>
							</div>
		</div>

</sf:form>
	<script>
function myFunction() {
  alert("Order successfully updated");
}
</script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>	
</body>
</html>