package com.bhook.ordermanagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhook.ordermanagement.model.Customer;
import com.bhook.ordermanagement.model.FoodOrder;
@Repository
public class FoodOrderDaoImpl implements FoodOrderDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//method which provide me session
	public void setSessionFactory(SessionFactory sessionFactory){
	
		this.sessionFactory = sessionFactory;
		
	}
	public void saveOrder(FoodOrder food) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(food);
		tx.commit();
		session.close();
	}
	
	

	public String AssignDriver(int orderId, String emailId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
		final String HQL_QRY_FOR_UPDATE = "update Driver set ORDER_ID= "+orderId +", STATUS='Busy' where EMAIL_ID= '" +emailId+"'";
		Query query = session.createQuery(HQL_QRY_FOR_UPDATE);
		query.executeUpdate();
		session.createQuery("update FoodOrder set DriverEmailId='"+emailId+"' where OrderId="+orderId+"").executeUpdate();
		
		
		
		tx.commit();
		return "inserted";
		}
	catch(Exception e){
		tx.rollback();
		System.err.println(e);
		return "failed to insert";
	}finally{
		session.close();
	} 
	}
	Session session;
		Transaction tx;
		public String setDeliveryStatus(int orderId)
		{
		try{
			session = sessionFactory.openSession();
		 tx = session.beginTransaction();
		 FoodOrder orders =(FoodOrder) session.get(FoodOrder.class,orderId);
			orders.setStatus("Delivered");
			tx.commit();
			session.close();
			 
		}
		catch(Exception e){
			tx.rollback();
			System.err.println(e);
			return "failed";
		}
		
		
return "done";
}
		/*public String UpdateFood(int orderId, String emailId) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			try{
			final String HQL_QRY_FOR_UPDATE = "update FoodOrder set emailId= "+emailId +", where orderId = '" +orderId+"'";
			Query query = session.createQuery(HQL_QRY_FOR_UPDATE);
			
			query.executeUpdate();
			
			tx.commit();
			return "inserted";
			}
		catch(Exception e){
			tx.rollback();
			System.err.println(e);
			return "success";
		}finally{
			session.close();
		} 
		}*/
		@SuppressWarnings("unchecked")
		public List<FoodOrder> foodList() {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<FoodOrder> foodList = session.createCriteria(FoodOrder.class).list();
			tx.commit();
			session.close();
			return foodList;
		}
		
		public List<FoodOrder> Assigneddriverdetailsget(String driverEmail)
        {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try
        {
        Query query = session.createQuery("from FoodOrder where DriverEmailId='"+driverEmail+"'");
        List<FoodOrder> order = (List<FoodOrder>)query.list();
                      
        tx.commit();
        return order;
        }
catch(Exception e)
        {
        tx.rollback();
        System.err.println(e);
        return null;
}
        finally
{
        session.close();
} 
        }
}