package calculator;

import java.util.EmptyStackException;

/**
 * This program creates a stack of floats and can add and remove entries.
 * 
 * @author danny
 *
 */
public class NumStack {
  private Stack numStack;

  /**
   * Constructor for the NumStack class that creates an empty stack.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Adds an entry to the stack.
   * 
   * @param entry The entry added to the stack.
   */
  public void push(float entry) {
    numStack.push(new Entry(entry));
  }

  /**
   * Removes the last element in the stack and returns it.
   * 
   * @return Last element in the stack.
   * @throws BadTypeException    If the value is not a number.
   * @throws EmptyStackException If the stack is empty.
   */
  public float pop() throws BadTypeException {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    }
    return numStack.pop().getValue();
  }

  /**
   * Checks if the stack is empty and returns a boolean.
   * 
   * @return true or false.
   */
  public boolean isEmpty() {
    return numStack.size() == 0;
  }
}
