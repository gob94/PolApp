package com.thinksoft.polapp;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.impl.ProductImpl;
import com.thinksoft.polapp.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ProductosActivity extends OrmLiteBaseActivity<PolAppHelper> {

	private BusinessManager bussinesManager;
	private final static int ZERO= 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		bussinesManager = new BusinessManagerImpl(getHelper().getConnectionSource());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productos);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.productos, menu);
		return true;
	}
	
	public boolean createProduct(int idProduct, String code, String name, float quantity, float price ){
		boolean var= false;
		Product product = new ProductImpl();
		
		if(idProduct < ZERO || code!= null || name!= null || quantity < ZERO || price < ZERO ){
			
			product.setIdProduct(idProduct);
			product.setName(name);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setCode(code);
			
			var= true;
		}else{
			var= false;
		}
		return var;
	}

}
