 package com.cognizant.farmfresh.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.farmfresh.dao.CartEmptyException;
import com.cognizant.farmfresh.dao.MenuItemDao;
import com.cognizant.farmfresh.model.Cart;
import com.cognizant.farmfresh.model.MenuItem;
import com.cognizant.farmfresh.model.Rating;

@Service
public class MenuItemService {
	@Autowired
	MenuItemDao menuItemDao;
	
	public List<MenuItem> getMenuItemListAdmin(String farmerName){
		List<MenuItem> res = new ArrayList<MenuItem>();
		res = menuItemDao.getMenuItemListAdmin(farmerName);
		return res;
	}

	public void insertListAdmin(String farmerName, String itemName, float d, String location, float stock,
			String category) {
		menuItemDao.insertListAdminJDBC(farmerName, itemName, d, location, stock, category);
	}

	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> res = new ArrayList<MenuItem>();
		res = menuItemDao.getMenuItemListCustomer();
		return res;
	}

	public MenuItem getMenuItem(int id) {
		return menuItemDao.getMenuItem(id);
	}

	public void modifyMenuItem(MenuItem m) {
		menuItemDao.modifyMenuItem(m);
	}

	public List<Cart> getCart(int farmerId) throws CartEmptyException {
		return menuItemDao.getCart(farmerId);
	}

	public void insertRate(String cName,String fname,String email,int rateService,String pros,String cons,String comments) {
		menuItemDao.insertRate(cName,fname,email,rateService,pros,cons,comments);
	}

	public  List<Rating> viewRate(String farmerName) {
		return menuItemDao.viewRate(farmerName);
	}


}
