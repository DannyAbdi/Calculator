package calculator;

import java.util.EmptyStackException;

/**
 * This program creates a stack of symbols and can add and remove entries.
 * 
 * @author danny
 *
 */
public class OpStack {
  private Stack opStack;

  /**
   * Constructor for the OpStack class that creates an empty stack.
   */
  public OpStack() {
    opStack = new Stack();
  }

  /**
   * Adds an entry to the stack.
   * 
   * @param entry The entry added to the stack.
   */
  public void push(Symbol entry) {
    opStack.push(new Entry(entry));
  }
  
  /**
   * Returns the number of symbols.
   * 
   * @return The size of the ArrayList as an Integer.
   */
  public int size() {
    return opStack.size();
  }

  /**
   * Removes the last element in the stack and returns it.
   * 
   * @return Last element in the stack.
   * @throws BadTypeException If the value is not a symbol.
   * @throws EmptyStackException If the stack is empty.
   */
  public Symbol pop() throws BadTypeException {
    if (opStack.size() == 0) {
      throw new EmptyStackException();
    }
    return opStack.pop().getSymbol();
  }
  
  /**
   * Returns the last element in the stack. Throws an EmptyStackException if the stack is empty.
   * 
   * @return The last element in the stack.
   * @throws BadTypeException If the value is not a symbol.
   */
  public Symbol top() throws BadTypeException {
    if (opStack.size() == 0) {
      throw new EmptyStackException();
    }
    return opStack.top().getSymbol();
  }

  /**
   * Checks if the stack is empty and returns a boolean.
   * 
   * @return true or false.
   */
  public boolean isEmpty() {
    return opStack.size() == 0;
  }
}
