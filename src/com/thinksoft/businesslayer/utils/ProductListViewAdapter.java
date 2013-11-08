package com.thinksoft.businesslayer.utils;

import java.util.ArrayList;
import java.util.HashMap;

import com.thinksoft.polapp.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProductListViewAdapter extends BaseAdapter {
	public static final String NAME_COLUNM = "Nombre";
	public static final String CODE_COLUNM = "Código";
	public static final String QUANTITY_COLUNM = "Cantidad";
	public static final String PRICE_COLUNM = "Precio";
	public ArrayList<HashMap<String,String>> list;
	Activity activity;

	public ProductListViewAdapter(Activity activity, ArrayList<HashMap<String,String>> list) {
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

	private class ViewHolder {
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

		HashMap<String,String> map = list.get(position);
		holder.txtName.setText((CharSequence) map.get(NAME_COLUNM));
		holder.txtCode.setText((CharSequence) map.get(CODE_COLUNM));
		holder.txtPrice.setText((CharSequence) map.get(PRICE_COLUNM));
		holder.txtQuantity.setText((CharSequence) map.get(QUANTITY_COLUNM));

		return convertView;
	}
}