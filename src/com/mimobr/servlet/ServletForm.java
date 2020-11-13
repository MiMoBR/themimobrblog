package com.mimobr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mimobr.objects.LogInForm;


public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String CMD_LOGIN_FORM = "getLogInForm";
	
    public ServletForm() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		if(cmd != null){
			if(cmd.equals(CMD_LOGIN_FORM)){
				getLogInForm(request, response);
			}
		}
	}
	
	public void getLogInForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogInForm oLogInForm = null;
		
		try{
			String emailLogIn = request.getParameter("emailLogIn");
			String passwordLogIn = request.getParameter("passwordLogIn");
			
			System.err.println("emailLogIn----"+emailLogIn);
			System.err.println("passwordLogIn------"+passwordLogIn);

			oLogInForm = new LogInForm(emailLogIn, passwordLogIn);
			oLogInForm.setEmailLogIn(emailLogIn);
			oLogInForm.setPasswordLogIn(passwordLogIn);
			
			LogInForm.getHelper().insert(oLogInForm, "RNCO");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		request.getRequestDispatcher("/index.jsp").forward(request, response);	
	}
}
