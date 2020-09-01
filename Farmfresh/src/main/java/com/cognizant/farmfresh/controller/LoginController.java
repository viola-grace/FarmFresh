package com.cognizant.farmfresh.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cognizant.farmfresh.model.MenuItem;
import com.cognizant.farmfresh.service.CartService;
import com.cognizant.farmfresh.service.LoginService;
import com.cognizant.farmfresh.service.MenuItemService;

@Controller
public class LoginController {
	/*Initialization of Classes and public attributes*/
	@Autowired
	LoginService loginService;
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	CartService cartService;
	int user_id;
	
	//First page
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	//To show login page for customer
	@GetMapping("/LoginCustomer")
	public String signupPageCustomer(ModelMap model) {
		return "login-customer";
	}
	
	//To show login page for farmer
	@GetMapping("/LoginAdmin")
	public String signupPageAdmin() {
		return "login-admin";
	}
	
	//To indicate that the farmer logged in successfully and to redirect to login page of farmer
	@PostMapping("/success")
	public String successAdmin(ModelMap model,@RequestParam("username")String username,@RequestParam("email")String email,@RequestParam("pswd")String pswd){
		model.addAttribute(username,username);
		loginService.registerService(username,email,pswd);
		return "success";
	}
	//To indicate that the customer logged in successfully and to redirect to login page of customer
	@PostMapping("/successCustomer")
	public String successCustomer(ModelMap model,@RequestParam("username")String username,@RequestParam("email")String email,@RequestParam("pswd")String pswd){
		model.addAttribute(username,username);
		loginService.registerService(username,email,pswd);
		return "success-customer";
	}
	
	//login page of Customer
	@PostMapping("/loginCustomer")
	public String loginPage(ModelMap model,@RequestParam(value="username",required=false)String username, @RequestParam(value="password",required=false)String pswd){
		model.addAttribute("username", username);
		if(username.equalsIgnoreCase("")||pswd.equalsIgnoreCase("")){
			model.addAttribute("msg","User name or password cannot be empty");
			return "login-customer";
		}
		user_id=loginService.getId(username, pswd);
		if(user_id==0){
			model.addAttribute("msg","Sign up to enter");
			return "login-customer";
		}
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
		    model.addAttribute("userId",user_id);
		return "menu-item-list-customer";
	}
	
	//login page of admin
	@PostMapping("/loginAdmin")
	public String loginPageAdmin(@Valid @ModelAttribute("hai")MenuItem menuItem,BindingResult bindingResult,ModelMap model,@RequestParam(value="username",required=false)String username, @RequestParam(value="password",required=false)String pswd) throws ParseException{
		if(username.equalsIgnoreCase("")||pswd.equalsIgnoreCase("")){
			model.addAttribute("msg","User name or password cannot be empty");
			return "login-admin";
		}
		user_id=loginService.getId(username, pswd);
		if(user_id==0){
			model.addAttribute("msg","Sign up to enter");
			return "login-admin";
		}
		String name=loginService.getCurrentFarmer();
		menuItemService.getMenuItemListAdmin(name);
		model.addAttribute("userId",user_id);	
		model.addAttribute("farmerName",name);
		model.addAttribute("CustName",loginService.getCurrentUser(user_id));
		model.addAttribute("menuItem", menuItemService.getMenuItemListAdmin(name));
		return "menu-item-list-admin";
	}
}
