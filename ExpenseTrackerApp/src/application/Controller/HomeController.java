package application.Controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HomeController {

	@FXML
	Text welcomeLabel;
	
	public void displayName(String username) {
		welcomeLabel.setText("Welcome: " + username);
	}
}
