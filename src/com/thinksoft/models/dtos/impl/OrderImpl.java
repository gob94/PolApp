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
	protected long finalBalance;
	@DatabaseField(useGetSet = true, defaultValue = "0")
	protected long actualBalance;
	@DatabaseField(useGetSet = true, defaultValue = "0")
	protected boolean orderState;
	@DatabaseField(useGetSet = true, canBeNull = false,foreign = true)
	protected EmployeeImpl employee;
	@DatabaseField(useGetSet = true, canBeNull = false,foreign = true)
	protected ClientImpl client;
	@DatabaseField(useGetSet = true, canBeNull = false,foreign = true)
	protected PaymentFrequencyImpl paymentFrequency;

	
	public OrderImpl() {
		
	}

	public OrderImpl( Date creationDate, Date nextPaymentDate,
			long finalBalance, long actualBalance, boolean orderState,
			EmployeeImpl employee, ClientImpl client,
			PaymentFrequencyImpl paymentFrequency) {
		super();
		this.creationDate = creationDate;
		this.nextPaymentDate = nextPaymentDate;
		this.finalBalance = finalBalance;
		this.actualBalance = actualBalance;
		this.orderState = orderState;
		this.employee =employee;
		this.client = client;
		this.paymentFrequency = paymentFrequency;
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

	public long getFinalBalance() {
		return finalBalance;
	}

	public long getActualBalance() {
		return actualBalance;
	}

	public EmployeeImpl getEmployee() {
		return employee;
	}

	public ClientImpl getClient() {
		return client;
	}

	public PaymentFrequencyImpl getPaymentFrequency() {
		return paymentFrequency;
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

	public void setFinalBalance(long finalBalance) {
		this.finalBalance = finalBalance;
	}

	public void setActualBalance(long actualBalance) {
		this.actualBalance = actualBalance;
	}

	public void setEmployee(EmployeeImpl employee) {
		this.employee = employee;
	}

	public void setClient(ClientImpl client) {
		this.client = client;
	}

	public void setPaymentFrequency(PaymentFrequencyImpl paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public void setOrderState(boolean orderState) {
		this.orderState = orderState;
	}

}
