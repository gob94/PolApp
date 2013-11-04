package com.thinksoft.businesslayer.bussinessmanagers;

import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.User;

public interface BusinessManager {
	public boolean checkUserCredentials(String userName, String password);
	
	public boolean addUser(User user); 
	
	public boolean addProduct(Product product);

	public String registerUser(User user);

	public User verifyUserInformation(String userName, String password,
			String name, String[] lastName, String identification);
}
