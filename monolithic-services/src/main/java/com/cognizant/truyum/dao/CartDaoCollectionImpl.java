package com.cognizant.truyum.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CartDaoCollectionImpl implements CartDao {

	/*private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	private static Map<String, Cart> userCarts;

	public CartDaoCollectionImpl() {
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
	}

	public static Map<String, Cart> getUserCarts() {
		return userCarts;
	}

	public static void setUserCarts(HashMap<String, Cart> userCarts) {
		CartDaoCollectionImpl.userCarts = userCarts;
	}

	@Override
	public void addCartItem(String user, long menuItemId) {
		
		LOGGER.info("Start");

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(user)) {
			
			Cart cartItem = userCarts.get(user);
			cartItem.getMenuItemList().add(menuItem);
			
		} else {
			
			Cart cartItem = new Cart(new ArrayList<MenuItem>(), 0.0);
			cartItem.getMenuItemList().add(menuItem);
			userCarts.put(user, cartItem);
			
		}
		LOGGER.info("End");
	}

	@Override
	public List<MenuItem> getAllCartItems(String user) throws CartEmptyException {
        
		LOGGER.info("Start");
		
		if (userCarts.isEmpty()) {
			
			CartEmptyException cartEmpty = new CartEmptyException();
			throw cartEmpty;
			
		} else {
			
			double total = 0.0;
			Cart cartItem = userCarts.get(user);
			List<MenuItem> menuItem = cartItem.getMenuItemList();

			if (menuItem.isEmpty()) {
				
				CartEmptyException cartEmpty = new CartEmptyException();
				throw cartEmpty;
				
			} else {
				
				for (int i = 0; i < menuItem.size(); i++) {
					total += menuItem.get(i).getPrice();
				}
				cartItem.setTotal(total);
				cartItem.setMenuItemList(menuItem);
			}
			LOGGER.info("End");
			return menuItem;
		}
	}

	@Override
	public List<MenuItem> removeCartItem(String user, long menuItemId) {

		LOGGER.info("Start");
		
		Cart cartItem = userCarts.get(user);
		List<MenuItem> menuItem = cartItem.getMenuItemList();

		for (int i = 0; i < menuItem.size(); i++) {
			if (menuItem.get(i).getId() == menuItemId) {
				menuItem.remove(i);
				break;
			}
		}
		
		LOGGER.info("End");
		return menuItem;

	}*/

}
