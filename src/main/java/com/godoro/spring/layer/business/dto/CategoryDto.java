package com.godoro.spring.layer.business.dto;

import java.util.List;

import com.godoro.spring.layer.data.entity.Product;

public class CategoryDto {
	
	private long categoryId;
	private String categoryName;
	private List<Product> productList;
	private String imgPath;
	
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
	
	

}
