package com.mimobr.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mimobr.commons.dbconnection.ConnectionFactory;



public class LogInFormHelper {

	private final static Logger logger = Logger.getLogger(LogInFormHelper .class.getName());

	public String getTableName() {
		return "MIMOBR_USER_LOGON";
	}
	
	public LogInForm rowToObject(ResultSet rs) {

		LogInForm oLogInForm = new LogInForm();
		
		try {
			oLogInForm.setId(rs.getInt("ID"));
			oLogInForm.setEmailLogIn(rs.getString("LOGIN"));
			oLogInForm.setPasswordLogIn(rs.getString("PASSWORD"));
			oLogInForm.setDtCreated(rs.getTimestamp("DT_CREATED"));
		} catch (SQLException e) {
		}
		return oLogInForm;
	}
	
	public LogInForm insert(LogInForm oLogInForm, String createdBy) throws ClassNotFoundException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer SQL_INSERT = new StringBuffer("");
		try {
			conn = ConnectionFactory.getConnection();
			
			if (conn!= null){
				SQL_INSERT.append("    INSERT INTO " + getTableName());
				SQL_INSERT.append("    (LOGIN,PASSWORD) ");
				SQL_INSERT.append("     VALUES (?, ?)");

				pstmt = conn.prepareStatement(SQL_INSERT.toString());
				
				if (oLogInForm !=  null){
					
					int pos = 1;
					pstmt.setString(pos++, oLogInForm.getEmailLogIn());
					pstmt.setString(pos++, oLogInForm.getPasswordLogIn());
					
					System.out.println("SQL sys:" + SQL_INSERT.toString() + " " + oLogInForm.toString() + " createdBy:" + createdBy);
					
					rs = pstmt.executeQuery();
					
//					if (rs.next())
//						System.err.println(">>>>>>>>>>>>" +rs.getInt("ID"));
				}
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			
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
		return oLogInForm;
	}
}