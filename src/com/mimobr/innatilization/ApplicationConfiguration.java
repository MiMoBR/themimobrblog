package com.mimobr.innatilization;

import com.mimobr.objects.SaveContentForm;

public class ApplicationConfiguration {
	
	private static ApplicationConfiguration ivInstance = null;
	protected static String jsonFullContent = null;
	protected static String jsonSingleContent = null;

	public static ApplicationConfiguration getInstance() {
		if (ivInstance == null)
			ivInstance = new ApplicationConfiguration();

		return ivInstance;
	}
	
	public void Reload() {	
		ivInstance = null;
	}

	private ApplicationConfiguration() {
		getBlogMain();
		getInstanceSingleContent();
	}

	public String getBlogMain(){
		if(jsonFullContent==null || jsonFullContent.equals("")){
			jsonFullContent = SaveContentForm.getHelper().blogMainJson();
		}
		return jsonFullContent;
	}
	
	public String getInstanceSingleContent(){
		if(jsonSingleContent==null || jsonSingleContent.equals("")){
			String urlDetail = null;
			jsonSingleContent = SaveContentForm.getHelper().blogSingleContentJson(urlDetail);
		}
		return jsonSingleContent;
	}
	
}