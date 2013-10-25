package com.thinksoft.models.databases;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.thinksoft.models.dtos.impl.*;

public class PolAppHelper extends OrmLiteSqliteOpenHelper {
	private static final String DATABASE_NAME = "PolApp.db";
	private static final int DATABASE_VERSION = 1;
	
	
	public PolAppHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Address.class);
			TableUtils.createTable(connectionSource, Brand.class);
			TableUtils.createTable(connectionSource, Client.class);
			TableUtils.createTable(connectionSource, Vehicle.class);
			TableUtils.createTable(connectionSource, Employee.class);
			TableUtils.createTable(connectionSource, PaymentFrequency.class);
			TableUtils.createTable(connectionSource, Product.class);
			TableUtils.createTable(connectionSource, User.class);
			TableUtils.createTable(connectionSource, ClientAddress.class);
			TableUtils.createTable(connectionSource, Order.class);
			TableUtils.createTable(connectionSource, ProductOrder.class);
			TableUtils.createTable(connectionSource, Payment.class);
		} catch (SQLException e) {
			Log.e(PolAppHelper.class.getName(), "Unable to create datbases", e);
		}
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int arg2,
			int arg3) {
		try {
			TableUtils.createTable(connectionSource, User.class);
			TableUtils.createTable(connectionSource, Address.class);
			TableUtils.createTable(connectionSource, Client.class);
			TableUtils.createTable(connectionSource, Product.class);
			TableUtils.createTable(connectionSource, Brand.class);
			TableUtils.createTable(connectionSource, PaymentFrequency.class);
			TableUtils.createTable(connectionSource, Vehicle.class);
			TableUtils.createTable(connectionSource, Employee.class);
			TableUtils.createTable(connectionSource, ClientAddress.class);
			TableUtils.createTable(connectionSource, Order.class);
			TableUtils.createTable(connectionSource, ProductOrder.class);
			TableUtils.createTable(connectionSource, Payment.class);
		} catch (SQLException e) {
			Log.e(PolAppHelper.class.getName(), "Unable to create datbases", e);
		}
		
	}
}
