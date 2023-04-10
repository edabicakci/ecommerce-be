package com.godoro.spring.layer.business.dto;

import com.godoro.spring.layer.data.entity.Cart;

public class CartProductDto {
	
	private long cartProductId;
	private Cart cart;
	private long productId;
	private int salesQuantity;
	
	
	
	public long getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	
	
	
	

}
