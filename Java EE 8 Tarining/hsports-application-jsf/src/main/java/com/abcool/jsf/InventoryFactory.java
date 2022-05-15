package com.abcool.jsf;

import java.time.LocalDateTime;

import javax.enterprise.inject.Produces;

public class InventoryFactory {
	
	//@Produces
	public IInventory createInstance() {
		IInventory inventoryService = null;
		if(LocalDateTime.now().getHour()<12) {
			inventoryService = new RemoteInventory();
		}else {
			inventoryService = new LocalInventory();
		}
		return inventoryService;
	}

}
