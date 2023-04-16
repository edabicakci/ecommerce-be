package com.godoro.spring.layer.business.dto;

import java.util.List;

import com.godoro.spring.enums.CartStatus;
import com.godoro.spring.layer.data.entity.CartProduct;

public class CartDto {
	
	private long id;
	private String customerName;
	private String cardNumber;
	private CartStatus cartStatus;
	private List<CartProductDto> cartProductList;
	  
	  
	public List<CartProductDto> getCartProductList() { 
		return cartProductList; 
	}
	
	public void setCartProductList(List<CartProductDto> cartProductList) {
	  this.cartProductList = cartProductList; 
	}
	 
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public CartStatus getCartStatus() {
		return cartStatus;
	}
	public void setCartStatus(CartStatus cartStatus) {
		this.cartStatus = cartStatus;
	}
	
	

}
