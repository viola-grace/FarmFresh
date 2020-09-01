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
<title>View Rating</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link href="/cart.css" rel="stylesheet"/>
</head>
<body>
	<div id="header">
		<h1 id="description">Review</h1>
	</div>

		<div class="table-responsive-xl">
			<table class="table table-striped">
				<tr>
							<th>CustomerName</th>
							<th>FarmerName</th>
							<th>EmailID</th>
							<th>Rating</th>
							<th>PROS</th>
							<th>CONS</th>
							<th>Comments</th>
						</tr>
			<c:forEach var="ratingList" items="${ratingList}">
								<tr>
									<td>${ratingList.cname}</td>
									<td>${ratingList.fname}</td>
									<td>${ratingList.email}</td>
									<td>${ratingList.rateService}</td>
									<td>${ratingList.pros}</td>
									<td>${ratingList.cons}</td>
									<td>${ratingList.comments}</td>
								</tr>
						</c:forEach>
			</table>
			</div>
			
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>