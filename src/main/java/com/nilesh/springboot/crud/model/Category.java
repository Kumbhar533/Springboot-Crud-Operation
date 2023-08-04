package com.nilesh.springboot.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category_tbl")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Category_id")
	private Integer CategoryId;
	
	
	@Column(name="Category_name")
	private String CategoryName;


	public Integer getCategoryId() {
		return CategoryId;
	}


	public void setCategoryId(Integer categoryId) {
		CategoryId = categoryId;
	}


	public String getCategoryName() {
		return CategoryName;
	}


	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
	
	public Category()
	{
		
	}

	public Category(Integer categoryId, String categoryName) {
		super();
		CategoryId = categoryId;
		CategoryName = categoryName;
	}
	
	
	

}
