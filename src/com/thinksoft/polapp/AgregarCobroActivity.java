package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.Constants.PRODUCTS_IDS_KEY;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.CLIENT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;

public class AgregarCobroActivity extends OrmLiteBaseActivity<PolAppHelper> {
	EditText txtClient;
	EditText txtTotal;
	TextView lblProductos;
	List<Integer> products_ids;
	BusinessManager businessLayer;
	
	public static int CLIENT_LIST_CODE = 100;
	public static int PRODUCT_LIST_CODE = 105;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar_cobro);
		products_ids = new ArrayList<Integer>();
		txtClient= (EditText) findViewById(R.id.txtClientAddOrder);
		txtTotal= (EditText) findViewById(R.id.txtTotalAddOrder);
		lblProductos = (TextView) findViewById(R.id.lblProductsAddOrder);
		businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
		
		
		txtClient.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View vista) {
				Intent intent = new Intent(AgregarCobroActivity.this, ListaClientesActivity.class);
				
				startActivityForResult(intent, CLIENT_LIST_CODE);
			}
		});
		
		lblProductos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Bundle bundle = new Bundle();
				Intent intent = new Intent(AgregarCobroActivity.this, ListaProductosActivity.class);
				if(products_ids.size()>0){
					bundle.putIntegerArrayList(PRODUCTS_IDS_KEY, (ArrayList<Integer>) products_ids);
					intent.putExtras(bundle);
				}
				startActivityForResult(intent, PRODUCT_LIST_CODE);
			}
		});
	
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==CLIENT_LIST_CODE){
			if(resultCode==Activity.RESULT_OK){
				Bundle bundle = data.getExtras();
				if(bundle!=null){
					txtClient.setText(bundle.getString(NAME_COLUMN));
					txtClient.setTag(bundle.getInt(CLIENT_ID_COLUMN));
				}
			}
		}else if(requestCode==PRODUCT_LIST_CODE){
			if(resultCode==Activity.RESULT_OK){
				Bundle bundle = data.getExtras();
				if(bundle!=null){
					products_ids = bundle.getIntegerArrayList(PRODUCTS_IDS_KEY);
					txtTotal.setText(String.valueOf(setTotal(products_ids)));
				}
			}
		}
	}

	
	public double setTotal(List<Integer> ids){
		double total=0;
		for (Integer id : ids) {
			total = total+businessLayer.getProductPrice(id);
		}
		return total;
		
	}
}
