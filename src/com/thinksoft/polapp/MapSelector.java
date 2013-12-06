package com.thinksoft.polapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;

public class MapSelector extends FragmentActivity implements Parcelable{

	   GoogleMap googleMap;
	   Button btnSaveMap;
	   BusinessManager bussinessLayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_selector);
		PolAppHelper p = new PolAppHelper(getApplicationContext());
		bussinessLayer= new BusinessManagerImpl(p.getConnectionSource());
		
		googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
	            .getMap();

	        if (googleMap!=null){
	        	 googleMap.setOnMapLongClickListener(new OnMapLongClickListener() {
	                 public void onMapLongClick(final LatLng point) {
	                	 drawMarker(point);
	                	 
	             	   	Intent intentV = new Intent(getApplicationContext(), AgregarClienteActivity.class);
	             	   	Bundle b;
	             	   	intentV.putExtra("Location", (LatLng)point);
	             	   	intentV.putExtra("Zoom", googleMap.getCameraPosition().zoom);
	             	   	//intentV.putExtra("latitude", point.latitude);
	             	   	//intentV.putExtra("longititude", point.longitude);
	             	   	//intentV.putExtra("zoom", googleMap.getCameraPosition().zoom);
	    	            startActivity(intentV);
	                    /** 	
							Address ad= new AddressImpl();
							ClientImpl cl= new ClientImpl();
							Intent i= getIntent();
							Bundle b= i.getExtras();
							String name= b.get("name").toString();
							String lastName1= b.getString("lastName1").toString();
							String lastName2= b.getString("lastName2").toString();
							int phone= Integer.parseInt(b.getString("phone"));
							
							cl.setName(name);
							cl.setFirstLastName(lastName1);
							cl.setSecondLastName(lastName2);
							cl.setAccountState(false);
															
							ad.setActive(true);
							ad.setClient(cl);
							
							ad.setLatitude(point.latitude);
							ad.setLonguitude(point.longitude);
							ad.setZoom(googleMap.getCameraPosition().zoom);
							ad.setPhoneNumber(phone);
	
							result= bussinessLayer.addAddress(ad);

							if(result == true){
							Toast.makeText(getApplicationContext(), "Dirección agregada con éxito", Toast.LENGTH_LONG).show();
							}else{
								Toast.makeText(getApplicationContext(), "Por favor verifique sus datos", Toast.LENGTH_LONG).show();

							}**/
	                 }
	             });
	        	 
	        	
	        }

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map_selector, menu);
		return true;
	}
	
	 private void drawMarker(LatLng point){
	        // Creating an instance of MarkerOptions
	        MarkerOptions markerOptions = new MarkerOptions();
	 
	        // Setting latitude and longitude for the marker
	        markerOptions.position(point);
	 
	        // Adding marker on the Google Map
	        googleMap.addMarker(markerOptions);
	    }

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}


}
