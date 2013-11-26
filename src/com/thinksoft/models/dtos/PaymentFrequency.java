package com.thinksoft.models.dtos;

import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public interface PaymentFrequency {
	
	public int getIdPaymentFrequency();

	public String getName();

	public int getLapse();
 
	public float getAmmount();

	public void setIdPaymentFrequency(int idPaymentFrequency);

	public void setName(String name);

	public void setLapse(int lapse);

	public void setAmmount(float ammount);
	
}
