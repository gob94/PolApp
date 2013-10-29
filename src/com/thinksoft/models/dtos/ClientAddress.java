package com.thinksoft.models.dtos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.Address;
import com.thinksoft.models.dtos.Client;

@DatabaseTable
public abstract class ClientAddress {
	
	@DatabaseField(useGetSet=true, foreign=true, foreignAutoCreate=true)
	protected Client client;
	@DatabaseField(useGetSet=true, foreign=true, foreignAutoCreate=true)
	protected Address address;
	@DatabaseField(useGetSet=true)
	protected int phoneNumber;
	
	public ClientAddress() {
	}
}
