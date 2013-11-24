package com.thinksoft.businesslayer.utils;

import android.widget.CheckBox;
import android.widget.TextView;

public class ProductCheckViewHolder {
	CheckBox chkProduct;
	TextView txtName;
	TextView txtCode;
	TextView txtQuantity;
	TextView txtPrice;
	public CheckBox getChkProduct() {
		return chkProduct;
	}
	public void setChkProduct(CheckBox chkProduct) {
		this.chkProduct = chkProduct;
	}
	public TextView getTxtName() {
		return txtName;
	}
	public void setTxtName(TextView txtName) {
		this.txtName = txtName;
	}
	public TextView getTxtCode() {
		return txtCode;
	}
	public void setTxtCode(TextView txtCode) {
		this.txtCode = txtCode;
	}
	public TextView getTxtQuantity() {
		return txtQuantity;
	}
	public void setTxtQuantity(TextView txtQuantity) {
		this.txtQuantity = txtQuantity;
	}
	public TextView getTxtPrice() {
		return txtPrice;
	}
	public void setTxtPrice(TextView txtPrice) {
		this.txtPrice = txtPrice;
	}
	
	
	
}
