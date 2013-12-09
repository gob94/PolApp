package com.thinksoft.polapp;

import java.util.ArrayList;
import java.util.Map;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.SupportMapFragment;

public class MapView extends FragmentActivity {

	GoogleMap googleMap;
	public static int CLIENT_MAP= 120;
	public Intent intent;
	 public double zoom;
	 public double longi;
	 public double lat;
	 private String name = "";
	 private String firstName = "";
	 public Bundle bundle_data;
	 ArrayList<LatLng> MarkerPoint;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_view);
		googleMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2)).getMap();
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.setMyLocationEnabled(true);
		
		intent = getIntent();
		name = intent.getStringExtra("NAME");
		firstName = intent.getStringExtra("FIRSTNAME");
		zoom= intent.getDoubleExtra("ZOOM", 0);
		longi= intent.getDoubleExtra("LONGITUDE", 0);
		lat = intent.getDoubleExtra("LATITUDE", 0);
		//zoom= intent.getExtras().getDouble("ZOOM");
		//longi= intent.getExtras().getDouble("LONGITUDE");
		//lat= intent.getExtras().getDouble("LATITUDE");
		
		LatLng point = new LatLng(lat, longi);
		
		drawMarker(point);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map_view, menu);
		return true;
	}
	
	private void drawMarker(LatLng point) {
		
		// Creating an instance of MarkerOptions
		MarkerOptions markerOptions = new MarkerOptions();

		// Setting latitude and longitude for the marker
		markerOptions.position(point);
		        
		// Adding marker on the Google Map
		googleMap.addMarker(markerOptions).setTitle(name+" "+firstName);
		googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(point.latitude, point.longitude), 14.0f));
		
	}
	}

	

