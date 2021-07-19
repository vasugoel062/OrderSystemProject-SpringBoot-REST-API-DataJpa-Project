package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.bean.ProductList;
import com.persistence.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public ProductList findAllProducts() {
		return new ProductList(productDao.findAllProducts());
	}

	@Override
	public Product findProductByCode(String code) {
		Optional<Product> prod = Optional.ofNullable(productDao.findProductByCode(code));
		Product product = null;
		if (prod.isPresent()) {
			product = prod.get();
		}
		return product;
	}

	@Override
	public Product findProductById(int id) {
		return productDao.findProductById(id);
	}
	

}
