package com.mimobr.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mimobr.commons.dbconnection.ConnectionFactory;

public class SignInFormHelper {

	public String getTableName() {
		return "MIMOBR_USER_LOGON";
	}
	
	public SignInForm rowToObject(ResultSet rs) {

		SignInForm oSignInForm = new SignInForm();
		
		try {
			oSignInForm.setId(rs.getInt("ID"));
			oSignInForm.setEmailLogIn(rs.getString("LOGIN"));
			oSignInForm.setPasswordLogIn(rs.getString("PASSWORD"));
			oSignInForm.setDtCreated(rs.getTimestamp("DT_CREATED"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return oSignInForm;
	}
	
	public SignInForm insert(SignInForm oSignInForm, String createdBy) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer SQL_INSERT = new StringBuffer("");
	
		try {
			conn = ConnectionFactory.getConnection();
			
			SQL_INSERT.append("    INSERT INTO " + getTableName());
			SQL_INSERT.append("    (LOGIN,PASSWORD) ");
			SQL_INSERT.append("     OUTPUT INSERTED.ID ");
			SQL_INSERT.append("     VALUES (?, ?)");
			

			pstmt = conn.prepareStatement(SQL_INSERT.toString());
			
			if (oSignInForm !=  null){
				
				int pos = 1;
				pstmt.setString(pos++, oSignInForm.getEmailLogIn());
				pstmt.setString(pos++, oSignInForm.getPasswordLogIn());
				
				
				System.out.println("SQL sys:" + SQL_INSERT.toString() + " " + oSignInForm.toString() + " createdBy:" + createdBy);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()){
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
		return oSignInForm;
	}
}