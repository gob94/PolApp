package com.thinksoft.businesslayer.bussinessmanagers.impl;

import com.j256.ormlite.dao.Dao;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.models.dtos.impl.*;

public class BusinessManagerImpl implements BusinessManager {
	
	private Dao<AddressImpl, Integer> addressDao;
	private Dao<BrandImpl, Integer> brandDao;
	private Dao<ClientImpl, Integer> clientDao;
	private Dao<ClientAddressImpl, Void> clientAddress;
	private Dao<EmployeeImpl, Integer> employee;
	private Dao<OrderImpl, Integer> orderDao;
	private Dao<PaymentImpl, Integer> paymentDao;
	private Dao<PaymentFrequencyImpl, Void> paymentFrequencyDao;
	private Dao<ProductImpl, Integer> productDao;
	private Dao<ProductOrderImpl, Void> productOrder;
	private Dao<UserImpl, Integer> userDao;
	private Dao<VehicleImpl, Integer> vehicleDao;


	public BusinessManagerImpl() {
	}


	public Dao<AddressImpl, Integer> getAddressDao() {
		return addressDao;
	}


	public Dao<BrandImpl, Integer> getBrandDao() {
		return brandDao;
	}


	public Dao<ClientImpl, Integer> getClientDao() {
		return clientDao;
	}


	public Dao<ClientAddressImpl, Void> getClientAddress() {
		return clientAddress;
	}


	public Dao<EmployeeImpl, Integer> getEmployee() {
		return employee;
	}


	public Dao<OrderImpl, Integer> getOrderDao() {
		return orderDao;
	}


	public Dao<PaymentImpl, Integer> getPaymentDao() {
		return paymentDao;
	}


	public Dao<PaymentFrequencyImpl, Void> getPaymentFrequencyDao() {
		return paymentFrequencyDao;
	}


	public Dao<ProductImpl, Integer> getProductDao() {
		return productDao;
	}


	public Dao<ProductOrderImpl, Void> getProductOrder() {
		return productOrder;
	}


	public Dao<UserImpl, Integer> getUserDao() {
		return userDao;
	}


	public Dao<VehicleImpl, Integer> getVehicleDao() {
		return vehicleDao;
	}


	public void setAddressDao(Dao<AddressImpl, Integer> addressDao) {
		this.addressDao = addressDao;
	}


	public void setBrandDao(Dao<BrandImpl, Integer> brandDao) {
		this.brandDao = brandDao;
	}


	public void setClientDao(Dao<ClientImpl, Integer> clientDao) {
		this.clientDao = clientDao;
	}


	public void setClientAddress(Dao<ClientAddressImpl, Void> clientAddress) {
		this.clientAddress = clientAddress;
	}


	public void setEmployee(Dao<EmployeeImpl, Integer> employee) {
		this.employee = employee;
	}


	public void setOrderDao(Dao<OrderImpl, Integer> orderDao) {
		this.orderDao = orderDao;
	}


	public void setPaymentDao(Dao<PaymentImpl, Integer> paymentDao) {
		this.paymentDao = paymentDao;
	}


	public void setPaymentFrequencyDao(
			Dao<PaymentFrequencyImpl, Void> paymentFrequencyDao) {
		this.paymentFrequencyDao = paymentFrequencyDao;
	}


	public void setProductDao(Dao<ProductImpl, Integer> productDao) {
		this.productDao = productDao;
	}


	public void setProductOrder(Dao<ProductOrderImpl, Void> productOrder) {
		this.productOrder = productOrder;
	}


	public void setUserDao(Dao<UserImpl, Integer> userDao) {
		this.userDao = userDao;
	}


	public void setVehicleDao(Dao<VehicleImpl, Integer> vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	
	
	
	
}
