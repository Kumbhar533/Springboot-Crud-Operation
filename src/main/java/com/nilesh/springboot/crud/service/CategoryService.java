package com.nilesh.springboot.crud.service;

import java.util.List;

import com.nilesh.springboot.crud.model.Category;

public interface CategoryService {
	
	public List<Category> get();
	
	public Category getdatabyid(int id);
	
	public Category update(Category category);
	
	public Category create(Category category);
	
	public void delete(int id);
	
	public List<Category> get(int page,int size);

}
