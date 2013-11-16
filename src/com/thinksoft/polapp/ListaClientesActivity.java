package com.thinksoft.polapp;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.ClientListViewAdapter;
import com.thinksoft.models.databases.PolAppHelper;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class ListaClientesActivity extends OrmLiteBaseActivity<PolAppHelper> {
	BusinessManager businessLayer;
	public EditText txtSearchClient = null;
	public ClientListViewAdapter adapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_clientes);
		businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
		final ListView listSearchClient = (ListView) findViewById(R.id.lstViewClientSearchList);
		txtSearchClient = (EditText) findViewById(R.id.txtSearchClientListActivity);
		adapter = new ClientListViewAdapter(ListaClientesActivity.this,businessLayer.getAllClients());
		listSearchClient.setAdapter(adapter); 
		
		txtSearchClient.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence string, int start, int before, int count) {
				ListaClientesActivity.this.adapter.getFilter().filter(string);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_clientes, menu);
		return true;
	}

}
