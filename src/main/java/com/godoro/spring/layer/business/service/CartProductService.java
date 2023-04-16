package com.godoro.spring.layer.business.service;

import com.godoro.spring.layer.business.dto.CartProductDto;
import com.godoro.spring.layer.data.entity.CartProduct;

public interface CartProductService {
	
	  
	  void add(long cartId, long productId); void remove (long cartProductId, long
	  productId);
	  CartProductDto toDto(CartProduct cartProduct);
	 

}
