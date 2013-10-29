package com.thinksoft.models.dtos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.Vehicle;

@DatabaseTable
public abstract class Employee {

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
	protected Vehicle vehicle;
	
	public Employee() {
	}
}
