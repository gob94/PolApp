package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_CLIENTID;
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
import com.thinksoft.models.dtos.Client;
public class PerfilClienteActivity extends OrmLiteBaseActivity<PolAppHelper> {

	TextView txtClientName;
	TextView txtClientLastName;
	TextView txtClientPhone;
	TextView txtClientAddress;
	Button btnAcceptClient;
	Button btnEditClient;
	Button btnDeleteClient;
	BusinessManager bussinessLayer;
	static String UNABLE_TO_SHOW = "Unable to show Item, check it's not deleted or modified";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_cliente);
		Bundle extras = getIntent().getExtras();
		
		if(extras!=null){
			final int id = extras.getInt(COLUMN_CLIENTID);
			bussinessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
			txtClientName = (TextView) findViewById(R.id.lblClientNameProfileEditabled);
			txtClientLastName  = (TextView) findViewById(R.id.lblClientLastNameProfileEditabled);
			txtClientPhone  = (TextView) findViewById(R.id.lblClientPhoneProfileEditabled);
			txtClientAddress  = (TextView) findViewById(R.id.lblClientDirectionProfileEditabled);
	
			btnAcceptClient  = (Button) findViewById(R.id.btnAcceptClientProfile);
			btnEditClient  = (Button) findViewById(R.id.btnEditClientProfile);
			btnDeleteClient  = (Button) findViewById(R.id.btnDeleteClientProfile);
			
			Client client = bussinessLayer.getClientById(id);
			
			txtClientName.setText((CharSequence) client.getName());
			txtClientLastName.setText((CharSequence) client.getFirstLastName().concat(" ").concat(client.getSecondLastName()));
			txtClientPhone.setText((CharSequence) String.valueOf(client.getPhoneNumber()));
			
			
			btnAcceptClient.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					sentToHome();
				}
			});
			
			btnEditClient.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Bundle extras = new Bundle();
					extras.putInt(COLUMN_CLIENTID, id);
					Intent intent = new Intent(PerfilClienteActivity.this, EditarClienteActivity.class);
					startActivity(intent);
				}
			});
			
			btnDeleteClient.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					sentToHome();
				}
			});
		}else{
			Toast toast = Toast.makeText(PerfilClienteActivity.this, UNABLE_TO_SHOW, Toast.LENGTH_LONG);
			toast.show();
			sentToHome();
		}
		
	}

	public void sentToHome(){
		Intent intent = new Intent(PerfilClienteActivity.this, HomeScreenActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.perfil_cliente, menu);
		return true;
	}

}
