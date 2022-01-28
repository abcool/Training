package com.abcool;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ICatalog {
	
	public List<CatalogItem> getItems();
	
	public void addItem(CatalogItem item);

}
