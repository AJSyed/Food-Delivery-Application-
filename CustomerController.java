package com.bhook.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhook.ordermanagement.model.Customer;
import com.bhook.ordermanagement.service.CustomerService;

//import com.incture.base.Util.Acknowledgement;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);

	}

	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> customerList() {
		return customerService.customerList();

	}
	// to check customer credentials are correct or not

	@RequestMapping(value = "/customercheck", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String admincheck(@RequestBody Customer customer) {
		return customerService.checkCustomerCredentials(customer);
	}

	/*
	 * @RequestMapping(value = "/getCustomerById", method = RequestMethod.POST,
	 * produces = MediaType.APPLICATION_JSON_VALUE) public String
	 * getSpecificCustomer(@RequestBody Customer customer){ return
	 * customerService.get(customer.getEmailId()); }
	 */

	@RequestMapping(value = "/getCustomerById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomer(@RequestBody Customer customer) {
		return customerService.getCustomerById(customer.getEmailId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCustomer(@RequestBody Customer customer) {

		return customerService.DeleteCustomer(customer.getEmailId());

	}

}