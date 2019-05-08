package com.bhook.ordermanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bhook.ordermanagement.dao.CustomerDao;
import com.bhook.ordermanagement.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	
	  @Autowired
	  CustomerDao customerDao;
	public void saveCustomer(Customer customer) {
	  customerDao.saveCustomer(customer);	
		
	}


	public List<Customer> customerList() {
		
		return customerDao.customerList();
	}

	
	
	
	
	public String checkCustomerCredentials(Customer customer) {
		return customerDao.checkCustomerCredentials(customer);
	}

	public Customer getCustomerById(String emailId) {
		
		return customerDao.getCustomer(emailId);
	}
	public String DeleteCustomer(String emailId){
		return customerDao.DeleteCustomer(emailId);
	}
	
}
