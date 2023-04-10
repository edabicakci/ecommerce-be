package com.godoro.spring.layer.business.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.godoro.spring.enums.CartStatus;
import com.godoro.spring.layer.business.dto.CartDto;
import com.godoro.spring.layer.data.entity.Cart;
import com.godoro.spring.layer.data.repository.CartRepository;

@Service
public class CartServiceImp implements CartService {

	CartRepository cartRepository;

	public CartServiceImp(CartRepository cartRepository) {

		this.cartRepository = cartRepository;
	}

	@Override
	public void checkout(CartDto cartDto) {
	
		Optional<Cart> optional = cartRepository.findById(cartDto.getCartId());
		if(optional.isPresent()) {
			
			Cart cart = optional.get();
			CartStatus cartStatus = cart.getCartStatus();
			
			if(cartStatus == CartStatus.NEW) {
				cart.setCartStatus(CartStatus.COMPLETED);
				cartRepository.save(cart);
			}
		}
		
	}

	
	// finds the cart and if doesn't exist, create one
	@Override
	public CartDto find(long cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);

		if (optional.isPresent()) {
			return toDto(optional.get());

		} else {
			
			if(cartId == 0) {
				CartDto cartDto = new CartDto();
				cartDto.setCartStatus(CartStatus.NEW);

				Cart cart = cartRepository.save(toEntity(cartDto));
				return toDto(cart);
				
			}
return null;
			
		}

	}

	private Cart toEntity(CartDto cartDto) {
		Cart cart = new Cart();

		cart.setCartId(cartDto.getCartId());
		cart.setCustomerName(cartDto.getCustomerName());
		cart.setCardNumber(cartDto.getCardNumber());
		cart.setCartProductList(cartDto.getCartProductList());
		cart.setCartStatus(cartDto.getCartStatus());

		return cart;
	}

	private CartDto toDto(Cart cart) {

		CartDto cartDto = new CartDto();

		cartDto.setCartId(cart.getCartId());
		cartDto.setCustomerName(cart.getCustomerName());
		cartDto.setCartProductList(cart.getCartProductList());
		cartDto.setCardNumber(cart.getCardNumber());
		cartDto.setCartStatus(cart.getCartStatus());

		return cartDto;

	}

	/*
	 * @Override public Long findMaxId() { return cartRepository.findMaxId(); }
	 */

}
