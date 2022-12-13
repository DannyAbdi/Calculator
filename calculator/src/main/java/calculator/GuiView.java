package calculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class oversees the interaction between JavaFX and the FXML file.
 * 
 * @author Dave Cohen
 *
 */
public class GuiView extends Application {
  @FXML
  private TextField inputField;
  @FXML
  private TextField totalField;
  @FXML
  private Button calcButton = null;
  @FXML
  private Button resetButton = null;

  private static GuiView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * Returns an instance of GuiView.
   * 
   * @return instance.
   */
  public synchronized GuiView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(GuiView.class)).start();

      while (instance == null) {
      }
    }

    return instance;
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    GridPane page = (GridPane) FXMLLoader.load(GuiView.class.getResource("View.fxml"));
    Scene scene = new Scene(page);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("Calculator");
    primaryStage.show();
  }

  /**
   * Gets the user input.
   * 
   * @return The expression as a string.
   */
  public String getUserInput() {
    return inputField.getText();
  }

  /**
   * Sets the result of the expression.
   * 
   * @param newTotal The result.
   */
  public void setTotal(String newTotal) {
    totalField.setText(newTotal);
  }

  /**
   * Enables the buttons.
   */
  public void menu() {
    calcButton.setDisable(false);
    resetButton.setDisable(false);
  }
}
