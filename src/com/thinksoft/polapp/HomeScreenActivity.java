package com.thinksoft.polapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.ClientListViewAdapter;
import com.thinksoft.businesslayer.utils.FleetListViewAdapter;
import com.thinksoft.businesslayer.utils.ProductListViewAdapter;
import com.thinksoft.models.databases.PolAppHelper;

public class HomeScreenActivity extends OrmLiteBaseActivity<PolAppHelper> {
	
	BusinessManager businessLayer;
	ImageView btnAddProduct;
	ImageView btnAddClient;
	ImageView btnAddFlotilla;
	ImageView btnAddCobro;
	SlidingMenu menu;
	ImageView btnSlidingVehicle;
	ImageView btnSlidingProduct;
	ImageView btnSlidingClient;
	ImageView btnSlidingHome;
	RelativeLayout layHome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		businessLayer = new BusinessManagerImpl(getHelper()
				.getConnectionSource());
		btnAddProduct = (ImageView) findViewById(R.id.imgAgregarProductos);
		btnAddClient = (ImageView) findViewById(R.id.imgAgregarClientes);
		btnAddFlotilla = (ImageView) findViewById(R.id.imgAgregarFlotilla);
		btnAddCobro = (ImageView) findViewById(R.id.imgAgregarCobros);
		/**
		btnSlidingVehicle = (ImageView)findViewById(R.id.btnSlidingVehicle);
		btnSlidingProduct =(ImageView)findViewById(R.id.btnSlidingProducts);
		btnSlidingClient =(ImageView)findViewById(R.id.btnSlidingClient);
		btnSlidingHome =(ImageView)findViewById(R.id.btnSlidingHome);
**/
		Resources res = getResources();
		
		Display display = getWindowManager().getDefaultDisplay();
		@SuppressWarnings("deprecation")
		int width = display.getWidth();
		
	    menu = new SlidingMenu(this);
	    menu.setMode(SlidingMenu.RIGHT);
	    menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
	   
	    menu.setShadowWidth(20);
	    menu.setBehindOffset(30);
	    menu.setFadeDegree(0.25f);
	    menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
	    menu.setBehindWidth(width-60);
	    menu.setMenu(R.layout.menulateral);
	    //menu.showMenu(false);

		final TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
		tabs.setup();

		TabHost.TabSpec spec = tabs.newTabSpec("tabCobros");
		spec.setContent(R.id.tab3);
		spec.setIndicator("", res.getDrawable(R.drawable.cobros32px));
		tabs.addTab(spec);

		spec = tabs.newTabSpec("tabClientes");
		spec.setContent(R.id.tab2);
		spec.setIndicator("", res.getDrawable(R.drawable.peoplegroup32px));
		tabs.addTab(spec);
		
		spec = tabs.newTabSpec("tabProductos");
		spec.setContent(R.id.tab1);
		spec.setIndicator("", res.getDrawable(R.drawable.productprincipal));
		tabs.addTab(spec);

		spec = tabs.newTabSpec("tabFlotilla");
		spec.setContent(R.id.tab4);
		spec.setIndicator("", res.getDrawable(R.drawable.carprincipal));
		tabs.addTab(spec);

		tabs.setCurrentTab(0);
				
		final ListView listaProductos = (ListView) tabs.findViewById(R.id.lvProductos);

		final ListView listaClientes = (ListView) tabs.findViewById(R.id.lvClientes);
		
		final ListView listaVehiculos = (ListView) tabs.findViewById(R.id.lvFlotillas);

		View clientHeader= getLayoutInflater().inflate(R.layout.client_header, null);
		listaClientes.addHeaderView(clientHeader);
		
		View productHeader= getLayoutInflater().inflate(R.layout.product_list_header, null);
		listaProductos.addHeaderView(productHeader);
		View vehiclesHeader= getLayoutInflater().inflate(R.layout.fleet_list_header, null);
		listaVehiculos.addHeaderView(vehiclesHeader);
		
		ClientListViewAdapter adapter = new ClientListViewAdapter(HomeScreenActivity.this,businessLayer.getAllClients());
		listaClientes.setAdapter(adapter);
		ProductListViewAdapter adapter2 = new ProductListViewAdapter(HomeScreenActivity.this, businessLayer.getAllProducts());
		listaProductos.setAdapter(adapter2);
		
		registerForContextMenu(listaVehiculos);
		registerForContextMenu(listaProductos);
		registerForContextMenu(listaClientes);
		

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
						AgregarClienteActivity.class);
				startActivity(intent);
			}
		});
		
		btnAddCobro.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),AgregarCobroActivity.class);
				startActivity(intent);
			}
		});
		
		btnAddFlotilla.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(getApplicationContext(), AgregarVehiculo.class);
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
						listaClientes.setDivider(new ColorDrawable(0x045FB4));

					} else if (tabId.equals("tabProductos")) {
						ProductListViewAdapter adapter = new ProductListViewAdapter(HomeScreenActivity.this, businessLayer.getAllProducts());
						listaProductos.setAdapter(adapter);
						listaClientes.setDivider(new ColorDrawable(0xB40431));
						
					} else if (tabId.equals("tabFlotilla")) {
						FleetListViewAdapter adapter = new FleetListViewAdapter(HomeScreenActivity.this, businessLayer.getAllVehicles());
						listaVehiculos.setAdapter(adapter);
						listaClientes.setDivider(new ColorDrawable(0x008B00));
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		listaProductos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View view,
					int pos, long arg3) {
					
		        registerForContextMenu(listaProductos);
					return false;
			}
			});		
		
	
		listaClientes.setOnItemLongClickListener(new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View view,
				int pos, long arg3) {
				
	        registerForContextMenu(listaClientes);
				return false;
			}
			});		
		Log.i("error", String.valueOf(listaVehiculos));
		
	listaVehiculos.setOnItemLongClickListener(new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View view,
				int pos, long arg3) {
	        registerForContextMenu(listaVehiculos);
				return false;
		}
		});	
	/**
	btnSlidingHome.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				menu.toggle(false);
			}
		});

		btnSlidingProduct.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						HomeProductos.class);
				startActivity(intent);
			}
		});

		btnSlidingClient.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						HomeClientes.class);
				startActivity(intent);
			}
		});

		btnSlidingVehicle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						HomeVehiculos.class);
				startActivity(intent);
			}
		});
		

		layHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				menu.toggle(false);
			}
		});
		**/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu1) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		getMenuInflater().inflate(R.menu.home_screen, menu1);
		return true;

	}
	
	 @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
     {
             super.onCreateContextMenu(menu, v, menuInfo);
             menu.add(0, v.getId(), 0, "Ver información");
             menu.add(0, v.getId(), 0, "Editar"); 
             menu.add(0, v.getId(), 0, "Eliminar");

     } 
	 	    
	 
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);		
        tabs.setup();
        
        if(item.getTitle().toString()=="Editar"){
        	if(tabs.getCurrentTab()==2){
	    		Intent intent = new Intent(HomeScreenActivity.this, EditarProductosActivity.class);
	    		startActivity(intent);
	    	}else if(tabs.getCurrentTab()== 1){
	    		Intent intent = new Intent(HomeScreenActivity.this, EditarClienteActivity.class);
	    		startActivity(intent);
	    	}else if(tabs.getCurrentTab()== 0){
	    		Intent intent = new Intent(HomeScreenActivity.this, EditarCobroActivity.class);
	    		startActivity(intent);
	    	} else if(tabs.getCurrentTab()==3){
	    		Intent intent = new Intent(HomeScreenActivity.this, EditarVehiculo.class);
	    		startActivity(intent);
	    	}
	    	return true;
        }

	 /**   switch (item.getItemId()) {
	    case R.id.MenuHomeScreenEditar:
	    	if(tabs.getCurrentTab()== R.id.tab1){
	    		Intent intent = new Intent(HomeScreenActivity.this, EditarProductosActivity.class);
	    		startActivity(intent);
	    	}else if(tabs.getCurrentTab()== R.id.tab2){
	    		Intent intent = new Intent(HomeScreenActivity.this, EditarClienteActivity.class);
	    		startActivity(intent);
	    	}else if(tabs.getCurrentTab()== R.id.tab3){
	    		Intent intent = new Intent(HomeScreenActivity.this, EditarCobroActivity.class);
	    		startActivity(intent);
	    	} else if(tabs.getCurrentTab()== R.id.tab4){
	    		Intent intent = new Intent(HomeScreenActivity.this, EditarVehiculo.class);
	    		startActivity(intent);
	    	}
	    	return true;
	    	  
	    case R.id.MenuHomeScreenEliminar:
	        Toast.makeText(getApplicationContext(), "Has pulsado la opción Eliminar", Toast.LENGTH_LONG).show();	
	        return true;
	    }**/
	    return super.onOptionsItemSelected(item);
	    
	}
	
	@Override
	public void onBackPressed() {
		if(menu.isMenuShowing()){menu.toggle();}
		else {finish();}
		
	}
	

@Override
public boolean onOptionsItemSelected(MenuItem item) {

    switch(item.getItemId())
    {
    case R.id.MenuSlidingBar:
    	
    	if(menu.isMenuShowing() == true){
    		menu.toggle(false);
    	}else{
    		menu.toggle(true);
    	}
    	        return true;
    case R.id.SlidingHomeLayout:
    	menu.toggle(false);
    	return true;
    	
    case R.id.SlidingClientLayout:
    	Intent intent = new Intent(getApplicationContext(), HomeClientes.class);
    	startActivity(intent);
    }
    return super.onOptionsItemSelected(item);
}
	

@Override
public void registerForContextMenu(View view) {
	// TODO Auto-generated method stub
	super.registerForContextMenu(view);
}

public void slidingClientMenu(){
	Intent intent = new Intent(getApplicationContext(), HomeClientes.class);
	startActivity(intent);
	
}

}


