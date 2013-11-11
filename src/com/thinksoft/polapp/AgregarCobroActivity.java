package com.thinksoft.polapp;

import android.os.Bundle;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.models.databases.PolAppHelper;

public class AgregarCobroActivity extends OrmLiteBaseActivity<PolAppHelper> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cobro);
	}
	
}
