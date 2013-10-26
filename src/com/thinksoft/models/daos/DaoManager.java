package com.thinksoft.models.daos;

import com.j256.ormlite.dao.Dao;
import com.thinksoft.models.dtos.impl.*;

public abstract class DaoManager {
	protected Dao<Address, Integer> addressDao;
	protected Dao<Brand, Integer> brandDao;
	protected Dao<Client, Integer> clientDao;
	protected Dao<ClientAddress, Void> clientAddress;
	protected Dao<Employee, Integer> employee;
	protected Dao<Order, Integer> orderDao;
	protected Dao<Payment, Integer> paymentDao;
	protected Dao<PaymentFrequency, Void> paymentFrequencyDao;
	protected Dao<Product, Integer> productDao;
	protected Dao<ProductOrder, Void> productOrder;
	protected Dao<User, Integer> userDao;
	protected Dao<Vehicle, Integer> vehicleDao;
	
	
	
}
