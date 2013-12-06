package com.thinksoft.businesslayer.utils;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_CLIENTID;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.thinksoft.polapp.EditarClienteActivity;
import com.thinksoft.polapp.PerfilClienteActivity;

public class ClientViewHolder  implements MainListSelectable{
	public int clientId=0;
	public TextView txtName;
	public TextView txtFirstLastName;
	public TextView txtSecondLastName;
	public ImageView txtStatus;
	
	
	@Override
	public Intent editItem(Context context) {
		Bundle extras = new Bundle();
		extras.putInt(COLUMN_CLIENTID, clientId);
		Intent intent = new Intent(context, EditarClienteActivity.class);
		intent.putExtras(extras);
		return intent;
		
	}
	@Override
	public Intent delete(Context context) {
		return null;
	}
	@Override
	public Intent viewProfile(Context context) {
		Bundle extras = new Bundle();
		extras.putInt(COLUMN_CLIENTID, clientId);
		Intent intent = new Intent(context, PerfilClienteActivity.class);
		intent.putExtras(extras);
		
		return intent;
	}
}
