package com.thinksoft.businesslayer.utils;

import android.content.Context;
import android.content.Intent;

public interface MainListSelectable {
	public Intent editItem(Context context);
	public Intent delete(Context context);
	public Intent viewProfile(Context context);
	
}
