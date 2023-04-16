package com.godoro.spring.layer.business.dto;

import com.godoro.spring.layer.data.entity.Cart;
import com.godoro.spring.layer.data.entity.Product;

public class CartProductDto {
	
	private long id;
	private long cartId;
	private Product product;
	private int salesQuantity;
	
	
	public long getId() {
		return id;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	
	
	
	

}
