package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.RowConstants.CLIENT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.ClientListViewAdapter;
import com.thinksoft.businesslayer.utils.ClientViewHolder;
import com.thinksoft.models.databases.PolAppHelper;

public class ListaClientesActivity extends OrmLiteBaseActivity<PolAppHelper> {
	BusinessManager businessLayer;
	public EditText txtSearchClient = null;
	public ClientListViewAdapter adapter = null;
	public static String SELECT_ITEM = "Seleccionar";
	public static String CANCEL_SELECT_ITEM = "Cancelar";
	public static int SELECT_OPTION_ID = 1;
	public static int CANCEL_OPTION_ID = 0;
	public static int OPTIONS_GROUP_ID = 1;
	public static int FIRST_OPTION = 1;
	public static int SECOND_OPTION = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_clientes);
		businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
		final ListView listSearchClient = (ListView) findViewById(R.id.lstViewClientSearchList);
		txtSearchClient = (EditText) findViewById(R.id.txtSearchClientListActivity);
		adapter = new ClientListViewAdapter(ListaClientesActivity.this,businessLayer.getAllClients());
		listSearchClient.setAdapter(adapter); 
		listSearchClient.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View item, int arg2,long arg3) {
					registerForContextMenu(item);
					item.showContextMenu();
			}
		});
		txtSearchClient.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence string, int start, int before, int count) {
				ListaClientesActivity.this.adapter.getFilter().filter(string);
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
		getMenuInflater().inflate(R.menu.lista_clientes, menu);
		return true;
	}

	
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

     } 
}
