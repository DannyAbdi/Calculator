package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Runs the application.
 * 
 * @author danny
 *
 */
public class Driver {

	/**
	 * Runs the calculator.
	 * 
	 * @param args Command line arguments as an array of String objects.
	 */
	public static void main(String[] args) {
		ViewInterface view = GuiView.getInstance();
		view.menu();
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View.fxml"));
		Scene scene = new Scene(root, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
