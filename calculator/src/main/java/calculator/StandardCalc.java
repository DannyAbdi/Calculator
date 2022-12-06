package calculator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author danny
 *
 */
public class StandardCalc {
  private OpStack ops = new OpStack();
  private RevPolishCalc rpCalc = new RevPolishCalc();
  String[] operators = {Symbol.PLUS.toString(), Symbol.MINUS.toString(), Symbol.TIMES.toString(),
      Symbol.DIVIDE.toString(), Symbol.LEFT_BRACKET.toString(), Symbol.RIGHT_BRACKET.toString()};
  Symbol[] symbols = {Symbol.PLUS, Symbol.MINUS, Symbol.TIMES, Symbol.DIVIDE, Symbol.LEFT_BRACKET,
      Symbol.RIGHT_BRACKET};
  int topPrecedence;
  String postfix = "";

  /**
   * @param what
   * @return
   * @throws BadTypeException
   * @throws InvalidExpressionException
   */
  public float evaluate(String what) throws BadTypeException, InvalidExpressionException {
    String[] elements = what.split(" ");

    for (String element : elements) {
      try {
        postfix += (Float.parseFloat(element)) + " ";
      } catch (NumberFormatException e) {
        if (Arrays.asList(operators).contains(element)) {
          for (int i = 0; i < operators.length; i++) {
            if (element.equals(operators[i])) {
              if (ops.isEmpty()) {
                ops.push(symbols[i]);
              } else if (symbols[i].getPrecedence() == 3) {
                while (ops.top().getPrecedence() > 0) {
                  postfix += ops.pop() + " ";
                }
                ops.pop();
              } else if (symbols[i].getPrecedence() > ops.top().getPrecedence()) {
                ops.push(symbols[i]);
              } else if (symbols[i].getPrecedence() <= ops.top().getPrecedence()) {
                while (symbols[i].getPrecedence() <= ops.top().getPrecedence()) {
                  postfix += ops.pop() + " ";
                }
                ops.push(symbols[i]);
              } else if (symbols[i].getPrecedence() == ops.top().getPrecedence()) {
                while (symbols[i].getPrecedence() == ops.top().getPrecedence()) {
                  postfix += ops.pop() + " ";
                }
                ops.push(symbols[i]);
              }
            }
          }
        }
      }
    }
    while (!ops.isEmpty()) {
      postfix += ops.pop() + "";
    }
    System.out.println(postfix);
    return rpCalc.evaluate(postfix);
  }
}

