package com.keshe.shujuku.hust;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
	private Boolean isInit;
	private Boolean isAdmin;
	
	private static class LazyHolder {
		private static final UserManager INSTANCE = new UserManager();
	}
	private UserManager (){
		isInit = false;
		isAdmin = false;
	}
	public static final UserManager getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	public void initWithDBData(ResultSet set) {
		if(!isInit) {
			try {
				isAdmin = set.getInt("usertype") == 1 ? true : false;
			} catch(SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
			isInit = true;
		}
	}
	
	public Boolean isAdminUser() {
		return isAdmin;
	}
}