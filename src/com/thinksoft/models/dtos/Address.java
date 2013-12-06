package com.thinksoft.models.dtos;

import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.impl.ClientImpl;

@DatabaseTable
public interface Address {

	public int getIdAddress();

	public void setIdAddress(int idAddress);

	public double getLatitude();
	public void setLatitude(double latitude);

	public double getLonguitude();
	public void setLonguitude(double longuitude);

	public double getZoom();
	public void setZoom(double zoom);

	public String getSpecificSigns();

	public ClientImpl getClient();

	public void setSpecificSigns(String specificSigns);

	public void setActive(boolean active);

	public void setClient(ClientImpl client);

	public boolean getActive();

	public int getPhoneNumber();

	public void setPhoneNumber(int phoneNumber);
}
