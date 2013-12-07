package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Address;


public class AddressImpl implements Address{
	
	@DatabaseField(generatedId = true, useGetSet = true)
	protected int idAddress;
	@DatabaseField(useGetSet = true, canBeNull=false)
	protected double zoom;
	@DatabaseField(useGetSet = true, canBeNull=false)
	protected double latitude;
	@DatabaseField(useGetSet = true, canBeNull=true)
	protected String specificSigns;
	@DatabaseField(useGetSet = true)
	protected double longuitude;
	@DatabaseField(useGetSet = true, foreign=true, foreignAutoCreate=true, columnName="client")
	protected ClientImpl client;
	@DatabaseField(useGetSet = true)
	protected boolean active;
	@DatabaseField(useGetSet = true)
	protected long phoneNumber;
	
	public AddressImpl() {
	}
	
	
	
	public AddressImpl(double zoom, double latitude,
			String specificSigns, double longuitude, ClientImpl client,
			boolean active, long phone) {
		super();
		this.phoneNumber = phone;
		this.zoom = zoom;
		this.latitude = latitude;
		this.specificSigns = specificSigns;
		this.longuitude = longuitude;
		this.client = client;
		this.active = active;
	}



	public int getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public double getLonguitude() {
		return longuitude;
	}
	public void setLonguitude(int longuitude) {
		this.longuitude = longuitude;
	}
	public String getSpecificSigns() {
		return specificSigns;
	}
	public ClientImpl getClient() {
		return client;
	}
	public void setSpecificSigns(String specificSigns) {
		this.specificSigns = specificSigns;
	}
	public double getZoom() {
		return zoom;
	}
	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setClient(ClientImpl client) {
		this.client = client;
	}
	
	public boolean getActive() {
		return active;
	}

	@Override
	public void setLatitude(double latitude) {
		this.latitude= latitude;
	}


	@Override
	public double getLatitude() {
		return latitude;
	}

	@Override
	public void setLonguitude(double longuitude) {
		this.longuitude = longuitude;
		
	}



	@Override
	public long getPhoneNumber() {
		return phoneNumber;
	}



	@Override
	public void setPhoneNumber(long phone) {
		this.phoneNumber= phone;
		
	}
}
