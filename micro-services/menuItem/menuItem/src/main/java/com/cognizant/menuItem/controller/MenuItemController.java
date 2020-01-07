package com.cognizant.menuItem.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.menuItem.MenuItemApplication;
import com.cognizant.menuItem.model.MenuItem;
import com.cognizant.menuItem.security.AppUserDetailsService;
import com.cognizant.menuItem.service.MenuItemService;


@RestController
@RequestMapping("/truyum")
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemApplication.class);

	@Autowired
	private MenuItemService menuItemService;

	@Autowired
	private AppUserDetailsService appUserDetailsService;

	@GetMapping("/menu-items")
	public List<MenuItem> getAllMenuItems() {

		LOGGER.info("Start");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();

		if (user != "anonymousUser") {

			UserDetails userDetails = appUserDetailsService.loadUserByUsername(authentication.getName());
			String role = userDetails.getAuthorities().toArray()[0].toString();

			if (role.equals("ADMIN")) {
				LOGGER.info("End");
				return menuItemService.getMenuItemListAdmin();
			} else {
				LOGGER.info("End");
				return menuItemService.getMenuItemListCustomer();
			}

		} else {
			LOGGER.info("End");
			return menuItemService.getMenuItemListCustomer();
		}

	}

	@GetMapping("/menu-items/{menuItemId}")
	public MenuItem getMenuItem(@PathVariable int menuItemId) {

		LOGGER.info("Start");
		LOGGER.info("End");

		return menuItemService.getMenuItem(menuItemId);

	}

	@PutMapping("/menu-items")
	public MenuItem editMenuItem(@RequestBody MenuItem menuItem) {

		LOGGER.info("Start");
		LOGGER.info("End");

		return menuItemService.editMenuItem(menuItem);

	}

}
