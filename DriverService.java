package com.bhook.ordermanagement.service;

import java.util.List;


import com.bhook.ordermanagement.model.Driver;



public interface DriverService {
	
	public void saveDriver(Driver driver);
	
	public List<Driver> driverList();
	
	public  Driver getDriverById(String emailId);

	public String checkDriverCredentials(Driver driver);
	
	public String DeliveryDone(String phoneNumber);
	
	public String DeleteDriver(Integer driverId);
	
	
	
	public Driver getAvailableDrivers(String status);
}
