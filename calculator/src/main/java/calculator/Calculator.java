package calculator;

/**
 * Interface to ensure every calculator has the evaluate method.
 * 
 * @author danny
 *
 */
public interface Calculator {
  /**
   * Interface for calculator.
   * 
   * @param what The string expression to evaluate.
   * @return The result of the expression.
   * @throws InvalidExpressionException Thrown if there's an error in the string expression.
   */
  float evaluate(String what) throws InvalidExpressionException, BadTypeException;
}
