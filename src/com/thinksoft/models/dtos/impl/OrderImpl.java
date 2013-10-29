package com.thinksoft.models.dtos.impl;

import java.util.Date;

import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.PaymentFrequency;
import com.thinksoft.models.dtos.User;


public class OrderImpl extends Order{

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
