package com.thinksoft.polapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class EditarCobroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_cobro);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.editar_cobro, menu);
		return true;
	}

}
