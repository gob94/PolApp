package com.thinksoft.polapp;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.models.databases.PolAppHelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ListaClientesActivity extends OrmLiteBaseActivity<PolAppHelper> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_clientes);
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_clientes, menu);
		return true;
	}

}
