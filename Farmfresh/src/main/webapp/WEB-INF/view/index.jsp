<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html  lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>FarmFresh</title>
<link href="/index.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="title">
				<h1>FARM FRESH</h1>
			</div>
			<div class="verticalA">
     <p>Scroll to Login</p>
    </div><br><br><br>
<div class="indicator">
  <span></span>
  <span></span>
  <span></span>
  <span></span>
   <span></span>
</div>
			
		</div>

		<div class="section">
				<div class="content">
					<img class="mySlides" src="farmfresh1.png" style="width: 100%">
					<img class="mySlides" src="farmfresh2.png" style="width: 100%">
					<img class="mySlides" src="farmfresh3.png" style="width: 100%">
					<img class="mySlides" src="farmfresh4.png" style="width: 100%">
				</div>	
				
<div class="sub">
<a href="LoginAdmin" class="d-block btn btn-outline-light">		
				<div class="left">	
							<h2 class="text">Admin	</h2>
						Login/Signup
						<br>
							</div> 
						</a>
				<a href="LoginCustomer" class="d-block btn btn-outline-light">
					
					<div class="right">
						<h2 class="text">Customer</h2>	
					
						Login/Signup
						<br>
						</div>
						</a>
					<br>			
			</div>
			
			<div class="details">
					<h4>Call 90 2545 2545 | support@ffhp.in | WhatsApp 96771 15550(only messages)</h4>
					</div>
		</div>
	</div>
	
	
	<script>
		var myIndex = 0;
		carousel();

		function carousel() {
			var i;
			var x = document.getElementsByClassName("mySlides");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			myIndex++;
			if (myIndex > x.length) {
				myIndex = 1
			}
			x[myIndex - 1].style.display = "block";
			setTimeout(carousel, 2000); // Change image every 2 seconds
		}
	</script>

</body>
</html>