package application.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.DatabaseConnection;

public class LoginModel {
	public boolean validateLogin(String username, String password) {
		DatabaseConnection connection = new DatabaseConnection();
		Connection connectDB = connection.getConnection();
		try {
			String verifyLogin = "SELECT count(1) FROM UserAccounts WHERE Username = ? AND Password = ?";
			PreparedStatement statement = connectDB.prepareStatement(verifyLogin);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet queryResult = statement.executeQuery();
			if(queryResult.next() && queryResult.getInt(1) == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
