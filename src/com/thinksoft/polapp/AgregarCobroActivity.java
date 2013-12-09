package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.Constants.CLIENT_LIST_CODE;
import static com.thinksoft.businesslayer.utils.constants.Constants.PAYMENT_ID;
import static com.thinksoft.businesslayer.utils.constants.Constants.PRODUCTS_IDS_KEY;
import static com.thinksoft.businesslayer.utils.constants.Constants.PRODUCT_LIST_CODE;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_CLIENTID;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_EMPLOYEE_ID;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_PAYMENTFREQUENCY_ID;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.EMPTY_STRING;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.CLIENT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;

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
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.PaymentFrequencySpinnerAdapter;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Order;

public class AgregarCobroActivity extends OrmLiteBaseActivity<PolAppHelper> {
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
		btnSave = (Button) findViewById(R.id.btnSaveAddOrder);
		
		PaymentFrequencySpinnerAdapter adapter = new PaymentFrequencySpinnerAdapter(this, businessLayer.listOfPaymentMethods());
		spnPayment.setAdapter(adapter);
		
		
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
				Toast msg = null;
				if(txtClient.getTag()!=null&&txtTotal.getText().toString()!="0"){
					Map<String,String> payment = (HashMap<String, String>) spnPayment.getSelectedItem(); 
					
					int clientId = (Integer) txtClient.getTag();
					double total = Double.valueOf(txtTotal.getText().toString());
					int paymentId = Integer.valueOf(payment.get(PAYMENT_ID));
					
					String result = businessLayer.verifyOrderInformation(clientId, paymentId);
					
					if(result.equals(EMPTY_STRING)){
						Order order = businessLayer.addOrder(clientId, paymentId,(long) total);
						if(order!=null){
							businessLayer.addProductsToOrder(order, products_ids, getHelper().getConnectionSource());
							msg = Toast.makeText(AgregarCobroActivity.this, MESSAGE_SUCCESSFUL , Toast.LENGTH_LONG);
						}else{
							msg = Toast.makeText(AgregarCobroActivity.this, MESSAGE_ERROR , Toast.LENGTH_LONG);
						}
					}else if(result.equals(COLUMN_CLIENTID)){
						msg = Toast.makeText(AgregarCobroActivity.this, COLUMN_CLIENTID +","+MESSAGE_ERROR , Toast.LENGTH_LONG);
					}else if(result.equals(COLUMN_PAYMENTFREQUENCY_ID)){
						msg = Toast.makeText(AgregarCobroActivity.this,  COLUMN_EMPLOYEE_ID +","+MESSAGE_ERROR  , Toast.LENGTH_LONG);
					}
					msg.show();
					finish();
				}else{
					msg = Toast.makeText(AgregarCobroActivity.this, MESSAGE_MISSING_FIELDS , Toast.LENGTH_LONG);
					msg.show();
				}
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
