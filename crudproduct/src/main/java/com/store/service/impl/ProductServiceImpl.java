package com.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entity.Product;
import com.store.model.CreateProductRequest;
import com.store.repository.ProductRepository;
import com.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	// productService talk to the productRepository
		@Autowired
		ProductRepository repository;

		// save single product
		public Product saveProduct(CreateProductRequest productRequest) { // this method accept the Product object and which save into database
			// through repository
			//create the object of entity class and set the values from CreateProductRequest into entity class Product
			Product product = new Product();
			product.setId(productRequest.getId());
			product.setName(productRequest.getName());
			product.setPrice(productRequest.getPrice());
			product.setQuantity(productRequest.getQuantity());
			
			Product saved = (Product)repository.save(product);
			return saved;
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
			@Override
			public List<Product> allProduct() {
				return repository.findAll();
			}

			@Override
			public Product update(int id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Boolean findProduct(String productName) {
				
				Optional<Product> productExist = repository.findByName(productName);
				
				if(productExist.isPresent()) {
					return true;
				}
				return false; 
			}
			
		//update product
			
//			public Product updateProduct(Product product) {
//				Product existingProduct = repository.findById(((Object) product).getId()).orElse(null);
//				
//			}
}
