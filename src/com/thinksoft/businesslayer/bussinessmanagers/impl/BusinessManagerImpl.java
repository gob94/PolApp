package com.thinksoft.businesslayer.bussinessmanagers.impl;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.models.daos.PolAppDaoManager;
import com.thinksoft.models.daos.impl.PolAppDaoManagerImpl;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.User;
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
				 userReturned = polAppDaoManager.getUserDao().queryForEq("username", userName);
				 user = userReturned.get(0);
				 if(user.getPassword().equals(password)){
					 result = true;
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return result;
	}
 
	@Override
	public boolean addUser(User user) {
		boolean result = false;
		try {
			polAppDaoManager.getUserDao().createIfNotExists(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean addProduct(Product product) {
		boolean result = false;
		try {
			polAppDaoManager.getProductDao().createIfNotExists(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public User verifyUserInformation(String userName, String password, String name, String firstLastName, String secondLastName, String identification){
		User user = null;
		
		if(!userName.equals("")&&!password.equals("")&&!name.equals("")&&!firstLastName.equals("")&&!secondLastName.equals("")&&!identification.equals("")){
			user = new UserImpl(userName,password,identification,name,firstLastName,secondLastName);
		}
		
		return user;
	}

	@Override
	public int registerUser(User user)  {
		int result = -2;
		try {
			polAppDaoManager.getUserDao().create(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
