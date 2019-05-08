package com.bhook.ordermanagement.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhook.ordermanagement.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//method which provide me session
	public void setSessionFactory(SessionFactory sessionFactory){
	
		this.sessionFactory = sessionFactory;
		
	}
	
	//saving the customer
	public void saveProduct(Product product) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(product);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> productList() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Product> productList = session.createCriteria(Product.class).list();
		tx.commit();
		session.close();
		return productList;
	}
	@SuppressWarnings("unchecked")
    public Map<String, String> getFoodItems(int id)
	{
                    Session session = this.sessionFactory.openSession();
                    Transaction tx = session.beginTransaction();
                    
                    /*Criteria criteria= session.createCriteria(FoodItems.class);
                    criteria.add(Restrictions.eq("restaurant",id));
                    List<FoodItems> list=criteria.list();*/
                    List<Object[]> items = session.createSQLQuery("select NAME,PRICE from Product where restaurantId="+id).list();
                    System.err.println("RestaurantDao.getFoodItems()---->"+items);
                    
                    Map<String, String> mapResult = new LinkedHashMap<String,String>();
                    for(Object[] obj:items)
                    {
                                    
                                    mapResult.put((String)obj[0], (String)obj[1]);
                                    
                                  
                    }
                    
                    tx.commit();
                    session.close();
                    return mapResult;
    }
	
	@SuppressWarnings("unchecked")
	public List<Product> AllItems(int id) 
	{
	            Session session = this.sessionFactory.openSession();
	            Transaction tx = session.beginTransaction();

	            List<Object[]> items = session.createSQLQuery("select NAME,PRICE from Product where restaurantId="+id).list();
	            //System.err.println("RestaurantDao.AllItems()---->" + items);
	     List<Product> list= new ArrayList<Product>();
	            Map<String, String> mapResult = new LinkedHashMap<String,String>();
	            for (Object[] obj : items) 
	            { Product item= new Product();
	            item.setName((String) obj[0]);
	            item.setPrice((String) obj[1]);
	            list.add(item);
	            }
	            tx.commit();
	            session.close();
	            return list;
	}


			  

}
