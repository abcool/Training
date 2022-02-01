package com.abcool.jsf;

public class InventoryItem {

	private Long inventoryItemId,catalogItemId,quantity;
	String name;
	
	public InventoryItem() {
		
	}

	public InventoryItem(Long inventoryItemId, Long catalogItemId, Long quantity, String name) {
		this.inventoryItemId = inventoryItemId;
		this.catalogItemId = catalogItemId;
		this.quantity = quantity;
		this.name = name;
	}

	public Long getInventoryItemId() {
		return inventoryItemId;
	}

	public Long getCatalogItemId() {
		return catalogItemId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	public void setInventoryItemId(Long inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public void setCatalogItemId(Long catalogItemId) {
		this.catalogItemId = catalogItemId;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
