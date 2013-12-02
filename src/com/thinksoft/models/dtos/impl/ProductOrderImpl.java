package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.ProductOrder;

public class ProductOrderImpl implements ProductOrder {

	
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected int quantity;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected int total;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true)
	protected OrderImpl order;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true)
	protected ProductImpl product;
	
	public ProductOrderImpl() {
	}
	
	public ProductOrderImpl(int quantity, int total, Order order,
			Product product) {
		super();
		this.quantity = quantity;
		this.total = total;
		this.order = (OrderImpl) order;
		this.product = (ProductImpl) product;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotal() {
		return total;
	}

	public OrderImpl getOrder() {
		return order;
	}

	public ProductImpl getProduct() {
		return product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
 
	public void setTotal(int total) {
		this.total = total;
	}

	public void setOrder(OrderImpl order) {
		this.order = order;
	}

	public void setProduct(ProductImpl product) {
		this.product = product;
	}
	
	
}
