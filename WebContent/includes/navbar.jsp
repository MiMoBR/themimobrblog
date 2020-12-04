<%@page import="com.mimobr.servlet.Blog"%>

<div class="col-md-3">
	<form id="toBlogForm" name="toBlogForm" action="http://localhost:8080/Mimobr/Blog" method="post" >
		<input type="hidden" id="cmd" name="cmd" value="<%=Blog.CMD_BLOG_MAIN%>"> 
		
		<a type="" onclick="sendBlog()" class="btn btn-dark">
			Blog
		</a>
	</form>
</div>
<div class="col-md-3">
	<a type="button" class="btn btn-dark" href="<%=request.getContextPath()%>/index.jsp">
		Index
	</a>
</div>
<div class="col-md-4 offset-md-2">
	<a type="button" class="btn btn-dark" href="<%=request.getContextPath()%>/access/login.jsp">
		Log In
	</a>
	<a type="button" class="btn btn-dark" href="<%=request.getContextPath()%>/access/signup.jsp">
		Sign Up
	</a>
</div>