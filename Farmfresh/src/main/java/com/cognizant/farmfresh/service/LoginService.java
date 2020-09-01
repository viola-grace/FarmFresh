package com.cognizant.farmfresh.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.farmfresh.dao.LoginDao;

@Service
public class LoginService {
	@Autowired
	LoginDao loginDao;
	  public int getId(String username, String pswd){
		  
			int admin_id=loginDao.getId(username, pswd);
			return admin_id;
		}
		public void registerService(String username,String email, String pswd){
			loginDao.registerService(username,email,pswd);
		 }
		public String getCurrentFarmer(){
			String farmer=loginDao.getCurrentFarmer();
			return farmer;
		}
		public int getCurrentUser() {
			return loginDao.getCurrentUser();		
		}
		public String getCurrentUser(int id) {
			return loginDao.getUserName(id);		
		}
		public int getFarmerId(String farmerName) {
			
			return loginDao.getFarmerId(farmerName);
		}
}
