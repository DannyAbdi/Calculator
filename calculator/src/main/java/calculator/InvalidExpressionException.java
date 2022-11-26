package calculator;

public class InvalidExpressionException extends Exception {

  public InvalidExpressionException(String errorMessage) {
    super(errorMessage);
  }
}
