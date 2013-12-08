package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_LICENSE_PLATE;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Vehicle;

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
			txtVehicleLicensePlate = (TextView) findViewById(R.id.lblVehiclePlateProfileEditabled);
			txtVehicleBrand  = (TextView) findViewById(R.id.lblVehicleBrandProfileEditabled);
			txtVehicleCostPerKm  = (TextView) findViewById(R.id.lblVehicleCostPerKmProfileEditabled);
			txtVehicleModel  = (TextView) findViewById(R.id.lblVehicleModelProfileEditabled);
			txtRTV  = (TextView) findViewById(R.id.lblVehicleRTVProfileEditabled);
			txtAvailable  = (TextView) findViewById(R.id.lblVehicleAvailableProfileEditabled);
	
			btnAcceptVehicle  = (Button) findViewById(R.id.btnAcceptVehicleProfile);
			btnEditVehicle  = (Button) findViewById(R.id.btnEditVehicleProfile);
			btnDeleteVehicle  = (Button) findViewById(R.id.btnDeleteVehicleProfile);
			
			Vehicle vehicle = bussinessLayer.getVehicleByLicensePlate(licensePlate);
			
			txtVehicleLicensePlate.setText((CharSequence) vehicle.getLicensePlate());
			txtVehicleBrand.setText((CharSequence) vehicle.getBrand().getBrandName());
			txtVehicleCostPerKm.setText((CharSequence) "0");
			txtVehicleModel.setText((CharSequence) String.valueOf(vehicle.getModel()));
			
			txtRTV.setText((CharSequence)bussinessLayer.getFormatedDate(vehicle.getRtv()));
			String available = vehicle.getFunctional()==true ? "Sí":"No";
			txtAvailable.setText((CharSequence) available);
			
			
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
