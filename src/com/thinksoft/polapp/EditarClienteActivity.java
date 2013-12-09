package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_CLIENTID;
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

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Client;
public class EditarClienteActivity extends OrmLiteBaseActivity<PolAppHelper> {

	 public BusinessManager businessLayer;
	 public EditText txtName;
	 public EditText txtLastName;
	 public EditText txtPhone;
	 public TextView txtAddress;
	 public ListView productList;
	 public Button btnSaveClient;
	 public Button btnCancelClient;
	 public Client client;
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
		setContentView(R.layout.activity_editar_cliente);
		Bundle extras = getIntent().getExtras();
		if(extras!=null){
			businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
		    txtName = (EditText) findViewById(R.id.txtNameEditClient);
		    txtLastName = (EditText) findViewById(R.id.txtFirstLastNameEditClient);
		    txtPhone = (EditText) findViewById(R.id.txtPhoneNumberEditClient);
		    txtAddress= (TextView) findViewById(R.id.lblAddressEditClient);
	
		    btnSaveClient = (Button) findViewById(R.id.btnEditAgregarCliente);
		    btnCancelClient = (Button) findViewById(R.id.btnEditCancelarCliente);
		    client = businessLayer.getClientById(extras.getInt(COLUMN_CLIENTID));
		    
		    txtName.setText((CharSequence) client.getName());
		    txtLastName.setText((CharSequence) client.getFirstLastName() + " " +client.getSecondLastName());
		    txtPhone.setText((CharSequence) String.valueOf(client.getPhoneNumber()));
		    
		    btnSaveClient.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					String name = txtName.getText().toString();
					String[] lastName = txtLastName.getText().toString().split(" ");
					
					int phoneNumber = 0;
					try{
						phoneNumber = Integer.parseInt(txtPhone.getText().toString());
					}catch(NumberFormatException ne){
						ne.printStackTrace();
					}
					
					updateClient(name, lastName, phoneNumber, 0, 0, 0);
					
				}
			});
		    
		    txtAddress.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				   	Intent intentV = new Intent(getApplicationContext(), MapSelector.class);
		            startActivity(intentV);
				}
			});
		    
		}else{
			finish();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.editar_cliente, menu);
		return true;
	}
 
	public void updateClient(String name, String[] lastName, long phoneNumber, double zoom, double latitude, double longitude){
		if(client != null){
			Toast msg = null;
			String result = businessLayer.verifyClientInformation(name,lastName,phoneNumber);
			if (EMPTY_STRING.equals(result)) {
				client.setName(name);
				client.setFirstLastName(lastName[0]);
				client.setPhoneNumber(phoneNumber);
					if(lastName.length>1){
						client.setSecondLastName(lastName[1]);
					}else{
						client.setSecondLastName(NO_SECOND_LASTNAME);
					}
				if(businessLayer.updateClient(client)){
					msg = Toast.makeText(EditarClienteActivity.this,"Cliente actualizado correctamente", MESSAGE_DURATION);
					finish();
				}else{
					msg = Toast.makeText(EditarClienteActivity.this,MESSAGE_GENERIC_ERROR, MESSAGE_DURATION);
				}
			}else if(COLUMN_NAME.equalsIgnoreCase(result)){		
				msg = Toast.makeText(EditarClienteActivity.this,MESSAGE_NO_NAME, MESSAGE_DURATION);
			}else if (COLUMN_LASTNAME.equalsIgnoreCase(result)) {
				msg = Toast.makeText(EditarClienteActivity.this,MESSAGE_NO_LASTNAME, MESSAGE_DURATION);
			} else if (COLUMN_PHONENUMBER.equalsIgnoreCase(result)) {
				msg = Toast.makeText(EditarClienteActivity.this,MESSAGE_WRONG_PHONE_NUMBER, MESSAGE_DURATION);
			} else {
				msg = Toast.makeText(EditarClienteActivity.this,MESSAGE_GENERIC_ERROR, MESSAGE_DURATION);
			}
			msg.show();
		}else{
			finish();
		}
	}
	
	
}
