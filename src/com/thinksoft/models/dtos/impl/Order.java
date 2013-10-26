package com.thinksoft.models.dtos.impl;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Order {
	
	@DatabaseField(generatedId=true, useGetSet=true)
	private int orderId;
	@DatabaseField(useGetSet=true, canBeNull=false)
	private Date creationDate;
	@DatabaseField(useGetSet=true, canBeNull=false)
	private Date nextPaymentDate;
	@DatabaseField(useGetSet=true, defaultValue="0")
	private float finalBalance;
	@DatabaseField(useGetSet=true, defaultValue="0")
	private float actualBalance;
	@DatabaseField(useGetSet=true, foreign=true, foreignAutoCreate=true)
	private User userId;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	private Client clientId;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	private PaymentFrequency paymentFrequencyId;
	
	
	public Order() {
	}


	public int getOrderId() {
		return orderId;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public Date getNextPaymentDate() {
		return nextPaymentDate;
	}


	public float getFinalBalance() {
		return finalBalance;
	}


	public float getActualBalance() {
		return actualBalance;
	}


	public User getUserId() {
		return userId;
	}


	public Client getClientId() {
		return clientId;
	}


	public PaymentFrequency getPaymentFrequencyId() {
		return paymentFrequencyId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public void setNextPaymentDate(Date nextPaymentDate) {
		this.nextPaymentDate = nextPaymentDate;
	}


	public void setFinalBalance(float finalBalance) {
		this.finalBalance = finalBalance;
	}


	public void setActualBalance(float actualBalance) {
		this.actualBalance = actualBalance;
	}


	public void setUserId(User userId) {
		this.userId = userId;
	}


	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}


	public void setPaymentFrequencyId(PaymentFrequency paymentFrequencyId) {
		this.paymentFrequencyId = paymentFrequencyId;
	}
	
	
}
