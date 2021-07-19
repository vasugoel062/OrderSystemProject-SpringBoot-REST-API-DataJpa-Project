package com.bean;

import java.util.List;


public class OrderList {
	List<Order> items;

	public OrderList() {
		
	}
	public OrderList(List<Order> items) {
		super();
		this.items = items;
	}
	public List<Order> getItems() {
		return items;
	}
	public void setItems(List<Order> items) {
		this.items = items;
	}
	
	
}
