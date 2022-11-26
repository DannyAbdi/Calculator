package calculator;

import java.util.Arrays;

/**
 * A calculator that can evaluate Reverse Polish string expressions (postfix) by creating smaller
 * sub-expressions and adding the result back to the stack. Approach taken from geeksforgeeks.
 * 
 * @see "https://www.geeksforgeeks.org/evaluate-the-value-of-an-arithmetic-expression-in-reverse-polish-notation-in-java/"
 *
 * @author danny
 *
 */
public class RevPolishCalc {
  private NumStack values = new NumStack();
  private float result;

  /**
   * Evaluates the expression by splitting the string into elements in an array. Iterates through
   * each element and pops the stack twice if the current element is an operator. Then a
   * sub-expression is formed using the 2 numbers and operator. The result is pushed back onto the
   * stack and the process repeats until there are no more elements in the array.
   * 
   * @param what The string expression to evaluate.
   * @return The result of the expression as a float.
   * @throws BadTypeException Thrown if value is not a number.
   * @throws InvalidExpressionException Thrown if there's an error in the string expression.
   */
  public float evaluate(String what) throws BadTypeException, InvalidExpressionException {
    String[] elements = what.split(" ");
    String[] operators = {"+", "-", "*", "/"};

    if (what.isEmpty()) {
      throw new InvalidExpressionException("Cannot evaulate an empty string.");
    } else if (what.contains("(") || what.contains(")")) {
      throw new InvalidExpressionException("Invalid format.");
    } else if (elements.length < 3) {
      throw new InvalidExpressionException("Expression is too short to evaluate.");
    }

    for (String element : elements) {
      if (Arrays.asList(operators).contains(element)) {
        float right = values.pop();
        float left = values.pop();

        switch (element) {
          case "+":
            result = left + right;
            break;
          case "-":
            result = left - right;
            break;
          case "*":
            result = left * right;
            break;
          case "/":
            if (right == 0f) {
              throw new InvalidExpressionException("Cannot divide by 0.");
            }
            result = left / right;
            break;
          default:
            throw new InvalidExpressionException("Invalid operator.");
        }
        values.push(result);
      } else {
        try {
          values.push(Float.parseFloat(element));
        } catch (NumberFormatException e) {
          throw new InvalidExpressionException("Not a number.");
        }
      }
    }
    return result;
  }
}
