package com.godoro.spring.layer.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.godoro.spring.layer.business.dto.ProductDto;
import com.godoro.spring.layer.data.entity.Product;
import com.godoro.spring.layer.data.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	ProductRepository productRepository;

	public ProductServiceImp(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	@Override
	public ProductDto find(long productId) {
		Optional<Product> optional = productRepository.findById(productId);

		if (optional.isPresent()) {
			return toDto(optional.get());
		}
		return null;
	}

	@Override
	public List<ProductDto> findByCategory(long categoryId) {

		List<ProductDto> productDtoList = new ArrayList<ProductDto>();

		for (Product product : productRepository.findByCategoryId(categoryId)) {

			productDtoList.add(toDto(product));

		}

		return productDtoList;
	}

	private ProductDto toDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setProductName(product.getProductName());
		productDto.setSalesPrice(product.getSalesPrice());
		//productDto.setCartProduct(product.getCartProduct());
		productDto.setCategory(product.getCategory());

		return productDto;
	}

}
