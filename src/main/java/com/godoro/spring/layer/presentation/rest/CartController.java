package com.godoro.spring.layer.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.spring.layer.business.dto.CartDto;
import com.godoro.spring.layer.business.service.CartService;
import com.godoro.spring.layer.data.entity.CartProduct;
import com.godoro.spring.layer.data.repository.CartProductRepository;
import com.godoro.spring.layer.data.repository.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	CartService cartService;
	
	public CartController(CartService cartService ) {
		this.cartService = cartService;
	}
	
	
	@GetMapping("/get/{cartId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public CartDto getCart(@PathVariable("cartId") long cartId) {	
		try {
			return cartService.find(cartId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
			
	}
	
	@PutMapping("/checkout")
	@CrossOrigin(origins = "http://localhost:3000")
	public void checkoutCart(@RequestBody CartDto cartDto) {	
		try {

			cartService.checkout(cartDto);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			
	}
	
	/*
	 * @GetMapping("/get/maxId")
	 * 
	 * @CrossOrigin(origins = "http://localhost:3000") public Long getCart() {
	 * return cartService.findMaxId();
	 * 
	 * }
	 */
	
	

}
