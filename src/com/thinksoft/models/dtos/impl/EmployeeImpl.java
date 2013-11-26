package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Employee;


public class EmployeeImpl implements Employee {
	
	@DatabaseField(useGetSet=true, generatedId=true)
	protected int idEmployee;
	@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
	protected String identification;

	@DatabaseField(useGetSet=true, canBeNull=false)
	protected String name;

	@DatabaseField(useGetSet=true, canBeNull=false )
	protected String middle_name;

	@DatabaseField(useGetSet=true, canBeNull=false )
	protected String lastName;
	
	@DatabaseField(useGetSet=true)
	protected int phoneNumber;
	
	@DatabaseField(useGetSet=true, foreign=true, foreignAutoCreate=true)
	protected VehicleImpl vehicle;
	
	public EmployeeImpl() {
		// TODO Auto-generated constructor stub
	}
	
	

	public EmployeeImpl(String identification, String name, String middle_name,
			String lastName, int phoneNumber, VehicleImpl vehicle) {
		super();
		this.identification = identification;
		this.name = name;
		this.middle_name = middle_name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.vehicle = vehicle;
	}



	public int getIdEmployee() {
		return idEmployee;
	}

	public String getIdentification() {
		return identification;
	}

	public String getName() {
		return name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public String getLastName() {
		return lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public VehicleImpl getVehicle() {
		return vehicle;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public void setName(String name) {
		this.name = name;
	}  

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setVehicle(VehicleImpl vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
