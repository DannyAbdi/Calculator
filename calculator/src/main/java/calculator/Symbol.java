package calculator;

/**
 * This class declares and prints various symbols that will be used in the
 * calculator.
 * 
 * @author Danny
 *
 */
public enum Symbol {
  LEFT_BRACKET("(", 0), RIGHT_BRACKET(")", 3), TIMES("*", 2), DIVIDE("/", 2), PLUS("+", 1), 
  MINUS("-", 1),
  INVALID("Invalid");

  private String symbol;
  private int precedence;

  Symbol(String symbol) {
    this.symbol = symbol;
  }

  Symbol(String symbol, int precedence) {
    this.symbol = symbol;
    this.precedence = precedence;
  }

  /**
   * Getter that accesses the precedence of a symbol.
   * 
   * @return The precedence.
   */
  public int getPrecedence() {
    return this.precedence;
  }

  @Override
  public String toString() {
    return this.symbol;
  }
}
