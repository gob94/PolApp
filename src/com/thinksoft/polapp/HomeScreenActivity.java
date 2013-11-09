package com.thinksoft.polapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.ClientListViewAdapter;
import com.thinksoft.businesslayer.utils.ProductListViewAdapter;
import com.thinksoft.models.databases.PolAppHelper;

public class HomeScreenActivity extends OrmLiteBaseActivity<PolAppHelper> {
	BusinessManager businessLayer;
	ImageView btnAddProduct;
	ImageView btnAddClient;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);

		businessLayer = new BusinessManagerImpl(getHelper()
				.getConnectionSource());
		btnAddProduct = (ImageView) findViewById(R.id.imgAgregarProductos);
		btnAddClient = (ImageView) findViewById(R.id.imgAgregarClientes);
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
		
		
		
		final ListView listaProductos = (ListView) tabs.findViewById(R.id.lvProductos);
		ProductListViewAdapter adapter = new ProductListViewAdapter(HomeScreenActivity.this, businessLayer.getAllProducts());
		listaProductos.setAdapter(adapter);
		final ListView listaClientes = (ListView) tabs.findViewById(R.id.lvClientes);
		View header= getLayoutInflater().inflate(R.layout.client_header, null);
		listaClientes.addHeaderView(header);
		


		btnAddProduct.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getApplicationContext(),
						ProductosActivity.class);
				startActivity(intent);
			}
		});
		btnAddClient.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getApplicationContext(),
						ClienteActivity.class);
				startActivity(intent);
			}
		});
		tabs.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {
				try {
					if (tabId.equals("tabClientes")) {
						ClientListViewAdapter adapter = new ClientListViewAdapter(HomeScreenActivity.this,businessLayer.getAllClients());
						listaClientes.setAdapter(adapter);

					} else if (tabId.equals("tabProductos")) {
						final ListView listaProductos = (ListView) tabs.findViewById(R.id.lvProductos);
						ProductListViewAdapter adapter = new ProductListViewAdapter(HomeScreenActivity.this, businessLayer.getAllProducts());
						listaProductos.setAdapter(adapter);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		/*
		listaProductos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View view,
					int pos, long arg3) {
				
		        registerForContextMenu(view);
		        openContextMenu( view );
		        unregisterForContextMenu(view);
		       /** final Dialog dialog = new Dialog(HomeScreenActivity.this);
				dialog.setContentView(R.layout.product_popup_window);
				TextView dialogButton = (TextView) dialog.findViewById(R.id.lblEliminarProductoPopUp);
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();**/
				/*return true;
			}
			
		});		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
	    super.onCreateContextMenu(menu, v, menuInfo);
	  /*  TextView lblEliminarPopUp = (TextView) findViewById(R.id.lblEliminarProductoPopUp);
	    registerForContextMenu(lblEliminarPopUp);
	    
	    TextView lblEditarPopUp = (TextView) findViewById(R.id.lblEditProductPopUp);
	    registerForContextMenu(lblEditarPopUp);
	    
	    if(v.getId()==R.id.lblEliminarProductoPopUp)
	        getMenuInflater().inflate(R.menu.home_screen, menu);
	    
	    if(v.getId()==R.id.lblEditProductPopUp)
	        getMenuInflater().inflate(R.menu.home_screen, menu);
	    
	    
	    */
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	 
	    switch (item.getItemId()) {
	    case R.id.MenuHomeScreenEditar:
	        Toast.makeText(getApplicationContext(), "Has pulsado la opción Editar", Toast.LENGTH_SHORT).show();
	        return true;
	    case R.id.MenuHomeScreenEliminar:
	        Toast.makeText(getApplicationContext(), "Has pulsado la opción Eliminar", Toast.LENGTH_SHORT).show();
	        return true;
	    
	    default:
	        return super.onContextItemSelected(item);
	    }
	}
	
}


