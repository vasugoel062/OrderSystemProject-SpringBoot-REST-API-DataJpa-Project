package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Order;
import com.bean.OrderList;
import com.persistence.OrderDao;
import com.persistence.OrderItemDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderItemDao orderItemDao;

	@Override
	public Order createOrder(Order order) {
		Order or = orderDao.save(order);
		return or;
	}

	@Override
	public Order findOrderById(int id) {
		Optional<Order> order = orderDao.findById(id);
		Order or = null;
		if (order.isPresent()) {
			or = order.get();
		}
		return or;
	}

	@Override
	public OrderList getAllOrders() {
		return new OrderList(orderDao.findAll());
	}

	@Override
	public int getHighestOrderId() {
		return orderDao.getHighestOrderId();
	}

	@Override
	public int getHighestOrderItemId() {
		return orderItemDao.getHighestOrderItemId();
	}

}
