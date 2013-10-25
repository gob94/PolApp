package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Client {
	@DatabaseField(generatedId=true, useGetSet=true)
	private int clientId;
	
	@DatabaseField(useGetSet=true, canBeNull=false)
	private String name;
	
	@DatabaseField(useGetSet=true, canBeNull=false)
	private String middleName;
	
	@DatabaseField(useGetSet=true, canBeNull=false)
	private String lastName;
	
	@DatabaseField(defaultValue="false",useGetSet=true, canBeNull=false)
	private boolean accountState;
	
	@ForeignCollectionField(eager=false, foreignFieldName="client")
	private ForeignCollection<ClientAddress> addresses;

	public Client() {
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isAccountState() {
		return accountState;
	}

	public void setAccountState(boolean accountState) {
		this.accountState = accountState;
	}

	public ForeignCollection<ClientAddress> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(ForeignCollection<ClientAddress> addresses) {
		this.addresses = addresses;
	}
	
}
