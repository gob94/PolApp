package com.thinksoft.businesslayer.bussinessmanagers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.User;
public interface BusinessManager {
	
	public boolean checkUserCredentials(String userName, String password);
	
	public boolean addUser(User user); 
	
	public boolean addProduct(Product product);

	public String registerUser(User user);

	public User verifyUserInformation(String userName, String password,
			String name, String[] lastName, String identification);


	public List<Map<String, String>> getAllClients();

	public boolean addClient(Client client);
	
	public List<Map<String, String>> getAllProducts();

}
