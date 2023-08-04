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

import com.nilesh.springboot.crud.model.Product;
import com.nilesh.springboot.crud.service.ProductService;


@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@GetMapping
	public List<Product> getAll(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size)
	{
      return 	productservice.get(page,size);	
	}
	
	
	
	
	@PostMapping
	public Product create( @RequestBody Product product)
	{
	return productservice.createproduct(product);	
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getbyId(@PathVariable int id)
	{
		Product pro=productservice.getbyId(id);
		
		if(pro!=null)
		{
			return ResponseEntity.ok(pro);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable int id,@RequestBody Product product)
	{
		Product prod=productservice.getbyId(id);
		
		if(prod!=null)
		{
			product.setProductid(id);
			return ResponseEntity.ok(productservice.update(product));
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable int  id)
	{
		Product prod=productservice.getbyId(id);
		
		if(prod!=null)
		{
			productservice.delete(id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.notFound().build();
	}

}
