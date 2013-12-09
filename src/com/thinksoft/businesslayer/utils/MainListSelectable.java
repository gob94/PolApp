package com.thinksoft.businesslayer.utils;

import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;

import android.content.Context;
import android.content.Intent;

public interface MainListSelectable {
	public Intent editItem(Context context);
	public Intent viewProfile(Context context);
	public boolean delete(BusinessManager businessLayer);
	
}
