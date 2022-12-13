package calculator;

/**
 * Allows both calculators to integrate with user interface.
 * 
 * @author danny
 *
 */
public class CalcModel {
  private Calculator revPolish;
  private Calculator standard;

  /**
   * Evaluates the expression by checking if it is infix or not. If infix, the
   * standard calculator is used to evaluate. Otherwise RevPolishCalc is used.
   * 
   * @param expression The string expression to evaluate.
   * @param infix      Boolean that checks if expression is infix or not.
   * @return The result of the expression.
   * @throws InvalidExpressionException Thrown if there's an error in the string
   *                                    expression.
   * @throws BadTypeException           Thrown if value was wrong type.
   */
  public float evaluate(String expression, boolean infix) 
      throws InvalidExpressionException, BadTypeException {
    if (infix) {
      return standard.evaluate(expression);
    } else {
      return revPolish.evaluate(expression);
    }
  }
}
