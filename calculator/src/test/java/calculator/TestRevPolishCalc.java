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

  @Test // Test 1
  public void testInvalid() {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate(""));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("(2 + 2) * 3"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("2 +"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("2 0 /"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("2 2 n"));
  }

  @Test // Test 2
  public void test() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("2 2 +"), 4f);
  }
}
