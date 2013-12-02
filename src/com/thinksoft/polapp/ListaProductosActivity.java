package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.Constants.PRODUCTS_IDS_KEY;
import static com.thinksoft.businesslayer.utils.constants.Constants.QUANTITY_SELECTOR_CODE;
import static com.thinksoft.businesslayer.utils.constants.Constants.SELECTED_FLAG;
import static com.thinksoft.businesslayer.utils.constants.Constants.VIEW_POSITION;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.PRODUCT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.SELECTED_QUANTITY_COLUMN;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.ProductCheckListViewAdapter;
import com.thinksoft.models.databases.PolAppHelper;


public class ListaProductosActivity extends OrmLiteBaseActivity<PolAppHelper> {

	private BusinessManager businessLayer;
	private EditText txtSearchProduct;
	private Button btnAccept;
	private ProductCheckListViewAdapter adapter;
	private ListView listCheckProduct;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_productos);
		businessLayer = new BusinessManagerImpl(getHelper().getConnectionSource());
		List<Map<String,String>> list = businessLayer.getAllProducts();
		Bundle bundle = getIntent().getExtras();
		if(bundle!=null){
			@SuppressWarnings("unchecked")
			Map<Integer,Integer> ids = (HashMap<Integer, Integer>) bundle.getSerializable(PRODUCTS_IDS_KEY);
			for (Map<String, String> map : list) {
				int prodId = Integer.valueOf(map.get(PRODUCT_ID_COLUMN));
				if(ids.containsKey(prodId)){
					map.put(SELECTED_FLAG, SELECTED_FLAG);
					map.put(SELECTED_QUANTITY_COLUMN,String.valueOf(ids.get(prodId)));
				}
			}
		}
		
		adapter = new ProductCheckListViewAdapter(ListaProductosActivity.this,list);
		listCheckProduct= (ListView) findViewById(R.id.lstViewSelectProductListActivity);
		txtSearchProduct = (EditText) findViewById(R.id.txtSearchSelectProductListActivity);
		btnAccept = (Button) findViewById(R.id.btnDoneProductCheckList);
		
		listCheckProduct.setAdapter(adapter); 
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
		
		btnAccept.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Bundle bundle =new Bundle();
				bundle.putSerializable(PRODUCTS_IDS_KEY, (HashMap<Integer, Integer>) adapter.checkedList);
				getIntent().putExtras(bundle);
				setResult(Activity.RESULT_OK, getIntent());
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lista_productos, menu);
		return true;
	}
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==QUANTITY_SELECTOR_CODE){
			if(resultCode==Activity.RESULT_OK){
				Bundle extras = data.getExtras();
				if(extras!=null){
					String quantity = String.valueOf(extras.getInt(QUANTITY_COLUMN));
					Map <String, String> item = adapter.list.get(extras.getInt(VIEW_POSITION));
					item.put(SELECTED_QUANTITY_COLUMN, quantity);
					adapter.checkedList.put(Integer.valueOf(item.get(PRODUCT_ID_COLUMN)), Integer.valueOf(quantity));
					adapter.notifyDataSetChanged();
				}
			}
		}
	}

}
