package com.thinksoft.businesslayer.utils;

import static com.thinksoft.businesslayer.utils.constants.DatabaseConstants.COLUMN_PRODUCT_CODE;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.thinksoft.polapp.EditarProductosActivity;
import com.thinksoft.polapp.PerfilProductos;

public class ProductViewHolder implements MainListSelectable{
		TextView txtName;
		TextView txtCode;
		TextView txtQuantity;
		TextView txtPrice;
		@Override
		public Intent editItem(Context context) {
			Bundle extras = new Bundle();
			extras.putString(COLUMN_PRODUCT_CODE,  txtCode.getText().toString());
			Intent intent = new Intent(context, EditarProductosActivity.class);
			intent.putExtras(extras);
			return intent;
		}
		@Override
		public Intent delete(Context context) {
			return null;
		}
		@Override
		public Intent viewProfile(Context context) {
			Bundle extras = new Bundle();
			extras.putString(COLUMN_PRODUCT_CODE, txtCode.getText().toString());
			Intent intent = new Intent(context, PerfilProductos.class);
			intent.putExtras(extras);
			return intent;
		}
}
