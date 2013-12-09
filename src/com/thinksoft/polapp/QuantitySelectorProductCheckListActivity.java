package com.thinksoft.polapp;

import static com.thinksoft.businesslayer.utils.constants.Constants.MIN_PRODUCT_QUANTITY;
import static com.thinksoft.businesslayer.utils.constants.Constants.VIEW_POSITION;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.SELECTED_QUANTITY_COLUMN;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;

public class QuantitySelectorProductCheckListActivity extends Activity {
	NumberPicker quantitySelector;
	Button btnAccept;	
	int viewPosition;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quantity_selector_product_check_list);
		
		quantitySelector = (NumberPicker) findViewById(R.id.nmbpQuantityQuantitySelector);
		btnAccept = (Button) findViewById(R.id.btnOkButtonQuantitySelector);
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			quantitySelector.setMinValue(MIN_PRODUCT_QUANTITY);
			quantitySelector.setMaxValue(extras.getInt(QUANTITY_COLUMN));
			//quantitySelector.setValue(extras.getInt(SELECTED_QUANTITY_COLUMN));
			viewPosition = extras.getInt(VIEW_POSITION);
		}
		
		btnAccept.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Bundle extras = new Bundle();
				extras.putInt(SELECTED_QUANTITY_COLUMN, quantitySelector.getValue());
				extras.putInt(VIEW_POSITION, viewPosition);
				getIntent().putExtras(extras);
				setResult(Activity.RESULT_OK, getIntent());
				finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.quantity_selector_product_check_list,
				menu);
		return true;
	}

}
