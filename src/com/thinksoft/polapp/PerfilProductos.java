package com.thinksoft.polapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PerfilProductos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_productos);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.perfil_productos, menu);
		return true;
	}

}