package com.bhook.ordermanagement.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	//method which provide me session
	public void setSessionFactory(SessionFactory sessionFactory){
	
		this.sessionFactory = sessionFactory;
		
	}
	
	//saving the customer
	public void saveCustomer(Customer customer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(customer);
		tx.commit();
		session.close();
	}
	
	
	

	
	@SuppressWarnings("unchecked")
	public List<Customer> customerList() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Customer> customerList = session.createCriteria(Customer.class).list();
		tx.commit();
		session.close();
		return customerList;
	}
	
	  
		public String checkCustomerCredentials(Customer customer)
			  {
				Session session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				 SQLQuery query= session.createSQLQuery("select 1 from CUSTOMER where EMAIL_ID='"+customer.getEmailId()+"' and PASSWORD = '"+customer.getPassword()+"'");
					if(query.uniqueResult()!=null)
					{
						return "success";
					}
					else 
					{
						return "failure";
					}
				  
			  }

	
			
			
		public Customer getCustomer(String emailId) {
			Query query =sessionFactory.getCurrentSession().createQuery("from Customer where EMAIL_ID =:emailId");
			query.setParameter("emailId", emailId);
			return (Customer) query.list().get(0);
			
		} Transaction tx ;
		public String DeleteCustomer(String emailId) {
			try {

				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();

				final String HQL_QRY_FOR_DELETE = "delete from Customer where emailId=:emailId";

				Query query = session.createQuery(HQL_QRY_FOR_DELETE);
				query.setParameter("emailId",emailId);
				
				query.executeUpdate();
				
				

				tx.commit();
				
				return "ok";
			} catch (Exception e) {

				System.err.println("Exception : " + e.getMessage());
				tx.rollback();
			}
			return "ok";
		}
		
		
		} 
		

		

