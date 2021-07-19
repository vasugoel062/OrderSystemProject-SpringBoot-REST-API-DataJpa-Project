package com.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.Product;
import com.bean.ProductList;
import com.helper.ProductRowMapper;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = jdbcTemplate.query("select * from product", new ProductRowMapper());
		return products;
	}

	@Override
	public Product findProductByCode(String code) {

		Object ob[] = { code };
		Product product = jdbcTemplate.queryForObject("select * from product where code = ?", ob,new ProductRowMapper());
		return product;

	}

	@Override
	public Product findProductById(int id) {
		Object ob[] = { id };
		Product product = jdbcTemplate.queryForObject("select * from product where id = ?", ob,new ProductRowMapper());
		return product;
	}

}
