package com.godoro.spring.layer.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class CartProduct {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartProductId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	//private long productId;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
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
