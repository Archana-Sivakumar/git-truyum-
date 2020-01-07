package com.cognizant.menuItem.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_item")
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="me_id")
	private int id;
	
	@Column(name="me_name")
	private String itemName;
	
	@Column(name="me_price",columnDefinition="DECIMAL(10,2)")
	private double price;
	
	@Column(name="me_active")
	private  String active;
	
	@Column(name="me_date_of_launch")
	private Date dateOfLaunch;
	
	@Column(name="me_category")
	private String category;
	
	@Column(name="me_free_delivery")
	private String freeDelivery;
	
	@Column(name="me_image_url")
    private String imageUrl;
	
    
	public MenuItem() {}

	public MenuItem(int id, String itemName, double price, String active, Date dateOfLaunch, String category,
			String freeDelivery, String imageUrl) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(String freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", itemName=" + itemName + ", price=" + price + ", active=" + active
				+ ", dateOfLaunch=" + dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery
				+ ", imageUrl=" + imageUrl + "]";
	}

	
	
}
