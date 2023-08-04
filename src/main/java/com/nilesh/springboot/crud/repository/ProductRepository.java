package com.nilesh.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilesh.springboot.crud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
