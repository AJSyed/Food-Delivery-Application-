package com.bhook.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhook.ordermanagement.model.FoodOrder;
import com.bhook.ordermanagement.service.FoodOrderService;

@RestController
@RequestMapping(value="/food")
public class FoodOrderController {
@Autowired
	
FoodOrderService foodService;
	
	
	@RequestMapping(value = "/saveFood",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCustomer(@RequestBody FoodOrder food){
	foodService.saveOrder(food);
	}
	@RequestMapping(value ="/getFood",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FoodOrder> foodList(){
		return foodService.foodList();
	}
	@RequestMapping(value = "/assignDriver",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String AssignDriver(@RequestBody FoodOrder food){
	return foodService.AssignDriver(food.getOrderId(),food.getEmailId());
	}
	
	@RequestMapping(value = "/assignStatus",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String setDeliveryStatus(@RequestBody FoodOrder food){
	return foodService.setDeliveryStatus(food.getOrderId());
	}
	/*
	@RequestMapping(value = "/updateFood",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String UpdateFood(@RequestBody FoodOrder food){
	return foodService.UpdateFood(food.getOrderId(),food.getEmailId());
	}*/
	@RequestMapping(value = "/driverDetails",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<FoodOrder> AssignedDriverDetail(@RequestBody FoodOrder food){
	return foodService.Assigneddriverdetailsget(food.getEmailId());
	}
	
}
