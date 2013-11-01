package com.thinksoft.models.dtos.impl;

import java.util.Date;

import com.thinksoft.models.dtos.Brand;
import com.thinksoft.models.dtos.Vehicle;

public class VehicleImpl extends Vehicle {

	public int getIdVehicle() {
		return idVehicle;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public boolean isFunctional() {
		return functional;
	}

	public Date getRtv() {
		return rtv;
	}

	public float getExpenditure() {
		return expenditure;
	}

	public String getModel() {
		return model;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void setFunctional(boolean functional) {
		this.functional = functional;
	}

	public void setRtv(Date rtv) {
		this.rtv = rtv;
	}

	public void setExpenditure(float expenditure) {
		this.expenditure = expenditure;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
