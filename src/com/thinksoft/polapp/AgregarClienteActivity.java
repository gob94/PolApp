package com.thinksoft.polapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.impl.ClientImpl;

public class AgregarClienteActivity extends OrmLiteBaseActivity<PolAppHelper> {
	 public BusinessManager businessLayer;
	 public EditText txtName;
	 public EditText txtLastName;
	 public EditText txtPhone;
	 public ListView productList;
	 public Button btnAddClient;
	 public static int MESSAGE_DURATION =10000;
	 public static String NO_SECOND_LASTNAME ="N/A";
	 public static boolean NO_DEBTS =false;
	 
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
	    
	    btnAddClient.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				String name = txtName.getText().toString();
				String[] lastName = txtLastName.getText().toString().split(" ");
				int phoneNumber = Integer.parseInt(txtPhone.getText().toString());
				registerClient(name, lastName, phoneNumber);
			}
		});
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.agregar_clientes, menu);
		return true;
	}
	
	public void registerClient(String name, String[] lastName, int phoneNumber){
		if (businessLayer.verifyClientInformation(name,lastName,phoneNumber)=="") {
			Client client = null;
				if(lastName.length>1){
					client= new ClientImpl(name, lastName[0], lastName[1], NO_DEBTS);			
				}else{
					client= new ClientImpl(name, lastName[0], NO_SECOND_LASTNAME,NO_DEBTS);	
				}
			
			if(businessLayer.addClient(client)){
				Intent intent = new Intent(AgregarClienteActivity.this, HomeScreenActivity.class);
				startActivity(intent);
			}
		}else{
			
			Toast msg = Toast.makeText(AgregarClienteActivity.this,"Hay campos con errores", MESSAGE_DURATION);
			msg.show();
		}
	}
 
}


/*if (clientId!=0) {
client = businessLayer.getClientById(clientId);
client.setName(txtName.getText().toString());
client.setFirstLastName(lastName[0]);
if(lastName.length>1){
	client.setSecondLastName(lastName[1]);							
}
client.setAccountState(businessLayer.clientHasOrders(clientId));
}else{*/
//}	    //final int clientId = bundle!=null ? bundle.getInt("clientId"):0;
/*if(clientId!= 0){
Client client = businessLayer.getClientById(clientId);
txtName.setText(client.getName());
txtLastName.setText(client.getFirstLastName()+client.getSecondLastName());
txtPhone.setText(businessLayer.getClientPhoneNumber(clientId));
List<Map<String, String>> productos = businessLayer.getClientProducts(clientId);
ClientListViewAdapter adapter = new ClientListViewAdapter(this, productos);
productList.setAdapter(adapter);
}*/