package com.thinksoft.businesslayer.utils;

import com.thinksoft.polapp.EditarCobroActivity;
import com.thinksoft.polapp.PerfilCobros;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_ORDERID;

public class OrderViewHolder implements MainListSelectable{
	
	TextView orderId;
	TextView clientName;
	TextView actualBalance;
	TextView nextPaymentDate;
	
	
	@Override
	public Intent viewProfile(Context context) {
		Bundle extras = new Bundle();
		extras.putInt(COLUMN_ORDERID, Integer.valueOf(orderId.getText().toString()));
		Intent intent = new Intent(context, PerfilCobros.class);
		intent.putExtras(extras);
		return intent;
	}


	@Override
	public Intent editItem(Context context) {
		Bundle extras = new Bundle();
		extras.putInt(COLUMN_ORDERID, Integer.valueOf(orderId.getText().toString()));
		Intent intent = new Intent(context, EditarCobroActivity.class);
		intent.putExtras(extras);
		return intent;
	}


	@Override
	public Intent delete(Context context) {
		return null;
	}

	
	
	
	
}
