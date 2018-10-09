package com.cg.payroll.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionProvider {
	private static Connection conn;
	public static Connection getDBConnection() {
		try{
			Properties dbProperties = new Properties();
			dbProperties.load(new FileInputStream(new File(".\\resources\\payroll.properties")));
			Class.forName(dbProperties.getProperty("driver"));
			conn=DriverManager.getConnection(dbProperties.getProperty("url"), dbProperties.getProperty("user"), dbProperties.getProperty("password"));
			return conn;
		}catch(IOException e){ e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		return null;
	}
}
