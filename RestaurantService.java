package com.bhook.ordermanagement.service;

import java.util.List;

import com.bhook.ordermanagement.model.Product;
import com.bhook.ordermanagement.model.Restaurant;

public interface RestaurantService {
	
	
public String saveRestaurant(Restaurant restaurant);
	
	public List<Restaurant> restaurantList();
	
	public  Restaurant getRestaurantById(int id);

	public String updateRestaurant(String name, long phoneNumber, String price,String address,String Image,Integer restaurantId);

	public void deleteRestaurantById(int id);
}
