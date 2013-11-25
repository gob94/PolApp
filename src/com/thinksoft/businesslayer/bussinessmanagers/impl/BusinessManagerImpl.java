package com.thinksoft.businesslayer.bussinessmanagers.impl;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.START_EMPTY_STRING;
import static com.thinksoft.businesslayer.utils.constants.Constants.NUMBER_OF_PRODUCTS_TO_DISPLAY;
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
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_PHONENUMBER;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_SECOND_LASTNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_USERNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.EMPTY_STRING;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.MINIMUM_PHONENUMBER_DIGITS;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.PRODUCT_ERROR_TAG;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.USER_ERROR_TAG;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.USER_INSERTED;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.VEHICLE_ERROR_TAG;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.BRAND_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.CLIENT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.CODE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.EXPEDITURE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.FIRST_LASTNAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.FUNCTIONAL_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.LICENCE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.MODEL_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.PRICE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.RTV_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.SECOND_LASTNAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.STATUS_COLUMN;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;
import android.widget.Toast;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.utils.services.QueryService;
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
import com.thinksoft.polapp.HomeScreenActivity;

public class BusinessManagerImpl implements BusinessManager {
	
	private PolAppDaoManager polAppDaoManager;

	
	public BusinessManagerImpl(ConnectionSource connection) {
		polAppDaoManager = new  PolAppDaoManagerImpl(connection);
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
			client =  (Client) polAppDaoManager.getClientDao().queryBuilder().where().idEq(id);
		} catch (SQLException e) {
			Log.e(CLIENT_ERROR_TAG, e.getMessage());
		}
		return client;
	}


	@Override
	public Product getProductById(int id) {
		Product product = null;
		try {
			product =  (Product) polAppDaoManager.getProductDao().queryBuilder().where().idEq(id);
		} catch (SQLException e) {
			Log.e(CLIENT_ERROR_TAG, e.getMessage());
		}
		return product;
	}
	
	@Override
	public Product getProductByCode(String id) {
		Product product = null;
		try {
			product =  (Product) polAppDaoManager.getProductDao().queryBuilder().where().eq("code", id);
		} catch (SQLException e) {
			Log.e(CLIENT_ERROR_TAG, e.getMessage());
		}
		return product;
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
				List<ProductOrder> productListOfOrder = polAppDaoManager.getProductOrderDao().queryBuilder().where().eq(COLUMN_ORDERID, order .getOrderId()).query();
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

	private Map<String, String> getProductAsItem(Product product){
		Map<String, String> productItem = new HashMap<String, String>();
		
		productItem.put(NAME_COLUMN, product.getName());

		productItem.put(CODE_COLUMN, product.getCode());

		productItem.put(PRICE_COLUMN, String.valueOf(product.getPrice()));
		
		productItem.put(QUANTITY_COLUMN, String.valueOf(product.getQuantity()));
		
		return productItem;
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
		
		vehicleItem.put(RTV_COLUMN, String.valueOf(vehicle.getRtv()));
		
		vehicleItem.put(EXPEDITURE_COLUMN, String.valueOf(vehicle.getExpenditure()));

		vehicleItem.put(FUNCTIONAL_COLUMN, String.valueOf(vehicle.getFunctional()));
		return vehicleItem;

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
	
	private int isNumber(String word) {
		int result = 0;
		
		try {
			result = Integer.parseInt(word);
		} catch (NumberFormatException e) {
			
		}
		return result;
	}

	@Override
	public String verifyClientInformation(String name, String[] lastName, int phoneNumber) {
		String result = EMPTY_STRING;
		try{
			if(name!=null&&!name.equalsIgnoreCase(EMPTY_STRING)){
				if(String.valueOf(phoneNumber).length()>=MINIMUM_PHONENUMBER_DIGITS){
					Log.i("jonathan es gay",String.valueOf(lastName.length));
					Log.i("jonathan se la come",String.valueOf(lastName.length<=0));
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
		Log.i("Jonathan sexy", result);
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
		Log.i("Jonathan sexy", result);
		return result;
	}
	
	
	
}
