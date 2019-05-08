package com.bhook.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.bhook.ordermanagement.model.Restaurant;
import com.bhook.ordermanagement.service.RestaurantService;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantservice; 

	@RequestMapping(value = "/saveRestaurant",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCustomer(@RequestBody Restaurant restaurant)
	{
		restaurantservice.saveRestaurant(restaurant);
	}
	@RequestMapping(value ="/getRestaurant",method = RequestMethod.GET)
	public List<Restaurant> restauarantList(){
		return restaurantservice.restaurantList();
	}
	
	@RequestMapping(value = "/getProductsById/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Restaurant getRestaurantById(@PathVariable("restaurantId") int id) {
		return restaurantservice.getRestaurantById(id);
	}

	
@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public  void deleteRestaurant(@RequestBody Restaurant restaurant) {
	
	 restaurantservice.deleteRestaurantById(restaurant.getRestaurantId());

}

@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public  String updateRestaurant(@RequestBody Restaurant restaurant) {
	
	return restaurantservice.updateRestaurant(restaurant.getName(),restaurant.getPhoneNumber(),restaurant.getPrice(),restaurant.getImage(),restaurant.getAddress(), restaurant.getRestaurantId());

}
}

