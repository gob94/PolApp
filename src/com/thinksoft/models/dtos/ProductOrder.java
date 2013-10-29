package com.thinksoft.models.dtos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.Product;

@DatabaseTable
public abstract class ProductOrder {

	@DatabaseField(useGetSet=true, canBeNull=false)
	protected int quantity;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected int total;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true)
	protected Order order;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true)
	protected Product product;
}
