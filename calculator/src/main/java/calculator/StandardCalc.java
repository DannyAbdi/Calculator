package calculator;

import java.util.Arrays;

/**
 * A calculator that can evaluate infix string expressions by turning it into
 * postfix and passing the new string into RevPolishCalc. Approach taken from
 * the Shunting Yard Algorithm.
 * 
 * @author danny
 *
 */
public class StandardCalc {
  private OpStack ops = new OpStack();
  private RevPolishCalc rpCalc = new RevPolishCalc();
  String[] operators = { "+", "-", "*", "/", "(", ")" };
  Symbol[] symbols = { Symbol.PLUS, Symbol.MINUS, Symbol.TIMES, Symbol.DIVIDE, Symbol.LEFT_BRACKET,
      Symbol.RIGHT_BRACKET };
  int topPrecedence;

  /**
   * Evaluates the expression by splitting the string into elements in an array.
   * Iterates through each element. If element is a number, element is added to
   * the new postfix expression. Otherwise, each element undergoes various
   * condition checks to compare the precedence with the topmost symbol in the
   * stack according to the Shunting Yard algorithm. The operators are then popped
   * and appended to the postfix string which is passed as the argument in
   * RevPolishCalc.
   * 
   * @param what The infix string expression to evaluate.
   * @return The result of the expression as a float.
   * @throws BadTypeException           Thrown if value is not a number.
   * @throws InvalidExpressionException Thrown if there's an error in the string
   *                                    expression.
   */
  public float evaluate(String what) throws BadTypeException, InvalidExpressionException {
    String[] elements = what.split(" ");
    String postfix = "";
    for (String element : elements) {
      try {
        postfix += (Float.parseFloat(element)) + " ";
      } catch (NumberFormatException e) {
        if (Arrays.asList(operators).contains(element)) {
          Symbol symbol = toSymbol(element);
          if (ops.isEmpty()) {
            ops.push(symbol);
          } else if (symbol == Symbol.LEFT_BRACKET) {
            ops.push(symbol);
          } else if (symbol == Symbol.RIGHT_BRACKET) {
            while (ops.top().getPrecedence() > 0) {
              postfix += ops.pop() + " ";
            }
            ops.pop();
          } else if (!ops.isEmpty() && symbol.getPrecedence() <= ops.top().getPrecedence()) {
            while (!ops.isEmpty() && symbol.getPrecedence() <= ops.top().getPrecedence()) {
              postfix += ops.pop() + " ";
            }
            ops.push(symbol);
          } else {
            ops.push(symbol);
          }
        } else {
          throw new InvalidExpressionException("Expression contains invalid symbol.");
        }
      }
    }

    if (!ops.isEmpty()) {
      while (ops.size() > 1) {
        postfix += ops.pop() + " ";
      }
      postfix += ops.pop();
    }
    return rpCalc.evaluate(postfix);
  }

  private Symbol toSymbol(String expression) {
    switch (expression) {
      case "+":
        return Symbol.PLUS;
      case "-":
        return Symbol.MINUS;
      case "*":
        return Symbol.TIMES;
      case "/":
        return Symbol.DIVIDE;
      case "(":
        return Symbol.LEFT_BRACKET;
      case ")":
        return Symbol.RIGHT_BRACKET;
      default:
        return Symbol.INVALID;
    }
  }
}
