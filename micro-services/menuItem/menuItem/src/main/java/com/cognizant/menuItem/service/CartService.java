package com.cognizant.menuItem.service;

import java.util.Set;

import com.cognizant.menuItem.exception.CartEmptyException;
import com.cognizant.menuItem.model.MenuItem;

public interface CartService {
	
	public void addCartItem(String user, int menuItemId);
	
	public Set<MenuItem> getAllCartItems(String user) throws CartEmptyException;
	
	public Set<MenuItem> removeCartItem(String user, int menuItemId);
}
