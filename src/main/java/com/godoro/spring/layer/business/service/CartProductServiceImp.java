package com.godoro.spring.layer.business.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.godoro.spring.layer.business.dto.CartProductDto;
import com.godoro.spring.layer.data.entity.Cart;
import com.godoro.spring.layer.data.entity.CartProduct;
import com.godoro.spring.layer.data.entity.Product;
import com.godoro.spring.layer.data.repository.CartProductRepository;
import com.godoro.spring.layer.data.repository.CartRepository;
import com.godoro.spring.layer.data.repository.ProductRepository;

@Service
public class CartProductServiceImp implements CartProductService {

	CartProductRepository cartProductRepository;
	CartRepository cartRepository;
	ProductRepository productRepository;

	public CartProductServiceImp(CartProductRepository cartProductRepository, CartRepository cartRepository,
			ProductRepository productRepository) {
		this.cartProductRepository = cartProductRepository;
		this.cartRepository = cartRepository;
		this.productRepository = productRepository;

	}

	@Override
	public void add(long cartId, long productId) {

		CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);

		if (cartProduct != null) {

			Optional<Cart> optionalCart = cartRepository.findById(cartId);
			Optional<Product> optionalProduct = productRepository.findById(productId);

			int salesQuantity = cartProduct.getSalesQuantity();
			cartProduct.setSalesQuantity(salesQuantity + 1);
			cartProduct.setCart(optionalCart.get());
			cartProduct.setProduct(optionalProduct.get());

			cartProductRepository.save(cartProduct);

		} else {

			cartProduct = new CartProduct();

			Optional<Cart> optionalCart = cartRepository.findById(cartId);
			Optional<Product> optionalProduct = productRepository.findById(productId);

			if (optionalCart.isPresent() && optionalProduct.isPresent()) {

				cartProduct.setCart(optionalCart.get());
				cartProduct.setProduct(optionalProduct.get());
				cartProduct.setSalesQuantity(1);

				cartProductRepository.save(cartProduct);

			}

		}

	}

	@Override
	public void remove(long cartId, long productId) {

		CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);

		if (cartProduct != null) {

			cartProductRepository.deleteById(cartProduct.getId());

		}

	}
	
	@Override
	public void removeOneItem(long cartId, long productId) {
		// TODO Auto-generated method stub
		CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);
		if (cartProduct != null) {
			
			cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() - 1 );

			cartProductRepository.save(cartProduct);
		}

		
	}
	
	
	

	public CartProduct toEntity(CartProductDto cartProductDto) {

		CartProduct cartProduct = new CartProduct();

		cartProduct.setId(cartProductDto.getId());
		cartProduct.setProduct(cartProductDto.getProduct());
		cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());

		return cartProduct;

	}

	public CartProductDto toDto(CartProduct cartProduct) {

		CartProductDto cartProductDto = new CartProductDto();

		cartProductDto.setId(cartProduct.getId());
		cartProductDto.setCartId(cartProduct.getCart().getId());
		cartProductDto.setProduct(cartProduct.getProduct());
		cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());

		return cartProductDto;

	}

	




	

}
