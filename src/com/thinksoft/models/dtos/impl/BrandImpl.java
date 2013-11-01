package com.thinksoft.models.dtos.impl;

import com.j256.ormlite.field.DatabaseField;
import com.thinksoft.models.dtos.Brand;

public class BrandImpl implements Brand {
	
	@DatabaseField(generatedId = true, useGetSet = true)
	protected int brandId;
	@DatabaseField(useGetSet = true, canBeNull = false, unique = true)
	protected String brandName;

	public BrandImpl() {
		// TODO Auto-generated constructor stub
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
