package com.thinksoft.models.databases;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.thinksoft.models.dtos.impl.AddressImpl;
import com.thinksoft.models.dtos.impl.BrandImpl;
import com.thinksoft.models.dtos.impl.ClientImpl;
import com.thinksoft.models.dtos.impl.EmployeeImpl;
import com.thinksoft.models.dtos.impl.OrderImpl;
import com.thinksoft.models.dtos.impl.PaymentFrequencyImpl;
import com.thinksoft.models.dtos.impl.PaymentImpl;
import com.thinksoft.models.dtos.impl.ProductImpl;
import com.thinksoft.models.dtos.impl.ProductOrderImpl;
import com.thinksoft.models.dtos.impl.UserImpl;
import com.thinksoft.models.dtos.impl.VehicleImpl;
import com.thinksoft.polapp.R;

public class PolAppHelper extends OrmLiteSqliteOpenHelper {
	private static final String DATABASE_NAME = "PolApp.db";
	private static final int DATABASE_VERSION = 1;
	
	
	public PolAppHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
	}
	@Override
	public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, AddressImpl.class);
			TableUtils.createTable(connectionSource, BrandImpl.class);
			TableUtils.createTable(connectionSource, ClientImpl.class);
			TableUtils.createTable(connectionSource, VehicleImpl.class);
			TableUtils.createTable(connectionSource, EmployeeImpl.class);
		 	TableUtils.createTable(connectionSource, PaymentFrequencyImpl.class);
			TableUtils.createTable(connectionSource, ProductImpl.class);
			TableUtils.createTable(connectionSource, UserImpl.class);
			TableUtils.createTable(connectionSource, OrderImpl.class);
			TableUtils.createTable(connectionSource, ProductOrderImpl.class);
			TableUtils.createTable(connectionSource, PaymentImpl.class);
		} catch (SQLException e) {
			Log.e(PolAppHelper.class.getName(), "Unable to create datbases", e);
		}
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int arg2,
			int arg3) {
		try {
			TableUtils.createTable(connectionSource, UserImpl.class);
			TableUtils.createTable(connectionSource, AddressImpl.class);
			TableUtils.createTable(connectionSource, ClientImpl.class);
			TableUtils.createTable(connectionSource, ProductImpl.class);
			TableUtils.createTable(connectionSource, BrandImpl.class);
			TableUtils.createTable(connectionSource, PaymentFrequencyImpl.class);
			TableUtils.createTable(connectionSource, VehicleImpl.class);
			TableUtils.createTable(connectionSource, EmployeeImpl.class);
			TableUtils.createTable(connectionSource, OrderImpl.class);
			TableUtils.createTable(connectionSource, ProductOrderImpl.class);
			TableUtils.createTable(connectionSource, PaymentImpl.class);
		} catch (SQLException e) {
			Log.e(PolAppHelper.class.getName(), "Unable to create datbases", e);
		}
		
	}
}
