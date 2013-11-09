package com.thinksoft.businesslayer.bussinessmanagers.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;
import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.models.daos.PolAppDaoManager;
import com.thinksoft.models.daos.impl.PolAppDaoManagerImpl;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.ProductOrder;
import com.thinksoft.models.dtos.User;
import com.thinksoft.models.dtos.impl.AddressImpl;
import com.thinksoft.models.dtos.impl.OrderImpl;
import com.thinksoft.models.dtos.impl.UserImpl;

public class BusinessManagerImpl implements BusinessManager {
	
	private PolAppDaoManager polAppDaoManager;
	private static String GET_CLIENT_ERROR_TAG = "Error obteniendo Cliente";
	
	
	public BusinessManagerImpl(ConnectionSource connection) {
		polAppDaoManager = new  PolAppDaoManagerImpl(connection);
	}
	
	public boolean checkUserCredentials(String userName, String password){
		boolean result = false;
		List<User> userReturned = null;
		User user = null;
			try {
				 userReturned = polAppDaoManager.getUserDao().queryForEq("username", userName);
				 if(userReturned.size()>0){
					 user = userReturned.get(0);
					 if(user.getPassword().equals(password)){
						 result = true;
					 }
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e){
				e.printStackTrace();
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
			Log.e("Error insertandousuario",e.getCause().toString());
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
			e.printStackTrace();
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
				
				productItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN, product.getName());

				productItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.CODE_COLUMN, product.getCode());

				productItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.PRICE_COLUMN, String.valueOf(product.getPrice()));
				
				productItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN, String.valueOf(product.getQuantity()));
				
				productList.add(productItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	@Override
	public User verifyUserInformation(String userName, String password, String name,String[] lastName, String identification){
		User user = null;
		if(lastName.length>1){
			if((!userName.equals("")&&!password.equals("")&&!name.equals("")&&!lastName[0].equals("")&&!identification.equals(""))){
				user = new UserImpl(userName,password,identification,name,lastName[0],lastName[1]);
			}
		}else{
			if((!userName.equals("")&&!password.equals("")&&!name.equals("")&&!lastName[0].equals("")&&!identification.equals(""))){
				user = new UserImpl(userName,password,identification,name,lastName[0],"");
			}
		}
		return user;
	}

	@Override
	public String registerUser(User user)  {
		String result = "inserted";
		List<User> userReturned;
		try {
			 userReturned = polAppDaoManager.getUserDao().queryForEq("identification", user.getIdentification());
			 if(userReturned.size()==0){
				 userReturned.addAll(polAppDaoManager.getUserDao().queryForEq("username", user.getUsername()));
				 if(userReturned.size()==0){
					 addUser(user);
				 }else{
					 result = "username";
				 }
			 }else{
				 result = "identification";
			 }
			} catch (SQLException e) {
				Log.e("Error verificando credenciales",e.getCause().toString());
			} catch (ArrayIndexOutOfBoundsException e){
				Log.e("Error verificando credenciales",e.getCause().toString());
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
			for (Client client : rawClients) {
				listOfClients = new ArrayList<Map<String,String>>();
				clientItem = new HashMap<String, String>();
				
				clientItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN, client.getName());

				clientItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.FIRST_LASTNAME_COLUMN, client.getFirstLastName());

				clientItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.SECOND_LASTNAME_COLUMN, client.getSecondLastName());
				
				clientItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.STATUS_COLUMN, String.valueOf(client.getAccountState()));
				
				listOfClients.add(clientItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfClients;
	}

	@Override
	public boolean addClient(Client client) {
		boolean result = false;
		try {
			polAppDaoManager.getClientDao().create(client);
			result = true;
		} catch (SQLException e) {
			Log.e("Error insertando Cliente",e.getCause().toString());
		}
		return result;
	}

	@Override
	public Client getClientById(int id) {
		Client client = null;
		try {
			client =  (Client) polAppDaoManager.getClientDao().queryBuilder().where().idEq(id);
		} catch (SQLException e) {
			Log.e(GET_CLIENT_ERROR_TAG, "Error Obteniendo client en la base, a continuacion el msj" + e.getMessage());
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
			actualOrders = polAppDaoManager.getOrderDao().queryBuilder().where().eq("clientId", clientId).query();
			productList = new ArrayList<Map<String,String>>();
			for (Order order : actualOrders) {
				List<ProductOrder> productListOfOrder = polAppDaoManager.getProductOrderDao().queryBuilder().where().eq("order_id", order.getOrderId()).query();
				/*for (ProductOrder productOrder : productListOfOrder) {
					int result = polAppDaoManager.getProductOrderDao().refresh(productOrder);
					productItem = new HashMap<String, String>();
					
					productItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN, ());

					productItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.CODE_COLUMN, product.getCode());

					productItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.PRICE_COLUMN, String.valueOf(product.getPrice()));
					
					productItem.put(com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN, String.valueOf(product.getQuantity()));
					
					productList.add(productItem);
				}*/	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	
	
}
