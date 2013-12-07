package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_PRODUCT_CODE;
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
import com.thinksoft.models.dtos.Product;

public class PerfilProductos extends OrmLiteBaseActivity<PolAppHelper> {

	TextView txtProductCode;
	TextView txtProductName;
	TextView txtProductPrice;
	TextView txtProductQuantity;

	Button btnAcceptProduct;
	Button btnEditProduct;
	Button btnDeleteProduct;
	BusinessManager bussinessLayer;
	static String UNABLE_TO_SHOW = "Unable to show Item, check it's not deleted or modified";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_productos);
		Bundle extras = getIntent().getExtras();
		
		if(extras!=null){
			final String code = extras.getString(COLUMN_PRODUCT_CODE);
			bussinessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
			txtProductCode = (TextView) findViewById(R.id.lblClientNameProfileEditabled);
			txtProductName  = (TextView) findViewById(R.id.lblClientLastNameProfileEditabled);
			txtProductPrice  = (TextView) findViewById(R.id.lblClientPhoneProfileEditabled);
			txtProductQuantity  = (TextView) findViewById(R.id.lblClientDirectionProfileEditabled);
	
			btnAcceptProduct  = (Button) findViewById(R.id.btnAcceptClientProfile);
			btnEditProduct  = (Button) findViewById(R.id.btnEditClientProfile);
			btnDeleteProduct  = (Button) findViewById(R.id.btnDeleteClientProfile);
			
			Product product = bussinessLayer.getProductByCode(code);
			
			txtProductCode.setText((CharSequence) product.getCode());
			txtProductName.setText((CharSequence) product.getName());
			txtProductPrice.setText((CharSequence) String.valueOf(product.getPrice()));
			txtProductQuantity.setText((CharSequence) String.valueOf(product.getQuantity()));
			
			
			btnAcceptProduct.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					sentToHome();
				}
			});
			
			btnEditProduct.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Bundle extras = new Bundle();
					extras.putString(COLUMN_PRODUCT_CODE, code);
					Intent intent = new Intent(PerfilProductos.this, EditarProductosActivity.class);
					startActivity(intent);
				}
			});
			
			btnDeleteProduct.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					sentToHome();
				}
			});
		}else{
			Toast toast = Toast.makeText(PerfilProductos.this, UNABLE_TO_SHOW, Toast.LENGTH_LONG);
			toast.show();
			sentToHome();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.perfil_productos, menu);
		return true;
	}

	
	public void sentToHome(){
		Intent intent = new Intent(PerfilProductos.this, HomeScreenActivity.class);
		startActivity(intent);
	}
}
