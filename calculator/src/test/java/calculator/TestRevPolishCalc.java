package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  private RevPolishCalc calc;

  @BeforeEach
  public void setup() {
    calc = new RevPolishCalc();
  }

  @Test // Test 1 Checking to see if various errors are handled correctly.
  public void testInvalid() {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate(""));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("(2 + 2) * 3"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("2 +"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("2 0 /"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("2 2 n"));
  }

  @Test // Test 2
  public void testSimpleExpressions() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("3 2 +"), 5f, "Expression should evaluate to 4.");
    assertEquals(calc.evaluate("3 1 -"), 2f, "Expression should evaluate to 2.");
    assertEquals(calc.evaluate("5 2 *"), 10f, "Expression should evaluate to 10.");
    assertEquals(calc.evaluate("6 3 /"), 2f, "Expression should evaluate to 2.");
  }

  @Test // Test 3
  public void testComplexExpressions() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("8 3 7 + / 4 -"), -3.2f, "Expression should evaluate to -3.2.");
    assertEquals(calc.evaluate("4 7 * 5 / 4 2 - *"), 11.2f, "Expression should evaluate to 11.2.");
    assertEquals(calc.evaluate("9.3 42.1 * 27 3 / -"), 382.53f,
        "Expression should evaluate to 382.53.");
  }
}
