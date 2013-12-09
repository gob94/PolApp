package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_PRODUCT_CODE;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.EMPTY_STRING;
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
public class EditarProductosActivity extends OrmLiteBaseActivity<PolAppHelper> {
	private BusinessManager bussinesManager;
	Button btnAdd;
	Button btnCancel;
	EditText txtCode;
	EditText txtName;
	EditText txtQuantity;
	EditText txtPrice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_productos);
		Bundle bundle = getIntent().getExtras();

		if (bundle != null) {
			bussinesManager = new BusinessManagerImpl(getHelper()
					.getConnectionSource());

			btnAdd = (Button) findViewById(R.id.btnSaveEditProduct);
			btnCancel = (Button) findViewById(R.id.btnCancelEditProduct);

			txtCode = (EditText) findViewById(R.id.txtCodeEditProduct);
			txtName = (EditText) findViewById(R.id.txtNameProductEditProduct);
			txtQuantity = (EditText) findViewById(R.id.txtQuantityEditProduct);
			txtPrice = (EditText) findViewById(R.id.txtCostEditProduct);
			
			final Product product = bussinesManager.getProductByCode(bundle.getString(COLUMN_PRODUCT_CODE));
			
			txtCode.setText(product.getCode());
			txtName.setText(product.getName());
			txtPrice.setText(String.valueOf(product.getPrice()));
			txtQuantity.setText(String.valueOf(product.getQuantity()));
			
			btnAdd.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					String code = txtCode.getText().toString();
					String name = txtName.getText().toString();
					String quantity = txtQuantity.getText().toString();
					String price = txtPrice.getText().toString();
					String result = bussinesManager.verifyProductInformation(
							code, name, quantity, price);

					if (result == EMPTY_STRING) {
						Toast toast = Toast.makeText(
								EditarProductosActivity.this,
								"Por favor verifique sus datos",
								Toast.LENGTH_LONG);
						toast.show();
					} else {

						long quantity1 = Long.parseLong(txtQuantity.getText()
								.toString());
						long price1 = Long.parseLong(txtPrice.getText()
								.toString());

						updateProductInfo(code, name, quantity1, price1,product);
						
						if (bussinesManager.updateProduct(product)) {
							Toast toast = Toast.makeText(
									EditarProductosActivity.this,
									"Producto modificado exitosamente",
									Toast.LENGTH_LONG);
							toast.show();
							finish();
						} else {
							Toast toast = Toast.makeText(
									EditarProductosActivity.this,
									"Por favor verifique sus datos",
									Toast.LENGTH_LONG);
							toast.show();
						}
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
					finish();
				}
			});

		} else {
			finish();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.editar_productos, menu);
		return true;
	}

	public Product updateProductInfo(String code, String name, long quantity, long price,Product product ) {
		product.setCode(code);
		product.setName(name);
		product.setPrice(price);
		product.setQuantity(quantity);
		return product;
	}

}
