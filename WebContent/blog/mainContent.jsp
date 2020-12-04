<%@page import="com.mimobr.servlet.Blog"%>
<%@page import="com.mimobr.innatilization.ApplicationConfiguration"%>
	<%
		String jSonFull = (String)request.getAttribute("jSonMainBlog");
	%>
	
	<form id="toDetailForm" name="toDetailForm" action="http://localhost:8080/Mimobr/Blog" method="post" >
		<input type="hidden" id="cmd" name="cmd" value="<%=Blog.CMD_CONTENT%>"> 
		<input type="hidden" id="urlDetail" name="urlDetail" value=""> 
		
		<div id="mainContent"></div>
	</form>

	<jsp:include page="/includes/scripts.jsp"></jsp:include>
	<script type="text/javascript">
		let theObj = <%= jSonFull %>;
		let ww = Object.keys(theObj);
		let theList = document.getElementById("mainContent");
	    
		let content = '';
			
		for(let i=0; i<ww.length;i++){
// 				console.log([i]);
// 				console.log(ww[i][0]);
			console.table(theObj[ww[i]][0]);
			let xxx = theObj[ww[i]][0];
			
			    content += "<div class='mainContentborder'>";
		    content += "<a class='mainContentOne' onclick='document.getElementById(\"urlDetail\").value=\""+theObj[ww[i]][0].ivUrlBO+"\";document.getElementById(\"toDetailForm\").submit();' target='_blank'>";
		    content += "	<div class='img'><img src='"+theObj[ww[i]][0].ivPic1BO+"' class='img-fluid' alt='"+theObj[ww[i]][0].ivTitleBO+"' title='"+theObj[ww[i]][0].ivTitleBO+"'></div>";
		    content += "	<div class='about'>";
		    content += "		<div><p class='author'>"+theObj[ww[i]][0].ivAuthorBO+"</p></div>";
		    content += "		<div><p class='date'>"+theObj[ww[i]][0].ivDtCreated+"</p></div>";
		    content += "	</div>";
		    content += "	<div>";
		    content += "		<div><h2 class='title'>"+theObj[ww[i]][0].ivTitleBO+"</h2></div>";
		    content += "		<div><p class='subTitle'>"+theObj[ww[i]][0].ivSubTitleBO+"</p></div>";
		    content += "	</div>";
		    content += "</a>";
		    content += "</div>";
		}
		theList.innerHTML = content;

	</script>