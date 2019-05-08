package com.bhook.ordermanagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Restaurant")
public class Restaurant
{
	@Id
@GenericGenerator(name = "generator", strategy = "increment")
@GeneratedValue(generator = "generator")
@Column(name = "RestaurantID")
private Integer restaurantId;
	
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant") 
		 
		private List<Product> productList;  
		 
		 
		
	
	public Integer getRestaurantId() {
	return restaurantId;
}

public void setRestaurantId(Integer restaurantId) {
	this.restaurantId = restaurantId;
}

	@Column(name="Name",unique=true)
	private String name;
	
	@Column(name="PhoneNumber")
	private long phoneNumber;
	
	//@Id
	@Column(name="Address",unique=true)
	private String address;
	
	@Column(name="Price")
	private String price;
	
	@Column(name="Image")
	private String Image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return Image;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public void setImage(String image) {
		this.Image = image;
	}
	
	 

}
