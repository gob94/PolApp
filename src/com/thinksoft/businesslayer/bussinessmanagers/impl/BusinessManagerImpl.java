package com.thinksoft.businesslayer.bussinessmanagers.impl;

import com.j256.ormlite.dao.Dao;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.models.dtos.impl.*;

public class BusinessManagerImpl implements BusinessManager {
	
	private Dao<Address, Integer> addressDao;
	private Dao<Brand, Integer> brandDao;
	private Dao<Client, Integer> clientDao;
	private Dao<ClientAddress, Void> clientAddress;
	private Dao<Employee, Integer> employee;
	private Dao<Order, Integer> orderDao;
	private Dao<Payment, Integer> paymentDao;
	private Dao<PaymentFrequency, Void> paymentFrequencyDao;
	private Dao<Product, Integer> productDao;
	private Dao<ProductOrder, Void> productOrder;
	private Dao<User, Integer> userDao;
	private Dao<Vehicle, Integer> vehicleDao;


	public BusinessManagerImpl() {
	}


	public Dao<Address, Integer> getAddressDao() {
		return addressDao;
	}


	public Dao<Brand, Integer> getBrandDao() {
		return brandDao;
	}


	public Dao<Client, Integer> getClientDao() {
		return clientDao;
	}


	public Dao<ClientAddress, Void> getClientAddress() {
		return clientAddress;
	}


	public Dao<Employee, Integer> getEmployee() {
		return employee;
	}


	public Dao<Order, Integer> getOrderDao() {
		return orderDao;
	}


	public Dao<Payment, Integer> getPaymentDao() {
		return paymentDao;
	}


	public Dao<PaymentFrequency, Void> getPaymentFrequencyDao() {
		return paymentFrequencyDao;
	}


	public Dao<Product, Integer> getProductDao() {
		return productDao;
	}


	public Dao<ProductOrder, Void> getProductOrder() {
		return productOrder;
	}


	public Dao<User, Integer> getUserDao() {
		return userDao;
	}


	public Dao<Vehicle, Integer> getVehicleDao() {
		return vehicleDao;
	}


	public void setAddressDao(Dao<Address, Integer> addressDao) {
		this.addressDao = addressDao;
	}


	public void setBrandDao(Dao<Brand, Integer> brandDao) {
		this.brandDao = brandDao;
	}


	public void setClientDao(Dao<Client, Integer> clientDao) {
		this.clientDao = clientDao;
	}


	public void setClientAddress(Dao<ClientAddress, Void> clientAddress) {
		this.clientAddress = clientAddress;
	}


	public void setEmployee(Dao<Employee, Integer> employee) {
		this.employee = employee;
	}


	public void setOrderDao(Dao<Order, Integer> orderDao) {
		this.orderDao = orderDao;
	}


	public void setPaymentDao(Dao<Payment, Integer> paymentDao) {
		this.paymentDao = paymentDao;
	}


	public void setPaymentFrequencyDao(
			Dao<PaymentFrequency, Void> paymentFrequencyDao) {
		this.paymentFrequencyDao = paymentFrequencyDao;
	}


	public void setProductDao(Dao<Product, Integer> productDao) {
		this.productDao = productDao;
	}


	public void setProductOrder(Dao<ProductOrder, Void> productOrder) {
		this.productOrder = productOrder;
	}


	public void setUserDao(Dao<User, Integer> userDao) {
		this.userDao = userDao;
	}


	public void setVehicleDao(Dao<Vehicle, Integer> vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	
	
	
	
}
