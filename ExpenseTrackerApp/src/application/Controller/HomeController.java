package application.Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

	@FXML
	private Button logoutButton;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private FXMLLoader loader;
	
	public void logoutButtonOnAction(ActionEvent event) throws IOException{
		loader = new FXMLLoader(getClass().getResource("../View/Login.fxml"));
		root = loader.load();
		
		stage = (Stage) logoutButton.getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../View/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
}
