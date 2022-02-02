package com.abcool.jsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.enterprise.inject.Alternative;

@RemoteService
@Alternative
public class RemoteInventory implements IInventory{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2366660323276337783L;
	private Map<Long,InventoryItem> items = new HashMap<>();
	
	@Override
	public void createItem(Long catalogItemId, String name) {
		long inventoryItemId = items.size()+1;
		this.items.put(catalogItemId, new InventoryItem(inventoryItemId,catalogItemId,0L,name));
		printInventory();
	}

	@Override
	public Long getQuantity(Long catalogItemId) {
		return 0L;
	}
	
	private void printInventory() {
		for(Entry<Long,InventoryItem> entry: items.entrySet()) {
			System.out.println("Remote Inventory contains: ");
			System.out.println("Item name: "+entry.getValue().name);
		}
	}

}
