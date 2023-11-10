package com.gen.shuncosDB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.shuncosDB.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByModelContaining(String modelTxt);

}