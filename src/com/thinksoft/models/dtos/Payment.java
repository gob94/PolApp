package com.thinksoft.models.dtos;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.Employee;

@DatabaseTable
public abstract class Payment {
	
	@DatabaseField(useGetSet=true, generatedId=true)
	protected int idPayment;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected Date paymentDate;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	protected Order order;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	protected Employee employee;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected float ammount;
	
	
	public Payment() {
	}
}
