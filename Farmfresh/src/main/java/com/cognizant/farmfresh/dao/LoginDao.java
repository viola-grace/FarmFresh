package com.cognizant.farmfresh.dao;


import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
	public int getId(String username, String pswd);
	
	public String getCurrentFarmer();
	
	public String getUserName(int userid) ;
	
	public void registerService(String username, String email, String pswd);
	
	public int getCurrentUser();
	
	public int getFarmerId(String farmername);
}
