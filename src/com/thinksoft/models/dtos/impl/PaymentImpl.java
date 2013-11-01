package com.thinksoft.models.dtos.impl;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Payment;

public class PaymentImpl implements Payment {

	@DatabaseField(useGetSet=true, generatedId=true)
	protected int idPayment;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected Date paymentDate;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	protected OrderImpl order;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	protected EmployeeImpl employee;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected float ammount;
	
	public PaymentImpl() {
	}
	
	public int getIdPayment() {
		return idPayment;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}
  

	public OrderImpl getOrder() {
		return order;
	}


	public EmployeeImpl getEmployee() {
		return employee;
	}


	public float getAmmount() {
		return ammount;
	}


	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public void setOrder(OrderImpl order) {
		this.order = order;
	}


	public void setEmployee(EmployeeImpl employee) {
		this.employee = employee;
	}


	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}
	
	
}
