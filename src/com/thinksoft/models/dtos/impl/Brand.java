package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Brand {
	
	@DatabaseField(generatedId=true, useGetSet=true)
	private int brandId;
	@DatabaseField(useGetSet=true, canBeNull=false, unique=true)
	private String brandName;
	
	public Brand() {
	}

	public int getBrandId() {
		return brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
}
