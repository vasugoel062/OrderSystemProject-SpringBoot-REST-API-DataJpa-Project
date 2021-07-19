package com.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Order;
import com.bean.OrderList;
import com.service.OrderService;

@RestController
public class OrderResource {

	@Autowired
	private OrderService orderService;

	@GetMapping(path = "/orders", produces = "application/json")
	public OrderList getAllOrders() {
		return orderService.getAllOrders();
	}

	@PostMapping(path = "/orders", produces = "application/json", consumes = "application/json")
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}

	@GetMapping(path = "/orders/{id}", produces = "application/json")
	public Order findOrderById(@PathVariable("id") int id) {
		return orderService.findOrderById(id);
	}

	@GetMapping(path = "/orders/highestId", produces = "application/json")
	public Integer getHighestOrderId() {
		return new Integer(orderService.getHighestOrderId());
	}

	@GetMapping(path = "/orderItems/highestId", produces = "application/json")
	public Integer getHighestOrderItemId() {
		return new Integer(orderService.getHighestOrderItemId());
	}
}
