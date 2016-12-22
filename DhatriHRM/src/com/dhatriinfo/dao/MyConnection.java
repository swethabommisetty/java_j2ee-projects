package com.dhatriinfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	private static MyConnection connection=new MyConnection();
	public  Connection connec;
private MyConnection() 
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			connec=DriverManager.getConnection("jdbc:mysql://localhost:3306/swe","root","vaseem");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public static MyConnection getInstance()
{
	return connection;
}
}
