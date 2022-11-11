package calculator;

/**
 * This class creates a specific exception for Bad Types. A BadTypeException is thrown when the type
 * is not the expected one.
 * 
 * @author Danny
 *
 */
public class BadTypeException extends Exception {

  /**
   * Calls the super class Exception to initialise the error message.
   * 
   * @param errorMessage The message that prints if a BadTypeException is thrown.
   */
  public BadTypeException(String errorMessage) {
    super(errorMessage);
  }
}
