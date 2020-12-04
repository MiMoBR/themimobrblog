
<%@page import="com.mimobr.servlet.ServletForm"%>
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
					<div style="text-align: center;">
						<h1>
							Welcome Back! ${message}
						</h1>
					</div>
				</div>
				<div class="col-md-6 offset-md-3">
					<div style="text-align: center;">
						<form id="logInForm" name="logInForm" action="http://localhost:8080/Mimobr/ServletForm" method="post" >
							<input type="hidden" id="cmd" name="cmd" value="<%=ServletForm.CMD_LOGIN_FORM%>"> 
							
							<div class="form-group">
								<label for="emailLogIn">Login</label>
								<input type="email" class="form-control" id="emailLogIn" name="emailLogIn" 
								aria-describedby="emailHelp">
<!-- 								<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
							</div>
							<div class="form-group">
								<label for="passwordLogIn">Password </label>
								<input type="password" class="form-control" id="passwordLogIn" name="passwordLogIn">
							</div>
							<a type="submit" onclick="sendLogIn()" class="btn btn-primary">
								Sign In
							</a>
						</form>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/includes/scripts.jsp"></jsp:include>
	</body>
</html>