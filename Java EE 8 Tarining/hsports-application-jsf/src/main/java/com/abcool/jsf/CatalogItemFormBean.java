package com.abcool.jsf;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class CatalogItemFormBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3602124267848495220L;
	
	private CatalogItem item = new CatalogItem();
	private List<CatalogItem> items = new ArrayList<>();
	
	public String addItem() {
		long itemId = items.size()+1;
		this.items.add(new CatalogItem(itemId, this.item.getName(),this.item.getManufacturer(),
				this.item.getDescription(),this.item.getAvailableDate()));
		return "list?faces-redirect=true";
	}
	
	public CatalogItem getItem() {
		return item;
	}
	public void setItem(CatalogItem item) {
		this.item = item;
	}
	public List<CatalogItem> getItems() {
		return items;
	}
	public void setItems(List<CatalogItem> items) {
		this.items = items;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
