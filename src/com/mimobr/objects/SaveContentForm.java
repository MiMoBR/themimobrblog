package com.mimobr.objects;

import java.sql.Timestamp;

public class SaveContentForm {

	protected int ivId;
	protected String ivTitleBO;
	protected String ivSubTitleBO;
	protected String ivContentBO;
	protected String ivPic1BO;
	protected String ivPic2BO;
	protected String ivUrl1BO;
	protected String ivUrl2BO;
	protected String ivLogoBO;
	protected String ivSiteBO;
	protected String ivTypeBO;
	protected String ivAuthorBO;
	protected String ivCompanyBO;
	protected String ivTelephoneBO;
	protected String ivAddressBO;
	protected String ivLocalityBO;
	protected String ivCountyBO;
	protected String ivCountryBO;
	protected String ivPostCodeBO;
	protected String ivHashMapBO;
	protected String ivTwitterBO;
	protected String ivOpeningHoursBO;
	protected String ivUrlBO;
	protected Timestamp ivDtCreated;
	
	protected static SaveContentFormHelper SaveContentFormHelperInstance;

	public String getTableName() {
		return getHelper().getTableName();
	}
	
	public static SaveContentFormHelper getHelper() {
		if (SaveContentFormHelperInstance == null)
			SaveContentFormHelperInstance = new SaveContentFormHelper();
		return SaveContentFormHelperInstance;
	}
	
	public SaveContentForm() {
	}
	
	public SaveContentForm(
			String titleBO, 
			String subTitleBO,
			String contentBO,
			String pic1BO,
			String pic2BO,
			String url1BO,
			String url2BO,
			String logoBO,
			String siteBO,
			String typeBO,
			String authorBO,
			String companyBO,
			String telephoneBO,
			String addressBO,
			String localityBO,
			String countyBO,
			String countryBO,
			String postCodeBO,
			String hashMapBO,
			String twitterBO,
			String openingHoursBO,
			String urlBO
		){
		ivTitleBO = titleBO;
		ivSubTitleBO = subTitleBO;
		ivContentBO = contentBO;
		ivPic1BO = pic1BO;
		ivPic2BO = pic2BO;
		ivUrl1BO = url1BO;
		ivUrl2BO = url2BO;
		ivLogoBO = logoBO;
		ivSiteBO = siteBO;
		ivTypeBO = typeBO;
		ivAuthorBO = authorBO;
		ivCompanyBO = companyBO;
		ivTelephoneBO = telephoneBO;
		ivAddressBO = addressBO;
		ivLocalityBO = localityBO;
		ivCountyBO = countyBO;
		ivCountryBO = countryBO;
		ivPostCodeBO = postCodeBO;
		ivHashMapBO = hashMapBO;
		ivTwitterBO = twitterBO;
		ivOpeningHoursBO = openingHoursBO;
		ivUrlBO = urlBO;
	}

	public int getId() {
		return ivId;
	}

	public void setId(int id) {
		ivId = id;
	}

	public String getTitleBO() {
		return ivTitleBO;
	}

	public void setTitleBO(String titleBO) {
		ivTitleBO = titleBO;
	}

	public String getSubTitleBO() {
		return ivSubTitleBO;
	}

	public void setSubTitleBO(String subTitleBO) {
		ivSubTitleBO = subTitleBO;
	}

	public String getContentBO() {
		return ivContentBO;
	}

	public void setContentBO(String contentBO) {
		ivContentBO = contentBO;
	}

	public String getPic1BO() {
		return ivPic1BO;
	}

	public void setPic1BO(String pic1bo) {
		ivPic1BO = pic1bo;
	}

	public String getPic2BO() {
		return ivPic2BO;
	}

	public void setPic2BO(String pic2bo) {
		ivPic2BO = pic2bo;
	}

	public String getUrl1BO() {
		return ivUrl1BO;
	}

	public void setUrl1BO(String url1bo) {
		ivUrl1BO = url1bo;
	}

	public String getUrl2BO() {
		return ivUrl2BO;
	}

	public void setUrl2BO(String url2bo) {
		ivUrl2BO = url2bo;
	}

	public String getLogoBO() {
		return ivLogoBO;
	}

	public void setLogoBO(String logoBO) {
		ivLogoBO = logoBO;
	}

	public String getSiteBO() {
		return ivSiteBO;
	}

	public void setSiteBO(String siteBO) {
		ivSiteBO = siteBO;
	}

	public String getTypeBO() {
		return ivTypeBO;
	}

	public void setTypeBO(String typeBO) {
		ivTypeBO = typeBO;
	}

	public String getAuthorBO() {
		return ivAuthorBO;
	}

	public void setAuthorBO(String authorBO) {
		ivAuthorBO = authorBO;
	}

	public String getCompanyBO() {
		return ivCompanyBO;
	}

	public void setCompanyBO(String companyBO) {
		ivCompanyBO = companyBO;
	}

	public String getTelephoneBO() {
		return ivTelephoneBO;
	}

	public void setTelephoneBO(String telephoneBO) {
		ivTelephoneBO = telephoneBO;
	}

	public String getAddressBO() {
		return ivAddressBO;
	}

	public void setAddressBO(String addressBO) {
		ivAddressBO = addressBO;
	}

	public String getLocalityBO() {
		return ivLocalityBO;
	}

	public void setLocalityBO(String localityBO) {
		ivLocalityBO = localityBO;
	}

	public String getCountyBO() {
		return ivCountyBO;
	}

	public void setCountyBO(String countyBO) {
		ivCountyBO = countyBO;
	}

	public String getCountryBO() {
		return ivCountryBO;
	}

	public void setCountryBO(String countryBO) {
		ivCountryBO = countryBO;
	}

	public String getPostCodeBO() {
		return ivPostCodeBO;
	}

	public void setPostCodeBO(String postCodeBO) {
		ivPostCodeBO = postCodeBO;
	}

	public String getHashMapBO() {
		return ivHashMapBO;
	}

	public void setHashMapBO(String hashMapBO) {
		ivHashMapBO = hashMapBO;
	}

	public String getTwitterBO() {
		return ivTwitterBO;
	}

	public void setTwitterBO(String twitterBO) {
		ivTwitterBO = twitterBO;
	}

	public String getOpeningHoursBO() {
		return ivOpeningHoursBO;
	}

	public void setOpeningHoursBO(String openingHoursBO) {
		ivOpeningHoursBO = openingHoursBO;
	}

	public Timestamp getDtCreated() {
		return ivDtCreated;
	}

	public void setDtCreated(Timestamp dtCreated) {
		ivDtCreated = dtCreated;
	}

	public static SaveContentFormHelper getSaveContentFormHelperInstance() {
		return SaveContentFormHelperInstance;
	}

	public static void setSaveContentFormHelperInstance(SaveContentFormHelper saveContentFormHelperInstance) {
		SaveContentFormHelperInstance = saveContentFormHelperInstance;
	}
	
	public String getUrlBO() {
		return ivUrlBO;
	}

	public void setUrlBO(String urlBO) {
		ivUrlBO = urlBO;
	}

	@Override
	public String toString() {
		return "SaveContentForm [ivId=" + ivId + ", ivTitleBO=" + ivTitleBO + ", ivSubTitleBO=" + ivSubTitleBO
				+ ", ivContentBO=" + ivContentBO + ", ivPic1BO=" + ivPic1BO + ", ivPic2BO=" + ivPic2BO + ", ivUrl1BO="
				+ ivUrl1BO + ", ivUrl2BO=" + ivUrl2BO + ", ivLogoBO=" + ivLogoBO + ", ivSiteBO=" + ivSiteBO
				+ ", ivTypeBO=" + ivTypeBO + ", ivAuthorBO=" + ivAuthorBO + ", ivCompanyBO=" + ivCompanyBO
				+ ", ivTelephoneBO=" + ivTelephoneBO + ", ivAddressBO=" + ivAddressBO + ", ivLocalityBO=" + ivLocalityBO
				+ ", ivCountyBO=" + ivCountyBO + ", ivCountryBO=" + ivCountryBO + ", ivPostCodeBO=" + ivPostCodeBO
				+ ", ivHashMapBO=" + ivHashMapBO + ", ivTwitterBO=" + ivTwitterBO + ", ivOpeningHoursBO="
				+ ivOpeningHoursBO + ", ivUrlBO=" + ivUrlBO + ", ivDtCreated=" + ivDtCreated + "]";
	}

}