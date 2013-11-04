package com.thinksoft.businesslayer.bussinessmanagers.impl;

import java.sql.SQLException;
import java.util.List;

import android.util.Log;

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

}
