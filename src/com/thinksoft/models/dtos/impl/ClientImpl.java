package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.thinksoft.models.dtos.Client;

public class ClientImpl implements Client {
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

	@DatabaseField(useGetSet = true, canBeNull = false)
	protected long phoneNumber;

	@ForeignCollectionField(eager = false)
	private ForeignCollection<AddressImpl> clientAddresses;

	public ClientImpl() {
	}

	public ClientImpl(String name, String firstLastName, String secondLastName,
			boolean accountState, long phoneNumber) {
		super();
		this.name = name;
		this.firstLastName = firstLastName;
		this.secondLastName = secondLastName;
		this.accountState = accountState;
		this.phoneNumber = phoneNumber;
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

	public void setClientAddresses(
			ForeignCollection<AddressImpl> clientAddresses) {
		this.clientAddresses = clientAddresses;
	}

	public ForeignCollection<AddressImpl> getClientAddresses() {
		return clientAddresses;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
