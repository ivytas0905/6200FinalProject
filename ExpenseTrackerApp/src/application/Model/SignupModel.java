package application.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.DatabaseConnection;

public class SignupModel {
	DatabaseConnection connection = new DatabaseConnection();
	Connection connectDB = connection.getConnection();
	
	public boolean createUser(String firstName, String lastName, String username, String password) {
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
	
	public boolean isUsernameUnique(String username) {
		try {
			String query = "SELECT Count(*) FROM UserAccounts WHERE Username = ?";
			PreparedStatement statement = connectDB.prepareStatement(query);
			statement.setString(1, username);
			ResultSet queryResult = statement.executeQuery();
			if(queryResult.next() && queryResult.getInt(1) == 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
