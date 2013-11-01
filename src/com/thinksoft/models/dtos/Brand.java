package com.thinksoft.models.dtos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.Brand;

@DatabaseTable
public abstract class Brand {
	
	@DatabaseField(generatedId=true, useGetSet=true)
	protected int brandId;
	@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
	protected String brandName;
	
	public Brand() {
	}
}
