package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ProductOrder {
	
	@DatabaseField(useGetSet=true, canBeNull=false)
	private int quantity;
	@DatabaseField(useGetSet=true, canBeNull=false)
	private int total;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true)
	private Order order;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true)
	private Product product;
	
	public ProductOrder() {
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotal() {
		return total;
	}

	public Order getOrder() {
		return order;
	}

	public Product getProduct() {
		return product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
