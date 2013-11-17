package com.thinksoft.polapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.models.databases.PolAppHelper;

public class AgregarCobroActivity extends OrmLiteBaseActivity<PolAppHelper> {
	TextView txtClient;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cobro);
		txtClient= (TextView) findViewById(R.id.txtAddOrdenClient);
		
		txtClient.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View vista) {
				txtClient = (TextView) vista;
				Intent intent = new Intent(AgregarCobroActivity.this, ListaClientesActivity.class);
				startActivity(intent);
			}
		});
	}
	
}
