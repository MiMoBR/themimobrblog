
<%@page import="com.mimobr.innatilization.ApplicationConfiguration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		
		<jsp:include page="/includes/top.jsp"></jsp:include>
		
	</head>
	<%
		String jSon = (String)request.getAttribute("jSon");
	
	%>
	<body>
		<div class="container">
			<div class="row">
				<jsp:include page="/includes/navbar.jsp"></jsp:include>

				<div class="col-md-12">
					
					<div id="mainContent"></div>
				</div>		
			</div>
		</div>
		<jsp:include page="/includes/scripts.jsp"></jsp:include>
		<script type="text/javascript">
 			var theObj = <%= jSon %>;
 			console.log(theObj);
 			console.table(theObj);
 			
			var ww = Object.keys(theObj);
			var theList = document.getElementById("mainContent");
		    
			let content = '';
			
			for(let i=0; i<ww.length;i++){
// 				console.log([i]);
// 				console.log(ww[i][0]);
				console.log(theObj[ww[i]][0]);
				console.table(theObj[ww[i]][0]);
				
 			    content += "<div class='mainContentborder'>";
			    content += "	<div class='img'><img src='"+theObj[ww[i]][0].ivPic1BO+"' class='img-fluid' alt='"+theObj[ww[i]][0].ivTitleBO+"' title='"+theObj[ww[i]][0].ivTitleBO+"'></div>";
			    content += "	<div class='about'>";
			    content += "		<div><p class='author'>"+theObj[ww[i]][0].ivAuthorBO+"</p></div>";
			    content += "		<div><p class='date'>"+theObj[ww[i]][0].ivDtCreated+"</p></div>";
			    content += "	</div>";
			    content += "	<div>";
			    content += "		<div><h2 class='title'>"+theObj[ww[i]][0].ivTitleBO+"</h2></div>";
			    content += "		<div><p class='subTitle'>"+theObj[ww[i]][0].ivSubTitleBO+"</p></div>";
			    content += "	</div>";
			    content += "</div>";
			}
			theList.innerHTML = content;

	    </script>
	</body>
</html>