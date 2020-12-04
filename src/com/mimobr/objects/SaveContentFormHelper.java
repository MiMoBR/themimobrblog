package com.mimobr.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.mimobr.commons.dbconnection.ConnectionFactory;

public class SaveContentFormHelper {

	public String getTableName() {
		return "BLOG_CONTENT";
	}
	
	public SaveContentForm rowToObject(ResultSet rs) {

		SaveContentForm oSaveContentForm = new SaveContentForm();
		
		try {
			oSaveContentForm.setId(rs.getInt("ID"));
			oSaveContentForm.setTitleBO(rs.getString("TITLE"));
			oSaveContentForm.setSubTitleBO(rs.getString("SUBTITLE"));
			oSaveContentForm.setContentBO(rs.getString("CONTENT"));
			oSaveContentForm.setPic1BO(rs.getString("PIC1"));
			oSaveContentForm.setPic2BO(rs.getString("PIC2"));
			oSaveContentForm.setUrl1BO(rs.getString("URL1"));
			oSaveContentForm.setUrl2BO(rs.getString("URL2"));
			oSaveContentForm.setLogoBO(rs.getString("SEOLOGO"));
			oSaveContentForm.setSiteBO(rs.getString("SEOSITE"));
			oSaveContentForm.setTypeBO(rs.getString("SEOTYPE"));
			oSaveContentForm.setAuthorBO(rs.getString("SEOAUTHOR"));
			oSaveContentForm.setCompanyBO(rs.getString("SEOCOMPANY"));
			oSaveContentForm.setTelephoneBO(rs.getString("SEOTELEPHONE"));
			oSaveContentForm.setAddressBO(rs.getString("SEOADDRESS"));
			oSaveContentForm.setLocalityBO(rs.getString("SEOLOCALITY"));
			oSaveContentForm.setCountyBO(rs.getString("SEOCOUNTY"));
			oSaveContentForm.setCountryBO(rs.getString("SEOCOUNTRY"));
			oSaveContentForm.setPostCodeBO(rs.getString("SEOPOSTECODE"));
			oSaveContentForm.setHashMapBO(rs.getString("SEOHASMAP"));
			oSaveContentForm.setTwitterBO(rs.getString("SEOTWITTER"));
			oSaveContentForm.setOpeningHoursBO(rs.getString("SEOOPENINGHOURS"));
			oSaveContentForm.setUrl1BO(rs.getString("URL"));
			oSaveContentForm.setDtCreated(rs.getTimestamp("DT_CREATED"));
		} catch (SQLException e) {
		}
		return oSaveContentForm;
	}
	
	public SaveContentForm insert(SaveContentForm oSaveContentForm, String createdBy) throws ClassNotFoundException  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer SQL_INSERT = new StringBuffer("");
	
		try {
			conn = ConnectionFactory.getConnection();
			
			SQL_INSERT.append("    INSERT INTO " + getTableName());
			SQL_INSERT.append("    (TITLE,SUBTITLE,CONTENT,PIC1,PIC2,URL1,URL2,SEOLOGO,SEOSITE,SEOTYPE,SEOAUTHOR,SEOCOMPANY,"
					+ "SEOTELEPHONE,SEOADDRESS,SEOLOCALITY,SEOCOUNTY,SEOCOUNTRY,SEOPOSTECODE,SEOHASMAP,SEOTWITTER,SEOOPENINGHOURS,URL) ");
			SQL_INSERT.append("     OUTPUT INSERTED.ID ");
			SQL_INSERT.append("     VALUES (?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?,?)");
			
			pstmt = conn.prepareStatement(SQL_INSERT.toString());
			
			if (oSaveContentForm !=  null){
				
				int pos = 1;
				pstmt.setString(pos++, oSaveContentForm.getTitleBO());
				pstmt.setString(pos++, oSaveContentForm.getSubTitleBO());
				pstmt.setString(pos++, oSaveContentForm.getContentBO());
				pstmt.setString(pos++, oSaveContentForm.getPic1BO());
				pstmt.setString(pos++, oSaveContentForm.getPic2BO());
				pstmt.setString(pos++, oSaveContentForm.getUrl1BO());
				pstmt.setString(pos++, oSaveContentForm.getUrl2BO());
				pstmt.setString(pos++, oSaveContentForm.getLogoBO());
				pstmt.setString(pos++, oSaveContentForm.getSiteBO());
				pstmt.setString(pos++, oSaveContentForm.getTypeBO());
				pstmt.setString(pos++, oSaveContentForm.getAuthorBO());
				pstmt.setString(pos++, oSaveContentForm.getCompanyBO());
				pstmt.setString(pos++, oSaveContentForm.getTelephoneBO());
				pstmt.setString(pos++, oSaveContentForm.getAddressBO());
				pstmt.setString(pos++, oSaveContentForm.getLocalityBO());
				pstmt.setString(pos++, oSaveContentForm.getCountyBO());
				pstmt.setString(pos++, oSaveContentForm.getCountryBO());
				pstmt.setString(pos++, oSaveContentForm.getPostCodeBO());
				pstmt.setString(pos++, oSaveContentForm.getHashMapBO());
				pstmt.setString(pos++, oSaveContentForm.getTwitterBO());
				pstmt.setString(pos++, oSaveContentForm.getOpeningHoursBO());
				pstmt.setString(pos++, oSaveContentForm.getUrlBO());
				
				System.out.println("SQL sys:" + SQL_INSERT.toString() + " " + oSaveContentForm.toString() + " createdBy:" + createdBy);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()){
					System.err.println(">>>>>>>>>>>>" +rs.getInt("ID"));
				}
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}				
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}

			ConnectionFactory.closeConnection(conn);
		}
		return oSaveContentForm;
	}
	
	public String blogMainJson() {
		
		HashMap<Integer, List<SaveContentForm>> map = new HashMap<Integer, List<SaveContentForm>>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer SQL = new StringBuffer("");
		
		try {
			conn = ConnectionFactory.getConnection();
			
			SQL.append(" SELECT * FROM " + getTableName() );

			pstmt = conn.prepareStatement(SQL.toString());
				
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				List<SaveContentForm> lstSaveContentForm = new ArrayList<SaveContentForm>();
				SaveContentForm oSaveContentForm = new SaveContentForm();
				oSaveContentForm.setId(rs.getInt("ID"));
				oSaveContentForm.setTitleBO(rs.getString("TITLE"));
				oSaveContentForm.setSubTitleBO(rs.getString("SUBTITLE"));
				oSaveContentForm.setContentBO(rs.getString("CONTENT"));
				oSaveContentForm.setPic1BO(rs.getString("PIC1"));
				oSaveContentForm.setPic2BO(rs.getString("PIC2"));
				oSaveContentForm.setUrl1BO(rs.getString("URL1"));
				oSaveContentForm.setUrl2BO(rs.getString("URL2"));
				oSaveContentForm.setLogoBO(rs.getString("SEOLOGO"));
				oSaveContentForm.setSiteBO(rs.getString("SEOSITE"));
				oSaveContentForm.setTypeBO(rs.getString("SEOTYPE"));
				oSaveContentForm.setAuthorBO(rs.getString("SEOAUTHOR"));
				oSaveContentForm.setCompanyBO(rs.getString("SEOCOMPANY"));
				oSaveContentForm.setTelephoneBO(rs.getString("SEOTELEPHONE"));
				oSaveContentForm.setAddressBO(rs.getString("SEOADDRESS"));
				oSaveContentForm.setLocalityBO(rs.getString("SEOLOCALITY"));
				oSaveContentForm.setCountyBO(rs.getString("SEOCOUNTY"));
				oSaveContentForm.setCountryBO(rs.getString("SEOCOUNTRY"));
				oSaveContentForm.setPostCodeBO(rs.getString("SEOPOSTECODE"));
				oSaveContentForm.setHashMapBO(rs.getString("SEOHASMAP"));
				oSaveContentForm.setTwitterBO(rs.getString("SEOTWITTER"));
				oSaveContentForm.setOpeningHoursBO(rs.getString("SEOOPENINGHOURS"));
				oSaveContentForm.setUrlBO(rs.getString("URL"));
				oSaveContentForm.setDtCreated(rs.getTimestamp("DT_CREATED"));
				
				lstSaveContentForm.add(oSaveContentForm);
				
				map.put(rs.getInt("ID"),lstSaveContentForm);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}				
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}

			ConnectionFactory.closeConnection(conn);
		}

		Gson gson  = new Gson();
		return gson.toJson(map);
	}
	
	public String blogSingleContentJson(String urlDetail) {
		
		HashMap<Integer, List<SaveContentForm>> map = new HashMap<Integer, List<SaveContentForm>>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer SQL = new StringBuffer("");
		
		try {
			conn = ConnectionFactory.getConnection();
			System.err.println("entrou              "+urlDetail);
			SQL.append(" SELECT * FROM " + getTableName() + " WHERE URL= ? ");

			pstmt = conn.prepareStatement(SQL.toString());

			int pos = 1;
			pstmt.setString(pos++, urlDetail);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				List<SaveContentForm> lstSaveContentForm = new ArrayList<SaveContentForm>();
				
				SaveContentForm oSaveContentForm = new SaveContentForm();
				oSaveContentForm.setId(rs.getInt("ID"));
				oSaveContentForm.setTitleBO(rs.getString("TITLE"));
				oSaveContentForm.setSubTitleBO(rs.getString("SUBTITLE"));
				oSaveContentForm.setContentBO(rs.getString("CONTENT"));
				oSaveContentForm.setPic1BO(rs.getString("PIC1"));
				oSaveContentForm.setPic2BO(rs.getString("PIC2"));
				oSaveContentForm.setUrl1BO(rs.getString("URL1"));
				oSaveContentForm.setUrl2BO(rs.getString("URL2"));
				oSaveContentForm.setLogoBO(rs.getString("SEOLOGO"));
				oSaveContentForm.setSiteBO(rs.getString("SEOSITE"));
				oSaveContentForm.setTypeBO(rs.getString("SEOTYPE"));
				oSaveContentForm.setAuthorBO(rs.getString("SEOAUTHOR"));
				oSaveContentForm.setCompanyBO(rs.getString("SEOCOMPANY"));
				oSaveContentForm.setTelephoneBO(rs.getString("SEOTELEPHONE"));
				oSaveContentForm.setAddressBO(rs.getString("SEOADDRESS"));
				oSaveContentForm.setLocalityBO(rs.getString("SEOLOCALITY"));
				oSaveContentForm.setCountyBO(rs.getString("SEOCOUNTY"));
				oSaveContentForm.setCountryBO(rs.getString("SEOCOUNTRY"));
				oSaveContentForm.setPostCodeBO(rs.getString("SEOPOSTECODE"));
				oSaveContentForm.setHashMapBO(rs.getString("SEOHASMAP"));
				oSaveContentForm.setTwitterBO(rs.getString("SEOTWITTER"));
				oSaveContentForm.setOpeningHoursBO(rs.getString("SEOOPENINGHOURS"));
				oSaveContentForm.setUrlBO(rs.getString("URL"));
				oSaveContentForm.setDtCreated(rs.getTimestamp("DT_CREATED"));
				
				lstSaveContentForm.add(oSaveContentForm);
				
				map.put(rs.getInt("ID"),lstSaveContentForm);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}				
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}

			ConnectionFactory.closeConnection(conn);
		}

		Gson gsonSingle  = new Gson();
		return gsonSingle.toJson(map);
	}
	
}