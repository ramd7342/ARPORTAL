package com.ariatech.arportal.admin;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
	private static Connection connection;
	public static Connection getdbconnection() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","root","server");
		return  connection;
	}
}
