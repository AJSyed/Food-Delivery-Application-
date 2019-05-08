package com.bhook.ordermanagement.service;



	import java.util.List;

	import javax.transaction.Transactional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	
import com.bhook.ordermanagement.dao.RestaurantDao;

import com.bhook.ordermanagement.model.Restaurant;

	@Service
	public class RestaurantServiceImpl implements RestaurantService {

		
		  @Autowired
		  RestaurantDao restaurantDao;
		@Transactional
		public String saveRestaurant(Restaurant restaurant) {
		 return restaurantDao.saveRestaurant(restaurant);	
			
		}

		@Transactional
		public List<Restaurant> restaurantList() {
			
			return restaurantDao.restaurantList();
		}

		@Transactional
		public Restaurant getRestaurantById(int id) {
			
			return restaurantDao.getRestaurant(id) ;
		}

		@Transactional
		public String updateRestaurant(String name, long phoneNumber,String price, String address,String Image,Integer restaurantId)
		{
			return restaurantDao.updateRestaurant(name,phoneNumber,price,address,Image,restaurantId);
		}
		
		public void deleteRestaurantById(int id)
		{
			restaurantDao.deleteRestaurantById(id);
		}

		

		
	}




