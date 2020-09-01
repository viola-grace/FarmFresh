package com.cognizant.farmfresh.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginDaoImpl implements LoginDao {
	
	static int uid;
	@Autowired
	 private JdbcTemplate jdbcTemplate;

	public int getId(String username, String pswd) {
		int is_present;
		System.out.println(username+" "+pswd);
		String SQL = "select exists(select uid from login where username=? and pswd=?)";
		is_present = jdbcTemplate.queryForObject(SQL, new Object[] { username, pswd }, Integer.class);
		if (is_present == 1) {
			String SQL1 = "select uid from login where username=? and pswd=?";
			uid = jdbcTemplate.queryForObject(SQL1, new Object[] { username, pswd }, Integer.class);
		} else {
			return 0;
		}
		return uid;
	}

	// Session replacement
	public String getCurrentFarmer() {
		String SQL1 = "select username from login where uid=?";
		return jdbcTemplate.queryForObject(SQL1, new Object[] { uid }, String.class);
	}

	// if user id is given return name
	public String getUserName(int userid) {
		String SQL1 = "select username from login where uid=?";
		return jdbcTemplate.queryForObject(SQL1, new Object[] { userid }, String.class);
	}

	// register
	public void registerService(String username, String email, String pswd) {
		String SQL = "insert into login(username,email,pswd) values (?, ?,?)";
		jdbcTemplate.update(SQL, username, email, pswd);
		return;
	}

	// return current user id
	public int getCurrentUser() {
		return uid;
	}
   //return current user id if farmer name is given
	public int getFarmerId(String farmername) {
		String SQL1 = "select uid from login where username=?";
		return jdbcTemplate.queryForObject(SQL1, new Object[] { farmername }, Integer.class);
	}

}
