package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private Connection databaseLink;
	private static final String databaseName = "projectDB";
	private static final String databaseUser = "root";
	private static final String databasePassword = "Xu.6wu/6cl4";
	private static final String url = "jdbc:mysql://localhost/" + databaseName;
	
	public Connection getConnection() {
		try {
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return databaseLink;
	}
}
