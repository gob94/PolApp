package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Product {

	@DatabaseField(generatedId=true, useGetSet=true)
	private int idProduct;
	@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
	private String code;
	@DatabaseField(useGetSet=true, canBeNull=false)
	private String name;
	@DatabaseField(useGetSet=true, canBeNull=false, defaultValue="0")
	private float quantity;
	@DatabaseField(useGetSet=true, canBeNull=false, defaultValue="0")
	private float price;

	public Product() {
	}
	
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
