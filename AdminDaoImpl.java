package com.bhook.ordermanagement.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhook.ordermanagement.model.Admin;
import com.bhook.ordermanagement.model.Driver;
import com.bhook.ordermanagement.model.FoodOrder;


@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//method which provide me session
	public void setSessionFactory(SessionFactory sessionFactory){
	
		this.sessionFactory = sessionFactory;
		
	}
	
	
	public void saveAdmin(Admin admin) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(admin);
		tx.commit();
		session.close();
	}
	public List<Admin> adminList() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Admin> adminList = session.createCriteria(Admin.class).list();
		tx.commit();
		session.close();
		return adminList;
	}
	
	  
		public String checkAdminCredentials(Admin admin)
			  {
				Session session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				 SQLQuery query= session.createSQLQuery("select 1 from ADMIN where EMAIL_ID='"+admin.getEmail()+"' and PASSWORD = '"+admin.getPassword()+"'");
					if(query.uniqueResult()!=null)
					{
						return "success";
					}
					else 
					{
						return "failure";
					}
				  
			  }
		




}
