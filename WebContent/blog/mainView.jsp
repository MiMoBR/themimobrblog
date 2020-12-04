<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		
		<jsp:include page="/includes/top.jsp"></jsp:include>
		
	</head>
	<body>
		<div class="container">
			<div class="row">
				<jsp:include page="/includes/navbar.jsp"></jsp:include>
				<div class="col-md-12">
					<h1>
						Our content for you!
					</h1>
				</div>
				<div class="col-md-12">
					<h2>Choose which one that you want to want!</h2> 
					<jsp:include page="mainContent.jsp"></jsp:include>
				</div>		
			</div>
		</div>
	</body>
</html>