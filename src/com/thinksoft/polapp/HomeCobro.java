package com.thinksoft.polapp;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class HomeCobro extends Activity {

	SlidingMenu menu;
	ImageView btnSlidingVehicle;
	ImageView btnSlidingProduct;
	ImageView btnSlidingClient;
	ImageView btnSlidingHome;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_cobro);
		
		btnSlidingVehicle = (ImageView)findViewById(R.id.btnSlidingVehicle);
		btnSlidingProduct =(ImageView)findViewById(R.id.btnSlidingProducts);
		btnSlidingClient =(ImageView)findViewById(R.id.btnSlidingClient);
		btnSlidingHome =(ImageView)findViewById(R.id.btnSlidingHome);
		
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

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_cobro, menu);
		return true;
	}

	
	public View onCreateView1(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.menulateral, container, false);

	    view.findViewById(R.id.LayoutListBillsHome).setOnClickListener((OnClickListener) this);
	    view.findViewById(R.id.LayoutAddBillsHome).setOnClickListener((OnClickListener) this);
	    view.findViewById(R.id.LayoutSearchBillsHome).setOnClickListener((OnClickListener) this);
		return view;
	}
	
	public void onClick1(View v) {
	    switch (v.getId()){
	        case R.id.LayoutListBillsHome:
	        	
	            break;
	        case R.id.LayoutAddBillsHome:
	        	Intent intentV = new Intent(getApplicationContext(), AgregarCobroActivity.class);
	            startActivity(intentV);

	            break;
	        case R.id.LayoutSearchBillsHome:
	        	Intent intentC = new Intent(getApplicationContext(), ListaProductosActivity.class);
	            startActivity(intentC);
	            break;
	    }
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
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.menulateral, container, false);

    view.findViewById(R.id.SlidingHomeLayout).setOnClickListener((OnClickListener) this);
    view.findViewById(R.id.SlidingProductsLayout).setOnClickListener((OnClickListener) this);
    view.findViewById(R.id.SlidingVehicleLayout).setOnClickListener((OnClickListener) this);
    view.findViewById(R.id.SlidingClientLayout).setOnClickListener((OnClickListener) this);
	return view;
}

public void onClick(View v) {
    switch (v.getId()){
        case R.id.SlidingHomeLayout:
        	menu.toggle(false);
            break;
        case R.id.SlidingProductsLayout:
            Intent intent = new Intent(getApplicationContext(), HomeProductos.class);
            startActivity(intent);

            break;
        case R.id.SlidingVehicleLayout:
        	Intent intentV = new Intent(getApplicationContext(), HomeVehiculos.class);
            startActivity(intentV);

            break;
        case R.id.SlidingClientLayout:
        	Intent intentC = new Intent(getApplicationContext(), HomeClientes.class);
            startActivity(intentC);
            break;
    }
}
}
