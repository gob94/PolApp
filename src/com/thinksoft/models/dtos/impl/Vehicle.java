package com.thinksoft.models.dtos.impl;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Vehicle {

	@DatabaseField(generatedId=true, useGetSet=true)
	private int idVehicle;
	@DatabaseField(useGetSet=true, canBeNull=false)
	private String licensePlate;
	@DatabaseField(useGetSet=true, canBeNull=false)
	private boolean functional;
	@DatabaseField(useGetSet=true, canBeNull=false)
	private Date rtv;
	@DatabaseField(useGetSet=true)
	private float expenditure;
	@DatabaseField(useGetSet=true)
	private String model;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	private Brand brand;
	
	public Vehicle() {
	}

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
