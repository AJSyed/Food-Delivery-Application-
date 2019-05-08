package com.bhook.ordermanagement.dao;

import java.util.List;

import com.bhook.ordermanagement.model.Driver;



public interface DriverDao{

	void saveDriver(Driver driver);
	
	public List<Driver> driverList();
	
	public Driver getDriver(String emailId);
	
	public String checkDriverCredentials(Driver driver);
	
	public String DeliveryDone(String phoneNumber);
	
	public String DeleteDriver(Integer driverId);
	
	
	public Driver getAvailableDrivers(String status);
	
}
