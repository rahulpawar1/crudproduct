package com.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.Product;
import com.store.model.CreateProductRequest;
import com.store.service.ProductService;


@RestController
@RequestMapping("/api/product/")
public class ProductController {
	
	//controller talk to the service layer so we need to inject here
	
	@Autowired
	ProductService productService;
	
	static final Logger LOG = LoggerFactory.getLogger(ProductController.class); 
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody @Valid CreateProductRequest productRequest, BindingResult bindingResult)
			throws Exception {
		try {
			LOG.info("Adding new product using CreateProductRequest: {}", productRequest.toString());
			
			if(bindingResult.hasErrors()) {
				StringBuilder message = new StringBuilder("");
				for(ObjectError oe : bindingResult.getAllErrors()) {
					FieldError fe = (FieldError) oe;
					message.append(fe.getField());
					message.append(":");
					message.append(fe.getDefaultMessage());
					message.append(".");
					LOG.info("Error while validating add product: {} : {}.....", fe.getField(), fe.getDefaultMessage());
				}
				
				 return buildResponseEntityCustomMessage(HttpStatus.BAD_REQUEST, message.toString());
			}
			
//			if(StringUtils.isBlank(productRequest.getName())){
//				throw new ValidationException(ProductServiceErrorCode.INVALID_NAME.name());
//			}			
			//check product already exist or not by name
//			Boolean isExist = productService.findProduct(productRequest.getName());
//			
//			if(isExist) {
//			Product product = new Product();
//			product.setIsPresent(isExist);
//			
//			return new ResponseEntity<Product>(product, HttpStatus.OK);
//			}
//			
			//save product call
			Product saveProduct = productService.saveProduct(productRequest);
			return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private ResponseEntity<Product> buildResponseEntityCustomMessage(HttpStatus badRequest, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/add-products")
	public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products){
		List<Product> saveProducts = productService.saveProducts(products);
		return new ResponseEntity<>(saveProducts, HttpStatus.CREATED);
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
