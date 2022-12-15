package calculator;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 * This class oversees the interaction between JavaFX and the FXML file.
 * 
 * @author Dave Cohen
 *
 */
public class GuiView extends Application implements ViewInterface {
	@FXML
    private TextField answerField;

    @FXML
    private Label answerLabel;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button calcButton;

    @FXML
    private Label calculatorLabel;

    @FXML
    private TextField inputField;

    @FXML
    private Label inputLabel;

    @FXML
    private Pane mainPane;

    @FXML
    private RadioButton postfixButton;


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
	public static synchronized GuiView getInstance() {
		if (instance == null) {
			GuiView.launch();;
			while (instance == null) {
			}
		}
		return instance;
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		BorderPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("View.fxml"));
		Scene scene = new Scene(pane);
        scene.getStylesheets().add(getClass().getResource("/calculator.css").toExternalForm());
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
		answerField.setText(newTotal);
	}

	/**
	 * Enables the buttons.
	 */
	public void menu() {
		calcButton.setDisable(false);
	}

	@Override
	public String getExpression() {
		return inputField.getText();
	}

	@Override
	public void setAnswer(float num) {
		this.answerField.setText(String.valueOf(num));
	}

	@Override
	public void addCalcObserver(Observer c) {
		calcButton.setOnAction(event -> c.notifyObservers());
	}

	@Override
	public void addTypeObserver(Observer t) {
		postfixButton.setOnAction(event -> t.notifyObservers());

	}

	@Override
	public OpType retrieveOpType() {
		if (postfixButton.isSelected()) {
			return OpType.POSTFIX;
		}
		return OpType.INFIX;
	}
}
