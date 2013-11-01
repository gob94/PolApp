package com.thinksoft.models.daos.impl;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.models.daos.PolAppDaoManager;
import com.thinksoft.models.dtos.*;
import com.thinksoft.models.dtos.impl.AddressImpl;

public class PolAppDaoManagerImpl implements PolAppDaoManager {

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

	public PolAppDaoManagerImpl() {
	}

	public PolAppDaoManagerImpl(ConnectionSource connection) {
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

	public <T> void setAddressDao(Class<T> classImpl, ConnectionSource connection) throws SQLException {
		addressDao = DaoManager.createDao(connection, classImpl);
	}

	public <T> void setBrandDao(Class<T> classImpl, ConnectionSource connection) {
		
	}

	public <T> void setClientDao(Class<T> classImpl, ConnectionSource connection) {

	}

	public <T> void setClientAddress(Class<T> classImpl,
			ConnectionSource connection) {

	}

	public <T> void setEmployee(Class<T> classImpl, ConnectionSource connection) {

	}

	public <T> void setOrderDao(Class<T> classImpl, ConnectionSource connection) {

	}

	public <T> void setPaymentDao(Class<T> classImpl,
			ConnectionSource connection) {

	}

	public <T> void setPaymentFrequencyDao(Class<T> classImpl,
			ConnectionSource connection) {

	}

	public <T> void setProductDao(Class<T> classImpl,
			ConnectionSource connection) {

	}

	public <T> void setProductOrder(Class<T> classImpl,
			ConnectionSource connection) {

	}

	public <T> void setUserDao(Class<T> classImpl, ConnectionSource connection) {

	}

	public <T> void setVehicleDao(Class<T> classImpl,
			ConnectionSource connection) {

	}
}
