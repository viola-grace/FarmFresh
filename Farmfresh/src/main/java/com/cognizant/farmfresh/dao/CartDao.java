package com.cognizant.farmfresh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.farmfresh.model.*;

@Repository
public interface CartDao {
	public float addCartItem(long userId, int fid,long menuItemId,float quantity);
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;
	public void removeCartItem(long userId, long menuItemId);
	public void orderStatus(String status, int id, int fid);
}