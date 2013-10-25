package com.thinksoft.models.dtos.impl;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Payment {

	@DatabaseField(useGetSet=true, generatedId=true)
	private int idPayment;
	@DatabaseField(useGetSet=true, canBeNull=false)
	private Date paymentDate;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	private Order order;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	private Employee employee;
	@DatabaseField(useGetSet=true, canBeNull=false)
	private float ammount;
	
	
	public Payment() {
	}


	public int getIdPayment() {
		return idPayment;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public Order getOrder() {
		return order;
	}


	public Employee getEmployee() {
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


	public void setOrder(Order order) {
		this.order = order;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}
	
	
}
