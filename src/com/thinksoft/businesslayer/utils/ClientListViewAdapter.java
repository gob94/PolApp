package com.thinksoft.businesslayer.utils;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thinksoft.polapp.R;

public class ClientListViewAdapter extends BaseAdapter {
	public static final String NAME_COLUMN = "Name";
	public static final String FIRST_LASTNAME_COLUMN = "First Last Name";
	public static final String SECOND_LASTNAME_COLUMN = "Second Last Name";
	public static final String ADDRESS_COLUMN = "Address";
	public static final String STATUS_COLUMN = "Status";
	public ArrayList<HashMap<String,String>> list;
	Activity activity;

	public ClientListViewAdapter(Activity activity, ArrayList<HashMap<String,String>> list) {
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
		TextView txtFirstLastName;
		TextView txtSecondLastName;
		TextView txtStatus;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.client_list_view_row, null);
			holder = new ViewHolder();
			holder.txtName = (TextView) convertView
					.findViewById(R.id.NameClientListRow);
			holder.txtFirstLastName = (TextView) convertView
					.findViewById(R.id.FirstLastNameClientListRow);
			holder.txtSecondLastName = (TextView) convertView
					.findViewById(R.id.SecondLastNameClientListRow);
			holder.txtStatus = (TextView) convertView
					.findViewById(R.id.AccountStateClientListRow);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		HashMap<String,String> map = list.get(position);
		holder.txtName.setText((CharSequence) map.get(NAME_COLUMN));
		holder.txtFirstLastName.setText((CharSequence) map.get(FIRST_LASTNAME_COLUMN));
		holder.txtSecondLastName.setText((CharSequence) map.get(SECOND_LASTNAME_COLUMN));
		holder.txtStatus.setText((CharSequence) map.get(STATUS_COLUMN));

		return convertView;
	}
}
