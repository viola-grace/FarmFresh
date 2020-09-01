package com.cognizant.farmfresh.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.cognizant.farmfresh.RowMapper.CartMapper;
import com.cognizant.farmfresh.RowMapper.MenuItemMapper;
import com.cognizant.farmfresh.RowMapper.RatingMapper;
import com.cognizant.farmfresh.model.Cart;
import com.cognizant.farmfresh.model.MenuItem;
import com.cognizant.farmfresh.model.Rating;


@Component
public class MenuItemDaoImpl implements MenuItemDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
   

	@Override
	public List<MenuItem> getMenuItemListAdmin(String farmerName) {
		String SQL = "select * from menuitem where farmerName=?";
		return jdbcTemplate.query(SQL, new Object[] { farmerName }, new MenuItemMapper());

	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		String SQL = "select * from menuitem ORDER BY price ASC";
		return jdbcTemplate.query(SQL, new MenuItemMapper());

	}

	@Override
	public void modifyMenuItem(MenuItem menuitem) {
		String SQL = "update menuitem set farmerName=?,itemName=?,price=?,location=?,category=?,quantity=?,stock=? where id=?";
		long id = menuitem.getId();
		String farmerName = menuitem.getFarmerName();
		String itemName = menuitem.getItemName();
		float price = menuitem.getPrice();
		String location = menuitem.getLocation();
		String category = menuitem.getCategory();
		float quantity = menuitem.getQuantity();
		float stock=menuitem.getStock();
		jdbcTemplate.update(SQL, farmerName, itemName, price, location, category, quantity, stock,id);
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		String SQL = "select * from menuitem where id=?";
		MenuItem menuItem = jdbcTemplate.queryForObject(SQL, new Object[] { menuItemId }, new MenuItemMapper());
		return menuItem;
	}

	public void insertListAdminJDBC(String farmerName, String itemName, float d, String location, float stock,
			String category) {
		String SQL = "insert into menuitem(farmerName,itemName, price, location,  stock,category) values(?,?,?,?,?,?)";
		jdbcTemplate.update(SQL, farmerName, itemName, d, location, stock, category);
	}

	public List<Cart> getCart(int farmerId) throws CartEmptyException {
		String SQL = "select userId,farmerId,menuitemId,total,delivered from cart where farmerId=? and delivered=0 ";
		List<Cart> cartList = jdbcTemplate.query(SQL, new Object[] { farmerId }, new CartMapper());
		return cartList;
	}

	public void insertRate(String customerName,String farmerName, String email, int rateService, String pros, String cons, String comments) {
		String SQL = "insert into rating(cname,fname,email,rateService,pros,cons,comments) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(SQL, customerName,farmerName,email,rateService,pros,cons,comments);	
	}

	public List<Rating> viewRate(String farmerName) {
		String SQL = "select cname,fname,email,rateService,pros,cons,comments from rating where fname=?";
		List<Rating> ratingList = jdbcTemplate.query(SQL, new Object[] { farmerName }, new RatingMapper());
		return ratingList;
	}

	
	

}