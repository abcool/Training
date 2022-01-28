package com.abcool.jsf;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.abcool.CatalogItem;

@Named
@RequestScoped
public class CatalogItemDeleteBean {
	private long itemId;
	private CatalogItem item;
	
	@Inject
	private CatalogItemFormBean catalogItemFormBean;
	
	public void fetchItem() {
		List<CatalogItem> items = this.catalogItemFormBean.getItems().stream().filter(x->{
			return x.getItemId()==itemId;
		}).collect(Collectors.toList());
		
		if(items.isEmpty()) {
			this.item=null;
		}else {
			this.item= items.get(0);
		}
	}
	
	public String removeItem() {
		this.catalogItemFormBean.getItems().removeIf(x->{
			return x.getItemId().equals(this.itemId);
		});
		return "list?faces-redirect=true";
	}

	public long getItemId() {
		return itemId;
	}

	public CatalogItem getItem() {
		return item;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public void setItem(CatalogItem item) {
		this.item = item;
	}
	
	
}
