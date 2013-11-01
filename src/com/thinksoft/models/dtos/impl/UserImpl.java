package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.User;

public class UserImpl implements User {
	
	@DatabaseField(generatedId=true, useGetSet=true )
	protected int idUser;

	@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
	protected String username;

	@DatabaseField(useGetSet=true, canBeNull=false)
	protected String password;

	@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
	protected String identification;

	@DatabaseField(useGetSet=true, canBeNull=false)
	protected String name;

	@DatabaseField(useGetSet=true, canBeNull=false )
	protected String firstLastName;

	@DatabaseField(useGetSet=true)
	protected String secondLastName;
	
	public UserImpl() {
		// TODO Auto-generated constructor stub
	}
	 
	
	public UserImpl(String username, String password,
			String identification, String name, String firstLastName,
			String secondLastName) {
		super();
		this.username = username;
		this.password = password;
		this.identification = identification;
		this.name = name;
		this.firstLastName = firstLastName;
		this.secondLastName = secondLastName;
	}


	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstLastName() {
		return firstLastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
