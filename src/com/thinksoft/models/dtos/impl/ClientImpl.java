package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Client;

public class ClientImpl extends Client {
	@DatabaseField(generatedId = true, useGetSet = true)
	protected int clientId;

	@DatabaseField(useGetSet = true, canBeNull = false)
	protected String name;

	@DatabaseField(useGetSet = true, canBeNull = false)
	protected String firstLastName;

	@DatabaseField(useGetSet = true)
	protected String secondLastName;

	@DatabaseField(defaultValue = "false", useGetSet = true, canBeNull = false)
	protected boolean accountState;
 
	public ClientImpl() {
	}
	
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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

	public boolean getAccountState() {
		return accountState;
	}

	public void setAccountState(boolean accountState) {
		this.accountState = accountState;
	}

}
