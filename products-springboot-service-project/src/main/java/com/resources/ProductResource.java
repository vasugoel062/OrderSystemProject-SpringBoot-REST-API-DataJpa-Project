package com.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;
import com.bean.ProductList;
import com.service.ProductService;

@RestController
public class ProductResource {
	@Autowired
	ProductService productService;

	@GetMapping(path = "/products", produces = "application/json")
	public ProductList findAllProductsController() {
		return productService.findAllProducts();
	}

	@GetMapping(path = "/products/{code}", produces = "application/json")
	public Product findProductByCodeController(@PathVariable("code") String code) {
		return productService.findProductByCode(code);
	}
	
	@GetMapping(path = "/product/{id}",produces = "application/json")
	public Product findProductByIdController(@PathVariable("id")int id) {
		return productService.findProductById(id);
	}

}
