package com.nilesh.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nilesh.springboot.crud.model.Category;
import com.nilesh.springboot.crud.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryrepo;
	
	
	 @Override
	public List<Category> get() {
		
		return categoryrepo.findAll();
	}
	 
	 
     @Override
	public Category getdatabyid(int id) {
		
		return  categoryrepo.findById(id).orElse(null);
	}

     
     @Override
 	public Category update(Category category) {
 		
 		return categoryrepo.save(category);
 	}

	@Override
	public Category create(Category category) {
		
		return categoryrepo.save(category);
	}


	@Override
	public void delete(int id) {
		
		categoryrepo.deleteById(id);
		
	}


	@Override
	public List<Category> get(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		
		Page<Category> getpage=categoryrepo.findAll(pageable);
		return getpage.getContent();
	}
	
	
	
	


	
     
     
     
	
	

}
