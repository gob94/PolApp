package com.thinksoft.polapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.ClientListViewAdapter;
import com.thinksoft.businesslayer.utils.ProductCheckViewHolder;
import com.thinksoft.models.databases.PolAppHelper;

public class ListaProductosActivity extends OrmLiteBaseActivity<PolAppHelper> {

	private BusinessManager businessLayer;
	private EditText txtSearchProduct;
	private ClientListViewAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_productos);
		
		businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
		final ListView listSearchClient = (ListView) findViewById(R.id.lstViewSelectProductListActivity);
		txtSearchProduct = (EditText) findViewById(R.id.txtSearchSelectProductListActivity);
		adapter = new ClientListViewAdapter(ListaProductosActivity.this,businessLayer.getAllClients());
		listSearchClient.setAdapter(adapter); 
		listSearchClient.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View item, int arg2,long arg3) {
					ProductCheckViewHolder holder = (ProductCheckViewHolder) item.getTag();
					if(holder.getChkProduct().isChecked()){
						holder.getChkProduct().setChecked(false);
					}else{
						holder.getChkProduct().setChecked(true);
					}		
			}
		});
		txtSearchProduct.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence string, int start, int before, int count) {
				ListaProductosActivity.this.adapter.getFilter().filter(string);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lista_productos, menu);
		return true;
	}
	/*
	 @Override
	 public void onCreateContextMenu(ContextMenu menu, final View view, ContextMenuInfo menuInfo)
	 {
	         super.onCreateContextMenu(menu, view, menuInfo);
	         menu.add(OPTIONS_GROUP_ID, SELECT_OPTION_ID,FIRST_OPTION, SELECT_ITEM).setOnMenuItemClickListener(new OnMenuItemClickListener() {
				
				@Override
				public boolean onMenuItemClick(MenuItem item) {
					ClientViewHolder client = (ClientViewHolder) view.getTag();
					String clientName = client.txtName.getText().toString()+" "+client.txtFirstLastName.getText().toString()+" "+client.txtSecondLastName.getText().toString();
					Bundle bundle = getIntent().getExtras()==null ? new Bundle():getIntent().getExtras();
					
					bundle.putInt(CLIENT_ID_COLUMN, client.clientId);
					bundle.putString(NAME_COLUMN, clientName);
					getIntent().putExtras(bundle);
					
					setResult(Activity.RESULT_OK, getIntent());
					finish();
					return true;
				}
			});
	         menu.add(OPTIONS_GROUP_ID, CANCEL_OPTION_ID, SECOND_OPTION, CANCEL_SELECT_ITEM); 
	
	 } */

}
