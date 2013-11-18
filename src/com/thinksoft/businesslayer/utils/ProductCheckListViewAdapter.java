package com.thinksoft.businesslayer.utils;

import java.util.List;
import java.util.Map;

import com.thinksoft.polapp.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProductCheckListViewAdapter extends BaseAdapter {
	public  List<Map<String, String>> list;
	Activity activity;
    public static final String CODE_COLUMN = "Code";
    public static final String PRICE_COLUMN = "Price";
    public static final String QUANTITY_COLUMN = "Quantity";

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

		ProductViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.product_list_view_row, null);
			holder = new ProductViewHolder();
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
			holder = (ProductViewHolder) convertView.getTag();
		}
		
		Map<String,String> map = list.get(position);

		holder.txtName.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN));
		holder.txtCode.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.CODE_COLUMN));
		holder.txtPrice.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.PRICE_COLUMN));
		holder.txtQuantity.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN));

		   
		return convertView;
	}

}
