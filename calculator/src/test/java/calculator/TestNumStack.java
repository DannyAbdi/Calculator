package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {
  private NumStack test;

  @BeforeEach
  public void setup() {
    test = new NumStack();
  }

  @Test // Test 1
  void testIsEmpty() {
    assertEquals(test.isEmpty(), true, "Test a new stack to see if it is empty.");
  }

  @Test // Test 2
  void testPush() {
    test.push(10.4f);
    assertEquals(test.isEmpty(), false,
        "Should now return false as 1 entry has been pushed onto the stack.");
  }

  @Test // Test 3
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> test.pop(), "You can't pop from an empty stack.");
  }

  @Test // Test 4
  void pushThenPop() throws BadTypeException {
    test.push(0.5f);
    test.push(9.4f);
    assertEquals(test.isEmpty(), false, "Test if stack with multiple entries is empty.");
    assertEquals(test.pop(), 9.4f, "Should return the last entry in stack.");
    assertEquals(test.isEmpty(), false, "Should still return false as stack is only popped once.");
    assertEquals(test.pop(), 0.5f, "Should return the last entry in stack.");
    assertEquals(test.isEmpty(), true,
        "Should now return true as all entries have been popped from stack.");
  }
}
