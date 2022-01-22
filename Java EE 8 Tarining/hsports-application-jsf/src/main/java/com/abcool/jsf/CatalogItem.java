package com.abcool.jsf;

import java.time.LocalDate;

public class CatalogItem {
	private Long itemId;
	private String name;
	private String manufacturer;
	private String description;
	private LocalDate availableDate;
	
	public CatalogItem() {}

	public CatalogItem(Long itemId, String name, String manufacturer, String description, LocalDate availableDate) {
		this.itemId = itemId;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.availableDate = availableDate;
	}

	public Long getItemId() {
		return itemId;
	}

	public String getName() {
		return name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}
	
	
}
