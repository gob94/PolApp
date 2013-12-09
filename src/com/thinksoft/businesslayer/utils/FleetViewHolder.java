package com.thinksoft.businesslayer.utils;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_LICENSE_PLATE;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.polapp.EditarVehiculoActivity;
import com.thinksoft.polapp.PerfilVehiculo;

public class FleetViewHolder implements MainListSelectable {
	

		TextView txtLicence;
		ImageView txtFunctional;
		TextView txtRtv;
		TextView txtModel;
		TextView txtBrand;
		
		
		@Override
		public Intent viewProfile(Context context) {
			Bundle extras = new Bundle();
			extras.putString(COLUMN_LICENSE_PLATE, txtLicence.getText().toString());
			Intent intent = new Intent(context, PerfilVehiculo.class);
			intent.putExtras(extras);
			return intent;
		}


		@Override
		public Intent editItem(Context context) {
			Bundle extras = new Bundle();
			extras.putString(COLUMN_LICENSE_PLATE, txtLicence.getText().toString());
			Intent intent = new Intent(context, EditarVehiculoActivity.class);
			intent.putExtras(extras);
			return intent;
		}


		@Override
		public boolean delete(BusinessManager businessLayer) {
			// TODO Auto-generated method stub
			return false;
		}


}
