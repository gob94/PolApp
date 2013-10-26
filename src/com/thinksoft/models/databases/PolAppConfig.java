package com.thinksoft.models.databases;

import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

public class PolAppConfig extends OrmLiteConfigUtil {
		public static void main(String[] args) throws SQLException, IOException {
			writeConfigFile("ormlite_config.txt");
		}
}
