package com.godoro.spring.layer.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.godoro.spring.layer.data.entity.CartProduct;


public interface CartProductRepository extends CrudRepository<CartProduct, Long>{
	
	
	  //@Query("select p from CartProduct p where p.cart.cartId = :cartId and p.product.productId = :productId" ) 
	CartProduct findByCartIdAndProductId( @Param("cartId") long
	  cartId, @Param("productId")long productId);
	 
	
	List<CartProduct> findAllByCartId( @Param("cartId") long cartId);
}
