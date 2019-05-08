package com.bhook.ordermanagement.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhook.ordermanagement.model.Customer;
import com.bhook.ordermanagement.model.Driver;



@Repository
public class DriverDaoImpl implements DriverDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	//method which provide me session
	public void setSessionFactory(SessionFactory sessionFactory){
	
		this.sessionFactory = sessionFactory;
		
	}
	
	//saving the customer
	public void saveDriver(Driver driver) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		driver.setStatus("available");
		
		session.persist(driver);
		tx.commit();
		session.close();
	}
	
	
		
		public Driver getDriver(String emailId) {
			Query query =sessionFactory.getCurrentSession().createQuery("from Driver where EMAIL_ID =:emailId");
			query.setParameter("emailId", emailId);
			return (Driver) query.list().get(0);
			
		} 
	 

	
	
	
	

	
	@SuppressWarnings("unchecked")
	public List<Driver> driverList() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Driver> driverList = session.createCriteria(Driver.class).list();
		tx.commit();
		session.close();
		return driverList;
	}

	public String checkDriverCredentials(Driver driver)
	  {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		 SQLQuery query= session.createSQLQuery("select 1 from DRIVER where EMAIL_ID='"+driver.getEmailId()+"' and PASSWORD = '"+driver.getPassword()+"'");
			if(query.uniqueResult()!=null)
			{
				return "success";
			}
			else 
			{
				return "failure";
			}
}
	Session session;
	Transaction tx;

	public String DeliveryDone(String phoneNumber)
	{ 
		try{

		 session = sessionFactory.openSession();
	 tx = session.beginTransaction();

	final String HQL_QRY_FOR_UPDATE = "update Driver set STATUS= 'available' where PHONE_NUMBER= '" +phoneNumber+"'";
	Query query = session.createQuery(HQL_QRY_FOR_UPDATE);

	query.executeUpdate();

	tx.commit();
	return "ok";
	}
	catch (Exception e) {
		 
	    System.err.println("Exception : " + e.getMessage());
	    tx.rollback();
	} 
	return "ok";
	}
 
	public String DeleteDriver(Integer driverId) {
		try {

			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			final String HQL_QRY_FOR_DELETE = "delete from Driver where driverId=:driverId";

			Query query = session.createQuery(HQL_QRY_FOR_DELETE);
			query.setParameter("driverId",driverId);
			
			query.executeUpdate();
			
			

			tx.commit();
			
			return "ok";
		} catch (Exception e) {

			System.err.println("Exception : " + e.getMessage());
			tx.rollback();
		}
		return "ok";
	}
	
	public Driver getAvailableDrivers(String status) {
		
		SQLQuery query =sessionFactory.getCurrentSession().createSQLQuery("select * from Driver where STATUS= 'available'");
		query.executeUpdate();
		return (Driver) query.list().get(0);
	} 
	  
		
		
	}

