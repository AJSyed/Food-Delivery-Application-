package com.bhook.ordermanagement.dao;

import java.util.List;

import com.bhook.ordermanagement.model.Customer;
import com.bhook.ordermanagement.model.FoodOrder;

public interface FoodOrderDao {
void saveOrder(FoodOrder food);
	
public List<FoodOrder> foodList();
	
	public String AssignDriver(int orderId, String emailId) ;
	public String setDeliveryStatus(int orderId);
	
	//public String UpdateFood(int orderId, String emailId);

	public List<FoodOrder> Assigneddriverdetailsget(String driverEmail);
}
