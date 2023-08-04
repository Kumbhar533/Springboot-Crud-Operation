package com.nilesh.springboot.crud.service;

import java.util.List;


import com.nilesh.springboot.crud.model.Product;

public interface ProductService {
	
	public List<Product> get();
	
	public Product getbyId(int id);
	
	public Product createproduct(Product product);
	
	public Product update(Product product);
	
	public void delete(int id);
	
	public List<Product> get(int page,int size);
	
	

}
