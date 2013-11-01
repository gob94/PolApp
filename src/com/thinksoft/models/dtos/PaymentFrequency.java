package com.thinksoft.models.dtos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public abstract class PaymentFrequency {

	@DatabaseField(generatedId=true, useGetSet=true)
	protected int idPaymentFrequency;
	
	@DatabaseField(useGetSet=true, unique=true, canBeNull=false)
	protected String name;
	
	@DatabaseField(useGetSet=true, unique=true, canBeNull=false)
	protected int lapse;
	
	@DatabaseField(useGetSet=true, canBeNull=false, defaultValue="0")
	protected float ammount;
	
	public PaymentFrequency() {
	}
}
