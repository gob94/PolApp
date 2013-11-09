package com.thinksoft.polapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.ForeignCollection;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Address;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.impl.AddressImpl;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ClienteActivity extends OrmLiteBaseActivity<PolAppHelper> {
	 BusinessManager businessLayer;
     EditText txtName;
     EditText txtLastName;
     EditText txtPhone;
     ListView productList;
     Button btnAddClient;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cliente);
		businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
	    txtName = (EditText) findViewById(R.id.txtNombreClient);
	    txtLastName = (EditText) findViewById(R.id.txtApellidoCliente);
	    txtPhone = (EditText) findViewById(R.id.txtTelefonoCliente);
	    productList = (ListView) findViewById(R.id.lstVProductosCliente);
	    btnAddClient = (Button) findViewById(R.id.btnAgregarCliente);
	    
	    int clientId = savedInstanceState.getInt("clientId");
	    
	    if(clientId!= 0){
	    	Client client = businessLayer.getClientById(clientId);
	    	txtName.setText(client.getName());
	    	txtLastName.setText(client.getFirstLastName()+client.getSecondLastName());
	    	txtPhone.setText(businessLayer.getClientPhoneNumber(clientId));
	    	List<Map<String, String>> productos = businessLayer.getClientProducts(clientId);
	    }
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.agregar_clientes, menu);
		return true;
	}
 
}
