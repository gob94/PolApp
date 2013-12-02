package com.thinksoft.models.dtos.impl;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.Employee;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.PaymentFrequency;

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
	@DatabaseField(useGetSet = true, defaultValue = "0")
	protected boolean orderState;
	@DatabaseField(useGetSet = true, canBeNull = false, foreign = true, foreignAutoCreate = true, columnName="employeeId")
	protected EmployeeImpl employeeId;
	@DatabaseField(useGetSet = true, canBeNull = false, foreign = true, foreignAutoCreate = true, columnName="clientId")
	protected ClientImpl clientId;
	@DatabaseField(useGetSet = true, canBeNull = false, foreign = true, foreignAutoCreate = true)
	protected PaymentFrequencyImpl paymentFrequencyId;

	
	public OrderImpl() {
		
	}

	public OrderImpl( Date creationDate, Date nextPaymentDate,
			float finalBalance, float actualBalance, boolean orderState,
			Employee employeeId, Client clientId,
			PaymentFrequency paymentFrequencyId) {
		super();
		this.creationDate = creationDate;
		this.nextPaymentDate = nextPaymentDate;
		this.finalBalance = finalBalance;
		this.actualBalance = actualBalance;
		this.orderState = orderState;
		this.employeeId = (EmployeeImpl) employeeId;
		this.clientId = (ClientImpl) clientId;
		this.paymentFrequencyId = (PaymentFrequencyImpl) paymentFrequencyId;
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

	public EmployeeImpl getEmployeeId() {
		return employeeId;
	}

	public ClientImpl getClientId() {
		return clientId;
	}

	public PaymentFrequencyImpl getPaymentFrequencyId() {
		return paymentFrequencyId;
	}
	
	

	@Override
	public boolean getOrderState() {
		return orderState;
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

	public void setEmployeeId(EmployeeImpl employeeId) {
		this.employeeId = employeeId;
	}

	public void setClientId(ClientImpl clientId) {
		this.clientId = clientId;
	}

	public void setPaymentFrequencyId(PaymentFrequencyImpl paymentFrequencyId) {
		this.paymentFrequencyId = paymentFrequencyId;
	}

	public void setOrderState(boolean orderState) {
		this.orderState = orderState;
	}
}
