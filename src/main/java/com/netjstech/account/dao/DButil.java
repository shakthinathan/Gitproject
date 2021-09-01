package com.netjstech.account.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {


	public static Connection getDBConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Employee","postgres","shakthi");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
