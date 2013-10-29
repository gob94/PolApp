package com.thinksoft.models.dtos;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.PaymentFrequency;
import com.thinksoft.models.dtos.User;
import com.thinksoft.models.dtos.Client;;

@DatabaseTable
public abstract class Order {
	
	@DatabaseField(generatedId=true, useGetSet=true)
	protected int orderId;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected Date creationDate;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected Date nextPaymentDate;
	@DatabaseField(useGetSet=true, defaultValue="0")
	protected float finalBalance;
	@DatabaseField(useGetSet=true, defaultValue="0")
	protected float actualBalance;
	@DatabaseField(useGetSet=true, foreign=true, foreignAutoCreate=true)
	protected User userId;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	protected Client clientId;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	protected PaymentFrequency paymentFrequencyId;
	
	
	public Order() {
	}
}
