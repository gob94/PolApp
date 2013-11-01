package com.thinksoft.models.dtos.impl;

import com.thinksoft.models.dtos.Address;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.ClientAddress;

public class ClientAddressImpl extends ClientAddress {

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
