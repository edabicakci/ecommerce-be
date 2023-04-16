package com.godoro.spring.layer.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.godoro.spring.enums.CartStatus;
import com.godoro.spring.layer.business.dto.CartDto;
import com.godoro.spring.layer.business.dto.CartProductDto;
import com.godoro.spring.layer.data.entity.Cart;
import com.godoro.spring.layer.data.entity.CartProduct;
import com.godoro.spring.layer.data.repository.CartProductRepository;
import com.godoro.spring.layer.data.repository.CartRepository;

@Service
public class CartServiceImp implements CartService {

	CartRepository cartRepository;
	
	CartProductRepository cartProductRepository;
	
	CartProductService cartProductService;

	public CartServiceImp(CartRepository cartRepository, CartProductRepository cartProductRepository,
			CartProductService cartProductService) {

		this.cartProductRepository = cartProductRepository;
		this.cartRepository = cartRepository;
		this.cartProductService = cartProductService;
	}

	@Override
	public void checkout(CartDto cartDto) {
		
		try {
			Optional<Cart> optional = cartRepository.findById(cartDto.getId());
			if(optional.isPresent()) {
				
				Cart cart = optional.get();
				CartStatus cartStatus = cart.getCartStatus();
				
				if(cartStatus == CartStatus.NEW) {
					cart.setCardNumber(cartDto.getCardNumber());
					cart.setCustomerName(cartDto.getCustomerName());
					cart.setCartStatus(CartStatus.COMPLETED);
					cartRepository.save(cart);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		
	}

	
	// finds the cart and if doesn't exist, create one
	@Override
	public CartDto find(long cartId) {
		
		try {
			Optional<Cart> optional = cartRepository.findById(cartId);

			if (optional.isPresent()) {
				List<CartProduct> cartProducts = cartProductRepository.findAllByCartId(cartId);
				
				 CartDto cartDto = toDto(optional.get());
				 List<CartProductDto> cartProductDtoList = new ArrayList<>();
				 
				 for(CartProduct cartProduct : cartProducts) {
					 cartProductDtoList.add(cartProductService.toDto(cartProduct));
				 }
				 
				 
				 cartDto.setCartProductList(cartProductDtoList);
				 
				 
				 return cartDto;

			} else {
				
				if(cartId == 0) {
					CartDto cartDto = new CartDto();
					cartDto.setCartStatus(CartStatus.NEW);

					Cart cart = cartRepository.save(toEntity(cartDto));
					return toDto(cart);
					
				}
				return null;
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return null;
	}

	private Cart toEntity(CartDto cartDto) {
		Cart cart = new Cart();

		cart.setId(cartDto.getId());
		cart.setCustomerName(cartDto.getCustomerName());
		cart.setCardNumber(cartDto.getCardNumber());
		//cart.setCartProductList(cartDto.getCartProductList());
		cart.setCartStatus(cartDto.getCartStatus());

		return cart;
	}

	private CartDto toDto(Cart cart) {

		CartDto cartDto = new CartDto();

		cartDto.setId(cart.getId());
		cartDto.setCustomerName(cart.getCustomerName());
		//cartDto.setCartProductList(cart.getCartProductList());
		cartDto.setCardNumber(cart.getCardNumber());
		cartDto.setCartStatus(cart.getCartStatus());

		return cartDto;

	}

	/*
	 * @Override public Long findMaxId() { return cartRepository.findMaxId(); }
	 */

}
