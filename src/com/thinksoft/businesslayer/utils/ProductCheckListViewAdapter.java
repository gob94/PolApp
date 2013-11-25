package com.thinksoft.businesslayer.utils;

import static com.thinksoft.businesslayer.utils.constants.Constants.SELECTED_FLAG;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.CODE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.NAME_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.PRICE_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.PRODUCT_ID_COLUMN;
import static com.thinksoft.businesslayer.utils.constants.RowConstants.QUANTITY_COLUMN;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.businesslayer.bussinessmanagers.BusinessManager;
import com.thinksoft.businesslayer.bussinessmanagers.impl.BusinessManagerImpl;
import com.thinksoft.businesslayer.utils.services.QueryService;
import com.thinksoft.models.databases.PolAppHelper;
import com.thinksoft.polapp.R;

public class ProductCheckListViewAdapter extends BaseAdapter implements Filterable{
	public  List<Map<String, String>> list;
	public  List<Integer> checkedList;
	public BusinessManager bussinessLayer = null;
	OrmLiteBaseActivity<PolAppHelper> activity;

    public ProductCheckListViewAdapter(OrmLiteBaseActivity<PolAppHelper> activity, List<Map<String, String>> list) {
		super();
		this.activity = activity;
		this.list = list;
		checkedList = new ArrayList<Integer>();
		Log.i("list", String.valueOf(checkedList.size()));

		Log.i("list", String.valueOf(list.size()));
		for (Map<String, String> map : list) {
			if(map.get(SELECTED_FLAG)!=null){
				checkedList.add(Integer.valueOf(map.get(PRODUCT_ID_COLUMN)));
			}
		}

		Log.i("list", String.valueOf(checkedList.size()));

		Log.i("list", String.valueOf(list.size()));
		bussinessLayer = new BusinessManagerImpl(activity.getHelper().getConnectionSource());
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
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

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
		holder.chkProduct.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View checkBox) {
				CheckBox check = (CheckBox)checkBox;
				if(check.isChecked()){
					checkedList.add(Integer.valueOf(list.get(position).get(PRODUCT_ID_COLUMN)));
				}else{
					checkedList.remove(Integer.valueOf(list.get(position).get(PRODUCT_ID_COLUMN)));
				}
			}
		});
		
		if(checkedList.contains(Integer.valueOf(map.get(PRODUCT_ID_COLUMN)))){
			holder.chkProduct.setChecked(true);
		}else{
			holder.chkProduct.setChecked(false);
		}
		holder.txtName.setText((CharSequence) map.get(NAME_COLUMN));
		holder.txtCode.setText((CharSequence) map.get(CODE_COLUMN));
		holder.txtPrice.setText((CharSequence) map.get(PRICE_COLUMN));
		holder.txtQuantity.setText((CharSequence) map.get(QUANTITY_COLUMN));

		   
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
		        	List<Map<String,String>> products = bussinessLayer.getAllProducts();
		        	results.values = products;
		            results.count = products.size();
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
