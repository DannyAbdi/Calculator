package calculator;

/**
 * This class declares and prints various symbols that will be used in the calculator.
 * 
 * @author Danny
 *
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "Invalid");

  private String symbol;

  Symbol(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return this.symbol;
  }
}
