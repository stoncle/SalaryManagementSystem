package com.keshe.shujuku.hust;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class DBUtil {
	private Boolean connectionEstablished;
	private Boolean dbLogined;
	private Connection connection;
	
	public DBUtil() {
		connectionEstablished = false;
		dbLogined = false;
	}
	
	public Boolean establishConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");// ¶¯Ì¬¼ÓÔØmysqlÇý¶¯
		} catch(Exception e) {
			e.printStackTrace();
			connectionEstablished = false;
			return connectionEstablished;
		}
		connectionEstablished = true;
		return connectionEstablished;
	}
	
	public Boolean doDBLogin() {
		if(dbLogined == false) {
			if(!connectionEstablished) {
				this.establishConnection();
			}
			String url = "jdbc:mysql://localhost:3306/salary?"
	                + "user=root&password=&useUnicode=true&characterEncoding=UTF8";
			try {
				Connection conn = DriverManager.getConnection(url);
				connection = conn;
			} catch(SQLException e) {
				e.printStackTrace();
				dbLogined = false;
				return dbLogined;
			} catch(Exception e) {
				e.printStackTrace();
				dbLogined = false;
				return dbLogined;
			}
			dbLogined = true;
		}
		return dbLogined;
	}
	
	public void doDBLogout() {
		connection = null;
	}
	
	public Boolean doUserLogin(String username, String password) {
		if(!doDBLogin()) {
			return false;
		}
		try {
			Statement stmt = connection.createStatement();
	        String sql = "select * from users where id =" + username + " and password=" + password;
	        ResultSet result = stmt.executeQuery(sql);
	        if(result.first()) {
	        	return true;
	        }
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
