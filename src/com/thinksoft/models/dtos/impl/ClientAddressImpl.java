package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.ClientAddress;

public class ClientAddressImpl implements ClientAddress {
	
	@DatabaseField(useGetSet = true, foreign = true)
	protected ClientImpl client;
	@DatabaseField(useGetSet = true, foreign = true)
	protected AddressImpl address;
	@DatabaseField(useGetSet = true)
	protected int phoneNumber;

	public ClientAddressImpl() {
		// TODO Auto-generated constructor stub
	}
	 
	public ClientImpl getClient() {
		return client;
	}

	public AddressImpl getAddress() {
		return address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setClient(ClientImpl client) {
		this.client = client;
	}

	public void setAddress(AddressImpl address) {
		this.address = address;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
