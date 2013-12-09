package com.thinksoft.polapp;

import android.os.Bundle;
import android.view.Menu;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.models.databases.PolAppHelper;

public class EditarProductosActivity extends OrmLiteBaseActivity<PolAppHelper> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_productos);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.editar_productos, menu);
		return true;
	}
 
}
