package calculator;

/**
 * This program encapsulates calculator inputs from the user.
 * 
 * @author Danny
 *
 */

public class Entry {
  private float number;
  private Symbol other;
  private String str;
  private Type type;

  /**
   * Entry constructor takes a float and initialises it.
   * 
   * @param value A float entry.
   */
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }

  /**
   * Entry constructor takes a Symbol and initialises it.
   * 
   * @param which A Symbol instance.
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * Entry constructor takes a String and initialises it.
   * 
   * @param string A String variable.
   */
  public Entry(String string) {
    this.str = string;
    this.type = Type.STRING;
  }

  /**
   * Getter that accesses the type of the current object.
   * 
   * @return The type of the current object.
   */
  public Type getType() {
    return this.type;
  }

  /**
   * Getter that accesses a string of type enum and returns it.
   * 
   * @return The string value of the type instance.
   * @throws BadTypeException If the value is not a String.
   */
  public String getString() throws BadTypeException {
    if (type != Type.STRING) {
      throw new BadTypeException("Value is not a string");
    }
    return this.str;
  }

  /**
   * Getter that accesses an instance of type Symbol.
   * 
   * @return An instance of type Symbol.
   * @throws BadTypeException If the value is not a symbol.
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type != Type.SYMBOL) {
      throw new BadTypeException("Value is not a symbol");
    }
    return this.other;
  }

  /**
   * Getter that accesses an instance of type Number.
   * 
   * @return An instance of type Number.
   * @throws BadTypeException If the value is not a number.
   */
  public float getValue() throws BadTypeException {
    if (type != Type.NUMBER) {
      throw new BadTypeException("Value is not a float");
    }
    return this.number;
  }

  /**
   * Boolean that checks if the type of the object is invalid.
   * 
   * @return False if the instance is valid. True otherwise.
   */
  public boolean isValid() {
    if (type != Type.STRING && type != Type.NUMBER && type != Type.SYMBOL) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entry [number=" + number + ", other=" + other + ", str=" + str + ", type=" + type + "]";
  }

  @Override
  public int hashCode() {
    int hash = 7648387;
    switch (this.type) {
    case NUMBER:
      return hash += 1193 * number;
    case SYMBOL:
      return hash += 1193 * other.hashCode();
    case STRING:
      return hash += 1193 * str.hashCode();
    default:
      // In this case it doesn't have a type
      return -1;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry o = (Entry) obj;
    if (this.type != o.type) {
      return false;
    }
    switch (this.type) {
    case NUMBER:
      return o.number == number;

    case SYMBOL:
      return o.other == other;

    case STRING:
      return o.str == str;

    default:
      return false;
    }
  }
}
