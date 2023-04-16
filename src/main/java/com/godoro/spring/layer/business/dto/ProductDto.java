package com.godoro.spring.layer.business.dto;

import com.godoro.spring.layer.data.entity.Category;

import java.util.List;

import com.godoro.spring.layer.data.entity.CartProduct;

public class ProductDto {
	
	private long id;
	private String productName;
	private double salesPrice;
	private Category category;

	/*
	 * private List<CartProduct> cartProduct;
	 * 
	 * 
	 * public List<CartProduct> getCartProduct() { return cartProduct; } public void
	 * setCartProduct(List<CartProduct> cartProduct) { this.cartProduct =
	 * cartProduct; }
	 */
	
	public String getProductName() {
		return productName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
	
	

}
