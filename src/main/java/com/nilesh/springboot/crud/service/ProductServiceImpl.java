package com.nilesh.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nilesh.springboot.crud.model.Product;
import com.nilesh.springboot.crud.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productrepo;
	
	@Override
	public List<Product> get() {
		
		return productrepo.findAll();
	}

	@Override
	public Product getbyId(int id) {
		
		return productrepo.findById(id).orElse(null);
	}

	@Override
	public Product createproduct(Product product) {
		
		return productrepo.save(product);
	}

	@Override
	public Product update(Product product) {
		
		return productrepo.save(product);
	}

	@Override
	public void delete(int id) {
		productrepo.deleteById(id);
		
	}

	@Override
	public List<Product> get(int page, int size) {
		Pageable existprodut=PageRequest.of(page, size);
		
		Page<Product> pages=productrepo.findAll(existprodut);
		return pages.getContent();
	}

}
