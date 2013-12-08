package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_ORDERID;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Order;

public class PerfilCobros extends OrmLiteBaseActivity<PolAppHelper> {

	TextView txtOrderClient;
	TextView txtOrderPaymentMethod;
	TextView txtOrderTotal;

	TextView txtOrderProducts;
	Button btnAcceptOrder;
	Button btnEditOrder;
	Button btnDeleteOrder;
	BusinessManager bussinessLayer;
	static String UNABLE_TO_SHOW = "Unable to show Item, check it's not deleted or modified";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_cobros);
		
Bundle extras = getIntent().getExtras();
		
		if(extras!=null){
			final int id = extras.getInt(COLUMN_ORDERID);
			bussinessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
			txtOrderClient = (TextView) findViewById(R.id.lblOrderClientProfileEditabled);
			txtOrderPaymentMethod  = (TextView) findViewById(R.id.lblOrderPaymentModeProfileEditabled);
			txtOrderTotal  = (TextView) findViewById(R.id.lblOrderTotalProfileEditabled);
			txtOrderProducts  = (TextView) findViewById(R.id.lblOrderProductProfileEditabled);
	
			btnAcceptOrder  = (Button) findViewById(R.id.btnAcceptOrderProfile);
			btnEditOrder  = (Button) findViewById(R.id.btnEditOrderProfile);
			btnDeleteOrder  = (Button) findViewById(R.id.btnDeleteOrderProfile);
			
			Order order = bussinessLayer.getOrderById(id);
			txtOrderPaymentMethod.setText((CharSequence) (order.getPaymentFrequency().getName()));
			txtOrderClient.setText((CharSequence) order.getClient().getName()+" "+order.getClient().getFirstLastName());
			txtOrderTotal.setText((CharSequence) String.valueOf(order.getActualBalance()));
			
			
			
			btnAcceptOrder.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					sentToHome();
				}
			});
			
			btnEditOrder.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Bundle extras = new Bundle();
					extras.putInt(COLUMN_ORDERID, id);
					Intent intent = new Intent(PerfilCobros.this, EditarCobroActivity.class);
					startActivity(intent);
				}
			});
			
			btnDeleteOrder.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					sentToHome();
				}
			});
		}else{
			Toast toast = Toast.makeText(PerfilCobros.this, UNABLE_TO_SHOW, Toast.LENGTH_LONG);
			toast.show();
			sentToHome();
		}
	}

	
	public void sentToHome(){
		Intent intent = new Intent(PerfilCobros.this, HomeScreenActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.perfil_cobros, menu);
		return true;
	}

}
