package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This program creates a stack and can add and remove entries stored in an
 * ArrayList.
 * 
 * @author Danny
 * 
 */
public class Stack {
  private int size;
  private ArrayList<Entry> entries;

  /**
   * Creates an empty stack.
   */
  public Stack() {
    size = 0;
    entries = new ArrayList<Entry>();
  }

  /**
   * Returns the number of entries.
   * 
   * @return The size of the ArrayList as an Integer.
   */
  public int size() {
    return entries.size();
  }

  /**
   * Adds an entry to the stack and increments the size by 1.
   * 
   * @param entry The entry added to the ArrayList.
   */
  public void push(Entry entry) {
    entries.add(entry);
    size++;
  }

  /**
   * Removes the last element in the stack and returns it. Throws an
   * EmptyStackException if the stack is empty. Reduces the value of size by 1.
   * 
   * @return The last element of the ArrayList.
   */
  public Entry pop() {
    if (entries.isEmpty()) {
      throw new EmptyStackException();
    }
    size--;
    return entries.remove(size);
  }

  /**
   * Returns the last element in the stack. Throws an EmptyStackException if the
   * stack is empty.
   * 
   * @return The last element of the ArrayList.
   */
  public Entry top() {
    if (entries.isEmpty()) {
      throw new EmptyStackException();
    }
    return entries.get(size - 1);
  }
}
