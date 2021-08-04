package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.Product;
import com.store.service.ProductService;

@RestController
public class ProductController {
	
	//controller talk to the service layer so we need to inject here
	@Autowired
	ProductService productService;
	
	@PostMapping("/addproduct")
	public Product addProduct (@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/addproducts")
		public List<Product> addProducts(@RequestBody List<Product> products){
			
			return productService.saveProducts(products);
		}
	
	

}
