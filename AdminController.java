package com.bhook.ordermanagement.controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.MediaType;
	
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	import org.springframework.web.bind.annotation.RestController;

import com.bhook.ordermanagement.model.Admin;
import com.bhook.ordermanagement.model.FoodOrder;
import com.bhook.ordermanagement.service.AdminService;




	


	@RestController
	@RequestMapping(value="/admin")
	public class AdminController {
	 
		
		@Autowired
		AdminService adminService;
		

		
		@RequestMapping(value = "/saveAdmin",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public void saveCustomer(@RequestBody Admin admin){
			adminService.saveAdmin(admin);
		}
		
		@RequestMapping(value ="/getAdmin",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public List<Admin> adminList(){
			return adminService.adminList();
		}
		//to check customer credentials are correct or not
		
				@RequestMapping(value="/admincheck",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
				  public String admincheck(@RequestBody Admin admin)
				  {
					  return adminService.checkAdminCredentials(admin);
				  } 
				/*@RequestMapping(value="/assignDriver",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
				
					public String setAssignDriver(@RequestBody FoodOrder foodorder)
					{
						return adminService.setAssignDriver(foodorder.getOrderId(), foodorder.getDriverName());
						
					}*/
				
}
