package com.cognizant.truyum.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public void addCartItem(String userName, int menuItemId) {

		Users user = userRepository.findByUserName(userName);
		Set<MenuItem> menuItemList = new HashSet<MenuItem>();
		menuItemList = user.getMenuItemsList();
		MenuItem oneMenuItem = menuItemRepository.findById(menuItemId).get();
		menuItemList.add(oneMenuItem);
		user.setMenuItemsList(menuItemList);
		userRepository.save(user);

	}

	@Override
	public Set<MenuItem> getAllCartItems(String userName) throws CartEmptyException {

		Users user = userRepository.findByUserName(userName);

		if (user.getMenuItemsList().isEmpty()) {
			
			CartEmptyException cartEmpty = new CartEmptyException();
			throw cartEmpty;
			
		} else {
			return user.getMenuItemsList();
		}

	}

	@Override
	public Set<MenuItem> removeCartItem(String userName, int menuItemId) {

		Users user = userRepository.findByUserName(userName);

		Set<MenuItem> menuItemList = new HashSet<MenuItem>();
		menuItemList = user.getMenuItemsList();
		boolean flag = false;
		for (MenuItem itr : menuItemList) {
			if (itr.getId() == menuItemId) {
				flag = menuItemList.remove(itr);
				break;
			}
		}
		if (flag) {
			user.setMenuItemsList(menuItemList);
			userRepository.save(user);
		}

		return menuItemList;
	}

}

