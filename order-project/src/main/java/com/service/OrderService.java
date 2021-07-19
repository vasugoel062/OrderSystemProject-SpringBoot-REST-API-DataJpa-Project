package com.service;

import com.bean.Order;
import com.bean.OrderList;

public interface OrderService {
	public OrderList getAllOrders();

	public Order createOrder(Order order);

	public Order findOrderById(int id);

	public int getHighestOrderId();

	public int getHighestOrderItemId();
}
