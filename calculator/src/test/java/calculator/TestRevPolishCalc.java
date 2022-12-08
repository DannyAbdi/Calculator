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
  public void testAdd() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("1 2 +"), 3f);
    assertEquals(calc.evaluate("27 13 +"), 40f);
    assertEquals(calc.evaluate("2 2 + 2 + 2 +"), 8f);
    assertEquals(calc.evaluate("1 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 +"), 45f);
  }

  @Test // Test 3
  public void testSubtract() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("3 2 -"), 1f);
    assertEquals(calc.evaluate("33 1 - 1 - 4 - 6 - 8 -"), 13f);
    assertEquals(calc.evaluate("128 1009 -"), -881f);
    assertEquals(calc.evaluate("3 3 - 3 - 3 - 3 - 3 -"), -12f);
  }

  @Test // Test 4
  public void testMultiply() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("4 7 *"), 28f);
    assertEquals(calc.evaluate("2 12 * 4 * 9 *"), 864f);
    assertEquals(calc.evaluate("4 4 * 4 * 4 * 4 *"), 1024f);
    assertEquals(calc.evaluate("1000 3278 *"), 3278000f);
  }

  @Test // Test 5
  public void testDivide() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("9 3 /"), 3f);
    assertEquals(calc.evaluate("5 5 / 5 / 5 /"), 0.04f);
    assertEquals(calc.evaluate("1000 10 / 5 / 2 / 1 /"), 10f);
    assertEquals(calc.evaluate("9999999 11 /"), 909090.818f);
  }

  @Test // Test 6
  public void testDecimal() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("4.2 6.7 +"), 10.9f);
    assertEquals(calc.evaluate("9.2 6.1 -"), 3.1f);
    assertEquals(calc.evaluate("7.2 3.6 /"), 2f);
    assertEquals(calc.evaluate("2.5 6 *"), 15f);
  }

  @Test // Test 7
  public void testNegative() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("-4 -2 +"), -6f);
    assertEquals(calc.evaluate("-12 5 -"), -17f);
    assertEquals(calc.evaluate("-3 12 *"), -36f);
    assertEquals(calc.evaluate("-12 -4 /"), 3f);
    assertEquals(calc.evaluate("-1.2 -2.4 *"), 2.88f);
    assertEquals(calc.evaluate("-1000 999 *"), -999000f);
  }

  @Test // Test 8
  public void testComplex() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("8 3 7 + / 4 -"), -3.2f);
    assertEquals(calc.evaluate("4 7 * 5 / 4 2 - *"), 11.2f);
    assertEquals(calc.evaluate("9.3 42.1 * 27 3 / -"), 382.53f);
    assertEquals(calc.evaluate("4 7 * 2 / 4 3 * *"), 168f);
  }
}
