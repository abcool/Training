package com.abcool.jsf;

import java.io.Serializable;

public interface IInventory extends Serializable{

	public void createItem(Long catalogItemId, String name);
	public Long getQuantity(Long catalogItemId);
}
