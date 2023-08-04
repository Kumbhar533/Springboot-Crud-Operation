package com.nilesh.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilesh.springboot.crud.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
