package com.thinksoft.polapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

public class CheckboxListActivity  extends ListActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box_cobros);
		
		
		CheckBoxListAdapter adapter = new CheckBoxListAdapter(getLayoutInflater());
 
		getListView().setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view_cobros, menu);
		return true;
	}

}
