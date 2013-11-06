package com.thinksoft.models.daos.impl;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.models.daos.PolAppDaoManager;
import com.thinksoft.models.dtos.*;
import com.thinksoft.models.dtos.impl.AddressImpl;
import com.thinksoft.models.dtos.impl.BrandImpl;
import com.thinksoft.models.dtos.impl.ClientImpl;
import com.thinksoft.models.dtos.impl.EmployeeImpl;
import com.thinksoft.models.dtos.impl.OrderImpl;
import com.thinksoft.models.dtos.impl.PaymentFrequencyImpl;
import com.thinksoft.models.dtos.impl.PaymentImpl;
import com.thinksoft.models.dtos.impl.ProductImpl;
import com.thinksoft.models.dtos.impl.ProductOrderImpl;
import com.thinksoft.models.dtos.impl.UserImpl;
import com.thinksoft.models.dtos.impl.VehicleImpl;

public class PolAppDaoManagerImpl implements PolAppDaoManager {

	private Dao<Address, Integer> addressDao;
	private Dao<Brand, Integer> brandDao;
	private Dao<Client, Integer> clientDao;
	private Dao<Employee, Integer> employeeDao;
	private Dao<Order, Integer> orderDao;
	private Dao<Payment, Integer> paymentDao;
	private Dao<PaymentFrequency, Void> paymentFrequencyDao;
	private Dao<Product, Integer> productDao;
	private Dao<ProductOrder, Void> productOrderDao;
	private Dao<User, Integer> userDao;
	private Dao<Vehicle, Integer> vehicleDao;

	public PolAppDaoManagerImpl(ConnectionSource connection) {
		try {
			addressDao = DaoManager.createDao(connection, AddressImpl.class);
			brandDao = DaoManager.createDao(connection, BrandImpl.class);
			clientDao = DaoManager.createDao(connection, ClientImpl.class);
			employeeDao = DaoManager.createDao(connection, EmployeeImpl.class);
			orderDao = DaoManager.createDao(connection, OrderImpl.class);
			paymentDao = DaoManager.createDao(connection, PaymentImpl.class);
			paymentFrequencyDao = DaoManager.createDao(connection, PaymentFrequencyImpl.class);
			productDao = DaoManager.createDao(connection, ProductImpl.class);
			productOrderDao = DaoManager.createDao(connection, ProductOrderImpl.class);
			userDao = DaoManager.createDao(connection, UserImpl.class);
			vehicleDao = DaoManager.createDao(connection, VehicleImpl.class);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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

	public Dao<Employee, Integer> getEmployee() {
		return employeeDao;
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
		return productOrderDao;
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

	public <T> void setBrandDao(Class<T> classImpl, ConnectionSource connection) throws SQLException {
		brandDao = DaoManager.createDao(connection, classImpl);
	}

	public <T> void setClientDao(Class<T> classImpl, ConnectionSource connection) throws SQLException {
		clientDao = DaoManager.createDao(connection, classImpl);
	}

	public <T> void setEmployee(Class<T> classImpl, ConnectionSource connection) throws SQLException {
		employeeDao = DaoManager.createDao(connection, classImpl);
	}

	public <T> void setOrderDao(Class<T> classImpl, ConnectionSource connection) throws SQLException {
		orderDao = DaoManager.createDao(connection, classImpl);
	}

	public <T> void setPaymentDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException {
		paymentDao = DaoManager.createDao(connection, classImpl);
	}

	public <T> void setPaymentFrequencyDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException {
		paymentFrequencyDao = DaoManager.createDao(connection, classImpl);
	}

	public <T> void setProductDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException {
		productDao = DaoManager.createDao(connection, classImpl);
	}

	public <T> void setProductOrder(Class<T> classImpl,
			ConnectionSource connection) throws SQLException {
		productOrderDao = DaoManager.createDao(connection, classImpl);
	}

	public <T> void setUserDao(Class<T> classImpl, ConnectionSource connection) throws SQLException {
		userDao = DaoManager.createDao(connection, classImpl);
	}

	public <T> void setVehicleDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException {
		vehicleDao = DaoManager.createDao(connection, classImpl);
	}
}
