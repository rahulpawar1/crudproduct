package com.store.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "SELECT name FROM product_tbl prod WHERE prod.name = ?1", nativeQuery = true)
	Optional<Product> findByName(String name);
	
}
