package com.thinksoft.polapp;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.ClientListViewAdapter;
import com.thinksoft.models.databases.PolAppHelper;

public class HomeScreenActivity extends OrmLiteBaseActivity<PolAppHelper> {
	BusinessManager businessLayer;
	ImageView btnAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);

		businessLayer = new BusinessManagerImpl(getHelper()
				.getConnectionSource());
		btnAdd = (ImageView) findViewById(R.id.imgAgregarProductos);

		Resources res = getResources();

		final TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
		tabs.setup();

		TabHost.TabSpec spec = tabs.newTabSpec("tabCobros");
		spec.setContent(R.id.tab1);
		spec.setIndicator("", res.getDrawable(R.drawable.cobros32px));
		tabs.addTab(spec);

		spec = tabs.newTabSpec("tabClientes");
		spec.setContent(R.id.tab2);
		spec.setIndicator("", res.getDrawable(R.drawable.peoplegroup32px));
		tabs.addTab(spec);

		spec = tabs.newTabSpec("tabProductos");
		spec.setContent(R.id.tab3);
		spec.setIndicator("", res.getDrawable(R.drawable.task24px));
		tabs.addTab(spec);

		spec = tabs.newTabSpec("tabFlotilla");
		spec.setContent(R.id.tab4);
		spec.setIndicator("", res.getDrawable(R.drawable.car24px));
		tabs.addTab(spec);

		tabs.setCurrentTab(0);

		btnAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getApplicationContext(),
						ProductosActivity.class);
				startActivity(intent);
			}
		});
		tabs.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {
				try {
					if (tabId.equals("tabClientes")) {
						final ListView listaClientes = (ListView) tabs.findViewById(R.id.lvClientes);
						ClientListViewAdapter adapter = new ClientListViewAdapter(HomeScreenActivity.this,(ArrayList<HashMap<String, String>>) businessLayer.getAllClients());
						listaClientes.setAdapter(adapter);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}

}
