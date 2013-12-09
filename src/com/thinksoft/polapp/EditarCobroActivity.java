package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.Constants.CLIENT_LIST_CODE;
import static com.thinksoft.businesslayer.utils.constants.Constants.PAYMENT_ID;
import static com.thinksoft.businesslayer.utils.constants.Constants.PRODUCTS_IDS_KEY;
import static com.thinksoft.businesslayer.utils.constants.Constants.PRODUCT_LIST_CODE;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_ORDERID;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.CLIENT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.PaymentFrequencySpinnerAdapter;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.impl.ClientImpl;
import com.thinksoft.models.dtos.impl.PaymentFrequencyImpl;
public class EditarCobroActivity extends OrmLiteBaseActivity<PolAppHelper> {

	EditText txtClient;
	EditText txtTotal;
	TextView lblProductos;
	Button btnSave;
	Button btnCancel;
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
		setContentView(R.layout.activity_editar_cobro);
		businessLayer = new BusinessManagerImpl(getConnectionSource());
		Bundle bundle = getIntent().getExtras();
		
		if(bundle != null ){
			
			
			txtClient = (EditText) findViewById(R.id.txtEditClientAddOrder);
			txtTotal = (EditText) findViewById(R.id.txtEditTotalAddOrder);
			lblProductos = (TextView) findViewById(R.id.lblEditProductsAddOrder);
			spnPayment = (Spinner) findViewById(R.id.spnEditPaymentModeAddOrder);
			
			btnSave = (Button) findViewById(R.id.btnEditSaveAddOrder);
			btnCancel = (Button) findViewById(R.id.btnEditCancelAddOrder);
		
			final Order order = businessLayer.getOrderById(bundle.getInt(COLUMN_ORDERID));
			products_ids =  businessLayer.getAllProductsByOrderId(order);
			txtClient.setText((CharSequence) order.getClient().getName() +" "+order.getClient().getFirstLastName() +" "+order.getClient().getSecondLastName());
			txtClient.setTag(order.getClient().getClientId());
			txtTotal.setText((CharSequence) String.valueOf(order.getFinalBalance()));
			List<Map<String,String>> list = businessLayer.listOfPaymentMethods();
			int i =0;
			for (Map<String,String> it : list) {
				if(it.get("Payment_ID")==String.valueOf(order.getPaymentFrequency().getIdPaymentFrequency())){
					i = list.indexOf(it);
				}
			}
			PaymentFrequencySpinnerAdapter adapter = new PaymentFrequencySpinnerAdapter(this, list);
			spnPayment.setAdapter(adapter);
			spnPayment.setSelection(i);
			
			
			
			
			txtClient.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View vista) {
					Intent intent = new Intent(EditarCobroActivity.this, ListaClientesActivity.class);
					startActivityForResult(intent, CLIENT_LIST_CODE);
				}
			});
			
			lblProductos.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					
					Bundle bundle = new Bundle();
					Intent intent = new Intent(EditarCobroActivity.this, ListaProductosActivity.class);
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
					try{
						Map<String,String> payment = (HashMap<String, String>) spnPayment.getSelectedItem(); 
						
						int clientId = (Integer) txtClient.getTag();
						long total = Long.valueOf(txtTotal.getText().toString());
						int paymentId = Integer.valueOf(payment.get(PAYMENT_ID));
						
						order.setClient((ClientImpl) businessLayer.getClientById(clientId));
						order.setPaymentFrequency((PaymentFrequencyImpl) businessLayer.getPaymentFrequencyById(paymentId));
						order.setActualBalance(total);
						businessLayer.updateOrder(order);
					}catch(Exception ex){
						ex.printStackTrace();
					}
					finish();
				}
			});
		}else{
			finish();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.editar_cobro, menu);
		return true;
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
