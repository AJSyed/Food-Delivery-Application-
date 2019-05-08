package com.bhook.ordermanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhook.ordermanagement.dao.CustomerDao;
import com.bhook.ordermanagement.dao.FoodOrderDao;
import com.bhook.ordermanagement.model.FoodOrder;
@Service
@Transactional
public class FoodOrderServiceImpl implements FoodOrderService{
	  @Autowired
	  FoodOrderDao foodDao;
	public void saveOrder(FoodOrder food) {
		
		foodDao.saveOrder(food);
	}

	public List<FoodOrder> foodList()
	{
		return foodDao.foodList();
	}
	public String AssignDriver(int orderId, String emailId) 
	{
		return foodDao.AssignDriver(orderId, emailId);
	}
	
	public String setDeliveryStatus(int orderId)
	{
		return foodDao.setDeliveryStatus(orderId);
	}
	
	/*public String UpdateFood(int orderId, String emailId)
	{
		return foodDao.UpdateFood(orderId, emailId);
	}*/
	

	public List<FoodOrder> Assigneddriverdetailsget(String driverEmail)
	
	{
		return foodDao.Assigneddriverdetailsget(driverEmail);
	}
}
