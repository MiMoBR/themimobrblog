package com.mimobr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mimibr.utils.StringTasks;
import com.mimobr.objects.LogInForm;
import com.mimobr.objects.SaveContentForm;
import com.mimobr.objects.SignInForm;


public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String CMD_REDIRECT_LOGIN = "redirectLogin";
	public static final String CMD_LOGIN_FORM = "getLogInForm";
	public static final String CMD_SIGNIN_FORM = "getSignInForm";
	public static final String CMD_SAVE_CONTENT_FORM = "getSaveContentForm";

    public ServletForm() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = StringTasks.cleanStringFixXSS(request.getParameter("cmd"), CMD_REDIRECT_LOGIN);
		
		if(cmd != null){
			if(CMD_REDIRECT_LOGIN.equals(cmd)){
				redirectLogin(request, response);
			}else if(cmd.equals(CMD_LOGIN_FORM)){
				getLogInForm(request, response);
			}else if(cmd.equals(CMD_SIGNIN_FORM)){
				getSignInForm(request, response);
			}else if(cmd.equals(CMD_SAVE_CONTENT_FORM)){
				getSaveContentForm(request, response);
			}else{
				redirectLogin(request, response);
			}
		}
	}
	
	public void redirectLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "Arrume o que fazer da vida!!!";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/access/login.jsp").forward(request, response);
	}
	
	public void getSaveContentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("sssssssssss");
		try {
			SaveContentForm oSaveContentForm = null;
			
			String titleBO = request.getParameter("titleBO");
			String subTitleBO = request.getParameter("subTitleBO");
			String contentBO = request.getParameter("contentBO");
			String pic1BO = request.getParameter("pic1BO");
			String pic2BO = request.getParameter("pic2BO");
			String url1BO = request.getParameter("url1BO");
			String url2BO = request.getParameter("url2BO");
			String logoBO = request.getParameter("logoBO");
			String siteBO = request.getParameter("siteBO");
			String typeBO = request.getParameter("typeBO");
			String authorBO = request.getParameter("authorBO");
			String companyBO = request.getParameter("companyBO");
			String telephoneBO = request.getParameter("telephoneBO");
			String addressBO = request.getParameter("addressBO");
			String localityBO = request.getParameter("localityBO");
			String countyBO = request.getParameter("countyBO");
			String countryBO = request.getParameter("countryBO");
			String postCodeBO = request.getParameter("postCodeBO");
			String hashMapBO = request.getParameter("hashMapBO");
			String twitterBO = request.getParameter("twitterBO");
			String openingHoursBO = request.getParameter("openingHoursBO");
			String urlBO = request.getParameter("urlBO");
			
//			System.err.println("-titleBO--"+titleBO);
//			System.err.println("-subTitleBO--"+subTitleBO);
//			System.err.println("-contentBO--"+contentBO);
//			System.err.println("-pic1BO--"+pic1BO);
//			System.err.println("-pic2BO--"+pic2BO);
//			System.err.println("-url1BO--"+url1BO);
//			System.err.println("-url2BO--"+url2BO);
//			System.err.println("-logoBO--"+logoBO);
//			System.err.println("-siteBO--"+siteBO);
//			System.err.println("-typeBO--"+typeBO);
//			System.err.println("-authorBO--"+authorBO);
//			System.err.println("-companyBO--"+companyBO);
//			System.err.println("-telephoneBO--"+telephoneBO);
//			System.err.println("-addressBO--"+addressBO);
//			System.err.println("-localityBO--"+localityBO);
//			System.err.println("-countyBO--"+countyBO);
//			System.err.println("-countryBO--"+countryBO);
//			System.err.println("-postCodeBO--"+postCodeBO);
//			System.err.println("-hashMapBO--"+hashMapBO);
//			System.err.println("-twitterBO--"+twitterBO);
//			System.err.println("-openingHoursBO--"+openingHoursBO);
			
			oSaveContentForm = new SaveContentForm();
			
			oSaveContentForm.setTitleBO(titleBO);
			oSaveContentForm.setSubTitleBO(subTitleBO);
			oSaveContentForm.setContentBO(contentBO);
			oSaveContentForm.setPic1BO(pic1BO);
			oSaveContentForm.setPic2BO(pic2BO);
			oSaveContentForm.setUrl1BO(url1BO);
			oSaveContentForm.setUrl2BO(url2BO);
			oSaveContentForm.setLogoBO(logoBO);
			oSaveContentForm.setSiteBO(siteBO);
			oSaveContentForm.setTypeBO(typeBO);
			oSaveContentForm.setAuthorBO(authorBO);
			oSaveContentForm.setCompanyBO(companyBO);
			oSaveContentForm.setTelephoneBO(telephoneBO);
			oSaveContentForm.setAddressBO(addressBO);
			oSaveContentForm.setLocalityBO(localityBO);
			oSaveContentForm.setCountyBO(countyBO);
			oSaveContentForm.setCountryBO(countryBO);
			oSaveContentForm.setPostCodeBO(postCodeBO);
			oSaveContentForm.setHashMapBO(hashMapBO);
			oSaveContentForm.setTwitterBO(twitterBO);
			oSaveContentForm.setOpeningHoursBO(openingHoursBO);
			oSaveContentForm.setUrlBO(urlBO);
			
			
			SaveContentForm.getHelper().insert(oSaveContentForm, "RNCO");
			
			request.getRequestDispatcher("/backoffice/mainBackOffice.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getLogInForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogInForm oLogInForm = null;
		String message = "Operacao efectuada com sucesso";
		try{
			String emailLogIn = request.getParameter("emailLogIn");
			String passwordLogIn = request.getParameter("passwordLogIn");
			
			System.err.println("emailLogIn----"+emailLogIn);
			System.err.println("passwordLogIn------"+passwordLogIn);

			oLogInForm = new LogInForm(emailLogIn, passwordLogIn);
			
			boolean login = LogInForm.getHelper().getUserLogIn(oLogInForm);

			if(login==true){
				request.setAttribute("emailLogIn", emailLogIn);
				request.getRequestDispatcher("/backoffice/mainBackOffice.jsp").forward(request, response);				
			}else{
				message = "Nao cadastrado";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/access/login.jsp").forward(request, response);
			}

		} catch (ClassNotFoundException e) {
			message = "Matricula ja registada em sistema";
			e.printStackTrace();
		}
		
//		StringBuffer buffJson = new StringBuffer();
//		buffJson.append("{");
//		buffJson.append(QUOTES + "response"+QUOTES+":" + QUOTES + message + QUOTES + ",");
//		buffJson.append(QUOTES + "type"+QUOTES+":" + QUOTES + type + QUOTES);
//		buffJson.append("}");
//		
//		HttpTasks.sendBodyMessageToClient(response, buffJson.toString(), "UTF-8", "application/json");

	}
	
	public void getSignInForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignInForm oSignInForm = null;
		
		try{
			String emailSignIn = request.getParameter("emailSignIn");
			String passwordSignIn = request.getParameter("passwordSignIn");
			
			System.err.println("emailSignIn----"+emailSignIn);
			System.err.println("passwordSignIn------"+passwordSignIn);  

			oSignInForm = new SignInForm(emailSignIn, passwordSignIn);
			oSignInForm.setEmailLogIn(emailSignIn);
			oSignInForm.setPasswordLogIn(passwordSignIn);
			
			SignInForm.getHelper().insert(oSignInForm, "RNCO"); 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		request.getRequestDispatcher("/index.jsp").forward(request, response);	
	}
}
