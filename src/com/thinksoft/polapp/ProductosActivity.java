package com.thinksoft.polapp;

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
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.impl.ProductImpl;

public class ProductosActivity extends OrmLiteBaseActivity<PolAppHelper> {

	private BusinessManager bussinesManager;
	private final static int ZERO= 0;
	Button btnAdd;
	Button btnCancel;
	EditText txtCode;
	EditText txtName;
	EditText txtQuantity;
	EditText txtPrice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productos);
		
		bussinesManager = new BusinessManagerImpl(getHelper().getConnectionSource());
		
		btnAdd = (Button)findViewById(R.id.btnSaveProduct);
		btnCancel= (Button) findViewById(R.id.btnCancelProduct);
		
		final EditText txtCode= (EditText) findViewById(R.id.txtCode);
		final EditText txtName= (EditText) findViewById(R.id.txtNameProduct);
		final EditText txtQuantity= (EditText) findViewById(R.id.txtCantidadProduct);
		final EditText txtPrice= (EditText) findViewById(R.id.txtCost);
		
		
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				String code = txtCode.getText().toString();
				String name= txtName.getText().toString();
				float quantity=Float.parseFloat(txtQuantity.getText().toString());
				float price= Integer.parseInt(txtPrice.getText().toString());
				
				Product product = createProduct(code, name, quantity, price);
				if(bussinesManager.addProduct(product)){
				
				Toast toast= Toast.makeText(ProductosActivity.this, "Producto agregado exitosamente", Toast.LENGTH_LONG);
				toast.show();
				}else{
					Toast toast= Toast.makeText(ProductosActivity.this, "Producto ya existente", Toast.LENGTH_LONG);
					toast.show();
				}
				}
		});
		
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				txtCode.setText("");
				txtName.setText("");
				txtQuantity.setText("");
				txtPrice.setText("");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.productos, menu);
		return true;
	}
	
	public Product createProduct(String code, String name, float quantity, float price ){
		Product product =null;
		
		if(code!= null || name!= null || quantity < ZERO || price < ZERO ){
			product = new ProductImpl(code, name, quantity, price);
		}
		return product;
	}
	
	public void registerProduct (){
		String code = txtCode.getText().toString();
		String name= txtName.getText().toString();
		float quantity=Float.parseFloat(txtQuantity.getText().toString());
		float price= Integer.parseInt(txtPrice.getText().toString());
		
		Product product = createProduct(code, name, quantity, price);
		if(bussinesManager.addProduct(product)){
		
		Toast toast= Toast.makeText(ProductosActivity.this, "Producto agregado exitosamente", Toast.LENGTH_LONG);
		toast.show();
		}else{
			Toast toast= Toast.makeText(ProductosActivity.this, "Producto ya existente", Toast.LENGTH_LONG);
			toast.show();
		}
	}

}
