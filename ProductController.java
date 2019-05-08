package com.bhook.ordermanagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhook.ordermanagement.model.Product;
import com.bhook.ordermanagement.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productservice; 

	
	
	@RequestMapping(value = "/getProductsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getRestaurantById(@PathVariable int id) {
		return productservice.getFoodItems(id);
	}
	@RequestMapping(value = "/getProducts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getRestaurants(@PathVariable int id) {
		return productservice.AllItems(id);
	}
}
