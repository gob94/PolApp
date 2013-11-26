package com.thinksoft.businesslayer.utils;

import java.util.List;
import java.util.Map;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.thinksoft.models.databases.PolAppHelper;

public class PaymentFrequencySpinnerAdapter extends BaseAdapter implements SpinnerAdapter{
    /**
     * The internal data (the ArrayList with the Objects).
     */
    private final List<Map<String,String>> data;

	private OrmLiteBaseActivity<PolAppHelper> activity;
    public PaymentFrequencySpinnerAdapter(OrmLiteBaseActivity<PolAppHelper> activity, List<Map<String,String>> data){
        this.data = data;
        this.activity = activity;
    }

    /**
     * Returns the Size of the ArrayList
     */
    @Override
    public int getCount() {
        return data.size();
    }

    /**
     * Returns one Element of the ArrayList
     * at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    /**
     * Returns the View that is shown when a element was
     * selected.
     */
    @Override
    public View getView(int position, View recycle, ViewGroup parent) {
        TextView text;
        if (recycle != null){
            // Re-use the recycled view here!
            text = (TextView) recycle;
        } else {
            // No recycled view, inflate the "original" from the platform:
            text = (TextView)  activity.getLayoutInflater().inflate( android.R.layout.simple_spinner_item, parent, false);
        }
        Map<String, String> map = data.get(position);
        text.setText(map.get("Payment_Name"));
        text.setTag(map.get("Payment_ID"));
        return text;
    }


	}
