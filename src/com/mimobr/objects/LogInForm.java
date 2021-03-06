package com.mimobr.objects;

import java.sql.Timestamp;
//import org.apache.log4j.Logger;



public class LogInForm {

//	private final static Logger logger = Logger.getLogger(LogInForm.class.getName());
	
	protected int ivId;
	protected String ivEmailLogIn;
	protected String ivPasswordLogIn;
	protected Timestamp ivDtCreated;
	
	protected static LogInFormHelper LogInFormHelperInstance;

	public String getTableName() {
		return getHelper().getTableName();
	}
	
	public static LogInFormHelper getHelper() {
		if (LogInFormHelperInstance == null)
			LogInFormHelperInstance = new LogInFormHelper();
		return LogInFormHelperInstance;
	}
	
	public LogInForm() {
	}
	
	public LogInForm(String emailLogIn, String passwordLogIn){
		ivEmailLogIn = emailLogIn;
		ivPasswordLogIn = passwordLogIn;
	}

	public int getId() {
		return ivId;
	}

	public void setId(int id) {
		ivId = id;
	}

	public String getEmailLogIn() {
		return ivEmailLogIn;
	}

	public void setEmailLogIn(String emailLogIn) {
		ivEmailLogIn = emailLogIn;
	}

	public String getPasswordLogIn() {
		return ivPasswordLogIn;
	}

	public void setPasswordLogIn(String passwordLogIn) {
		ivPasswordLogIn = passwordLogIn;
	}

	public Timestamp getDtCreated() {
		return ivDtCreated;
	}

	public void setDtCreated(Timestamp dtCreated) {
		ivDtCreated = dtCreated;
	}
	
	@Override
	public String toString() {
		return "LogInForm [ivId=" + ivId + ", ivEmailLogIn=" + ivEmailLogIn + ", ivPasswordLogIn=" + ivPasswordLogIn
				+ ", ivDtCreated=" + ivDtCreated + "]";
	}	
	
	
}