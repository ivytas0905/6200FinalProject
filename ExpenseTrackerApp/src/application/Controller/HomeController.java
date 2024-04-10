package application.Controller;

import java.io.IOException;

import application.FXMLUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

	@FXML
	private Button logoutButton;
	
	public void logoutButtonOnAction(ActionEvent event) throws IOException{
		FXMLUtils.loadFXML("View/Login.fxml", logoutButton);
	}
}
