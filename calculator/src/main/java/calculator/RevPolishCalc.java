package calculator;

import java.util.Arrays;

public class RevPolishCalc {
  private NumStack values = new NumStack();
  private float result;

  public float evaluate(String what) throws BadTypeException, InvalidExpressionException {
    String[] elements = what.split(" ");
    String[] operators = {"+", "-", "*", "/"};
    if (what.isEmpty()) {
      throw new InvalidExpressionException("Cannot evaulate an empty string.");
    } else if (what.contains("(") || what.contains(")")) {
      throw new InvalidExpressionException("Invalid format.");
    } else if (what.length() < 3) {
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
        values.push(Float.parseFloat(element));
      }
    }
    return result;
  }
}

// what = "2 2 +"
// becomes "2 + 2"
// returns 2 + 2

// create array of strings that splits input when there is a space
// loop the contents of the array
// if value is operator, pop both previous values from stack and calculate result
// else push onto stack
// return final calculation
