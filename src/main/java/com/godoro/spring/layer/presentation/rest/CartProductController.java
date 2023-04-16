package com.godoro.spring.layer.presentation.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.spring.layer.business.service.CartProductService;

@RestController
@RequestMapping("/cart")
public class CartProductController {
	
	CartProductService cartProductService;
	
	public CartProductController(CartProductService cartProductService) {
		this.cartProductService = cartProductService;	
		
	}
	
	
	  @PostMapping("/add/{cartId}/{productId}")
	  
	  @CrossOrigin(origins = "http://localhost:3000") 
	  public void addCartProduct(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		  
		  try {
			  cartProductService.add(cartId, productId);
				
			}catch(Exception e) {
				e.printStackTrace();
			}

	  }
	  
	  @DeleteMapping("/remove/{cartId}/{productId}")
	  
	  @CrossOrigin(origins = "http://localhost:3000") 
	  public void deleteCartProduct(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		  
		try {
			cartProductService.remove(cartId, productId);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	  
	  }
	 
	  @PostMapping("/removeOneItem/{cartId}/{productId}")
	  
	  @CrossOrigin(origins = "http://localhost:3000") 
	  public void deleteCartProductOne(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		  
			try {
				 cartProductService.removeOneItem(cartId, productId);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	  
	 
	  
	  }
	
	
	
	
	
	

}
