package com.thinksoft.businesslayer.bussinessmanagers.impl;

import static com.thinksoft.businesslayer.utils.constants.Constants.WILDCARD_MATCH;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_CLIENTID;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_FIRST_LASTNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_IDENTIFICATION;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_LASTNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_NAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_ORDERID;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_ORDERSTATE;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_PHONENUMBER;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_SECOND_LASTNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_USERNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.EMPTY_STRING;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.GET_CLIENT_ERROR_TAG;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.GET_PRODUCT_ERROR_TAG;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.GET_USER_ERROR_TAG;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.MINIMUM_PHONENUMBER_DIGITS;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.USER_INSERTED;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.CODE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.FIRST_LASTNAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.PRICE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.SECOND_LASTNAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.STATUS_COLUMN;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.models.daos.PolAppDaoManager;
import com.thinksoft.models.daos.impl.PolAppDaoManagerImpl;
import com.thinksoft.models.dtos.Brand;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.ProductOrder;
import com.thinksoft.models.dtos.User;
import com.thinksoft.models.dtos.Vehicle;
import com.thinksoft.models.dtos.impl.AddressImpl;
import com.thinksoft.models.dtos.impl.UserImpl;

public class BusinessManagerImpl implements BusinessManager {
	
	private PolAppDaoManager polAppDaoManager;

	
	public BusinessManagerImpl(ConnectionSource connection) {
		polAppDaoManager = new  PolAppDaoManagerImpl(connection);
	}
	
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
				Log.e(GET_USER_ERROR_TAG,e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e){
				Log.e(GET_USER_ERROR_TAG,e.getMessage());
			}
		return result;
	}
 
	@Override
	public boolean addUser(User user) {
		boolean result = false;
		try {
			polAppDaoManager.getUserDao().create(user);
			result = true;
		} catch (SQLException e) {
			Log.e(GET_USER_ERROR_TAG,e.getMessage());
		}
		return result;
	}
	
	@Override
	public boolean addProduct(Product product) {
		boolean result = false;
		try {
			polAppDaoManager.getProductDao().createIfNotExists(product);
			result = true;
		} catch (SQLException e) {
			Log.e(GET_PRODUCT_ERROR_TAG, e.getMessage());
		}
		return result;
	}
	
	public List<Map<String,String>> getAllProducts(){
		List<Map<String,String>> productList = null;
		List<Product> rawProducts = null;
		Map<String, String> productItem = null;
		try {
			productList = new ArrayList<Map<String,String>>();
			rawProducts = polAppDaoManager.getProductDao().queryForAll();
			for (Product product : rawProducts) {
					
				productItem = new HashMap<String, String>();
				
				productItem.put(NAME_COLUMN, product.getName());

				productItem.put(CODE_COLUMN, product.getCode());

				productItem.put(PRICE_COLUMN, String.valueOf(product.getPrice()));
				
				productItem.put(QUANTITY_COLUMN, String.valueOf(product.getQuantity()));
				
				productList.add(productItem);
			}
		} catch (SQLException e) {
			Log.e(GET_PRODUCT_ERROR_TAG,e.getMessage());
		}
		return productList;
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
				Log.e(GET_USER_ERROR_TAG,e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e){
				Log.e(GET_USER_ERROR_TAG,e.getMessage());
			}
		return result;
	}

	@Override
	public List<Map<String,String>> getAllClients(){
		List<Map<String,String>> listOfClients = null;
		List<Client> rawClients = null;
		Map<String, String> clientItem = null;
		try {			
			rawClients = polAppDaoManager.getClientDao().queryForAll();
			listOfClients = new ArrayList<Map<String,String>>();
			for (Client client : rawClients) {
				
				clientItem = new HashMap<String, String>();
				
				clientItem.put(NAME_COLUMN, client.getName());

				clientItem.put(FIRST_LASTNAME_COLUMN, client.getFirstLastName());

				clientItem.put(SECOND_LASTNAME_COLUMN, client.getSecondLastName());
				
				clientItem.put(STATUS_COLUMN, String.valueOf(client.getAccountState()));
				
				listOfClients.add(clientItem);
			}
		} catch (SQLException e) {
			Log.e(GET_CLIENT_ERROR_TAG,e.getMessage());
		}
		return listOfClients;
	}

	@Override
	public boolean addClient(Client client) {
		boolean result = false;
		try {
			polAppDaoManager.getClientDao().createOrUpdate(client);
			result = true;
		} catch (SQLException e) {
			Log.e(GET_CLIENT_ERROR_TAG,e.getMessage());
		}
		return result;
	}

	@Override
	public Client getClientById(int id) {
		Client client = null;
		try {
			client =  (Client) polAppDaoManager.getClientDao().queryBuilder().where().idEq(id);
		} catch (SQLException e) {
			Log.e(GET_CLIENT_ERROR_TAG, e.getMessage());
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
		Map<String,String> productItem = null;
		
		try {
			actualOrders = polAppDaoManager.getOrderDao().queryBuilder().where().eq(COLUMN_CLIENTID, clientId).query();
			productList = new ArrayList<Map<String,String>>();
			for (Order order : actualOrders) {
				List<ProductOrder> productListOfOrder = polAppDaoManager.getProductOrderDao().queryBuilder().where().eq(COLUMN_ORDERID, order .getOrderId()).query();
				if (productList.size()>2) {
					productList = productList.subList(0, 2);
				}
				for (ProductOrder productOrder : productListOfOrder) {
					polAppDaoManager.getProductOrderDao().refresh(productOrder);
					productItem = new HashMap<String, String>();
					
					productItem.put(NAME_COLUMN, productOrder.getProduct().getName());

					productItem.put(CODE_COLUMN, productOrder.getProduct().getCode());

					productItem.put(PRICE_COLUMN, String.valueOf(productOrder.getProduct().getPrice()));
					
					productItem.put(QUANTITY_COLUMN, String.valueOf(productOrder.getProduct().getQuantity()));
					
					productList.add(productItem);
				}
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Map<String, String>> getAllVehicles() {
		List<Map<String,String>> listOfVehicles = null;
		List<Vehicle> rawVehicles = null;
		Map<String, String> vehicleItem = null;
		try {			
			rawVehicles = polAppDaoManager.getVehicleDao().queryForAll();
			listOfVehicles = new ArrayList<Map<String,String>>();
			
			for (Vehicle vehicle : rawVehicles) {
				vehicleItem = new HashMap<String, String>();
				polAppDaoManager.getBrandDao().refresh(vehicle.getBrand());
				
				vehicleItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.LICENCE_COLUMN, vehicle.getLicensePlate().toString());

				vehicleItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.BRAND_COLUMN, vehicle.getBrand().getBrandName());

				vehicleItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.MODEL_COLUMN, vehicle.getModel());
				
				vehicleItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.RTV_COLUMN, String.valueOf(vehicle.getRtv()));
				
				vehicleItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.EXPEDITURE_COLUMN, String.valueOf(vehicle.getExpenditure()));

				vehicleItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.FUNCTIONAL_COLUMN, String.valueOf(vehicle.getFunctional()));

				listOfVehicles.add(vehicleItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfVehicles;
	}

	@Override
	public boolean addVechicle(Vehicle vehicle) {
		boolean result = false;
		try {
			polAppDaoManager.getVehicleDao().create(vehicle);
			result = true;
		} catch (SQLException e) {
			Log.e("Error insertando vehículo",e.getCause().toString());
		}
		return result;
	}
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
	public boolean addBrand(Brand brand) {
		boolean result = false;
		try {
			polAppDaoManager.getBrandDao().create(brand);
			result = true;
		} catch (SQLException e) {
			Log.e("Error insertando marca",e.getCause().toString());
		}
		return result;
	}
	public String verifyClientInformation(String name, String[] lastName, int phoneNumber) {
		String result = EMPTY_STRING;
		try{
			if(name!=null&&!name.equalsIgnoreCase(EMPTY_STRING)){
				if(String.valueOf(phoneNumber).length()>=MINIMUM_PHONENUMBER_DIGITS){
					if(lastName==null||lastName.equals(EMPTY_STRING)){
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
	public List<Map<String, String>> getSpecifiedNumberOfClients(long number) {
		List<Map<String,String>> listOfClients = null;
		List<Client> rawClients = null;
		Map<String, String> clientItem = null;
		try {			
			rawClients = polAppDaoManager.getClientDao().queryBuilder().limit(number).query();
			listOfClients = new ArrayList<Map<String,String>>();
			for (Client client : rawClients) {
				
				clientItem = new HashMap<String, String>();
				
				clientItem.put(NAME_COLUMN, client.getName());

				clientItem.put(FIRST_LASTNAME_COLUMN, client.getFirstLastName());

				clientItem.put(SECOND_LASTNAME_COLUMN, client.getSecondLastName());
				
				clientItem.put(STATUS_COLUMN, String.valueOf(client.getAccountState()));
				
				listOfClients.add(clientItem);
			}
		} catch (SQLException e) {
			Log.e(GET_CLIENT_ERROR_TAG,e.getMessage());
		}
		return listOfClients;
	}

	@Override
	public List<Map<String, String>> searchClients(String[] queryString) {
		List<Map<String,String>> listOfClients = null;
		List<Client> rawClients = null;
		Map<String, String> clientItem = null;
		//boolean accountState = (query.equalsIgnoreCase(ACCOUNT_STATE_FALSE)||query.equalsIgnoreCase(ACCOUNT_STATE_INACTIVE)) ? false : true;
		if(queryString.length>0){
			try {		
				QueryBuilder<Client, Integer> query = polAppDaoManager.getClientDao().queryBuilder();
				Where<Client, Integer> where  = query.where();
				for(int i=0; i<queryString.length;i++){
					String word = queryString[i];
					if(i==queryString.length-1){
						where.like(COLUMN_NAME,setWildCardMatch(word)).or()
						   .like(COLUMN_FIRST_LASTNAME,setWildCardMatch(word)).or()
						   .like(COLUMN_SECOND_LASTNAME,setWildCardMatch(word));
					}else{
						where.like(COLUMN_NAME,setWildCardMatch(word)).or()
						   .like(COLUMN_FIRST_LASTNAME,setWildCardMatch(word)).or()
						   .like(COLUMN_SECOND_LASTNAME,setWildCardMatch(word)).or();
					}
				}
				query.setWhere(where);
				rawClients = query.query();
				
				listOfClients = new ArrayList<Map<String,String>>();
				for (Client client : rawClients) {
					
					clientItem = new HashMap<String, String>();
					
					clientItem.put(NAME_COLUMN, client.getName());
	
					clientItem.put(FIRST_LASTNAME_COLUMN, client.getFirstLastName());
	
					clientItem.put(SECOND_LASTNAME_COLUMN, client.getSecondLastName());
					
					clientItem.put(STATUS_COLUMN, String.valueOf(client.getAccountState()));
					
					listOfClients.add(clientItem);
				}
			} catch (SQLException e) {
				Log.e(GET_CLIENT_ERROR_TAG,e.getMessage());
			}
		}
		return listOfClients;
		
	}
	
	private String setWildCardMatch(String queryString){
		return WILDCARD_MATCH+queryString+WILDCARD_MATCH;
	}
	
}
