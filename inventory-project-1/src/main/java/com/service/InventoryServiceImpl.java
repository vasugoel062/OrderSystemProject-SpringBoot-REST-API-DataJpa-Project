package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Inventory;
import com.bean.InventoryList;
import com.persistence.InventoryDao;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryDao inventoryDao;

	@Override
	public Inventory findInventoryByCode(String code) {
		return inventoryDao.findInventoryByCode(code);
	}

	@Override
	public InventoryList findAll() {
		return new InventoryList(inventoryDao.findAll());
	}

	@Override
	public void updateQuantity(Inventory inventory) {
		if (inventory.getQuantity() != 0) {
			inventoryDao.updateQuantity(inventory.getQuantity(), inventory.getId());
		} else {
			inventoryDao.delete(inventory);
		}
	}
}
