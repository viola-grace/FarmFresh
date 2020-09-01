package com.cognizant.farmfresh.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.farmfresh.dao.CartEmptyException;
import com.cognizant.farmfresh.model.MenuItem;
import com.cognizant.farmfresh.service.CartService;
import com.cognizant.farmfresh.service.LoginService;
import com.cognizant.farmfresh.service.MenuItemService;

@Controller
public class CartController {
	//Initialization of Classes and public attributes
	@Autowired
		CartService cartService;
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	LoginService loginService;
	public int user_id=0;
	public float total=0;

	//to add to cart
	@GetMapping("/add-to-cart")
	public String addToCart(ModelMap model ,@RequestParam("id")int id,@RequestParam("quantity")float quantity){
			List<MenuItem> lis=new ArrayList<>();
			List<MenuItem> veglis=new ArrayList<>();
			List<MenuItem> fruitlis=new ArrayList<>();
			
			lis= menuItemService.getMenuItemListCustomer();

			for (MenuItem menuitem : lis) {
			if(menuitem.getCategory().equals("Vegetable"))
				veglis.add(menuitem);
			else
				fruitlis.add(menuitem);	
			}
			model.addAttribute("menuItemVeg",veglis);	
			model.addAttribute("menuItemFruit",fruitlis);

		user_id=loginService.getCurrentUser();
		model.addAttribute("userId",user_id);
		int fid=loginService.getFarmerId(menuItemService.getMenuItem(id).getFarmerName());
		float stock=menuItemService.getMenuItem(id).getStock();
		if(quantity>stock){
			model.addAttribute("addCartStatus",false);
			model.addAttribute("alert","Quantity is greater than stock");
			return "menu-item-list-customer";
		}
		model.addAttribute("addCartStatus",true);
		total=cartService.addCartItemService(user_id,fid,id,quantity);
		model.addAttribute("total",total);
		return "menu-item-list-customer";
	}
	
	//To display stock and add to cart
	@GetMapping("/menu-item-list-customer")
	public String showMenuItem(ModelMap model){
		List<MenuItem> lis=new ArrayList<>();
		List<MenuItem> veglis=new ArrayList<>();
		List<MenuItem> fruitlis=new ArrayList<>();
		user_id=loginService.getCurrentUser();
		
		    model.addAttribute("userId",user_id);
				lis= menuItemService.getMenuItemListCustomer();
				for (MenuItem menuitem : lis) {
				if(menuitem.getCategory().equals("Vegetable"))
					veglis.add(menuitem);
				else
					fruitlis.add(menuitem);	
				}
				model.addAttribute("menuItemVeg",veglis);	
				model.addAttribute("menuItemFruit",fruitlis);
		return "menu-item-list-customer";
	}
	
	//to display the cart items
	@GetMapping("/show-cart")
	public String showCart(@RequestParam("userId")int uid ,ModelMap model){
		List<MenuItem> lis=new ArrayList<>();
		model.addAttribute("userId",user_id);
		model.addAttribute("total", total);
		try {
			lis=cartService.getAllCartItemService(uid);
		}catch (CartEmptyException e) {
			return "cart-empty";
		} 
		model.addAttribute("menuItem",lis);
		return "cart";	
	}
	
	//to delete items from cart
	@GetMapping("/remove-cart-item")
	public String removeCart(@RequestParam("menuItemId")int mid ,ModelMap model) throws CartEmptyException{
		System.out.println(mid);
		model.addAttribute("remove",mid);
		List<MenuItem> lis=new ArrayList<>();
		model.addAttribute("userId",user_id);
		try{
		cartService.removeCartItemService(user_id,mid);
		lis=cartService.getAllCartItemService(user_id);
		}catch(NullPointerException e){
			return "cart-empty";
		}catch(CartEmptyException e){
			return "cart-empty";
		}
		model.addAttribute("menuItem",lis);
		return "cart";	
	}
}
