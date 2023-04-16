package com.godoro.spring.layer.data.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Category {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String categoryName;
	private String imgPath;
	
	/*
	 * @OneToMany(mappedBy="category", cascade= CascadeType.ALL, fetch=
	 * FetchType.LAZY) private List<Product> productList;
	 */
	
	public String getImgPath() {
		return imgPath;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/*
	 * public List<Product> getProductList() { return productList; } public void
	 * setProductList(List<Product> productList) { this.productList = productList; }
	 */
	
	
	
	
	

}
