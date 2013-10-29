package com.thinksoft.models.dtos;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.Brand;

@DatabaseTable
public abstract class Vehicle {
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
	protected Brand brand;
}
