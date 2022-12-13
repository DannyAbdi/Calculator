package calculator;

/**
 * Declares the type of expression.
 * 
 * @author danny
 *
 */
public enum OpType {
  Infix(true), Postfix(false);

  private boolean opType;

  OpType(boolean opType) {
    this.opType = opType;
  }

  /**
   * Gets the type of the expression.
   * 
   * @return true if infix. false if postfix.
   */
  public boolean getOpType() {
    return this.opType;
  }
}
