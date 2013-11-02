package com.thinksoft.polapp;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.models.databases.PolAppHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.TabHost;

public class HomeScreenActivity extends OrmLiteBaseActivity<PolAppHelper> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		
		Resources res = getResources();
		 
		TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		 
		TabHost.TabSpec spec=tabs.newTabSpec("tabCobros");
		spec.setContent(R.id.tab1);
		spec.setIndicator("",
		    res.getDrawable(R.drawable.cobros32px));
		tabs.addTab(spec);
		 
		spec=tabs.newTabSpec("tabClientes");
		spec.setContent(R.id.tab2);
		spec.setIndicator("",
		    res.getDrawable(R.drawable.peoplegroup32px));
		tabs.addTab(spec);
		
		spec=tabs.newTabSpec("tabProductos");
		spec.setContent(R.id.tab3);
		spec.setIndicator("",
		    res.getDrawable(R.drawable.task24px));
		tabs.addTab(spec);
		
		spec=tabs.newTabSpec("tabFlotilla");
		spec.setContent(R.id.tab4);
		spec.setIndicator("",
		    res.getDrawable(R.drawable.car24px));
		tabs.addTab(spec);
		 
		tabs.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}

}
