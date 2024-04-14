package application.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SignupModel {
	private static final String USER_ACCOUNTS_FILE = "user.txt";

    public boolean createUser(String firstName, String lastName, String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_ACCOUNTS_FILE, true))) {
            String userAccountInfo = String.format("%s,%s,%s,%s", firstName, lastName, username, password);
            writer.write(userAccountInfo);
            writer.newLine(); //change to next line to write the new data
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isUsernameUnique(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_ACCOUNTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String storedUsername = parts[2]; // Username is at index 2
                if (storedUsername.equals(username)) {
                    return false; // Username already exists
                }
            }
            
            return true; // Username is unique
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
