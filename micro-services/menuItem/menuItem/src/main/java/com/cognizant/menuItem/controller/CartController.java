package com.cognizant.menuItem.controller;


import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuItem.MenuItemApplication;
import com.cognizant.menuItem.exception.CartEmptyException;
import com.cognizant.menuItem.model.MenuItem;
import com.cognizant.menuItem.service.CartService;


@RestController
@RequestMapping("/truyum")
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemApplication.class);
	
	@Autowired
	private CartService cartService;

	@PostMapping("/cart-items/{user}/{menuItemId}")
	void addCartItem(@PathVariable String user, @PathVariable int menuItemId) {
		
		LOGGER.info("Start"); 
		
		cartService.addCartItem(user, menuItemId);
		
		LOGGER.info("End");
	}

	@GetMapping("/cart-items/{user}")
	public Set<MenuItem> getAllCartItems(@PathVariable String user) throws CartEmptyException {
		
		LOGGER.info("Start"); 
		LOGGER.info("End");
		
		return cartService.getAllCartItems(user);
	}

	@DeleteMapping("/cart-items/{user}/{menuItemId}")
	public Set<MenuItem> removeCartItem(@PathVariable String user, @PathVariable int menuItemId) {
		
		LOGGER.info("Start"); 
		LOGGER.info("End");
		
		return cartService.removeCartItem(user, menuItemId);
	}
}
