package com.godoro.spring.layer.business.service;

import com.godoro.spring.layer.business.dto.CartProductDto;
import com.godoro.spring.layer.data.entity.CartProduct;

public interface CartProductService {
	
	  
	  void add(long cartId, long productId); 
	  void remove (long cartId, long productId);
	  void removeOneItem(long cartId, long productId);
	  CartProductDto toDto(CartProduct cartProduct);
	
	 

}
