package com.thinksoft.businesslayer.bussinessmanagers;

import com.thinksoft.models.dtos.User;

public interface BusinessManager {
	public boolean checkUserCredentials(String userName, String password);
	
	public boolean addUser(User user); 
}
