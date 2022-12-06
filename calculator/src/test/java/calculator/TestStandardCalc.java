package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {
  private StandardCalc calc;

  @BeforeEach
  public void setup() {
    calc = new StandardCalc();
  }
  
  @Test // Test 1
  public void testSimple() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("1 + 2"), 3f);
  }

}
