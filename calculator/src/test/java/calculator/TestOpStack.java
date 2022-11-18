package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {
  private OpStack test;

  @BeforeEach
  public void setup() {
    test = new OpStack();
  }

  @Test // Test 1
  public void testisEmpty() {
    assertEquals(test.isEmpty(), true, "Test a new stack to see if it is empty.");
  }

  @Test // Test 2
  public void testNotEmpty() {
    test.push(Symbol.PLUS);
    assertEquals(test.isEmpty(), false,
        "Tests the stack to see if it is empty. Should now return false.");
  }

  @Test // Test 3
  public void pushThenPop() throws BadTypeException {
    test.push(Symbol.DIVIDE);
    assertEquals(test.pop(), Symbol.DIVIDE, "Should return the last entry in stack.");
  }

  @Test // Test 4
  public void testEmptyStackException() {
    assertThrows(EmptyStackException.class, () -> test.pop(),
        "Popping an empty stack should throw an exception.");
  }
}
