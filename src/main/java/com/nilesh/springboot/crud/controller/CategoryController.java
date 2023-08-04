package com.nilesh.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nilesh.springboot.crud.model.Category;
import com.nilesh.springboot.crud.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryservice;
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getbyId(@PathVariable int id)
	{
		Category category=categoryservice.getdatabyid(id);
		
		if(category!=null)
		{
			return ResponseEntity.ok(category);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public Category saveData(@RequestBody Category category)
	{
		return categoryservice.create(category);
	}
	
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updatedata(@PathVariable int id,@RequestBody Category category)
	{
		Category categoryexist=categoryservice.getdatabyid(id);
		
		if(categoryexist!=null)
		{
			category.setCategoryId(id);
			return ResponseEntity.ok(categoryservice.update(category));
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id)
	{
		Category category=categoryservice.getdatabyid(id);
		if(category!=null)
		{
			categoryservice.delete(id);
			return ResponseEntity.notFound().build();
		}
		else
			return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping
	public List<Category> getAll(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10") int size)
	{
		return categoryservice.get(page,size);
	}
	

}
