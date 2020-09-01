package com.cognizant.farmfresh.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.farmfresh.dao.CartDao;
import com.cognizant.farmfresh.dao.CartEmptyException;
import com.cognizant.farmfresh.model.MenuItem;


@Service
public class CartService {
	@Autowired
	CartDao cartDao;
	
	public  float addCartItemService(int userid,int fid,int id,float quantity) {
		float total=cartDao.addCartItem(userid,fid, id, quantity);
		return total;
	}
	
	public List<MenuItem> getAllCartItemService(int userId) throws CartEmptyException{
		return cartDao.getAllCartItems(userId);
	}
	
	public void removeCartItemService(int userid,int menuItemId){
		cartDao.removeCartItem(userid,menuItemId);
	}

	public void orderStatus(String status, int id, int fid) {
		cartDao.orderStatus(status,id,fid);
	}
	
}
