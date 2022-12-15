package calculator;

/**
 * Interface for view classes.
 * 
 * @author danny
 *
 */
public interface ViewInterface {
	/**
	 * Takes user input.
	 * 
	 * @return The expression as a string.
	 */
	public String getExpression();

	/**
	 * Shows the user the answer.
	 * 
	 * @param str The expression as a string.
	 */
	public void setAnswer(float num);

	/**
	 * Notified if a user has input an expression.
	 * 
	 * @param c Instance of Observer.
	 */
	public void addCalcObserver(Observer c);

	/**
	 * Notifies the type of expression.
	 * 
	 * @param t Instance of Observer.
	 */
	public void addTypeObserver(Observer t);

	/**
	 * Notified if input is reset.
	 * 
	 * @param r Instance of Observer.
	 */

	/**
	 * Menu.
	 */
	public void menu();
	
	public OpType retrieveOpType();

}
