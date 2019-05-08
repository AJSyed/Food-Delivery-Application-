package com.bhook.ordermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="FoodOrder")
public class FoodOrder {
	
	
		@Id
		@GenericGenerator(name = "generator", strategy = "increment")
		@GeneratedValue(generator = "generator")
		@Column(name = "OrderId")
		private Integer orderId;


		@Column(name = "CustomerName")
		private String name;

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		@Column(name="DriverEmailId")
		private String emailId;
		
		@Column(name="Price")
		private double price;
		
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Column(name="PhoneNumber")
		private String phoneNumber;
		
		
		@Column(name = "Address")
		private String address;


		@Column(name="DriverName")
		private String driverName;

		
		@Column(name="Status")
		private String status;
		
		@Column(name="RestaurantName")
		private String restaurantName;
		
		@Column(name="RestaurantAddress")
		private String restaurantAddress;
		
		@Column(name="OrderName")
		private String orderName;
		
		@Column(name="Quantity")
		private String quantity;

		public Integer getOrderId() {
			return orderId;
		}

		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getDriverName() {
			return driverName;
		}

		public void setDriverName(String driverName) {
			this.driverName = driverName;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getRestaurantName() {
			return restaurantName;
		}

		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}

		public String getRestaurantAddress() {
			return restaurantAddress;
		}

		public void setRestaurantAddress(String restaurantAddress) {
			this.restaurantAddress = restaurantAddress;
		}

		public String getOrderName() {
			return orderName;
		}

		public void setOrderName(String orderName) {
			this.orderName = orderName;
		}

		public String getQuantity() {
			return quantity;
		}

		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}

		public FoodOrder(Integer orderId, String name, String emailId, double price, String phoneNumber, String address,
				String driverName, String status, String restaurantName, String restaurantAddress, String orderName,
				String quantity) {
			super();
			this.orderId = orderId;
			this.name = name;
			this.emailId = emailId;
			this.price = price;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.driverName = driverName;
			this.status = status;
			this.restaurantName = restaurantName;
			this.restaurantAddress = restaurantAddress;
			this.orderName = orderName;
			this.quantity = quantity;
		}

		public FoodOrder() {
			
		}

		

}
