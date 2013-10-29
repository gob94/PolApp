package com.thinksoft.models.dtos.impl;

import com.thinksoft.models.dtos.Employee;
import com.thinksoft.models.dtos.Vehicle;


public class EmployeeImpl extends Employee {


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
