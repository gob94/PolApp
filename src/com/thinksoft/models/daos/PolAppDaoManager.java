package com.thinksoft.models.daos;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.models.dtos.Address;
import com.thinksoft.models.dtos.Brand;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.Employee;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.Payment;
import com.thinksoft.models.dtos.PaymentFrequency;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.ProductOrder;
import com.thinksoft.models.dtos.User;
import com.thinksoft.models.dtos.Vehicle;

public interface PolAppDaoManager {

	public Dao<Address, Integer> getAddressDao();

	public Dao<Brand, Integer> getBrandDao();

	public Dao<Client, Integer> getClientDao();

	public Dao<Employee, Integer> getEmployee();

	public Dao<Order, Integer> getOrderDao();

	public Dao<Payment, Integer> getPaymentDao();

	public Dao<PaymentFrequency, Void> getPaymentFrequencyDao();
 
	public Dao<Product, Integer> getProductDao();

	public Dao<ProductOrder, Void> getProductOrderDao();

	public Dao<User, Integer> getUserDao();

	public Dao<Vehicle, Integer> getVehicleDao();
	
	public <T> void setAddressDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException;

	public <T> void setBrandDao(Class<T> classImpl, ConnectionSource connection) throws SQLException;

	public <T> void setClientDao(Class<T> classImpl, ConnectionSource connection) throws SQLException;

	public <T> void setEmployee(Class<T> classImpl, ConnectionSource connection) throws SQLException;

	public <T> void setOrderDao(Class<T> classImpl, ConnectionSource connection) throws SQLException;

	public <T> void setPaymentDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException;

	public <T> void setPaymentFrequencyDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException;

	public <T> void setProductDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException;

	public <T> void setProductOrderDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException;

	public <T> void setUserDao(Class<T> classImpl, ConnectionSource connection) throws SQLException;

	public <T> void setVehicleDao(Class<T> classImpl,
			ConnectionSource connection) throws SQLException;
}
