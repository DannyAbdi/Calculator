package calculator;

/**
 * This class declares and prints various types that will be used in the
 * calculator.
 * 
 * @author danny
 *
 */
public enum Type {
  NUMBER("Number"), SYMBOL("Symbol"), STRING("String"), INVALID("Invalid");

  private String type;

  Type(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return this.type;
  }
}
