package com.bean;

public class Shopping {

	private Integer id;
	private String name;
	private double price;
	private int quantityAvailable;
	
	public Shopping(){
		
	}

	public Shopping(Integer id, String name, double price, int quantityAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
	}

	public Shopping(Integer id)
	{
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	
}
