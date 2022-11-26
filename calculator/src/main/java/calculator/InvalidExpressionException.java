package calculator;

/**
 * This class creates an exception for invalid string expressions. It is thrown when certain
 * conditions are not met in RevPolishCalc.
 * 
 * @author danny
 *
 */
public class InvalidExpressionException extends Exception {

  /**
   * Calls the super class Exception to initialise the error message.
   * 
   * @param errorMessage The message that prints if an InvalidExpressionException is thrown.
   */
  public InvalidExpressionException(String errorMessage) {
    super(errorMessage);
  }
}
