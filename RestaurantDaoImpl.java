package com.bhook.ordermanagement.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhook.ordermanagement.model.Customer;
import com.bhook.ordermanagement.model.Product;
import com.bhook.ordermanagement.model.Restaurant;



@Repository
public class RestaurantDaoImpl implements RestaurantDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	//method which provide me session
	public void setSessionFactory(SessionFactory sessionFactory){
	
		this.sessionFactory = sessionFactory;
		
	}
	
	Session session;
	Transaction tx; 
	public String saveRestaurant(Restaurant restaurant) {
		try {
		 session = this.sessionFactory.openSession();
	 tx = session.beginTransaction();
		session.save(restaurant);
        for (int i=0; i<restaurant.getProductList().size();i++)
        {
                  restaurant.getProductList().get(i).setRestaurant(restaurant);
                  session.save(restaurant.getProductList().get(i));
        }
        tx.commit();
        return "restaurant added";
}
catch (Exception e)
{
        tx.rollback();
        return "Restaurant already exists";
}
finally
{
        session.close();
}

		
		
	}
	
	
	public Restaurant getRestaurant(int id){
		Session session = sessionFactory.openSession();
		
		return  (Restaurant) session.get(Restaurant.class, id);
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Restaurant> restaurantList() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Restaurant> restaurantList = session.createCriteria(Restaurant.class).list();
        for(int i=0;i<restaurantList.size();i++)
        {
                  restaurantList.get(i).setProductList(null);
        }

		tx.commit();
		session.close();
		return restaurantList;
	}



	
	
	

	
 
		public void deleteRestaurantById(int id)
			{
				Session session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.createSQLQuery("delete from Product where restaurantId= "+id+"").executeUpdate();
				session.createSQLQuery("delete from Restaurant where RestaurantID = "+id+"").executeUpdate();
				tx.commit();
				session.close();
			} 
		 
	
	public String updateRestaurant(String name, long phoneNumber,String price,String address,String Image,Integer restaurantId) {
		{
			Session session = this.sessionFactory.openSession();
		
			Transaction tx = session.beginTransaction();
		
			Restaurant restaurant = (Restaurant) session.get(Restaurant.class, restaurantId);
			restaurant.getRestaurantId();
			restaurant.setName(name);
			restaurant.setAddress(address);
			restaurant.setPhoneNumber(phoneNumber);
			restaurant.setPrice(price);
			restaurant.setImage(Image);
			
           
			tx.commit();
			session.close();
			return " Record Update Successfull..";
		}
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	