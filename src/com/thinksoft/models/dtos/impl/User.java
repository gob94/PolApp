package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class User {

@DatabaseField(generatedId=true, useGetSet=true )
private int idUser;

@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
private String username;

@DatabaseField(useGetSet=true, canBeNull=false)
private String password;

@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
private String identification;

@DatabaseField(useGetSet=true, canBeNull=false)
private String name;

@DatabaseField(useGetSet=true, canBeNull=false )
private String middle_name;

@DatabaseField(useGetSet=true, canBeNull=false )
private String lastName;

public User() {
}

public int getIdUser() {
	return idUser;
}

public void setIdUser(int idUser) {
	this.idUser = idUser;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMiddle_name() {
	return middle_name;
}

public void setMiddle_name(String middle_name) {
	this.middle_name = middle_name;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getIdentification() {
	return identification;
}

public void setIdentification(String identification) {
	this.identification = identification;
}





}
