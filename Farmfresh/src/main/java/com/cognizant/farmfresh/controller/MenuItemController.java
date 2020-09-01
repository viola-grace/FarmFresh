package com.cognizant.farmfresh.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cognizant.farmfresh.dao.CartEmptyException;
import com.cognizant.farmfresh.model.Cart;
import com.cognizant.farmfresh.model.MenuItem;
import com.cognizant.farmfresh.model.Rating;
import com.cognizant.farmfresh.service.CartService;
import com.cognizant.farmfresh.service.LoginService;
import com.cognizant.farmfresh.service.MenuItemService;


@Controller
public class MenuItemController {
	//Initialization of Classes and public attributes
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	CartService cartService;
	@Autowired
	LoginService loginService;	
	public int store_id;
	public int admin_id;
	

	//To display form to take in orders and list of his stock
	@GetMapping("/menu-item-list-admin")
	public String showMenuItemListAdmin(@Valid @ModelAttribute("hai")MenuItem menuitem,BindingResult bindingResult,ModelMap model) throws SystemException {
			String itemName=menuitem.getItemName(); 
			float price= menuitem.getPrice();
			String location=menuitem.getLocation();
			String category=menuitem.getCategory();
			float stock=menuitem.getStock();
			String farmerName=loginService.getCurrentFarmer();
			menuitem.setFarmerName(farmerName);
			model.addAttribute("farmerName",farmerName);	
			model.addAttribute("menuItem", menuItemService.getMenuItemListAdmin(farmerName));
			
		if(bindingResult.hasErrors()){
			return "menu-item-list-admin";
		}else{
			menuItemService.insertListAdmin(farmerName,itemName,price,location,stock,category);
			model.addAttribute("addItemStatus",true);
			model.addAttribute("menuItem", menuItemService.getMenuItemListAdmin(farmerName));
			return "menu-item-list-admin";
		}	
	}
	
	//to help farmer view his orders from his customers
	@GetMapping("/myOrders")
	public String showMyOrders(ModelMap model) throws CartEmptyException {
		List<Cart> cartlist=new ArrayList<Cart>();;		
		cartlist=	menuItemService.getCart(loginService.getCurrentUser());
		 	Map<String, List<List>> map = new HashMap<String, List<List>>();
	       
	        for(int i=0;i<cartlist.size();i++)
	        {        	
	        	List<Object> menuitems = new ArrayList<Object>();
	        	 List<List> values = new ArrayList<List>();
	        	String name=loginService.getCurrentUser(cartlist.get(i).getUserId());
	        	menuitems.add(menuItemService.getMenuItem(cartlist.get(i).getMenuitemId()).getItemName());
	        	menuitems.add(menuItemService.getMenuItem(cartlist.get(i).getMenuitemId()).getQuantity()+"Kg"); 	
	        	menuitems.add(menuItemService.getMenuItem(cartlist.get(i).getMenuitemId()).getCategory());
	        	menuitems.add("Rs."+cartlist.get(i).getTotal());
	        	values.add(menuitems);
	        	map.put(name, values);
	        }
		model.addAttribute("myMap", map);
		return "my-orders";
		}
	
	//To know the status of order
	@GetMapping("/orderStatus")
	public String orderStatus(ModelMap model,@RequestParam("status") String status,@RequestParam("cname")String cname) throws CartEmptyException {
		int id=loginService.getFarmerId(cname);
		int fid=loginService.getCurrentUser();
		cartService.orderStatus(status,id,fid);
		List<Cart> cartlist=new ArrayList<Cart>();;		
		cartlist=	menuItemService.getCart(loginService.getCurrentUser());
		 	Map<String, List<List>> map = new HashMap<String, List<List>>();
	        for(int i=0;i<cartlist.size();i++)
	        {        	
	        	List<Object> menuitems = new ArrayList<Object>();
	        	 List<List> values = new ArrayList<List>();
	        	String name=loginService.getCurrentUser(cartlist.get(i).getUserId());
	        	menuitems.add(menuItemService.getMenuItem(cartlist.get(i).getMenuitemId()).getItemName());
	        	menuitems.add(menuItemService.getMenuItem(cartlist.get(i).getMenuitemId()).getQuantity()+"Kg"); 	
	        	menuitems.add(menuItemService.getMenuItem(cartlist.get(i).getMenuitemId()).getCategory());
	        	menuitems.add("Rs."+cartlist.get(i).getTotal());
	        	values.add(menuitems);
	        	map.put(name, values);
	        }
		model.addAttribute("myMap", map);
		return "my-orders";
		}

	//if item ID is given menu item details will be fetched
	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam("menuItemId") int id, ModelMap model,
			@ModelAttribute("hai") MenuItem menuItem) {
		model.addAttribute("menuItemObj", menuItemService.getMenuItem(id));
		store_id=id;
		return "edit-menu-item";
	}
	
	@GetMapping("/EnterRate")
	public String rate(@ModelAttribute("rating") Rating rating,BindingResult bindingResult) {
		return "rate";
	}
	@GetMapping("/rate")
	public String insertRate(@ModelAttribute("rating") Rating rating,BindingResult bindingResult) {
		String cname=rating.getCname();
		String fname=rating.getFname();
		String email=rating.getEmail();
		int rateService=rating.getRateService();
		String pros=rating.getPros();
		String cons=rating.getCons();
		String comments=rating.getComments();
		menuItemService.insertRate(cname,fname,email,rateService,pros,cons,comments);
		return "rate";
	}
	@GetMapping("/viewRate")
	public String viewRate(@ModelAttribute("rating") Rating rating,BindingResult bindingResult, ModelMap model,@RequestParam("farmerName")String farmerName) {
		List<Rating> ratingList=new ArrayList<Rating>();
		ratingList=menuItemService.viewRate(farmerName);
		model.addAttribute("ratingList",ratingList);
		return "view-rating";
	}
	

	//to enable customer to edit their order
	@RequestMapping(value = "/edit-menu-item1",method=RequestMethod.POST)
	public String editMenuItem(@Valid @ModelAttribute("hai")MenuItem menuItem, BindingResult bindingResult,ModelMap model) {
		MenuItem m = menuItem;
		m.setId(store_id);
		String farmerName=loginService.getCurrentFarmer();
		model.addAttribute("farmerName", farmerName);
		if (bindingResult.hasErrors()) {
			return "edit-menu-item";
		} else {
			menuItemService.modifyMenuItem(m);
			return "edit-menu-item-status";
		}
	}
	
}
