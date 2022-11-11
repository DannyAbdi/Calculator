package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestEntry {
  private Entry first = new Entry(3.0f);
  private Entry second = new Entry(Symbol.PLUS);
  private Entry third = new Entry("cat");
  private Entry fourth = new Entry(3.0f);
  private Entry fifth = new Entry(3);

  @Test // Test 1
  // Testing getters
  // Changed test to throw a BadTypeException
  void testGetters() throws BadTypeException {
    assertEquals(3.0f, first.getValue(),
        "Tests if getValue correctlt accesses the Entry's float value.");
    assertEquals(Symbol.PLUS, second.getSymbol(),
        "Tests if getSymbol accesses the Entry's symbol.");
    assertEquals("cat", third.getString(), "Tests if getString accesses the Entry's String value.");
  }

  @Test // Test 2
  // Testing to see if the constructors are called correctly
  // Changed getters to check for the type first
  void testConstructor() {
    assertEquals(first.getType(), Type.NUMBER);
    assertEquals(second.getType(), Type.SYMBOL);
    assertEquals(third.getType(), Type.STRING);
  }

  @Test // Test 3
  // Overrided the equals method for tests to pass
  void testEqual() {
    assertEquals(first.equals(fourth), true,
        "2 objects with the same type and value should be equal.");
    assertEquals(first.equals(second), false,
        "Objects with a different type and/or value should not be equal.");
  }

  @Test // Test 4
  void testValid() {
    assertEquals(fifth.isValid(), true, "Tests if an object's type is valid.");
  }

  @Test // Test 5
  // Tests if Entry is printable and in the correct format
  void testPrintable() {
    assertEquals(first.toString(), "Entry [number=3.0, other=null, str=null, type=Number]");
    assertEquals(second.toString(), "Entry [number=0.0, other=+, str=null, type=Symbol]");
    assertEquals(third.toString(), "Entry [number=0.0, other=null, str=cat, type=String]");
  }

  @Test // Test 6
  void testBadTypeException() {
    assertThrows(BadTypeException.class, () -> first.getSymbol(),
        "Throws an exception if wrong type.");
  }

  @Test // Test 7
  // Tests hashCodes for each type
  void testHashCode() {
    assertEquals(first.hashCode(), 7651966);
    assertEquals(second.hashCode(), 505538662);
    assertEquals(third.hashCode(), 124874953);
  }
}
