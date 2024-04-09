package application.Controller;

import java.io.IOException;

import application.Model.LoginModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController {
	
	@FXML
	private TextField nameTextfield;
	
	@FXML
	private PasswordField passwordTextfield;
	
	@FXML
	private Button loginButton;
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private Button signupButton;
	
	@FXML
	private Label loginMessage;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private FXMLLoader loader;
	
	private LoginModel loginModel = new LoginModel();
	
	public void loginButtonOnAction(ActionEvent event) throws IOException{
		if (nameTextfield.getText().isBlank() == false && passwordTextfield.getText().isBlank() == false) {
			String username = nameTextfield.getText();
			String password = passwordTextfield.getText();
			boolean isValid = loginModel.validateLogin(username, password);
			
			if(isValid) {
				switchToHome(username);
			} else {
				loginMessage.setText("Invalid Login. Please try again");
			}
		} else {
			loginMessage.setText("Please enter Username and Password");
		}
	}
	
	public void cancelButtonOnAction(ActionEvent event) {
		stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
	
	public void signupButtonOnAction(ActionEvent event) throws IOException{
		loader = new FXMLLoader(getClass().getResource("../View/Signup.fxml"));
		root = loader.load();
		
		stage = (Stage) signupButton.getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../View/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToHome(String username) throws IOException{
		loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
		root = loader.load();
		
		stage = (Stage) loginButton.getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../View/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
//	public void validateLogin() {
//		DatabaseConnection connection = new DatabaseConnection();
//		Connection connectDB = connection.getConnection();
//		
//		String verifyLogin = "SELECT count(1) FROM UserAccounts WHERE Username = '" + nameTextfield.getText() + "' AND Password = '" + passwordTextfield.getText() + "'";
//		
//		try {
//			Statement statement = connectDB.createStatement();
//			ResultSet queryResult = statement.executeQuery(verifyLogin);
//			
//			while(queryResult.next()) {
//				if(queryResult.getInt(1) == 1) {
//					String username = nameTextfield.getText();
//					
//					loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
//					root = loader.load();
//					
//					HomeController homeController = loader.getController();
//					homeController.displayName(username);
//
//					stage = (Stage) loginButton.getScene().getWindow();
//					scene = new Scene(root);
//					stage.setScene(scene);
//					stage.show();
//				}else {
//					loginMessage.setText("Invalid Login. Please try again");
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
