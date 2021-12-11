package com.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entity.Product;
import com.store.repository.ProductRepository;

@Service
public class ProductServiceImpl {
	// productService talk to the productRepository
		@Autowired
		ProductRepository repository;

		// save single product
		public Product saveProduct(Product product) { // this method accept the Product object and which save into database
														// through repository
			return repository.save(product);
		}

		// save multiple products
		public List<Product> saveProducts(List<Product> products) {

			return repository.saveAll(products);
		}

		// get single product
		public Product getProductById(int id) {
			
			return repository.findById(id).orElse(null);
		}

		// get multiple product

		public List<Product> getProductById(List<Product> products) {

			return repository.findAll();
		}
		
		// get product by name
			public Product getProductByName(String name) {
				
				return repository.findByName(name).orElse(null);
			}
			
		//delete product by id
			public String deleteProduct(int id) {
				repository.deleteById(id);
				return "product removed"+id;
			}
			
		//list of products
			public List<Product> findAll(){
				return repository.findAll();
			}
			
		//update product
			
//			public Product updateProduct(Product product) {
//				Product existingProduct = repository.findById(((Object) product).getId()).orElse(null);
//				
//			}
}
