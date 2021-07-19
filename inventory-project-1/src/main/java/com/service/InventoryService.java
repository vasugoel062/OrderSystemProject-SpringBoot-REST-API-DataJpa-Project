package com.service;

import com.bean.Inventory;
import com.bean.InventoryList;

public interface InventoryService {

	public Inventory findInventoryByCode(String code);
	public InventoryList findAll();
	public void updateQuantity(Inventory inventory);
}
