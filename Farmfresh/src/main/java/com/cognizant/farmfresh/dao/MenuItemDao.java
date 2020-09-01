package com.cognizant.farmfresh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.farmfresh.model.Cart;
import com.cognizant.farmfresh.model.MenuItem;
import com.cognizant.farmfresh.model.Rating;

@Repository
public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin(String farmerName);

    public List<MenuItem> getMenuItemListCustomer();

    public void modifyMenuItem(MenuItem menuitem);

    public MenuItem getMenuItem(long menuItemId);
    
    public void insertListAdminJDBC(String farmerName, String itemName, float d, String location, float stock,String category);
    
    public List<Cart> getCart(int farmerId) throws CartEmptyException;
    
    public void insertRate(String customerName,String farmerName, String email, int rateService, String pros, String cons, String comments);
    
    public List<Rating> viewRate(String farmerName);

}
