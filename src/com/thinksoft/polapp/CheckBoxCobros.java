package com.thinksoft.polapp;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CheckBoxCobros extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box_cobros);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.check_box_cobros, menu);
		return true;
	}

}
