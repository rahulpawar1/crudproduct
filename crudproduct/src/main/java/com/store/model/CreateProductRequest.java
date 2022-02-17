package com.store.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotBlank;

public class CreateProductRequest {

	private int id;	
	
	@NotBlank
	@Size(min=2)
	private String name;
	
	@NotNull
	private int quantity;
	
	@NotNull
	private double price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CreateProductRequest [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}	
}
