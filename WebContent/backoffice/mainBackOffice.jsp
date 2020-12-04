
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
		<div class="container-fluid">
			<div class="row">
				<jsp:include page="/includes/navbarLogged.jsp"></jsp:include>
				<div class="col-md-6 offset-md-3">
					<div style="text-align: center;">
						<h1>
							Welcome ${emailLogIn}!
						</h1>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<form id="saveContentForm" name="saveContentForm" method="post" action="http://localhost:8080/Mimobr/ServletForm">
						<input type="hidden" id="cmd" name="cmd" value="<%=ServletForm.CMD_SAVE_CONTENT_FORM%>"> 
					
						<div class="form-group">
							<label for="titleBO">Title</label>
							<input type="text" class="form-control" id="titleBO" name="titleBO" maxlength="149">
						</div>
						<div class="form-group">
							<label for="subTitleBO">SubTitle</label>
							<input type="text" class="form-control" id="subTitleBO" name="subTitleBO" maxlength="249">
						</div>
						<div class="form-group">
							<label for="contentBO">Content</label>
							<textarea rows="5" cols="5" class="form-control" id="contentBO" name="contentBO"></textarea>
						</div>
						<div class="form-group">
							<label for="pic1BO">Pic 1</label>
							<input type="text" class="form-control" id="pic1BO" name="pic1BO" maxlength="299">
						</div>
						<div class="form-group">
							<label for="pic2BO">Pic 2</label>
							<input type="text" class="form-control" id="pic2BO" name="pic2BO" maxlength="299">
						</div>
						<div class="form-group">
							<label for="ur12BO">URL 1</label>
							<input type="text" class="form-control" id="url1BO" name="url1BO" maxlength="299">
						</div>
						<div class="form-group">
							<label for="url2BO">URL 2</label>
							<input type="text" class="form-control" id="url2BO" name="url2BO" maxlength="299">
						</div>
						<div class="form-group">
							<label for="logoBO">Logo</label>
							<input type="text" class="form-control" id="logoBO" name="logoBO" maxlength="299">
						</div>
						<div class="form-group">
							<label for="siteBO">Site URL</label>
							<input type="text" class="form-control" id="siteBO" name="siteBO" maxlength="299">
						</div>
						<div class="form-group">
							<label for="typeBO">Type</label>
							<input type="text" class="form-control" id="typeBO" name="typeBO" maxlength="49">
						</div>
						<div class="form-group">
							<label for="authorBO">Author</label>
							<input type="text" class="form-control" id="authorBO" name="authorBO" maxlength="99">
						</div>
						<div class="form-group">
							<label for="companyBO">Company Name</label>
							<input type="text" class="form-control" id="companyBO" name="companyBO" maxlength="99">
						</div>
						<div class="form-group">
							<label for="telephoneBO">Telephone</label>
							<input type="text" class="form-control" id="telephoneBO" name="telephoneBO" maxlength="99">
						</div>
						<div class="form-group">
							<label for="addressBO">Address</label>
							<input type="text" class="form-control" id="addressBO" name="addressBO" maxlength="99">
						</div>
						<div class="form-group">
							<label for="localityBO">Locality</label>
							<input type="text" class="form-control" id="localityBO" name="localityBO" maxlength="99">
						</div>
						<div class="form-group">
							<label for="countyBO">County</label>
							<input type="text" class="form-control" id="countyBO" name="countyBO" maxlength="99">
						</div>
						<div class="form-group">
							<label for="countryBO">Country</label>
							<input type="text" class="form-control" id="countryBO" name="countryBO" maxlength="99">
						</div>
						<div class="form-group">
							<label for="postCodeBO">PostCode</label>
							<input type="text" class="form-control" id="postCodeBO" name="postCodeBO" maxlength="99">
						</div>
						<div class="form-group">
							<label for="hashMapBO">HasMap</label>
							<input type="text" class="form-control" id="hashMapBO" name="hashMapBO" maxlength="299">
						</div>
						<div class="form-group">
							<label for="twitterBO">Twitter</label>
							<input type="text" class="form-control" id="twitterBO" name="twitterBO" maxlength="99">
						</div>
						<div class="form-group">
							<label for="openingHoursBO">Opening Hours</label>
							<input type="text" class="form-control" id="openingHoursBO" name="openingHoursBO" maxlength="149">
						</div>						
						<div class="form-group">
							<label for="urlBO">url</label>
							<input type="text" class="form-control" id="urlBO" name="urlBO" maxlength="299">
						</div>
						
						<a type="submit" onclick="saveContent()" class="btn btn-primary">Save</a>
					</form>
				</div>
			</div>						
		</div>
		<jsp:include page="/includes/scripts.jsp"></jsp:include>
	</body>
</html>