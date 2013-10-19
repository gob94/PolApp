package com.thinksoft.businesslayer.databaseaccesses.impl;

import com.thinksoft.businesslayer.databaseaccesses.BusinessLayer;
import com.thinksoft.models.daos.UserDao;
import com.thinksoft.models.daos.impl.UserDaoImpl;

public class BusinessLayerImpl implements BusinessLayer {
	UserDao user = new UserDaoImpl();
	
	@Override
	public void getUserById() {
		
		user.getUserById();
	}

}
