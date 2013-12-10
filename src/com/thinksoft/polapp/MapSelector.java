package com.thinksoft.polapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;

public class MapSelector extends FragmentActivity implements Parcelable {

	GoogleMap googleMap;
	Button btnSaveMap;
	BusinessManager bussinessLayer;
	public static int CLIENT_INFO = 1;
	public static Bundle bundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_selector);
		PolAppHelper p = new PolAppHelper(getApplicationContext());
		bussinessLayer = new BusinessManagerImpl(p.getConnectionSource());
		
		bundle= new Bundle();

		googleMap = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();

		if (googleMap != null) {
			googleMap.setOnMapLongClickListener(new OnMapLongClickListener() {
				public void onMapLongClick(final LatLng point) {
					//drawMarker(point);
					
					if(point!= null){
					Log.i("LONGITUDE", String.valueOf(point.longitude));
					Log.i("LATITUDE", String.valueOf(point.latitude));
					Log.i("ZOOM", String.valueOf(googleMap.getCameraPosition().zoom));
					
					bundle.putDouble("LATITUDE", point.latitude);
					bundle.putDouble("LONGITUDE", point.longitude);			
					bundle.putDouble("ZOOM", googleMap.getCameraPosition().zoom);

					getIntent().putExtras(bundle);
					setResult(Activity.RESULT_OK, getIntent());
					finish();
					}else{
						Toast.makeText(getApplicationContext(), "Estas mamando", Toast.LENGTH_LONG).show();
					}
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



	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CLIENT_INFO) {
			if (resultCode == Activity.RESULT_OK) {
				Bundle extras = data.getExtras();
				if (extras != null) {
					bundle = extras;
				}
			}
		}
	}

}
