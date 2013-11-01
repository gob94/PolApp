package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.PaymentFrequency;

public class PaymentFrequencyImpl implements PaymentFrequency {

	@DatabaseField(generatedId = true, useGetSet = true)
	protected int idPaymentFrequency;

	@DatabaseField(useGetSet = true, unique = true, canBeNull = false)
	protected String name;

	@DatabaseField(useGetSet = true, unique = true, canBeNull = false)
	protected int lapse;

	@DatabaseField(useGetSet = true, canBeNull = false, defaultValue = "0")
	protected float ammount;

	public PaymentFrequencyImpl() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPaymentFrequency() {
		return idPaymentFrequency;
	}

	public String getName() {
		return name;
	}

	public int getLapse() {
		return lapse;
	}
 
	public float getAmmount() {
		return ammount;
	}

	public void setIdPaymentFrequency(int idPaymentFrequency) {
		this.idPaymentFrequency = idPaymentFrequency;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLapse(int lapse) {
		this.lapse = lapse;
	}

	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}

}
