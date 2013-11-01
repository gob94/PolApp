package com.thinksoft.models.dtos;

import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public interface User {
	public int getIdUser();

	public void setIdUser(int idUser);

	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);

	public String getName();

	public void setName(String name);

	public String getFirstLastName();

	public String getSecondLastName();

	public void setFirstLastName(String firstLastName);

	public void setSecondLastName(String secondLastName);

	public String getIdentification();

	public void setIdentification(String identification); 
}
