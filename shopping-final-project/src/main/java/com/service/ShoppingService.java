package com.service;

import java.util.List;

import com.bean.Order;
import com.bean.Shopping;

public interface ShoppingService {

	public List<Shopping> getProductList();
	public int getHighestOrderId();
	public int getHighestOrderItemId();
	public Order saveOrder(Order order);
	public void reduceQuantityOfPurchasedProducts(Order order);
}
