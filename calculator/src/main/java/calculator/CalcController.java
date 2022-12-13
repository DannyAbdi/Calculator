package calculator;

/**
 * Controller class that handles interaction between interface and model.
 * 
 * @author danny
 *
 */
public class CalcController {
	private CalcModel model;
	private ViewInterface view;
	private boolean isInfix;
	
	/**
	 * Adds methods as observers.
	 * 
	 * @param m instance of CalcModel.
	 * @param v instance of ViewInterface.
	 */
	public CalcController(CalcModel m, ViewInterface v) {
		this.model = m;
		this.view = v;
		view.addCalcObserver(this::calculate);
		view.addTypeObserver(this::expressionType);
	}

	/**
	 * Takes the user input and evaluates it.
	 */
	public void calculate() {
		String userInput = view.getExpression();
		try {
			model.evaluate(userInput, isInfix);
		} catch (InvalidExpressionException e) {
			e.printStackTrace();
		} catch (BadTypeException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the type of the expression.
	 */
	public void expressionType() {
		view.retrieveOpType().getOpType();
	}
}
