package com.cognizant.farmfresh.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.cognizant.farmfresh.model.Cart;

public class CartMapper implements RowMapper<Cart> {
   public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
      Cart cart = new Cart();
      cart.setUserId(rs.getInt("userId"));
     cart.setFarmerId(rs.getInt("farmerId"));
     cart.setMenuitemId(rs.getInt("menuitemId"));
     cart.setTotal(rs.getFloat("total"));
      return cart;
   }
}