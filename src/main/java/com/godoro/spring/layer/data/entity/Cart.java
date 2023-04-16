package com.godoro.spring.layer.data.entity;

import java.util.List;

import com.godoro.spring.enums.CartStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String customerName;
	private String cardNumber;
	private CartStatus cartStatus;
	
	/*
	 * @OneToMany(mappedBy="cart", cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	 * private List<CartProduct> cartProductList;
	 */
	
	
	

	/*
	 * public List<CartProduct> getCartProductList() { return cartProductList; }
	 * public void setCartProductList(List<CartProduct> cartProductList) {
	 * this.cartProductList = cartProductList; }
	 */
	
	public String getCustomerName() {
		return customerName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
