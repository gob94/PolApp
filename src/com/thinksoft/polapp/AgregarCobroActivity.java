package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.Constants.PRODUCTS_IDS_KEY;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.CLIENT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.Constants.CLIENT_LIST_CODE;

import static com.thinksoft.businesslayer.utils.constants.Constants.PAYMENT_ID;

import static com.thinksoft.businesslayer.utils.constants.Constants.PAYMENT_NAME;
import static com.thinksoft.businesslayer.utils.constants.Constants.EMPLOYEE_ID;

import static com.thinksoft.businesslayer.utils.constants.Constants.EMPLOYEE_NAME;
import static com.thinksoft.businesslayer.utils.constants.Constants.PRODUCT_LIST_CODE;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.EmployeeSpinnerAdapter;
import com.thinksoft.businesslayer.utils.PaymentFrequencySpinnerAdapter;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Order;

public class AgregarCobroActivity extends OrmLiteBaseActivity<PolAppHelper> {
	EditText txtClient;
	EditText txtTotal;
	TextView lblProductos;
	Spinner spnEmployee;
	Button btnSave;
	Map<Integer,Integer> products_ids;
	BusinessManager businessLayer;
	Spinner spnPayment;

	@SuppressLint("UseSparseArrays")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar_cobro);

		businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
		
		products_ids = new HashMap<Integer,Integer>();
		txtClient= (EditText) findViewById(R.id.txtClientAddOrder);
		txtTotal= (EditText) findViewById(R.id.txtTotalAddOrder);
		lblProductos = (TextView) findViewById(R.id.lblProductsAddOrder);
		spnPayment = (Spinner) findViewById(R.id.spnPaymentModeAddOrder);
		spnEmployee = (Spinner) findViewById(R.id.spnSellerAddOrder);
		btnSave = (Button) findViewById(R.id.btnSaveAddOrder);
		
		PaymentFrequencySpinnerAdapter adapter = new PaymentFrequencySpinnerAdapter(this, businessLayer.listOfPaymentMethods());
		spnPayment.setAdapter(adapter);
		EmployeeSpinnerAdapter adapterEmployee = new EmployeeSpinnerAdapter(this, businessLayer.listOfSellers());
		spnEmployee.setAdapter(adapterEmployee);
		
		
		businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
		businessLayer.addDefaultOrderValues();
		
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
					bundle.putSerializable(PRODUCTS_IDS_KEY, (HashMap<Integer,Integer>) products_ids);
					intent.putExtras(bundle);
				}
				startActivityForResult(intent, PRODUCT_LIST_CODE);
			}
		});
		
		btnSave.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onClick(View v) {
				Map<String,String> employee = (HashMap<String, String>) spnEmployee.getSelectedItem(); 
				Map<String,String> payment = (HashMap<String, String>) spnPayment.getSelectedItem(); 
				
				int clientId = (Integer) txtClient.getTag();
				double total = Double.valueOf(txtTotal.getText().toString());
				int employeeId = Integer.valueOf(employee.get(EMPLOYEE_ID));
				int paymentId = Integer.valueOf(payment.get(PAYMENT_ID));
				
				businessLayer.verifyOrderInformation(clientId, employeeId, paymentId);
				Order order = businessLayer.addOrder(clientId, employeeId, paymentId,(float) total);
				businessLayer.addProductsToOrder(order, products_ids, getHelper().getConnectionSource());
				finish();
			}
		});
	}
	
	
	@SuppressWarnings("unchecked")
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
					products_ids = (HashMap<Integer, Integer>) bundle.getSerializable(PRODUCTS_IDS_KEY);
					txtTotal.setText(String.valueOf(setTotal(products_ids)));
				}
			}
		}
	}

	
	public double setTotal(Map<Integer,Integer> ids){
		double total=0;
		for (Integer id : ids.keySet()) {
			total = total+(businessLayer.getProductPrice(id)*ids.get(id));
		}
		return total;
		
	}
}
