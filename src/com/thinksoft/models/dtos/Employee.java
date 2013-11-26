package com.thinksoft.models.dtos;

import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.impl.VehicleImpl;

@DatabaseTable
public interface Employee { 
	
	public int getIdEmployee();

	public String getIdentification();

	public String getName();

	public String getMiddle_name();

	public String getLastName();

	public int getPhoneNumber();

	public VehicleImpl getVehicle();
	public void setIdEmployee(int idEmployee);

	public void setIdentification(String identification);

	public void setName(String name);

	public void setMiddle_name(String middle_name);

	public void setLastName(String lastName);

	public void setPhoneNumber(int phoneNumber);

	public void setVehicle(VehicleImpl vehicle);
}
