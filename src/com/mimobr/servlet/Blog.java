package com.mimobr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mimibr.utils.StringTasks;
import com.mimobr.innatilization.ApplicationConfiguration;
import com.mimobr.objects.SaveContentForm;


public class Blog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String CMD_BLOG_MAIN = "getMainBlog";
	public static final String CMD_CONTENT = "detailSearch";

    public Blog() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = StringTasks.cleanStringFixXSS(request.getParameter("cmd"), "");
		
		String[] url = request.getRequestURI().split("/");
		String urlContent = url[url.length-1];
		
		if(!urlContent.equals("") && cmd.equals("") && !urlContent.equals("Blog")){
			cmd = CMD_CONTENT;
		}
		
		System.err.println("entrou");
		if(cmd != null){
			if(CMD_BLOG_MAIN.equals(cmd)){
				getMainBlog(request, response);//blog main
			}else if(CMD_CONTENT.equals(cmd)){
				detailSearch(request, response,urlContent);//blog content
			}else{
				getMainBlog(request, response);//blog main
			}
		}
	}	
	
	private void getMainBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("getmenu");
		String jSonMainBlog = SaveContentForm.getHelper().blogMainJson();
		request.setAttribute("jSonMainBlog", jSonMainBlog);
		
		request.getRequestDispatcher("/blog/mainView.jsp").forward(request, response);
	}

	public void detailSearch(HttpServletRequest request, HttpServletResponse response, String urlContent) throws ServletException, IOException {
		String urlDetail = StringTasks.cleanStringFixXSS(request.getParameter("urlDetail"), "");
		
		String jSon = "";
		
		if(urlDetail.equals("")){
			jSon = SaveContentForm.getHelper().blogSingleContentJson(urlContent);
		}else{
			jSon = SaveContentForm.getHelper().blogSingleContentJson(urlDetail);			
		}
		

		request.setAttribute("jSon", jSon);
		
		request.getRequestDispatcher("/blog/general.jsp").forward(request, response);
	}
}
