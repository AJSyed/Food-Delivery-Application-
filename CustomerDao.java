package com.bhook.ordermanagement.dao;

import java.util.List;



import com.bhook.ordermanagement.model.Customer;



public interface CustomerDao{

	public void saveCustomer(Customer customer);
	
	public List<Customer> customerList();
	
	public Customer getCustomer(String emailId);
	
	public String checkCustomerCredentials(Customer customer);
	public String DeleteCustomer(String emailId);
	
}
