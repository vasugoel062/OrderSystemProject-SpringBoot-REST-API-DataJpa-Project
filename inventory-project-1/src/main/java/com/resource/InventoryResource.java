package com.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Inventory;
import com.bean.InventoryList;
import com.service.InventoryService;

@RestController
public class InventoryResource {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping(path = "/inventories", produces = "application/json")
	public InventoryList findAll() {
		return inventoryService.findAll();
	}

	@GetMapping(path = "/inventories/{code}", produces = "application/json")
	public Inventory findInventoryByCode(@PathVariable("code") String code) {
		return inventoryService.findInventoryByCode(code);
	}

	@PostMapping(path = "/inventories", produces = "application/json", consumes = "application/json")
	public void updateInventory(@RequestBody Inventory inventory) {
		inventoryService.updateQuantity(inventory);
	}
}
