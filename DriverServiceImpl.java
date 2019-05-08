package com.bhook.ordermanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhook.ordermanagement.dao.DriverDao;
import com.bhook.ordermanagement.model.Driver;



@Service
@Transactional
public class DriverServiceImpl implements DriverService {

	
	  @Autowired
	  DriverDao driverDao;
	
	public void saveDriver(Driver driver) {
	  driverDao.saveDriver(driver);	
		
	}

	
	public List<Driver> driverList() {
		
		return driverDao.driverList();
	}


	public Driver getDriverById(String emailId) {
		
		return driverDao.getDriver(emailId) ;
	}

	public String checkDriverCredentials(Driver driver) {
		return driverDao.checkDriverCredentials(driver);
	}
	public String DeliveryDone(String phoneNumber)
	{
		return driverDao.DeliveryDone(phoneNumber);
	}
	@Transactional
	public String DeleteDriver(Integer driverId)
	{
		return driverDao.DeleteDriver(driverId);
	}

	
	public Driver getAvailableDrivers(String status) 
	{
		return driverDao.getAvailableDrivers(status);
	}
	
	
}
