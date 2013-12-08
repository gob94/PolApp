package com.thinksoft.businesslayer.bussinessmanagers.impl;

import static com.thinksoft.businesslayer.utils.constants.Constants.EMPLOYEE_ID;
import static com.thinksoft.businesslayer.utils.constants.Constants.EMPLOYEE_NAME;
import static com.thinksoft.businesslayer.utils.constants.Constants.NUMBER_OF_PRODUCTS_TO_DISPLAY;
import static com.thinksoft.businesslayer.utils.constants.Constants.PAYMENT_ID;
import static com.thinksoft.businesslayer.utils.constants.Constants.PAYMENT_NAME;
import static com.thinksoft.businesslayer.utils.constants.Constants.ZERO;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.BRAND_ERROR_TAG;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.CLIENT_ERROR_TAG;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_CLIENTID;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_FIRST_LASTNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_IDENTIFICATION;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_LASTNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_NAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_ORDERID;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_ORDERSTATE;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_PAYMENTFREQUENCY_ID;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_PHONENUMBER;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_SECOND_LASTNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_USERNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.EMPTY_STRING;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.MINIMUM_PHONENUMBER_DIGITS;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.PRODUCT_ERROR_TAG;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.START_EMPTY_STRING;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.USER_ERROR_TAG;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.USER_INSERTED;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.VEHICLE_ERROR_TAG;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_LICENSE_PLATE;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.ACTUAL_BALANCE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.BRAND_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.CLIENT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.CODE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.EXPEDITURE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.FIRST_LASTNAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.FUNCTIONAL_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.LICENCE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.MODEL_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NEXT_PAYMENT_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.ORDER_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.PRICE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.PRODUCT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.RTV_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.SECOND_LASTNAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.STATUS_COLUMN;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

import android.annotation.SuppressLint;
import android.util.Log;

import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.utils.services.QueryService;
import com.thinksoft.models.daos.PolAppDaoManager;
import com.thinksoft.models.daos.impl.PolAppDaoManagerImpl;
import com.thinksoft.models.dtos.Address;
import com.thinksoft.models.dtos.Brand;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.Employee;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.PaymentFrequency;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.ProductOrder;
import com.thinksoft.models.dtos.User;
import com.thinksoft.models.dtos.Vehicle;
import com.thinksoft.models.dtos.impl.AddressImpl;
import com.thinksoft.models.dtos.impl.BrandImpl;
import com.thinksoft.models.dtos.impl.ClientImpl;
import com.thinksoft.models.dtos.impl.EmployeeImpl;
import com.thinksoft.models.dtos.impl.OrderImpl;
import com.thinksoft.models.dtos.impl.PaymentFrequencyImpl;
import com.thinksoft.models.dtos.impl.ProductOrderImpl;
import com.thinksoft.models.dtos.impl.UserImpl;
import com.thinksoft.models.dtos.impl.VehicleImpl;

@SuppressLint("SimpleDateFormat")
public class BusinessManagerImpl implements BusinessManager {
	
	private PolAppDaoManager polAppDaoManager;

	
	public BusinessManagerImpl(ConnectionSource connection) {
		polAppDaoManager = new  PolAppDaoManagerImpl(connection);
	}
	
	@Override
	public boolean addAddress(Address address) {
		boolean result = false;
		try {
			polAppDaoManager.getAddressDao().create(address);
			result = true;
		} catch (SQLException e) {
			Log.e(USER_ERROR_TAG,e.getMessage());
		}
		return result;
	}
 
	@Override
	public boolean addBrand(Brand brand) {
		boolean result = false;
		try {
			polAppDaoManager.getBrandDao().create(brand);
			result = true;
		} catch (SQLException e) {
			Log.e(BRAND_ERROR_TAG,e.getCause().toString());
		}
		return result;
	}
	
	@Override
	public boolean addClient(Client client) {
		boolean result = false;
		try {
			polAppDaoManager.getClientDao().create(client);
			result = true;
		} catch (SQLException e) {
			Log.e(CLIENT_ERROR_TAG,e.getMessage());
		}
		return result;
	}
	
	@Override
	public void addDefaultOrderValues() {
		try {
		PaymentFrequency frequency = new PaymentFrequencyImpl("Semanal 1000",7,1000);
		try{
			polAppDaoManager.getPaymentFrequencyDao().createIfNotExists(frequency);
			}catch(SQLException e){
				e.printStackTrace();
			}
		frequency = new PaymentFrequencyImpl("Quincenal 2000",15,2000);
		try{
			polAppDaoManager.getPaymentFrequencyDao().createIfNotExists(frequency);
			}catch(SQLException e){
				e.printStackTrace();
			}
		frequency = new PaymentFrequencyImpl("Quincenal 5000",15,5000);
		try{
			polAppDaoManager.getPaymentFrequencyDao().createIfNotExists(frequency);
			}catch(SQLException e){
				e.printStackTrace();
			}
		frequency = new PaymentFrequencyImpl("Quincenal 10000",15,10000);
		try{
			polAppDaoManager.getPaymentFrequencyDao().createIfNotExists(frequency);
			}catch(SQLException e){
				e.printStackTrace();
			}
		frequency = new PaymentFrequencyImpl("Mensual 5000",30,5000);
		try{
			polAppDaoManager.getPaymentFrequencyDao().createIfNotExists(frequency);
			}catch(SQLException e){
				e.printStackTrace();
			}
		frequency = new PaymentFrequencyImpl("Mensual 10000",30,10000);
		try{
			polAppDaoManager.getPaymentFrequencyDao().createIfNotExists(frequency);
			}catch(SQLException e){
				e.printStackTrace();
			}
		frequency = new PaymentFrequencyImpl("Mensual 20000",30,20000);
		try{
			polAppDaoManager.getPaymentFrequencyDao().createIfNotExists(frequency);
		}catch(SQLException e){
			e.printStackTrace();
		}
		frequency = new PaymentFrequencyImpl("Mensual 50000",30,50000);
		try{
			polAppDaoManager.getPaymentFrequencyDao().createIfNotExists(frequency);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		Brand brand = new BrandImpl("Yamaha");
		polAppDaoManager.getBrandDao().createIfNotExists(brand);
		Vehicle vehicle = new VehicleImpl("M123123",true,new Date(), 1000,"123512331", (BrandImpl) brand); 
		
		polAppDaoManager.getVehicleDao().createIfNotExists(vehicle);
		Employee mark = new EmployeeImpl("1","Sergio","Monge","Monge",86882316,(VehicleImpl) vehicle);
		polAppDaoManager.getEmployee().createIfNotExists(mark);
		mark = new EmployeeImpl("2","Allan","Porras","Porras",86882316,(VehicleImpl) vehicle);
		polAppDaoManager.getEmployee().createIfNotExists(mark);
		mark = new EmployeeImpl("3","Jose","Pablo","Pablo",86882316,(VehicleImpl) vehicle);
		polAppDaoManager.getEmployee().createIfNotExists(mark);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Order addOrder(int clientId, int paymentId, long total) {
		Order order = null;
		try {
			Date creationDate = new Date();
			Calendar calendarHelper = Calendar.getInstance();
			calendarHelper.setTime(creationDate);
			calendarHelper.add(Calendar.DATE, 1);
			
			Date nextPaymentDate =calendarHelper.getTime();
			PaymentFrequency payment = polAppDaoManager.getPaymentFrequencyDao().queryForId(paymentId);
			Client client = polAppDaoManager.getClientDao().queryForId(clientId);
			client.setAccountState(true);
			
			order = new OrderImpl(creationDate, nextPaymentDate , total, total, true, (ClientImpl) client,(PaymentFrequencyImpl) payment);
			polAppDaoManager.getOrderDao().create((OrderImpl)order);
		} catch (SQLException e) {
			Log.i("Error adding order", e.getMessage());
			e.printStackTrace();
			order=null;
		}
		return order;
	}

	@Override
	public boolean addProduct(Product product) {
		boolean result = false;
		try {
			
			if(product.getName().startsWith(" ") || product.getCode().startsWith(" ") 
					|| product.getPrice() == ZERO || product.getQuantity() == ZERO){
				result= false;
			}else{
				polAppDaoManager.getProductDao().create(product);
				result = true;
			}
			
		} catch (SQLException e) {
			Log.e(PRODUCT_ERROR_TAG, e.getMessage());
		}
		return result;
	}

	@Override
	public boolean addProductsToOrder(final Order order, final Map<Integer,Integer> productsId, ConnectionSource connectionSource) {
		
		try {
			TransactionManager.callInTransaction(connectionSource, new Callable<Void>() {
			    public Void call() throws Exception {
			    	ProductOrder productOrder;
			    	Product product;
			    	for (Integer id : productsId.keySet()) {
			    		int quantity = productsId.get(id);
			    		product = polAppDaoManager.getProductDao().queryForId(id);
			    		productOrder = new ProductOrderImpl(quantity,(int)(quantity*product.getPrice()), order, product);
			    		product.setQuantity(product.getQuantity()-quantity);
			    		if(product.getQuantity()>=ZERO){
			    			polAppDaoManager.getProductDao().update(product);
			    			polAppDaoManager.getProductOrderDao().create(productOrder);
			    		}
					}
					return null;
			    }
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addUser(User user) {
		boolean result = false;
		try {
			polAppDaoManager.getUserDao().create(user);
			result = true;
		} catch (SQLException e) {
			Log.e(USER_ERROR_TAG,e.getMessage());
		}
		return result;
	}

	@Override
	public boolean addVechicle(Vehicle vehicle) {
		boolean result = false;
		try {
			polAppDaoManager.getVehicleDao().create(vehicle);
			result = true;
		} catch (SQLException e) {
			Log.e(VEHICLE_ERROR_TAG,e.getCause().toString());
		}
		return result;
	}

	
	@Override
	public boolean checkUserCredentials(String userName, String password){
		boolean result = false;
		List<User> userReturned = null;
		User user = null;
			try {
				 userReturned = polAppDaoManager.getUserDao().queryForEq(COLUMN_USERNAME, userName);
				 if(userReturned.size()>0){
					 user = userReturned.get(0);
					 if(user.getPassword().equals(password)){
						 result = true;
					 }
				 }
			} catch (SQLException e) {
				Log.e(USER_ERROR_TAG,e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e){
				Log.e(USER_ERROR_TAG,e.getMessage());
			}
		return result;
	}
	
	@Override
	public boolean clientHasOrders(int clientId) {
		boolean result = false;
		try {
			int size = polAppDaoManager.getOrderDao().queryBuilder().where().eq(COLUMN_CLIENTID, clientId).and().eq(COLUMN_ORDERSTATE, true).query().size();
			if (size>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Map<String,String>> getAllActiveOrders(){
		List<Map<String,String>> orderList = null;
		List<Order> rawOrder = null;
		try {
			orderList = new ArrayList<Map<String,String>>();
			rawOrder = polAppDaoManager.getOrderDao().queryForAll();
			
			Log.i("zero",String.valueOf( rawOrder.size()));
			for (Order order : rawOrder) {
				orderList.add(getOrderAsItem(order));
			}
		} catch (SQLException e) {
			Log.e(PRODUCT_ERROR_TAG,e.getMessage());
		}
		Log.i("zero",String.valueOf( orderList.size()));
		return orderList;
	}
	
	@Override
	public List<Map<String,String>> getAllClients(){
		List<Map<String,String>> listOfClients = null;
		List<Client> rawClients = null;
		
		try {			
			rawClients = polAppDaoManager.getClientDao().queryForAll();
			listOfClients = new ArrayList<Map<String,String>>();
			for (Client client : rawClients) {
				listOfClients.add(getClientAsItem(client));
			}
		} catch (SQLException e) {
			Log.e(CLIENT_ERROR_TAG,e.getMessage());
		}
		
		return listOfClients;
	}

	@Override
	public List<Map<String,String>> getAllProducts(){
		List<Map<String,String>> productList = null;
		List<Product> rawProducts = null;
		try {
			productList = new ArrayList<Map<String,String>>();
			rawProducts = polAppDaoManager.getProductDao().queryForAll();
			for (Product product : rawProducts) {
				productList.add(getProductAsItem(product));
			}
		} catch (SQLException e) {
			Log.e(PRODUCT_ERROR_TAG,e.getMessage());
		}
		return productList;
	}


	@Override
	public List<Map<String, String>> getAllVehicles() {
		List<Map<String,String>> listOfVehicles = null;
		List<Vehicle> rawVehicles = null;
		try {			
			rawVehicles = polAppDaoManager.getVehicleDao().queryForAll();
			listOfVehicles = new ArrayList<Map<String,String>>();
			
			for (Vehicle vehicle : rawVehicles) {
				polAppDaoManager.getBrandDao().refresh(vehicle.getBrand());
				listOfVehicles.add(getVehicleAsItem(vehicle));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfVehicles;
	}
	
	private Map<String, String> getClientAsItem(Client client){
		Map<String, String> clientItem = new HashMap<String, String>();
		
		clientItem.put(CLIENT_ID_COLUMN, String.valueOf(client.getClientId()));
		
		clientItem.put(NAME_COLUMN, client.getName());

		clientItem.put(FIRST_LASTNAME_COLUMN, client.getFirstLastName());

		clientItem.put(SECOND_LASTNAME_COLUMN, client.getSecondLastName());
		
		clientItem.put(STATUS_COLUMN, String.valueOf(client.getAccountState()));
		
		return clientItem;
	}

	@Override
	public Client getClientById(int id) {
		Client client = null;
		try {
			client =  polAppDaoManager.getClientDao().queryBuilder().where().idEq(id).queryForFirst();
		} catch (SQLException e) {
			Log.e(CLIENT_ERROR_TAG, e.getMessage());
		}
		return client;
	}
	@Override
	public String getClientPhoneNumber(int clientId) {
		String number = null;
		if(clientId!=0){
			List<AddressImpl> addresses =  new ArrayList<AddressImpl>( getClientById(clientId).getClientAddresses());
	    	if(addresses.size()>0){
	    		 number = String.valueOf(addresses.get(0).getPhoneNumber());
	    	}
		}
    	return number;
	}

	@Override
	public List<Map<String, String>> getClientProducts(int clientId) {
		List<Map<String,String>> productList = null;
		List<Order> actualOrders = null;
		try {
			actualOrders = polAppDaoManager.getOrderDao().queryBuilder().where().eq(COLUMN_CLIENTID, clientId).query();
			productList = new ArrayList<Map<String,String>>();
			for (Order order : actualOrders) {
				List<ProductOrder> productListOfOrder = polAppDaoManager.getProductOrderDao().queryBuilder().where().eq(COLUMN_ORDERID, order.getOrderId()).query();
				if (productList.size()>2) {
					productList = productList.subList(ZERO, NUMBER_OF_PRODUCTS_TO_DISPLAY);
				}
				for (ProductOrder productOrder : productListOfOrder) {
					polAppDaoManager.getProductOrderDao().refresh(productOrder);
					productList.add(getProductOrderAsItem(productOrder));
				}
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	private Map<String, String> getOrderAsItem(Order order){
		Map<String, String> orderItem = new HashMap<String, String>();
		try {
			polAppDaoManager.getClientDao().refresh(order.getClient());
			orderItem.put(ORDER_ID_COLUMN, String.valueOf(order.getOrderId()));
			
			orderItem.put(NAME_COLUMN, order.getClient().getName() + " " + order.getClient().getFirstLastName());
			orderItem.put(NEXT_PAYMENT_COLUMN, getFormatedDate(order.getNextPaymentDate()));
	
			orderItem.put(ACTUAL_BALANCE_COLUMN, String.valueOf(order.getActualBalance()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderItem;
	}

	@Override
	public Order getOrderById(int id) {
		Order order=null;
		
		try {
			order = polAppDaoManager.getOrderDao().queryForId(id);
			polAppDaoManager.getClientDao().refresh(order.getClient());
			polAppDaoManager.getPaymentFrequencyDao().refresh(order.getPaymentFrequency());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public Product getProduct(int id) {
		Product product = null;
		try {
			product = polAppDaoManager.getProductDao().queryForId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	private Map<String, String> getProductAsItem(Product product){
		Map<String, String> productItem = new HashMap<String, String>();
		productItem.put(PRODUCT_ID_COLUMN, String.valueOf(product.getIdProduct()));
		
		productItem.put(NAME_COLUMN, product.getName());

		productItem.put(CODE_COLUMN, product.getCode());

		productItem.put(PRICE_COLUMN, String.valueOf(product.getPrice()));
		
		productItem.put(QUANTITY_COLUMN, String.valueOf(product.getQuantity()));
		
		return productItem;
	}
	
	@Override
	public Product getProductByCode(String code) {
		Product product = null;
		try {
			product =  polAppDaoManager.getProductDao().queryBuilder().where().eq("code", code).queryForFirst();
		} catch (SQLException e) {
			Log.e(CLIENT_ERROR_TAG, e.getMessage());
		}
		return product;
	}

	@Override
	public Product getProductById(int id) {
		Product product = null;
		try {
			product =  polAppDaoManager.getProductDao().queryBuilder().where().idEq(id).queryForFirst();
		} catch (SQLException e) {
			Log.e(CLIENT_ERROR_TAG, e.getMessage());
		}
		return product;
	}
	
	private Map<String, String> getProductOrderAsItem(ProductOrder productOrder){
		Map<String,String> productItem = new HashMap<String, String>();
		
		productItem.put(NAME_COLUMN, productOrder.getProduct().getName());

		productItem.put(CODE_COLUMN, productOrder.getProduct().getCode());

		productItem.put(PRICE_COLUMN, String.valueOf(productOrder.getProduct().getPrice()));
		
		productItem.put(QUANTITY_COLUMN, String.valueOf(productOrder.getProduct().getQuantity()));
		
		return productItem;
	}

	@Override
	public double getProductPrice(int id) {
		double price = 0;
		try {
			price = polAppDaoManager.getProductDao().queryForId(id).getPrice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
	
	@Override
	public List<Map<String, String>> getSpecifiedNumberOfClients(long number) {
		List<Map<String,String>> listOfClients = null;
		List<Client> rawClients = null;
		try {			
			rawClients = polAppDaoManager.getClientDao().queryBuilder().limit(number).query();
			listOfClients = new ArrayList<Map<String,String>>();
			for (Client client : rawClients) {
				listOfClients.add(getClientAsItem(client));
			}
		} catch (SQLException e) {
			Log.e(CLIENT_ERROR_TAG,e.getMessage());
		}
		return listOfClients;
	}

	private Map<String,String> getVehicleAsItem(Vehicle vehicle){
		Map<String,String> vehicleItem = new HashMap<String, String>(); 
		vehicleItem.put(LICENCE_COLUMN, vehicle.getLicensePlate().toString());

		vehicleItem.put(BRAND_COLUMN, vehicle.getBrand().getBrandName());

		vehicleItem.put(MODEL_COLUMN, vehicle.getModel());
		
		vehicleItem.put(RTV_COLUMN, getFormatedDate(vehicle.getRtv()));
		
		vehicleItem.put(EXPEDITURE_COLUMN, String.valueOf(vehicle.getExpenditure()));

		vehicleItem.put(FUNCTIONAL_COLUMN, String.valueOf(vehicle.getFunctional()));
		return vehicleItem;

	}

	private int isNumber(String word) {
		int result = 0;
		
		try {
			result = Integer.parseInt(word);
		} catch (NumberFormatException e) {
			
		}
		return result;
	}

	@Override
	public List<Map<String, String>> listOfPaymentMethods() {
		List<Map<String, String>> payments = new ArrayList<Map<String, String>>();
		Map<String,String> map =null;
		try {
			for (PaymentFrequency payment : polAppDaoManager.getPaymentFrequencyDao().queryForAll()) {
				map= new HashMap<String, String>();
				map.put(PAYMENT_NAME, payment.getName());
				map.put(PAYMENT_ID, String.valueOf(payment.getIdPaymentFrequency()));
				payments.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return payments;
	}

	
	@Override
	public List<Map<String,String>> listOfSellers() {
		List<Map<String, String>> employees = new ArrayList<Map<String, String>>();
		Map<String,String> map =null;
		try {
			for (Employee employee : polAppDaoManager.getEmployee().queryForAll()) {
				map= new HashMap<String, String>();
				map.put(EMPLOYEE_NAME, employee.getName()+ " " + employee.getMiddle_name());
				map.put(EMPLOYEE_ID, String.valueOf(employee.getIdEmployee()));
				employees.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public String registerUser(User user)  {
		String result = USER_INSERTED;
		List<User> userReturned;
		try {
			 userReturned = polAppDaoManager.getUserDao().queryForEq(COLUMN_IDENTIFICATION, user.getIdentification());
			 if(userReturned.size()==0){
				 userReturned.addAll(polAppDaoManager.getUserDao().queryForEq(COLUMN_USERNAME, user.getUsername()));
				 if(userReturned.size()==0){
					 addUser(user);
				 }else{
					 result = USER_INSERTED;
				 }
			 }else{
				 result = COLUMN_IDENTIFICATION;
			 }
			} catch (SQLException e) {
				Log.e(USER_ERROR_TAG,e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e){
				Log.e(USER_ERROR_TAG,e.getMessage());
			}
		return result;
	}

	@Override
	public List<Map<String, String>> searchClients(String[] queryString) {
		List<Map<String,String>> listOfClients = null;
		List<Client> rawClients = null;
		QueryBuilder<Client, Integer> query = null;
		QueryService qService  = new QueryService();
		
		if(queryString.length>0){
			try {
				int lastWordPosition = queryString.length-1;
				query = polAppDaoManager.getClientDao().queryBuilder();
				
				for(int i=0; i<queryString.length;i++){
					String word = queryString[i];
					query.where().like(COLUMN_NAME,qService.setWildCardMatch(word)).or().
								  like(COLUMN_FIRST_LASTNAME,qService.setWildCardMatch(word)).or().
								  like(COLUMN_SECOND_LASTNAME,qService.setWildCardMatch(word));
					
					if(i!=lastWordPosition){
						   query.where().or();
					}
				}
				rawClients = query.query();
				
				listOfClients = new ArrayList<Map<String,String>>();
				for (Client client : rawClients) {
					listOfClients.add(getClientAsItem(client));
				}
			} catch (SQLException e) {
				Log.e(CLIENT_ERROR_TAG,e.getMessage());
			}
		}
		return listOfClients;
		
	}

	@Override
	public List<Map<String, String>> searchProducts(String[] queryString) {
		List<Map<String,String>> listOfProducts = null;
		List<Product> rawProducts = null;
		QueryBuilder<Product, Integer> query = null;
		QueryService qService  = new QueryService();
		int number = 0;
		if(queryString.length>0){
			try {
				int lastWordPosition = queryString.length-1;
				query = polAppDaoManager.getProductDao().queryBuilder();
				
				for(int i=0; i<queryString.length;i++){
					String word = queryString[i];
					number = isNumber(word);
					if(number==0){
						query.where().like(NAME_COLUMN,qService.setWildCardMatch(word)).or()
						  			 .like(CODE_COLUMN,qService.setWildCardMatch(word));
					}else{
						query.where().like(PRICE_COLUMN,number).or()
									 .like(QUANTITY_COLUMN, number);
					}
					
					  
					if(i!=lastWordPosition){
						   query.where().or();
					}
				}
				rawProducts = query.query();
				
				listOfProducts = new ArrayList<Map<String,String>>();
				for (Product product : rawProducts) {
					listOfProducts.add(getProductAsItem(product));
				}
			} catch (SQLException e) {
				Log.e(PRODUCT_ERROR_TAG,e.getMessage());
			}
		}
		return listOfProducts;
	}

	@Override
	public String verifyClientInformation(String name, String[] lastName, long phoneNumber) {
		String result = EMPTY_STRING;
		try{
			if(name!=null&&!name.equalsIgnoreCase(EMPTY_STRING)){
				if(String.valueOf(phoneNumber).length()>=MINIMUM_PHONENUMBER_DIGITS){
					if(lastName==null||lastName.length<=0||lastName[0].equals(EMPTY_STRING)){
						result =COLUMN_LASTNAME;
					}
				}else{
					result = COLUMN_PHONENUMBER;
				}
			}else{
				result = COLUMN_NAME;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String verifyOrderInformation(int clientId,  int paymentId) {
		String result=EMPTY_STRING;
		try {
			if(!polAppDaoManager.getClientDao().idExists(clientId)){
				result=COLUMN_CLIENTID;
			}else if(!polAppDaoManager.getPaymentFrequencyDao().idExists(paymentId)){
				result=COLUMN_PAYMENTFREQUENCY_ID;
			}
		} catch (SQLException e) {
			Log.i("Error on verification", e.getMessage());
		}
		return result;
	}

	@Override
	public String verifyProductInformation(String code, String name, String quantity, String price) {
		String result = EMPTY_STRING;
		try{
			
			if(code.equals(EMPTY_STRING) || name.equals(EMPTY_STRING) || quantity.equals(EMPTY_STRING) 
					|| price.equals(EMPTY_STRING)){
				
				result= EMPTY_STRING;
				
			}else if(code.startsWith(EMPTY_STRING) || name.startsWith(EMPTY_STRING) 
						|| quantity.startsWith(EMPTY_STRING) || price.startsWith(EMPTY_STRING)){
				
				result= START_EMPTY_STRING;
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User verifyUserInformation(String userName, String password, String name,String[] lastName, String identification){
		User user = null;
		if(lastName.length>1){
			if((!userName.equals(EMPTY_STRING)&&!password.equals(EMPTY_STRING)&&!name.equals(EMPTY_STRING)&&!lastName[0].equals(EMPTY_STRING)&&!identification.equals(EMPTY_STRING))){
				user = new UserImpl(userName,password,identification,name,lastName[0],lastName[1]);
			}
		}else{
			if((!userName.equals(EMPTY_STRING)&&!password.equals(EMPTY_STRING)&&!name.equals(EMPTY_STRING)&&!lastName[0].equals(EMPTY_STRING)&&!identification.equals(EMPTY_STRING))){
				user = new UserImpl(userName,password,identification,name,lastName[0],EMPTY_STRING);
			}
		}
		return user;
	}

	@Override
	public Vehicle getVehicleByLicensePlate(String licensePlate) {
		Vehicle vehicle = null;
		try {
			vehicle = polAppDaoManager.getVehicleDao().queryForEq(COLUMN_LICENSE_PLATE, licensePlate).get(0);
			polAppDaoManager.getBrandDao().refresh(vehicle.getBrand());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicle;
	}

	@Override
	public String getFormatedDate(Date date) {
		SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MMMM'/'yy", new Locale("es_ES"));
		return formateador.format(date);
		
	}
	
	
	
}
