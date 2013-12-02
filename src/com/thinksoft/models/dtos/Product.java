package com.thinksoft.models.dtos;

import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public interface Product {
 
	public int getIdProduct();

	public void setIdProduct(int idProduct);
 
	public String getCode();

	public void setCode(String code);

	public String getName();
	
	public void setName(String name);

	public long getQuantity();

	public void setQuantity(long quantity);

	public long getPrice();

	public void setPrice(long price);
}
