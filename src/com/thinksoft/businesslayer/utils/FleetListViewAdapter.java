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

public class FleetListViewAdapter extends BaseAdapter {

	public  List<Map<String, String>> list;
	Activity activity;
    public static final String LICENCE_COLUMN = "Licence";
    public static final String FUNCTIONAL_COLUMN = "Functional";
    public static final String RTV_COLUMN = "Rtv";
    public static final String EXPEDITURE_COLUMN = "Expediture";
    public static final String MODEL_COLUMN = "Model";
    public static final String BRAND_COLUMN = "Brand";
    
    public FleetListViewAdapter() {
		// TODO Auto-generated constructor stub
	}
    
    
	public FleetListViewAdapter(Activity activity, List<Map<String, String>> list) {
		super();
		this.list = list;
		this.activity = activity;
	}




	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return list.get(pos);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private class ViewHolder {
		TextView txtLicence;
		TextView txtFunctional;
		TextView txtRtv;
		TextView txtExpediture;
		TextView txtModel;
		TextView txtBrand;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.fleet_list_view_row, null);
			holder = new ViewHolder();
			holder.txtLicence = (TextView) convertView
					.findViewById(R.id.LicenceFleetListRow);
			holder.txtRtv = (TextView) convertView
					.findViewById(R.id.RtvFleetListRow);
			holder.txtExpediture = (TextView) convertView
					.findViewById(R.id.ExpenditureFleetListRow);
			holder.txtModel = (TextView) convertView
					.findViewById(R.id.ModelFleetListRow);
			holder.txtBrand = (TextView) convertView
					.findViewById(R.id.BrandFleetListRow);
			holder.txtFunctional = (TextView) convertView
					.findViewById(R.id.FunctionalFleetListRow);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		Map<String,String> map = list.get(position);

		holder.txtLicence.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.LICENCE_COLUMN));
		holder.txtRtv.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.RTV_COLUMN));
		holder.txtExpediture.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.EXPEDITURE_COLUMN));
		holder.txtModel.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.MODEL_COLUMN));
		holder.txtBrand.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.BRAND_COLUMN));
		holder.txtFunctional.setText((CharSequence) map.get(com.thinksoft.businesslayer.utils.constants.RowConstants.FUNCTIONAL_COLUMN));

		   
		return convertView;
	}

}
