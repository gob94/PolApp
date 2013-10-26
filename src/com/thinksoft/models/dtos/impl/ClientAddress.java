package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.Address;

@DatabaseTable
public class ClientAddress {

	@DatabaseField(useGetSet=true, foreign=true, foreignAutoCreate=true)
	private Client client;
	@DatabaseField(useGetSet=true, foreign=true, foreignAutoCreate=true)
	private Address address;
	@DatabaseField(useGetSet=true)
	private int phoneNumber;
	
	public ClientAddress() {
	}

	public Client getClient() {
		return client;
	}

	public Address getAddress() {
		return address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
