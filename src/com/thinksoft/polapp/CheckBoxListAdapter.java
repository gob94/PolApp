package com.thinksoft.polapp;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.impl.ProductImpl;

public class CheckBoxListAdapter extends BaseAdapter implements OnClickListener {
	
	
	/** The inflator used to inflate the XML layout */
	private LayoutInflater inflator;
 
	/** A list containing some sample data to show. */
	Product product = new ProductImpl();
	private List<ProductImpl> dataList;
 
	public CheckBoxListAdapter(LayoutInflater inflator) {
		super();
		this.inflator = inflator;
		dataList = new ArrayList();
		
		/**Cargar la lista con la BD**/
	}
	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		// We only create the view if its needed
		if (view == null) {
			view = inflator.inflate(R.layout.activity_check_box_cobros, null);
 
			// Set the click listener for the checkbox
			view.findViewById(R.id.checkBoxCobros).setOnClickListener(this);
		}
 
		SampleDataCobros data = (SampleDataCobros) getItem(position);
 
		// Set the example text and the state of the checkbox
		CheckBox cb = (CheckBox) view.findViewById(R.id.checkBoxCobros);
		cb.setChecked(data.isSelected());
		// We tag the data object to retrieve it on the click listener.
		cb.setTag(data);
 
		TextView tv = (TextView) view.findViewById(R.id.lblCheckBoxCobros);
		tv.setText(data.getName());
 
		return view;
	}

	@Override
	public void onClick(View view) {
		SampleDataCobros data = (SampleDataCobros) view.getTag();
		data.setSelected(((CheckBox) view).isChecked());
	}

}
