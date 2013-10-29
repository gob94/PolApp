package com.thinksoft.models.dtos;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.ClientAddress;

@DatabaseTable
public abstract class Client {
	
	@DatabaseField(generatedId=true, useGetSet=true)
	protected int clientId;
	
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected String name;
	
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected String firstLastName;
	
	@DatabaseField(useGetSet=true)
	protected String secondLastName;
	
	@DatabaseField(defaultValue="false",useGetSet=true, canBeNull=false)
	protected boolean accountState;
	
	@ForeignCollectionField(eager=false, foreignFieldName="client")
	protected ForeignCollection<ClientAddress> addresses;

	public Client() {
	}
	
}
