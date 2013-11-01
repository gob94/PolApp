package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Address;


public class AddressImpl implements Address{
	
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
	
	public AddressImpl() {
	}
	
	public int getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getDisctric() {
		return disctric;
	}
	public void setDisctric(int disctric) {
		this.disctric = disctric;
	}
	public int getSpecificSigns() {
		return specificSigns;
	}
	public void setSpecificSigns(int specificSigns) {
		this.specificSigns = specificSigns;
	}
	public int getMapURL() {
		return mapURL;
	}
	public void setMapURL(int mapURL) {
		this.mapURL = mapURL;
	}
	
	
	
}
