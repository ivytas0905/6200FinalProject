package application.Controller;

import java.io.IOException;

import application.Model.SignupModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController {
	
	@FXML
	private TextField firstNameField;
	
	@FXML
	private TextField lastNameField;
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private Label signupMessage;
	
	@FXML
	private Button previousButton;
	
	@FXML
	private Button signupConfirmBtn;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private FXMLLoader loader;
	
	private SignupModel signModel = new SignupModel();
	
	public void signupButtonOnAction(ActionEvent event) throws IOException{
		if (firstNameField.getText().isBlank() == false && lastNameField.getText().isBlank() == false
			&& usernameField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String username = usernameField.getText();
			String password = passwordField.getText();
			boolean success = signModel.createUser(firstName, lastName, username, password);
			
			if(success) {
				signupMessage.setText("Account created successfully");
			} else {
				signupMessage.setText("Account created unsuccessfully");
			}
		} else {
			signupMessage.setText("Please fill the informations above");
		}
	}
	
	public void previousButtonOnAction(ActionEvent event) throws IOException{
		loader = new FXMLLoader(getClass().getResource("../View/Login.fxml"));
		root = loader.load();
		
		stage = (Stage) previousButton.getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../View/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
}
