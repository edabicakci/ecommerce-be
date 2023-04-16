package com.godoro.spring.layer.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.spring.layer.business.dto.ProductDto;
import com.godoro.spring.layer.business.service.ProductService;

@RestController
public class ProductController {

	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;

	}
	
	
	@GetMapping("/product/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ProductDto getProduct(@PathVariable("id") long productId) {
		
		try {
			return productService.find(productId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@GetMapping("/products/{categoryId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<ProductDto> getProductsByCategoryId(@PathVariable("categoryId") long categoryId) {
		try {
			return productService.findByCategory(categoryId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
