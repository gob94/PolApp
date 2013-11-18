package com.thinksoft.businesslayer.utils;

import java.util.List;
import java.util.Map;

import com.thinksoft.polapp.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ProductCheckListViewAdapter extends BaseAdapter {
	public  List<Map<String, String>> list;
	Activity activity;

    public ProductCheckListViewAdapter(Activity activity, List<Map<String, String>> list) {
		super();
		this.activity = activity;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}
	

	
	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ProductCheckViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.product_check_list_view_row, null);
			holder = new ProductCheckViewHolder();
			holder.chkProduct = (CheckBox)convertView.findViewById(R.id.chkProduct);
			holder.txtName = (TextView) convertView
					.findViewById(R.id.NameProductCheckListRow);
			holder.txtCode = (TextView) convertView
					.findViewById(R.id.CodeProductCheckListRow);
			holder.txtQuantity = (TextView) convertView
					.findViewById(R.id.QuantityProductCheckListRow);
			holder.txtPrice = (TextView) convertView
					.findViewById(R.id.PriceProductCheckListRow);
			convertView.setTag(holder);
		} else {
			holder = (ProductCheckViewHolder) convertView.getTag();
		}
		
		Map<String,String> map = list.get(position);
		holder.chkProduct.setChecked(false);
		holder.txtName.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN));
		holder.txtCode.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.CODE_COLUMN));
		holder.txtPrice.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.PRICE_COLUMN));
		holder.txtQuantity.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN));

		   
		return convertView;
	}

}
