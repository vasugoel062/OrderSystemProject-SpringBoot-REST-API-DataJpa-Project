package com.bean;

public class Inventory {

	private int id;
	private String code;
	private int quantity;
	
	public Inventory(){
		
	}

	public Inventory(int id, String code, int quantity) {
		super();
		this.id = id;
		this.code = code;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
