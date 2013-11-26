package com.thinksoft.businesslayer.bussinessmanagers;

import java.util.List;
import java.util.Map;

import com.thinksoft.models.dtos.Brand;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.User;
import com.thinksoft.models.dtos.Vehicle;
public interface BusinessManager {
	
	public boolean checkUserCredentials(String userName, String password);
	
	public boolean addUser(User user); 
	
	public boolean addProduct(Product product);
	
	public boolean addVechicle(Vehicle vehicle);
	
	public boolean addBrand(Brand brand);

	public String registerUser(User user);

	public User verifyUserInformation(String userName, String password,
			String name, String[] lastName, String identification);


	public List<Map<String, String>> getAllClients();

	public List<Map<String, String>> getSpecifiedNumberOfClients(long number);
	
	public boolean addClient(Client client);
	
	public List<Map<String, String>> getAllProducts();
	
	public Client getClientById(int id);

	public Product getProductById(int id);

	public Product getProductByCode(String id);

	
	public String getClientPhoneNumber(int clientId);
	
	public List<Map<String, String>> getClientProducts(int clientId);
	
	public List<Map<String, String>> getAllVehicles();
	
	public List<Map<String, String>> searchClients(String[] queryString);
	
	public boolean clientHasOrders(int clientId);

	public String verifyClientInformation(String name, String[] lastName,int phoneNumber);

	public List<Map<String, String>> searchProducts(String[] queryString);
	
	public String verifyProductInformation(String code, String name, String quantity, String price);
	public Product getProduct(int id);
	
	public double getProductPrice(int id);
	
	public void addDefaultOrderValues();
	public List<Map<String,String>> listOfSellers();
	public List<Map<String,String>> listOfPaymentMethods();
}
