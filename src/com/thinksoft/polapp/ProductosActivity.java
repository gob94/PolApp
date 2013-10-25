package com.thinksoft.polapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ProductosActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productos);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.productos, menu);
		return true;
	}

}
