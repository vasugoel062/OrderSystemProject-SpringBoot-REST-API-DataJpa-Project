package com.bean;

import java.util.List;

public class InventoryList {

	public List<Inventory> inventoryList;
	
	public InventoryList(){
		
	}

	public InventoryList(List<Inventory> inventoryList) {
		super();
		this.inventoryList = inventoryList;
	}

	public List<Inventory> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}
	
}
