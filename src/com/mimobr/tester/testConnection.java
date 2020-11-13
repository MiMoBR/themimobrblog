package com.mimobr.tester;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mimobr.commons.dbconnection.ConnectionFactory;


public class testConnection {

	public static void main(String[] args) {

		Connection conn = null;        
		
			try{
				conn = ConnectionFactory.getConnection();
				
				if (conn != null) {
					
					DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
					System.out.println("Driver name: " + dm.getDriverName());
					System.out.println("Driver version: " + dm.getDriverVersion());
					System.out.println("Product name: " + dm.getDatabaseProductName());
					System.out.println("Product version: " + dm.getDatabaseProductVersion());
					
					insertTest(conn);
				}
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println("---Test Connection ClassNotFoundException----"+ e.getMessage());
			}catch (SQLException e) {
				e.printStackTrace();
				System.err.println("---Test Connection SQLException----"+ e.getMessage());
			}finally{
				ConnectionFactory.closeConnection(conn);				
			}
	}
	
	public static void insertTest(Connection conn) throws ClassNotFoundException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer SQL_INSERT = new StringBuffer("");
		try {
			conn = ConnectionFactory.getConnection();
			SQL_INSERT.append("    INSERT INTO MIMOBR_USER_LOGON") ;
			SQL_INSERT.append("    (LOGIN,PASSWORD) ");
			SQL_INSERT.append(" 	OUTPUT INSERTED.ID ");
			SQL_INSERT.append("     VALUES ('rey80sp@gmail.com', '123456')");

			pstmt = conn.prepareStatement(SQL_INSERT.toString());
			rs = pstmt.executeQuery();
			if (rs.next())
				System.err.println(">>>>>>>>>>>>" +rs.getInt("ID"));

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
	}

}
