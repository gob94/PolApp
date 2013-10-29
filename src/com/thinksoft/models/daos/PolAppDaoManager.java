package com.thinksoft.models.daos;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.models.dtos.*;

public interface PolAppDaoManager {

	public Dao<Address, Integer> getAddressDao();

	public Dao<Brand, Integer> getBrandDao();

	public Dao<Client, Integer> getClientDao();

	public Dao<ClientAddress, Void> getClientAddress();

	public Dao<Employee, Integer> getEmployee();

	public Dao<Order, Integer> getOrderDao();

	public Dao<Payment, Integer> getPaymentDao();

	public Dao<PaymentFrequency, Void> getPaymentFrequencyDao();

	public Dao<Product, Integer> getProductDao();

	public Dao<ProductOrder, Void> getProductOrder();

	public Dao<User, Integer> getUserDao();

	public Dao<Vehicle, Integer> getVehicleDao();

	public <T> void setAddressDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException;

	public <T> void setBrandDao(Class<T> classImpl, ConnectionSource connection);

	public <T> void setClientDao(Class<T> classImpl, ConnectionSource connection);

	public <T> void setClientAddress(Class<T> classImpl,
			ConnectionSource connection);

	public <T> void setEmployee(Class<T> classImpl, ConnectionSource connection);

	public <T> void setOrderDao(Class<T> classImpl, ConnectionSource connection);

	public <T> void setPaymentDao(Class<T> classImpl,
			ConnectionSource connection);

	public <T> void setPaymentFrequencyDao(Class<T> classImpl,
			ConnectionSource connection);

	public <T> void setProductDao(Class<T> classImpl,
			ConnectionSource connection);

	public <T> void setProductOrder(Class<T> classImpl,
			ConnectionSource connection);

	public <T> void setUserDao(Class<T> classImpl, ConnectionSource connection);

	public <T> void setVehicleDao(Class<T> classImpl,
			ConnectionSource connection);
}
