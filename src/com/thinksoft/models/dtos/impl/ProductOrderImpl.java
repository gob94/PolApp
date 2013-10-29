package com.thinksoft.models.dtos.impl;

import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.ProductOrder;

public class ProductOrderImpl extends ProductOrder {

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
