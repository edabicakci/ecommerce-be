package com.godoro.spring.layer.business.dto;

import java.util.List;

import com.godoro.spring.layer.data.entity.Product;

public class CategoryDto {
	
	private long id;
	private String categoryName;
	//private List<Product> productList;
	private String imgPath;
	
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
