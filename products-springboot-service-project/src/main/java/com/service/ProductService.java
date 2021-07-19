package com.service;

import java.util.List;

import com.bean.Product;
import com.bean.ProductList;
import com.persistence.ProductDao;

public interface ProductService {

	public ProductList findAllProducts();

	public Product findProductByCode(String code);
	
	public Product findProductById(int id);
}
