package calculator;

public class CalcController {
	private CalcModel model;
	private ViewInterface view;
	private boolean isInfix;

	public void calculate() {
		String userInput = view.getUserInput();
		model.evaluate(userInput, isInfix);
	}
	
	public void expressionType() {
		
	}
}
