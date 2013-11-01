package com.thinksoft.models.dtos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public abstract class User {

	@DatabaseField(generatedId=true, useGetSet=true )
	protected int idUser;

	@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
	protected String username;

	@DatabaseField(useGetSet=true, canBeNull=false)
	protected String password;

	@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
	protected String identification;

	@DatabaseField(useGetSet=true, canBeNull=false)
	protected String name;

	@DatabaseField(useGetSet=true, canBeNull=false )
	protected String firstLastName;

	@DatabaseField(useGetSet=true)
	protected String secondLastName;
}
