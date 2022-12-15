package calculator;

/**
 * Main class that runs the application.
 * 
 * @author Dave Cohen
 *
 */
public class Driver {

	/**
	 * Runs the calculator.
	 * 
	 * @param args Command line arguments as an array of String objects.
	 */
	public static void main(String[] args) {
		ViewInterface view = new AsciiView();
		CalcModel model = new CalcModel();
		if (System.console() == null) {
			System.out.println("hello");
			view = GuiView.getInstance();
		}
		new CalcController(model, view);
		view.menu();
	}
}
