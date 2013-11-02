package com.thinksoft.polapp;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.models.databases.PolAppHelper;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabHost;

public class HomeScreenActivity extends OrmLiteBaseActivity<PolAppHelper> {

	ImageView btnAdd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		btnAdd =(ImageView) findViewById(R.id.imgAgregarProductos);
		Resources res = getResources();
		 
		TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		 
		TabHost.TabSpec spec=tabs.newTabSpec("tabCobros");
		spec.setContent(R.id.tab1);
		spec.setIndicator("",
		    res.getDrawable(R.drawable.cobros32px));
		tabs.addTab(spec);
		 
		spec=tabs.newTabSpec("tabClientes");
		spec.setContent(R.id.tab2);
		spec.setIndicator("",
		    res.getDrawable(R.drawable.peoplegroup32px));
		tabs.addTab(spec);
		
		spec=tabs.newTabSpec("tabProductos");
		spec.setContent(R.id.tab3);
		spec.setIndicator("",
		    res.getDrawable(R.drawable.task24px));
		tabs.addTab(spec);
		
		spec=tabs.newTabSpec("tabFlotilla");
		spec.setContent(R.id.tab4);
		spec.setIndicator("",
		    res.getDrawable(R.drawable.car24px));
		tabs.addTab(spec);
		 
		tabs.setCurrentTab(0);
		
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// custom dialog
				final Dialog dialog = new Dialog(HomeScreenActivity.this);
				dialog.setContentView(R.layout.activity_productos);
				dialog.setTitle("Agregar producto");
	 /*
				// set the custom dialog components - text, image and button
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText("Android custom dialog example!");
				ImageView image = (ImageView) dialog.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);
		**/
	 
				Button dialogButton = (Button) dialog.findViewById(R.id.btnSaveProduct);
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
			  
	}
			});}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}
	

}
