package com.thinksoft.businesslayer.utils;

import static com.thinksoft.businesslayer.utils.constants.RowConstants.ACTUAL_BALANCE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NEXT_PAYMENT_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.ORDER_ID_COLUMN;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thinksoft.polapp.R;

public class OrderListViewAdapter extends BaseAdapter {
	
	
	
	public List<Map<String, String>> list;
	public Activity activity;
	
	
	
	public OrderListViewAdapter(List<Map<String, String>> list,
			Activity activity) {
		super();
		this.list = list;
		this.activity = activity;
	}

	@Override
	public int getCount() {
		if(list==null)
			return 0;
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return Integer.parseInt(list.get(position).get( ORDER_ID_COLUMN));
	}	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		OrderViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.order_list_view_row, null);
			holder = new OrderViewHolder();
			holder.orderId = (TextView) convertView.findViewById(R.id.txtOrderIdOrderListRow);
			holder.clientName = (TextView) convertView.findViewById(R.id.txtClientNameOrderListRow);
			holder.actualBalance = (TextView) convertView
					.findViewById(R.id.txtActualBalanceOrderListRow);
			holder.nextPaymentDate = (TextView) convertView
					.findViewById(R.id.txtNextPaymentOrderListRow);
			
			convertView.setTag(holder);
		} else {
			holder = (OrderViewHolder) convertView.getTag();
		}

		Map<String,String> map = list.get(position);
		holder.orderId.setText((CharSequence) map.get(ORDER_ID_COLUMN));
		holder.clientName.setText((CharSequence) map.get(NAME_COLUMN));
		holder.actualBalance.setText((CharSequence) map.get(ACTUAL_BALANCE_COLUMN));
		holder.nextPaymentDate.setText((CharSequence) map.get(NEXT_PAYMENT_COLUMN));
		return convertView;
	}



}
