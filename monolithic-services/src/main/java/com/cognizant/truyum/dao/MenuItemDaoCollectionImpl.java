package com.cognizant.truyum.dao;


import org.springframework.stereotype.Repository;


@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	
	/*private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		
		ApplicationContext contextMenuItem = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = (ArrayList) contextMenuItem.getBean("menuItemList");
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		MenuItemDaoCollectionImpl.menuItemList = menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		
		LOGGER.info("Start");
		List<MenuItem> filteredArrayList = new ArrayList<MenuItem>();
		for (MenuItem item : menuItemList) {
			int dateCompare = item.getDateOfLaunch().compareTo(new Date());
			if (item.isActive() == true && (dateCompare == 0 || dateCompare < 0)) {
				filteredArrayList.add(item);
			}
		}
		LOGGER.info("End");
		return filteredArrayList;
		return  null;
	}

	@Override
	public void editMenuItem(MenuItem menuItem) {
		
		LOGGER.info("Start");
		int i;
		for (i = 0; i < menuItemList.size(); i++) {
			if (menuItem.getId() == menuItemList.get(i).getId()) {
				menuItemList.set(i, menuItem);
				break;
			}
		}
		LOGGER.info("End");
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		
		LOGGER.info("Start");
		int i;
		MenuItem menuItem = null;
		for (i = 0; i < menuItemList.size(); i++) {
			if (menuItemId == menuItemList.get(i).getId()) {
				menuItem = menuItemList.get(i);
				break;
			}
		}
		LOGGER.info("End");
		
		return menuItem;
	}*/
	
}
