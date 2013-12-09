package com.thinksoft.polapp;

import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;

public class EditarCobroActivity extends Activity {

	EditText txtClient;
	EditText txtTotal;
	TextView lblProductos;
	Button btnSave;
	Map<Integer,Integer> products_ids;
	BusinessManager businessLayer;
	Spinner spnPayment;
	static String MESSAGE_ERROR="No existe";
	static String MESSAGE_SUCCESSFUL="Agregado exitosamente";
	static String MESSAGE_MISSING_FIELDS="Debe de elegir un cliente";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_cobro);
		
		txtClient = (EditText) findViewById(R.id.lblEditClientAddOrder);
		txtTotal = (EditText) findViewById(R.id.lblEditTotalAddOrder);
		lblProductos = (TextView) findViewById(R.id.lblEditProductsAddOrder);
		spnPayment = (Spinner) findViewById(R.id.spnEditPaymentModeAddOrder);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.editar_cobro, menu);
		return true;
	}

	
	
	
}
