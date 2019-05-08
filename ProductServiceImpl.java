package com.bhook.ordermanagement.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhook.ordermanagement.dao.ProductDao;
import com.bhook.ordermanagement.dao.RestaurantDao;
import com.bhook.ordermanagement.model.Product;

@Service
public class ProductServiceImpl implements ProductService
{ @Autowired
	  ProductDao productDao;

	public void saveProduct(Product product) {
		productDao.saveProduct(product);
		
	}

	public List<Product> productList() {
		return productDao.productList();
	}

	public Map<String, String> getFoodItems(int id) {
		
		return productDao.getFoodItems(id);
	}

	public List<Product> AllItems(int id) {
		return productDao.AllItems(id);
		
	}
	
	
}