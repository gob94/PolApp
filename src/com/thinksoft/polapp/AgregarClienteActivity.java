package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_LASTNAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_NAME;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_PHONENUMBER;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.EMPTY_STRING;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.MINIMUM_PHONENUMBER_DIGITS;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Address;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.impl.AddressImpl;
import com.thinksoft.models.dtos.impl.ClientImpl;

public class AgregarClienteActivity extends OrmLiteBaseActivity<PolAppHelper> {
	 public BusinessManager businessLayer;
	 public EditText txtName;
	 public EditText txtLastName;
	 public EditText txtPhone;
	 public TextView txtAddress;
	 public ListView productList;
	 public Button btnAddClient;
	 public static int MESSAGE_DURATION =10000;
	 public static String NO_SECOND_LASTNAME ="N/A";
	 public static String MESSAGE_NO_NAME ="El campo nombre esta vacio";
	 public static String MESSAGE_NO_LASTNAME ="Primer apellido no especificado, especifica un primer apellido	";
	 public static String MESSAGE_WRONG_PHONE_NUMBER ="Numero de telefono vacio o no es correcto, digite al menos "+ MINIMUM_PHONENUMBER_DIGITS +" caracteres";
	 public static String MESSAGE_GENERIC_ERROR ="Hay error con la aplicacion, reinicie la aplicacion";
	 public static boolean NO_DEBTS =false;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar_cliente);
		businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
	    txtName = (EditText) findViewById(R.id.txtNameAddClient);
	    txtLastName = (EditText) findViewById(R.id.txtLastNameAddClient);
	    txtPhone = (EditText) findViewById(R.id.txtPhoneAddClient);
	    txtAddress= (TextView) findViewById(R.id.lblDireccion);

	    btnAddClient = (Button) findViewById(R.id.btnSaveAddClient);
	   
	    btnAddClient.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				String name = txtName.getText().toString();
				String[] lastName = txtLastName.getText().toString().split(" ");
				Intent i= getIntent();
				Bundle b= i.getExtras();
				double zoom= b.getDouble("Zoom");
				LatLng location= i.getParcelableExtra("Location");
				
				int phoneNumber = 0;
				try{
					phoneNumber = Integer.parseInt(txtPhone.getText().toString());
				}catch(NumberFormatException ne){
					ne.printStackTrace();
				}
				
				registerClient(name, lastName, phoneNumber, zoom, location.latitude, location.longitude);
				
			}
		});
	    
	    txtAddress.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			   	Intent intentV = new Intent(getApplicationContext(), MapSelector.class);
	            startActivity(intentV);
			}
		});
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.agregar_clientes, menu);
		return true;
	}
	
	public void registerClient(String name, String[] lastName, long phoneNumber, double zoom, double latitude, double longitude){
		Toast msg = null;
		String result = businessLayer.verifyClientInformation(name,lastName,phoneNumber);
		if (EMPTY_STRING.equals(result)) {
			Client client = null;
			Address add= null;

			
				if(lastName.length>1){
				client= new ClientImpl(name, lastName[0], lastName[1], NO_DEBTS,phoneNumber);
				}else{
				client= new ClientImpl(name, lastName[0], NO_SECOND_LASTNAME,NO_DEBTS,phoneNumber);	
				}
				
			if(businessLayer.addClient(client)){
				add= new AddressImpl(zoom, latitude, "", longitude, (ClientImpl)client, true, phoneNumber);
				Intent intent = new Intent(AgregarClienteActivity.this, HomeScreenActivity.class);
				businessLayer.addAddress(add);
				startActivity(intent);
			}
		}else if(COLUMN_NAME.equalsIgnoreCase(result)){		
			msg = Toast.makeText(AgregarClienteActivity.this,MESSAGE_NO_NAME, MESSAGE_DURATION);
		}else if (COLUMN_LASTNAME.equalsIgnoreCase(result)) {
			msg = Toast.makeText(AgregarClienteActivity.this,MESSAGE_NO_LASTNAME, MESSAGE_DURATION);
		} else if (COLUMN_PHONENUMBER.equalsIgnoreCase(result)) {
			msg = Toast.makeText(AgregarClienteActivity.this,MESSAGE_WRONG_PHONE_NUMBER, MESSAGE_DURATION);
		} else {
			msg = Toast.makeText(AgregarClienteActivity.this,MESSAGE_GENERIC_ERROR, MESSAGE_DURATION);
		}
		msg.show();
	}
	
	public boolean asignAddressToClient(double lat, double longitude, double zoom, ClientImpl client){
		boolean result= false;
		Address address= null;
		
		address.setLatitude(lat);
		address.setLonguitude(longitude);
		address.setZoom(zoom);
		
		if(client != null){
			address.setClient(client);
			result= true;
		}else{
			Toast.makeText(getApplicationContext(), "Por favor verifique sus datos", Toast.LENGTH_LONG).show();
		}
		return result;
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