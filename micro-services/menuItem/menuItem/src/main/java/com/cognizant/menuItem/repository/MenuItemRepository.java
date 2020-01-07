package com.cognizant.menuItem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cognizant.menuItem.model.MenuItem;



@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer>{
	
	@Query(nativeQuery=true, value="select me_id, me_name, me_price, me_active,"
			+ " me_date_of_launch, me_category, me_free_delivery, me_image_url "
			+ "from `truyum`.`menu_item` where me_active = 'Yes' "
			+ "and  me_date_of_launch < NOW() or me_date_of_launch = NOW()")
	List<MenuItem> getMenuItemListCustomer();
	
}