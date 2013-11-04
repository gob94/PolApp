package com.thinksoft.polapp;

import android.app.ListActivity;
import android.os.Bundle;

public class CheckBoxListClient extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box_cobros);
		
		
		CheckBoxListAdapterClient adapter = new CheckBoxListAdapterClient(getLayoutInflater());
 
		getListView().setAdapter(adapter);
	}

}
