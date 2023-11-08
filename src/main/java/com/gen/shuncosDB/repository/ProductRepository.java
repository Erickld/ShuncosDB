package com.gen.shuncosDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.shuncosDB.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}