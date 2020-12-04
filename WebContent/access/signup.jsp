
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
							Let´s work toghter?
						</h1>
					</div>
				</div>
				<div class="col-md-6 offset-md-3">
					<div style="text-align: center;">
						<form id="signInForm" name="signInForm" action="http://localhost:8080/Mimobr/Servlet"  method="post" >
							<input type="hidden" id="cmd" name="cmd" value="<%=ServletForm.CMD_SIGNIN_FORM%>"> 
							
							<div class="form-group">
								<label for="emailSignIn">Login</label>
								<input type="email" class="form-control" id="emailSignIn" name="emailSignIn" 
								aria-describedby="emailHelp">
<!-- 								<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
							</div>
							<div class="form-group">
								<label for="passwordSignIn">Password </label>
								<input type="password" class="form-control" id="passwordSignIn" name="passwordSignIn">
							</div>
							<a type="submit" onclick="sendSignIn()" class="btn btn-primary">
								Join
							</a>
						</form>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/includes/scripts.jsp"></jsp:include>
	</body>
</html>