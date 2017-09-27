package com.sundar.disastermanagement.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private final String url = "jdbc:mysql://localhost:3306/disaster_management";
	private final String user = "root";
	private final String pass = "";
	private static Connection connection;
	private static DBUtil instance;
	
	private DBUtil(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, pass);
		}catch(Exception e){}
	}
	public static DBUtil getDBUtil()
	{
		instance=new DBUtil();
		return instance;
	}
	public Connection getConnection() throws Exception {
		return connection;
	}
	}
