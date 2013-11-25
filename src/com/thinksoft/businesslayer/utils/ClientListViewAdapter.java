package com.thinksoft.businesslayer.utils;

import static com.thinksoft.businesslayer.utils.constants.RowConstants.CLIENT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.FIRST_LASTNAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.SECOND_LASTNAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.STARTING_CLIENT_NUMBER;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.STATUS_COLUMN;

import java.util.List;
import java.util.Map;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.services.QueryService;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.polapp.R;

public class ClientListViewAdapter extends BaseAdapter implements Filterable {
	
	public BusinessManager bussinessLayer = null;
	public List<Map<String,String>> list = null;
	public OrmLiteBaseActivity<PolAppHelper> activity;
	private Drawable imgTrue;
	private Drawable imgFalse;

	public ClientListViewAdapter(OrmLiteBaseActivity<PolAppHelper> activity, List<Map<String, String>> list) {
		super();
		this.activity = activity;
		bussinessLayer = new BusinessManagerImpl(activity.getHelper().getConnectionSource());
		this.list = list;
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
		return Integer.parseInt(list.get(position).get( CLIENT_ID_COLUMN));
	}	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ClientViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();
		imgTrue= activity.getResources().getDrawable(R.drawable.check16px);
		imgFalse= activity.getResources().getDrawable(R.drawable.cancel32px);

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.client_list_view_row, null);
			holder = new ClientViewHolder();
			holder.txtName = (TextView) convertView
					.findViewById(R.id.NameClientListRow);
			holder.txtFirstLastName = (TextView) convertView
					.findViewById(R.id.FirstLastNameClientListRow);
			holder.txtSecondLastName = (TextView) convertView
					.findViewById(R.id.SecondLastNameClientListRow);
			holder.txtStatus = (ImageView) convertView
					.findViewById(R.id.AccountStateClientListRow);
			convertView.setTag(holder);
		} else {
			holder = (ClientViewHolder) convertView.getTag();
		}

		Map<String,String> map = list.get(position);
		holder.clientId = Integer.parseInt(map.get(CLIENT_ID_COLUMN));
		holder.txtName.setText((CharSequence) map.get(NAME_COLUMN));
		holder.txtFirstLastName.setText((CharSequence) map.get(FIRST_LASTNAME_COLUMN));
		holder.txtSecondLastName.setText((CharSequence) map.get(SECOND_LASTNAME_COLUMN));
		if(map.get(STATUS_COLUMN).equalsIgnoreCase("true")){
			holder.txtStatus.setImageDrawable(imgTrue);
		}else{
			holder.txtStatus.setImageDrawable(imgFalse);
		}
		return convertView;
	}

	@Override
	public Filter getFilter() {
		return new Filter() {
			
			@SuppressWarnings("unchecked")
			@Override
			protected void publishResults(CharSequence constraint, FilterResults results) {
				list = (List<Map<String, String>>) results.values;
				notifyDataSetChanged();
			}
			
			@Override
			protected FilterResults performFiltering(CharSequence constraint) {
			  	FilterResults results = new FilterResults();
		        if (constraint == null || constraint.length() == 0) {
		        	list = bussinessLayer.getSpecifiedNumberOfClients(STARTING_CLIENT_NUMBER);
		        	results.values = list;
		            results.count = list.size();
		        } else { 
		        	
		        	String[] wordsToSearch = new QueryService().getWordsToSearch(constraint);
		            List<Map<String, String>> filteredRowItems = bussinessLayer.searchClients(wordsToSearch);
		            if(filteredRowItems==null||filteredRowItems.isEmpty()){
		            	filteredRowItems= bussinessLayer.getSpecifiedNumberOfClients(STARTING_CLIENT_NUMBER);
		            }
		            results.values = filteredRowItems;
		            results.count = filteredRowItems.size();
		        }
		        return results;
			}
		};
	}
	
	
	
}
