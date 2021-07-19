package com.persistence;

import java.util.List;
import java.util.Optional;

import com.bean.Product;
import com.bean.ProductList;

public interface ProductDao {
	List<Product> findAllProducts();

	Product findProductByCode(String code);
	Product findProductById(int id);
}
