package com.godoro.spring.layer.business.dto;

import java.util.List;

import com.godoro.spring.enums.CartStatus;
import com.godoro.spring.layer.data.entity.CartProduct;

public class CartDto {
	
	private long cartId;
	private String customerName;
	private String cardNumber;
	private CartStatus cartStatus;
	
	private List<CartProduct> cartProductList;
	
	
	public List<CartProduct> getCartProductList() {
		return cartProductList;
	}
	public void setCartProductList(List<CartProduct> cartProductList) {
		this.cartProductList = cartProductList;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
