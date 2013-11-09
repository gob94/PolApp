 package com.thinksoft.models.dtos;

import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.impl.OrderImpl;
import com.thinksoft.models.dtos.impl.ProductImpl;

@DatabaseTable
public interface ProductOrder {
	
	public int getQuantity();

	public int getTotal();

	public OrderImpl getOrder();

	public ProductImpl getProduct();

	public void setQuantity(int quantity);
 
	public void setTotal(int total);

	public void setOrder(OrderImpl order);

	public void setProduct(ProductImpl product);
}
