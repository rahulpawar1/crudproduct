package com.store.service;

import java.util.List;

import com.store.entity.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	
	public List<Product> saveProducts(List<Product> products);
	
	public List<Product> productList();
	
	public List<Product> allProduct();

	public Product update(int id);
}
