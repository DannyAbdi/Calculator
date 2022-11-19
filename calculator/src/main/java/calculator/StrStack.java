package calculator;

import java.util.EmptyStackException;

/**
 * This program creates a stack of strings and can add and remove entries.
 * 
 * @author danny
 *
 */
public class StrStack {
  private Stack strStack;

  /**
   * Constructor for the StrStack class that creates an empty stack.
   */
  public StrStack() {
    strStack = new Stack();
  }

  /**
   * Adds an entry to the stack.
   * 
   * @param entry The entry added to the stack.
   */
  public void push(String entry) {
    strStack.push(new Entry(entry));
  }

  /**
   * Removes the last element in the stack and returns it.
   * 
   * @return Last element in the stack.
   * @throws BadTypeException If the entry is not a string.
   * @throws EmptyStackException If the stack is empty.
   */
  public String pop() throws BadTypeException {
    if (strStack.size() == 0) {
      throw new EmptyStackException();
    }
    return strStack.pop().getString();
  }

  /**
   * Checks if the stack is empty and returns a boolean.
   * 
   * @return true or false.
   */
  public boolean isEmpty() {
    return strStack.size() == 0;
  }
}
