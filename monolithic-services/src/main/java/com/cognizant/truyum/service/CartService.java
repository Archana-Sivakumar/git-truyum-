package com.cognizant.truyum.service;

import java.util.Set;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public interface CartService {
	
	public void addCartItem(String user, int menuItemId);
	
	public Set<MenuItem> getAllCartItems(String user) throws CartEmptyException;
	
	public Set<MenuItem> removeCartItem(String user, int menuItemId);
}
