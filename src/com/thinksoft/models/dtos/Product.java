package com.thinksoft.models.dtos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public abstract class Product {
	@DatabaseField(generatedId=true, useGetSet=true)
	protected int idProduct;
	@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
	protected String code;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected String name;
	@DatabaseField(useGetSet=true, canBeNull=false, defaultValue="0")
	protected float quantity;
	@DatabaseField(useGetSet=true, canBeNull=false, defaultValue="0")
	protected float price;
	
	public Product() {
	}
}
