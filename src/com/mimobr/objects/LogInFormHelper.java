package com.mimobr.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mimobr.commons.dbconnection.ConnectionFactory;



public class LogInFormHelper {


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
	
	public boolean  getUserLogIn(LogInForm oLogInForm) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer SQL = new StringBuffer("");
		boolean login = false;
		
		try {
			conn = ConnectionFactory.getConnection();
			
				SQL.append("    SELECT * FROM " + getTableName()	);
				SQL.append("	WHERE LOGIN = ? AND PASSWORD = ? "	);
				 
				pstmt = conn.prepareStatement(SQL.toString());
					
				int pos = 1;
				pstmt.setString(pos++, oLogInForm.getEmailLogIn());
				pstmt.setString(pos++, oLogInForm.getPasswordLogIn());
				
				
				System.out.println("SQL sys:" + SQL.toString() + " " + oLogInForm.toString() );
				
				rs = pstmt.executeQuery();
				
				while (rs.next()){
					System.err.println("ENTROU NO TRUE");
					login = true;
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
		return login;
	}
}