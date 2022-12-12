package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {
  private CalcModel test;

  @BeforeEach
  public void setup() {
    test = new CalcModel();
  }

  @Test
  public void test() throws InvalidExpressionException, BadTypeException {
    assertEquals(test.evaluate("3 + 8", true), 11f);
    assertEquals(test.evaluate("7 8 -", false), -1f);
    assertEquals(test.evaluate("( 7 * 3 ) + 2", true), 23f);
    assertEquals(test.evaluate("7 2 / 10 * 32 -", false), 3f);
  }
}
