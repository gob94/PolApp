package com.thinksoft.models.dtos;

import java.util.Date;

import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.impl.BrandImpl;

@DatabaseTable
public interface Vehicle { 
	public int getIdVehicle();

	public String getLicensePlate();

	public boolean getFunctional();

	public Date getRtv();
  
	public float getExpenditure();

	public String getModel();

	public BrandImpl getBrand();

	public void setIdVehicle(int idVehicle);

	public void setLicensePlate(String licensePlate);

	public void setFunctional(boolean functional);

	public void setRtv(Date rtv);

	public void setExpenditure(float expenditure);

	public void setModel(String model);

	public void setBrand(BrandImpl brand);

}
