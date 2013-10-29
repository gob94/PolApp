package com.thinksoft.models.dtos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public abstract class Address {
	@DatabaseField(generatedId = true, useGetSet = true)
	protected int idAddress;
	@DatabaseField(useGetSet = true, canBeNull=false)
	protected int state;
	@DatabaseField(useGetSet = true, canBeNull=false)
	protected int city;
	@DatabaseField(useGetSet = true, canBeNull=false)
	protected int disctric;
	@DatabaseField(useGetSet = true)
	protected int specificSigns;
	@DatabaseField(useGetSet = true)
	protected int mapURL;
	
	public Address() {
	}
}
