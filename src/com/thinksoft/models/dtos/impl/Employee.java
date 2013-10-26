package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Employee {

	@DatabaseField(useGetSet=true, generatedId=true)
	private int idEmployee;
	@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
	private String identification;

	@DatabaseField(useGetSet=true, canBeNull=false)
	private String name;

	@DatabaseField(useGetSet=true, canBeNull=false )
	private String middle_name;

	@DatabaseField(useGetSet=true, canBeNull=false )
	private String lastName;
	
	@DatabaseField(useGetSet=true)
	private int phoneNumber;
	
	@DatabaseField(useGetSet=true, foreign=true, foreignAutoCreate=true)
	private Vehicle vehicle;
	
	public Employee() {
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

	public Vehicle getVehicle() {
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

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
