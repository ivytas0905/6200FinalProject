package application.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.DatabaseConnection;

public class SignupModel {
	public boolean createUser(String firstName, String lastName, String username, String password) {
		DatabaseConnection connection = new DatabaseConnection();
		Connection connectDB = connection.getConnection();
		try {
			String insertQuery = "INSERT INTO UserAccounts (FirstName, LastName, Username, Password) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connectDB.prepareStatement(insertQuery);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, username);
			statement.setString(4, password);
			int rowInserted = statement.executeUpdate();
			connectDB.close();
			
			if(rowInserted > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
