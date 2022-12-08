package calculator;

import java.util.Arrays;

/**
 * @author danny
 *
 */
public class StandardCalc {
  private OpStack ops = new OpStack();
  private RevPolishCalc rpCalc = new RevPolishCalc();
  String[] operators = {"+", "-", "*", "/", "(", ")"};
  Symbol[] symbols = {Symbol.PLUS, Symbol.MINUS, Symbol.TIMES, Symbol.DIVIDE, Symbol.LEFT_BRACKET,
      Symbol.RIGHT_BRACKET};
  int topPrecedence;

  /**
   * @param what
   * @return
   * @throws BadTypeException
   * @throws InvalidExpressionException
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
          } else if (symbol.getPrecedence() <= ops.top().getPrecedence()) {
            while (symbol.getPrecedence() <= ops.top().getPrecedence()) {
              postfix += ops.pop() + " ";
            }
            ops.push(symbol);
          } else {
            ops.push(symbol);
          }
        }
      }
    }

    while (!ops.isEmpty()) {
      postfix += ops.pop() + "";
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
