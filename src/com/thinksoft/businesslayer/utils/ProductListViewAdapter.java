package com.thinksoft.businesslayer.utils;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thinksoft.polapp.R;

public class ProductListViewAdapter extends BaseAdapter {
	public  List<Map<String, String>> list;
	Activity activity;
    public static final String CODE_COLUMN = "Code";
    public static final String PRICE_COLUMN = "Price";
    public static final String QUANTITY_COLUMN = "Quantity";

    public ProductListViewAdapter(Activity activity, List<Map<String, String>> list2) {
		super();
		this.activity = activity;
		this.list = list2;
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

	public class ViewHolder {
		TextView txtName;
		TextView txtCode;
		TextView txtQuantity;
		TextView txtPrice;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.product_list_view_row, null);
			holder = new ViewHolder();
			holder.txtName = (TextView) convertView
					.findViewById(R.id.NameProductListRow);
			holder.txtCode = (TextView) convertView
					.findViewById(R.id.CodeProductListRow);
			holder.txtQuantity = (TextView) convertView
					.findViewById(R.id.QuantityProductListRow);
			holder.txtPrice = (TextView) convertView
					.findViewById(R.id.PriceProductListRow);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		Map<String,String> map = list.get(position);

		holder.txtName.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN));
		holder.txtCode.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.CODE_COLUMN));
		holder.txtPrice.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.PRICE_COLUMN));
		holder.txtQuantity.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN));

		   
		return convertView;
	}
	
}