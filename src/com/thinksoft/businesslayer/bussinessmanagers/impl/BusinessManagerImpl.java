package com.thinksoft.businesslayer.bussinessmanagers.impl;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.models.daos.PolAppDaoManager;
import com.thinksoft.models.daos.impl.PolAppDaoManagerImpl;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.User;

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
			polAppDaoManager.getProductDao().create(product);
			result= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
