package com.thinksoft.polapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class HomeClientes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_clientes);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_clientes, menu);
		return true;
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.menulateral, container, false);

	    view.findViewById(R.id.layoutHomeClientList).setOnClickListener((OnClickListener) this);
	    view.findViewById(R.id.layoutHomeClientAdd).setOnClickListener((OnClickListener) this);
	    view.findViewById(R.id.layoutHomeClientSearch).setOnClickListener((OnClickListener) this);
		return view;
	}
	
	public void onClick(View v) {
	    switch (v.getId()){
	        case R.id.layoutHomeClientList:
	        	
	            break;
	        case R.id.layoutHomeClientAdd:
	        	Intent intentV = new Intent(getApplicationContext(), AgregarClienteActivity.class);
	            startActivity(intentV);

	            break;
	        case R.id.layoutHomeClientSearch:
	        	Intent intentC = new Intent(getApplicationContext(), ListaClientesActivity.class);
	            startActivity(intentC);
	            break;
	    }
	}

}
