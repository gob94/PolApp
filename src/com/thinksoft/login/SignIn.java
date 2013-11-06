package com.thinksoft.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.User;
import com.thinksoft.models.dtos.impl.ClientImpl;
import com.thinksoft.models.dtos.impl.UserImpl;
import com.thinksoft.polapp.HomeScreenActivity;
import com.thinksoft.polapp.R;

public class SignIn extends OrmLiteBaseActivity<PolAppHelper> {

	private BusinessManager bussinnessLayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		bussinnessLayer = new BusinessManagerImpl(getHelper() .getConnectionSource());
		User user = new UserImpl("admin", "superadmin", "1", "Administrator", "Polaco", "Application");
		bussinnessLayer.addUser(user);
		Client client = new ClientImpl("Johnny","Xu","Liang",true);
		bussinnessLayer.addClient(client);
		
		final EditText username = (EditText) findViewById(R.id.txtUserName);
		final EditText password = (EditText) findViewById(R.id.txtPassword);
		TextView signUp = (TextView) findViewById(R.id.lblSignUp);
		Button btnEntrar = (Button) findViewById(R.id.btnEntrar);

		signUp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SignIn.this, SignUp.class);
				startActivity(intent);
			}
		});

		btnEntrar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String usernameString = username.getText().toString();
				String passString = password.getText().toString();
					if (bussinnessLayer.checkUserCredentials(usernameString,passString)) {
						Intent intent = new Intent(SignIn.this, HomeScreenActivity.class);
						startActivity(intent);
					} else {
						Toast error = Toast
								.makeText(
										SignIn.this,
										"El nombre de usuario o contraseña es incorrecto, ingreselos de nuevo",
										Toast.LENGTH_LONG);
						error.show();
					}
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_in, menu);
		return true;
	}

}
