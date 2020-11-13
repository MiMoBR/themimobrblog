package com.mimobr.commons.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  /**/
		
		String dbURL = "jdbc:sqlserver://localhost\\SQLLOCAL:1433;Database=MimobrBlog;";
		String user = "admin";
		String pwd = "admin1234567";
		
		Connection conn = DriverManager.getConnection(dbURL,user,pwd);
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
