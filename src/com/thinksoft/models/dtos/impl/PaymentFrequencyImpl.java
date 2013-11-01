package com.thinksoft.models.dtos.impl;

import com.thinksoft.models.dtos.PaymentFrequency;

public class PaymentFrequencyImpl extends PaymentFrequency {

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
