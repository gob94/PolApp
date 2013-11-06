package com.thinksoft.models.dtos;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.impl.AddressImpl;

@DatabaseTable
public interface Client { 
	
	
	public int getClientId();

	public void setClientId(int clientId);

	public String getName();

	public void setName(String name);

	public String getFirstLastName();

	public String getSecondLastName();
	public void setFirstLastName(String firstLastName);

	public void setSecondLastName(String secondLastName);

	public boolean getAccountState();

	public void setAccountState(boolean accountState);
	
	public void setClientAddresses(ForeignCollection<AddressImpl> clientAddresses);
	
	public ForeignCollection<AddressImpl> getClientAddresses();
}
