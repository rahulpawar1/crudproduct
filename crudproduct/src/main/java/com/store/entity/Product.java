package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//model class
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PRODUCT_TBL")
public class Product {

	@Id
	@GeneratedValue //this id we need auto generated so we use @GeneratedValue annotation.
	private int id;
	@SuppressWarnings("unused")
	private String name;
	
	@SuppressWarnings("unused")
	private int quantity;
	
	@SuppressWarnings("unused")
	private double price;
	
}
