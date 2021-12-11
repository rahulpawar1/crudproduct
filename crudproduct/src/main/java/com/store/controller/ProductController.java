package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.Product;
import com.store.service.ProductService;

@RestController("api/product")
public class ProductController {
	
	//controller talk to the service layer so we need to inject here
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct (@RequestBody Product product) {
		Product saveProduct = productService.saveProduct(product);
		return new ResponseEntity<>(saveProduct, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/add-products")
	public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products){
		List<Product> saveProducts = productService.saveProducts(products);
		return new ResponseEntity<>(saveProducts, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Product>> productList(){
		List<Product> productList = productService.allProduct();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id){
		Product updatedProduct = productService.update(id);
		return new ResponseEntity<>(updatedProduct, HttpStatus.ACCEPTED);
		
	}
		
}
