package com.thinksoft.models.dtos.impl;

import com.thinksoft.models.dtos.Brand;

public class BrandImpl extends Brand{

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
