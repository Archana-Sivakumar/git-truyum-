package com.cognizant.menuItem.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.menuItem.MenuItemApplication;
import com.cognizant.menuItem.model.MenuItem;
import com.cognizant.menuItem.repository.MenuItemRepository;


@Service
public class MenuItemServiceImpl implements MenuItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemApplication.class);

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public List<MenuItem> getMenuItemListAdmin() {

		LOGGER.info("Start");
		LOGGER.info("End");
		
		return menuItemRepository.findAll();

	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {

		LOGGER.info("Start");
		LOGGER.info("End");
		
		return menuItemRepository.getMenuItemListCustomer();

	}

	@Override
	public MenuItem editMenuItem(MenuItem menuItem) {

		LOGGER.info("Start");
		LOGGER.info("End");
		
		return menuItemRepository.save(menuItem);

	}

	@Override
	public MenuItem getMenuItem(int menuItemId) {

		LOGGER.info("Start");
		LOGGER.info("End");

		return menuItemRepository.findById(menuItemId).get();
	}

}
