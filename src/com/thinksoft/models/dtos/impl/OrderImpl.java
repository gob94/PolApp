package com.thinksoft.models.dtos.impl;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Order;

public class OrderImpl implements Order {

	@DatabaseField(generatedId = true, useGetSet = true)
	protected int orderId;
	@DatabaseField(useGetSet = true, canBeNull = false)
	protected Date creationDate;
	@DatabaseField(useGetSet = true, canBeNull = false)
	protected Date nextPaymentDate;
	@DatabaseField(useGetSet = true, defaultValue = "0")
	protected float finalBalance;
	@DatabaseField(useGetSet = true, defaultValue = "0")
	protected float actualBalance;
	@DatabaseField(useGetSet = true, foreign = true, foreignAutoCreate = true)
	protected UserImpl userId;
	@DatabaseField(useGetSet = true, canBeNull = false, foreign = true, foreignAutoCreate = true, columnName="clientId")
	protected ClientImpl clientId;
	@DatabaseField(useGetSet = true, canBeNull = false, foreign = true, foreignAutoCreate = true)
	protected PaymentFrequencyImpl paymentFrequencyId;

	public OrderImpl() {
		// TODO Auto-generated constructor stub
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

	public UserImpl getUserId() {
		return userId;
	}

	public ClientImpl getClientId() {
		return clientId;
	}

	public PaymentFrequencyImpl getPaymentFrequencyId() {
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

	public void setUserId(UserImpl userId) {
		this.userId = userId;
	}

	public void setClientId(ClientImpl clientId) {
		this.clientId = clientId;
	}

	public void setPaymentFrequencyId(PaymentFrequencyImpl paymentFrequencyId) {
		this.paymentFrequencyId = paymentFrequencyId;
	}

}
