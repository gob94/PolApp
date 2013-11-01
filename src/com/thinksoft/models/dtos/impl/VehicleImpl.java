package com.thinksoft.models.dtos.impl;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Vehicle;

public class VehicleImpl implements Vehicle {

	
	@DatabaseField(generatedId=true, useGetSet=true)
	protected int idVehicle;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected String licensePlate;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected boolean functional;
	@DatabaseField(useGetSet=true, canBeNull=false)
	protected Date rtv;
	@DatabaseField(useGetSet=true)
	protected float expenditure;
	@DatabaseField(useGetSet=true)
	protected String model;
	@DatabaseField(useGetSet=true, canBeNull=false, foreign=true, foreignAutoCreate=true)
	protected BrandImpl brand;
	
	public VehicleImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdVehicle() {
		return idVehicle;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public boolean getFunctional() {
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

	public BrandImpl getBrand() {
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

	public void setBrand(BrandImpl brand) {
		this.brand = brand;
	}

}
