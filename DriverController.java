package com.bhook.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhook.ordermanagement.model.Driver;
import com.bhook.ordermanagement.model.FoodOrder;
import com.bhook.ordermanagement.service.DriverService;



//import com.incture.base.Util.Acknowledgement;


@RestController
@RequestMapping(value="/driver")
public class DriverController {

	
	@Autowired
	
	DriverService driverService;
	
	
	@RequestMapping(value = "/saveDriver",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCustomer(@RequestBody Driver driver){
	driverService.saveDriver(driver);
	}
	@RequestMapping(value ="/getDriver",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Driver> driverList(){
		return driverService.driverList();
	}
	@RequestMapping(value="/drivercheck",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	  public String admincheck(@RequestBody Driver driver)
	  {
		  return driverService.checkDriverCredentials(driver);
	  } 
	
	@RequestMapping(value = "/getDriverById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Driver getDriver(@RequestBody Driver driver){
		return driverService.getDriverById(driver.getEmailId());
	} 
	@RequestMapping(value = "/driverStatus",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String DeliveryDone(@RequestBody Driver driver){
	return driverService.DeliveryDone(driver.getPhoneNumber());
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes= MediaType.APPLICATION_JSON_VALUE)
	public  String deleteDriver(@RequestBody Driver driver) {
		
		return driverService.DeleteDriver(driver.getDriverId());

	}
	
	@RequestMapping(value = "/getAvailableDriver", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Driver getAvailableDrivers(@RequestBody Driver driver){
		return driverService.getAvailableDrivers(driver.getName());
	} 
	
	
}