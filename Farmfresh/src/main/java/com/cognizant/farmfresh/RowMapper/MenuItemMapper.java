package com.cognizant.farmfresh.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.cognizant.farmfresh.model.MenuItem;

public class MenuItemMapper implements RowMapper<MenuItem> {
   public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
      MenuItem menuItem = new MenuItem();
      menuItem.setId(rs.getInt("id"));
      menuItem.setItemName(rs.getString("itemName"));
      menuItem.setPrice(rs.getFloat("price"));
      menuItem.setFarmerName(rs.getString("farmerName"));
      menuItem.setLocation(rs.getString("location"));
      menuItem.setCategory(rs.getString("category"));
      menuItem.setQuantity(rs.getFloat("quantity"));
      menuItem.setStock(rs.getFloat("stock"));
      return menuItem;
   }
}