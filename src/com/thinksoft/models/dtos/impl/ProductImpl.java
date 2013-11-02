package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Product;

public class ProductImpl implements Product{
	
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
	

	public ProductImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductImpl(String code, String name, float quantity,
			float price) {
		super();
		this.code = code;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
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
