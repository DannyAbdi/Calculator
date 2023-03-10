package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


// The structure of this code was inspired by Dave's TDD demo

class TestStack {
  // Test stack used during all tests
  private Stack test;
  // Created multiple Entry instances after amending Stack class to use type Entry instead of
  // Integer
  private Entry two = new Entry(2.0f);
  private Entry four = new Entry(4.0f);
  private Entry five = new Entry(5.0f);
  private Entry ten = new Entry(10.0f);
  private Entry plus = new Entry("+");
  private Entry minus = new Entry("-");

  @BeforeEach
  public void setup() {
    test = new Stack();
  }

  @Test // Test 1
  void testSize() {
    assertEquals(test.size(), 0, "Test a new stack to see if it has size 0.");
  }

  @Test // Test 2 augmented code in Stack class to change parameter of push method from Integer to
  // entry
  void testPush() {
    test.push(four);
    assertEquals(test.size(), 1, "Test a new stack to see if it has size 1 after pushing.");
  }

  @Test // Test 3
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> test.pop(), "You can't pop from an empty stack.");
  }

  @Test // Test 4 augmented code in Stack class to change return type of pop method from Integer to
  // entry
  void pushThenPop() {
    test.push(two);
    assertEquals(test.pop(), two, "Pushing a 2 and then popping it should return 2");
    assertEquals(test.size(), 0,
        "Pushing a 2 and then popping it should result in an empty stack.");
    assertThrows(EmptyStackException.class, () -> test.pop(),
        "Push, pop, pop should throw an exception.");
  }

  @Test // Test 5 changed tests to use Entry parameters rather than Integer
  void pushTwice() {
    test.push(five);
    test.push(ten);
    assertEquals(test.size(), 2, "Pushing twice should give size of 2.");
    assertEquals(test.pop(), ten, "Pushing twice then popping should return the 2nd thing pushed.");
    assertEquals(test.pop(), five, "Popping again should return the 1st thing pushed.");
    assertEquals(test.size(), 0,
        "Pushing an empty stack twice then popping it twice should result in an empty stack.");
    assertThrows(EmptyStackException.class, () -> test.pop(),
        "Popping an empty stack should throw an exception.");
  }

  @Test // Test 6 changed test loop to account for Entry instances rather than Integer values
  // Testing to see if code allows for pushing a high number of entries.
  void pushLots() {
    int i = 0;
    float num = (float) i;
    Entry value = new Entry(num);
    for (i = 0; i < 1000; i++) {
      test.push(value);
      assertEquals(test.size(), i + 1, "Pushing should increase the size.");
    }
  }

  @Test // Test 7
  void testEmptyTop() {
    assertThrows(EmptyStackException.class, () -> test.top(), "You can't top from an empty stack.");
  }

  @Test // Test 8
  void topFunctionality() {
    test.push(four);
    test.push(ten);
    assertEquals(test.top(), ten, "Pushing a 10 then topping should return 10.");
    assertEquals(test.top(), ten, "Topping again should not change the return value.");
  }

  @Test // Test 9
  void testEntryTypes() {
    test.push(plus);
    test.push(minus);
    assertEquals(test.size(), 2, "Pushing 2 values should give a stack size of 2");
    assertEquals(test.pop(), minus,
        "Test to see if other Entry types work with all methods. Should return -");
    assertEquals(test.top(), plus, "Returns +");
    assertEquals(test.size(), 1, "Since topping doesn't reduce stack size, should return 1");
  }
}
