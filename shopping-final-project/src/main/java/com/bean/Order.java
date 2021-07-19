package com.bean;

import java.util.List;

public class Order {
	private int id;
	private String customerEmail;
	private String customerAddress;
	private List<OrderItem> items;
	public Order() {
		super();
	}
	public Order(int id, String customerEmail, String customerAddress, List<OrderItem> items) {
		super();
		this.id = id;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.items = items;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
}
