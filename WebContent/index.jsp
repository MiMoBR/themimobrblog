<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		
		<jsp:include page="/includes/top.jsp"></jsp:include>
<!-- 		http://localhost:8080/Mimobr/index.jsp   -->
	</head>
	<body>
		<div class="container">
			<div class="row">
				<jsp:include page="/includes/navbar.jsp"></jsp:include>
				<div class="col-md-12">
					<h1>
						The blog!
					</h1>
				</div>
			</div>
		</div>
		<jsp:include page="/includes/scripts.jsp"></jsp:include> 
	</body>
</html>