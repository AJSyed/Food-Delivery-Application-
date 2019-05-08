package com.bhook.ordermanagement.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "CUSTOMER_ID")
	private Integer customerId;


	@Column(name = "NAME")
	private String name;

	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	@NotEmpty
	@Column(name = "PASSWORD")
	private String password;

	
	@Column(name = "ADDRESS")
	private String address;


	@Column(name = "EMAIL_ID",nullable=false)
	private String emailId;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer employeeId) {
		this.customerId= customerId;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Customer(Integer customerId, String name,String phoneNumber, String password, String address,
			String emailId) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
		this.emailId = emailId;
	}

	public Customer() {
		
	}

	
	}

