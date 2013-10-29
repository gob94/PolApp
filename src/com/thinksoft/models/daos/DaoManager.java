package com.thinksoft.models.daos;

import com.j256.ormlite.dao.Dao;
import com.thinksoft.models.dtos.impl.*;

public abstract class DaoManager {
	protected Dao<AddressImpl, Integer> addressDao;
	protected Dao<BrandImpl, Integer> brandDao;
	protected Dao<ClientImpl, Integer> clientDao;
	protected Dao<ClientAddressImpl, Void> clientAddress;
	protected Dao<EmployeeImpl, Integer> employee;
	protected Dao<OrderImpl, Integer> orderDao;
	protected Dao<PaymentImpl, Integer> paymentDao;
	protected Dao<PaymentFrequencyImpl, Void> paymentFrequencyDao;
	protected Dao<ProductImpl, Integer> productDao;
	protected Dao<ProductOrderImpl, Void> productOrder;
	protected Dao<UserImpl, Integer> userDao;
	protected Dao<VehicleImpl, Integer> vehicleDao;
	
	
	
}
