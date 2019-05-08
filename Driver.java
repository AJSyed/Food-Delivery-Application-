package com.bhook.ordermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import org.hibernate.annotations.GenericGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name ="DRIVER")
public class Driver {
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "DRIVER_ID")
	private Integer driverId;


	@Column(name = "NAME")
	private String name;

	
	@Column(name="PHONE_NUMBER",unique=true)
	private String phoneNumber;
	
	@Column(name = "PASSWORD")
	private String password;

	@NotEmpty
	@Column(name = "LISENCE_NO")
	private String lisenceNo;

	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="ORDER_ID")
	private int oderId;

	
	public int getOderId() {
		return oderId;
	}

	public void setOderId(int oderId) {
		this.oderId = oderId;
	}

	

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLisenceNo() {
		return lisenceNo;
	}

	public void setLisenceNo(String lisenceNo) {
		this.lisenceNo = lisenceNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}