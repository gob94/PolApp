package com.thinksoft.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.thinksoft.polapp.HomeScreenActivity;
import com.thinksoft.polapp.R;

public class SignIn extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		
		EditText username = (EditText)findViewById(R.id.txtUserName);
		EditText password = (EditText)findViewById(R.id.txtPassword);
		TextView signUp = (TextView)findViewById(R.id.lblSignUp);
		Button btnEntrar = (Button)findViewById(R.id.btnEntrar);
		
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
				// TODO Auto-generated method stub
				Intent intent = new Intent(SignIn.this, HomeScreenActivity.class);
				startActivity(intent);
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
