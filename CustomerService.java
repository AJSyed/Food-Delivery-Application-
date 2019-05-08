package com.bhook.ordermanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bhook.ordermanagement.model.Customer;



public interface CustomerService {
	
	public void saveCustomer(Customer customer);
	
	public List<Customer> customerList();
	
	public  Customer getCustomerById(String emailId);

	public String checkCustomerCredentials(Customer customer);
	
	public String DeleteCustomer(String emailId);

	
	
	
}
