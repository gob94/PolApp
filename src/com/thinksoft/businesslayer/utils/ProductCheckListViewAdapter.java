package com.thinksoft.businesslayer.utils;

import java.util.List;
import java.util.Map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.utils.services.QueryService;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.polapp.R;

public class ProductCheckListViewAdapter extends BaseAdapter implements Filterable{
	public  List<Map<String, String>> list;
	public  List<Map<String, String>> checkedList;
	public BusinessManager bussinessLayer = null;
	OrmLiteBaseActivity<PolAppHelper> activity;

    public ProductCheckListViewAdapter(OrmLiteBaseActivity<PolAppHelper> activity, List<Map<String, String>> list) {
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
		        	bussinessLayer.getAllProducts();
		        } else { 
		        	
		        	String[] wordsToSearch =  new QueryService().getWordsToSearch(constraint);
		            List<Map<String, String>> filteredRowItems = bussinessLayer.searchProducts(wordsToSearch);
		            if(filteredRowItems==null||filteredRowItems.isEmpty()){
		            	filteredRowItems= bussinessLayer.getAllProducts();
		            }
		            results.values = filteredRowItems;
		            results.count = filteredRowItems.size();
		        }
		        return results;
			}
		};
	}

}
