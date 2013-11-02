package com.thinksoft.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.User;
import com.thinksoft.polapp.R;

public class SignUp extends OrmLiteBaseActivity<PolAppHelper> {
	BusinessManager businessLayer;
	Button btnRegister;
	Button btnCancel;
	final static String MESSAGE_USERNAME_ERROR =  "Username already exists";
	final static String MESSAGE_REGISTRATION_SUCCESFUL =  "Success: User Added";
	final static String MESSAGE_ID_ERROR = "Identification already exists";
	final static int MESSAGE_DURATION = 10000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
		
		btnRegister = (Button)findViewById(R.id.btnRegister);
		btnCancel = (Button) findViewById(R.id.btnCancelSignUp);
		final EditText txtUserName = (EditText) findViewById(R.id.txtUserName);
		final EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
		final EditText txtName = (EditText) findViewById(R.id.txtNameSignUp);
		final EditText txtLastName = (EditText) findViewById(R.id.txtLastName);
		final EditText txtIdentification = (EditText) findViewById(R.id.txtIdentitySignUp);
		
		btnRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String userName = txtUserName.getText().toString();
				String password = txtPassword.getText().toString();
				String name = txtName.getText().toString();
				String firstLastName = retrieveFirstLastName(txtLastName.getText().toString());
				String secondLastName =  retrieveSecondLastName(txtLastName.getText().toString());
				String identification = txtIdentification.getText().toString();
				
				User user = businessLayer.verifyUserInformation(userName, password, name, firstLastName, secondLastName, identification);
				
				if(user!=null){
					int addResult = businessLayer.registerUser(user);
					if(addResult==0){
						sendToSignIn();
						Toast msg = Toast.makeText(SignUp.this, MESSAGE_REGISTRATION_SUCCESFUL , MESSAGE_DURATION);
						msg.show();
					}else if(addResult==1){
						Toast msg = Toast.makeText(SignUp.this, MESSAGE_USERNAME_ERROR , MESSAGE_DURATION);
						msg.show();
					}else if(addResult==-1){
						Toast msg = Toast.makeText(SignUp.this,MESSAGE_ID_ERROR , MESSAGE_DURATION);
						msg.show();
					}
				}
				
				
			}


		});
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendToSignIn();
			}
		});
	}
	
	public void sendToSignIn(){
		Intent intent = new Intent(SignUp.this, SignIn.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}
	
	private String retrieveFirstLastName(String lastName) {
		return lastName.split(" ")[0];
	}
	private String retrieveSecondLastName(String lastName) {
		return lastName.split(" ")[1];
	}
}
