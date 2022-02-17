package com.store.service;

import java.util.List;
import com.store.entity.Product;
import com.store.model.CreateProductRequest;

public interface ProductService {

	public Product saveProduct(CreateProductRequest productRequest);
	
	public List<Product> saveProducts(List<Product> products);
	
	public List<Product> allProduct();

	public Product update(int id);
}
