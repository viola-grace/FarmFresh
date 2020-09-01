package com.cognizant.farmfresh.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.farmfresh.RowMapper.MenuItemMapper;
import com.cognizant.farmfresh.model.MenuItem;

@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	 private JdbcTemplate jdbcTemplate;

	@Override
	public float addCartItem(long userId, int fid, long menuItemId, float quantity) {
		System.out.println("MenuitemID"+menuItemId);
		String SQL1 = "UPDATE menuitem SET quantity=(?) where id=?";
		jdbcTemplate.update(SQL1, quantity,menuItemId);
		String SQL = "insert into cart(userId,farmerId,menuitemId,delivered) values (?,?, ?,?)";
		jdbcTemplate.update(SQL, userId, fid, menuItemId, false);
		String SQL2 = "select (quantity*price) from menuitem where id=?";
		float total = jdbcTemplate.queryForObject(SQL2, new Object[] { menuItemId }, Float.class);
		String SQL3 = "update cart set total=(?) where menuitemId=?";
		jdbcTemplate.update(SQL3, new Object[] { total,menuItemId });
		String SQL4 = "select stock from menuitem where id=?";
		float stock=jdbcTemplate.queryForObject(SQL4,  new Object[] { menuItemId }, Float.class);
		stock=stock-quantity;
		String SQL5 = "UPDATE menuitem SET stock=(?) where id=?";
		jdbcTemplate.update(SQL5, stock,menuItemId);
		return total;
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		String SQL = "select * from menuitem as m join cart as c on m.id=c.menuitemId where c.userId=? and c.delivered=false ORDER BY m.price ASC";
		List<MenuItem> menuItemList = jdbcTemplate.query(SQL, new Object[] { userId }, new MenuItemMapper());
		if (menuItemList.isEmpty()) {
			throw new CartEmptyException();
		}
		return menuItemList;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {	
		String SQL1= "select quantity from menuitem as m join cart as c on m.id=c.menuitemId where c.userId=? and m.id=? limit 1";
		float quantity = jdbcTemplate.queryForObject(SQL1, new Object[] { userId,menuItemId }, Float.class);
		String SQL2 = "select stock from menuitem where id=?";
		float stock=jdbcTemplate.queryForObject(SQL2,  new Object[] { menuItemId }, Float.class);
		stock=stock+quantity;
		String SQL5 = "UPDATE menuitem SET stock=(?) where id=?";
		jdbcTemplate.update(SQL5, stock,menuItemId);
		String SQL = "delete from cart where userId=? and menuitemId=?";
		jdbcTemplate.update(SQL, userId, menuItemId);
		return;
	}

	public void orderStatus(String status,int id, int fid) {
		boolean store;
		String SQL1 = "UPDATE cart SET delivered=(?) where userId=? and farmerId=?";
		if (status.equals("yes")) {
			store = true;
		} else {
			store = false;
		}
		jdbcTemplate.update(SQL1, store,id,fid);
	}

}