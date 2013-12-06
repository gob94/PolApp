package com.thinksoft.businesslayer.utils;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.imgFalse;
import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.imgTrue;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.BRAND_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.FUNCTIONAL_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.LICENCE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.MODEL_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.RTV_COLUMN;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thinksoft.polapp.R;

public class FleetListViewAdapter extends BaseAdapter {

	public  List<Map<String, String>> list;
	Activity activity;
    
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


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		FleetViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();
		imgTrue= activity.getResources().getDrawable(R.drawable.check16listview);
		imgFalse= activity.getResources().getDrawable(R.drawable.cancel16listview);
		
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.fleet_list_view_row, null);
			holder = new FleetViewHolder();
			holder.txtLicence = (TextView) convertView
					.findViewById(R.id.LicenceFleetListRow);
			holder.txtRtv = (TextView) convertView
					.findViewById(R.id.RtvFleetListRow);
			holder.txtModel = (TextView) convertView
					.findViewById(R.id.ModelFleetListRow);
			holder.txtBrand = (TextView) convertView
					.findViewById(R.id.BrandFleetListRow);
			holder.txtFunctional = (ImageView) convertView
					.findViewById(R.id.FunctionalFleetListRow);
			convertView.setTag(holder);
		} else {
			holder = (FleetViewHolder) convertView.getTag();
		}
		
		Map<String,String> map = list.get(position);
		
		holder.txtLicence.setText((CharSequence) map.get(LICENCE_COLUMN));
		holder.txtRtv.setText((CharSequence) map.get(RTV_COLUMN));
		holder.txtModel.setText((CharSequence) map.get(MODEL_COLUMN));
		holder.txtBrand.setText((CharSequence) map.get(BRAND_COLUMN));
		
		if(map.get(FUNCTIONAL_COLUMN).equalsIgnoreCase("true")){
			holder.txtFunctional.setImageDrawable(imgTrue);
		}else{
			holder.txtFunctional.setImageDrawable(imgFalse);
		}

		
		return convertView;
	}

}
