package com.bhook.ordermanagement.dao;

import java.util.List;
import java.util.Map;

import com.bhook.ordermanagement.model.Product;


public interface ProductDao {
public void saveProduct(Product product);
	
	public List<Product> productList();

	public Map<String, String> getFoodItems(int id);
	
	public List<Product> AllItems(int id);
}
