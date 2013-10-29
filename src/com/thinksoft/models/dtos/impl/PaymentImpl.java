package com.thinksoft.models.dtos.impl;

import java.util.Date;

import com.thinksoft.models.dtos.Employee;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.Payment;

public class PaymentImpl extends Payment {


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
