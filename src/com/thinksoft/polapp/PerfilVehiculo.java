package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_LICENSE_PLATE;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.Vehicle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilVehiculo extends OrmLiteBaseActivity<PolAppHelper> {
	TextView txtVehicleLicensePlate;
	TextView txtVehicleBrand;
	TextView txtVehicleCostPerKm;
	TextView txtVehicleModel;
	TextView txtRTV;
	TextView txtAvailable;

	Button btnAcceptVehicle;
	Button btnEditVehicle;
	Button btnDeleteVehicle;
	BusinessManager bussinessLayer;
	
	static String UNABLE_TO_SHOW = "Unable to show Item, check it's not deleted or modified";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_vehiculo);
		
		Bundle extras = getIntent().getExtras();
		
		if(extras!=null){
			final String licensePlate = extras.getString(COLUMN_LICENSE_PLATE);
			bussinessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
			txtVehicleLicensePlate = (TextView) findViewById(R.id.lblClientNameProfileEditabled);
			txtVehicleBrand  = (TextView) findViewById(R.id.lblClientLastNameProfileEditabled);
			txtVehicleCostPerKm  = (TextView) findViewById(R.id.lblClientPhoneProfileEditabled);
			txtVehicleModel  = (TextView) findViewById(R.id.lblClientDirectionProfileEditabled);
			txtRTV  = (TextView) findViewById(R.id.lblClientDirectionProfileEditabled);
			txtAvailable  = (TextView) findViewById(R.id.lblClientDirectionProfileEditabled);
	
			btnAcceptVehicle  = (Button) findViewById(R.id.btnAcceptClientProfile);
			btnEditVehicle  = (Button) findViewById(R.id.btnEditClientProfile);
			btnDeleteVehicle  = (Button) findViewById(R.id.btnDeleteClientProfile);
			
			Vehicle vehicle = bussinessLayer.getVehicleByLicensePlate(licensePlate);
			
			txtVehicleLicensePlate.setText((CharSequence) vehicle.getLicensePlate());
			txtVehicleBrand.setText((CharSequence) vehicle.getBrand().getBrandName());
			txtVehicleCostPerKm.setText((CharSequence) "0");
			txtVehicleModel.setText((CharSequence) String.valueOf(vehicle.getModel()));
			txtRTV.setText((CharSequence) String.valueOf(vehicle.getRtv()));
			txtAvailable.setText((CharSequence) String.valueOf(vehicle.getFunctional()));
			
			
			btnAcceptVehicle.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					sentToHome();
				}
			});
			
			btnEditVehicle.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Bundle extras = new Bundle();
					extras.putString(COLUMN_LICENSE_PLATE, licensePlate);
					Intent intent = new Intent(PerfilVehiculo.this, EditarProductosActivity.class);
					startActivity(intent);
				}
			});
			
			btnDeleteVehicle.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					sentToHome();
				}
			});
		}else{
			Toast toast = Toast.makeText(PerfilVehiculo.this, UNABLE_TO_SHOW, Toast.LENGTH_LONG);
			toast.show();
			sentToHome();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.perfil_vehiculo, menu);
		return true;
	}
	
	public void sentToHome(){
		Intent intent = new Intent(PerfilVehiculo.this, HomeScreenActivity.class);
		startActivity(intent);
	}

}
