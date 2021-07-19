package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.Inventory;
import com.bean.Order;
import com.bean.OrderItem;
import com.bean.Product;
import com.bean.ProductList;
import com.bean.Shopping;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Shopping> getProductList() {

		ProductList productList = restTemplate.getForObject("http://localhost:8080/products", ProductList.class);
		List<Shopping> shoppingList = new ArrayList<>();
		Shopping shopping = null;
		for (Product product : productList.getProducts()) {
			Inventory inventory = restTemplate.getForObject("http://localhost:8082/inventories/" + product.getCode(),
					Inventory.class);
			shopping = new Shopping(product.getId(), product.getName(), product.getPrice(), inventory.getQuantity());
			shoppingList.add(shopping);
		}
		return shoppingList;
	}

	@Override
	public int getHighestOrderId() {
		int id = restTemplate.getForObject("http://localhost:8084/orders/highestId", Integer.class);
		System.out.println("Order id" + id);
		return id;
	}

	@Override
	public int getHighestOrderItemId() {
		int id = restTemplate.getForObject("http://localhost:8084/orderItems/highestId", Integer.class);
		System.out.println(id);
		return id;
	}

	@Override
	public Order saveOrder(Order order) {
		return restTemplate.postForObject("http://localhost:8084/orders", order, Order.class);
	}

	@Override
	public void reduceQuantityOfPurchasedProducts(Order order) {
		List<OrderItem> itemList = order.getItems();
		for (OrderItem orderItem : itemList) {
			Product p = restTemplate.getForObject("http://localhost:8080/product/" + orderItem.getProductId(),Product.class);
			Inventory inventory = restTemplate.getForObject("http://localhost:8082/inventories/" + p.getCode(),Inventory.class);
			int availableQuantity = inventory.getQuantity() - orderItem.getQuantity();
			inventory.setQuantity(availableQuantity);
			restTemplate.postForObject("http://localhost:8082/inventories", inventory, Inventory.class);
		}

	}

}
