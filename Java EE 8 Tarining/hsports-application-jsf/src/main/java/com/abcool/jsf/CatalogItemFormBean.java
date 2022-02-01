package com.abcool.jsf;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.abcool.CatalogItem;
import com.abcool.ICatalog;

@Named
@SessionScoped
public class CatalogItemFormBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3602124267848495220L;
	
	@Inject
	private ICatalog catalogBean;
	
	@Inject
	private IInventory inventoryService;
	
	private CatalogItem item = new CatalogItem();
	private List<CatalogItem> items = new ArrayList<>();
	
	public String addItem() {
		long itemId = this.catalogBean.getItems().size()+1;
		this.catalogBean.addItem(new CatalogItem(itemId, this.item.getName(),this.item.getManufacturer(),
				this.item.getDescription(),this.item.getAvailableDate()));
		this.inventoryService.createItem(this.item.getItemId(), this.item.getName());
		return "list?faces-redirect=true";
	}
	
	public void init() {
		this.items = this.catalogBean.getItems();
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
