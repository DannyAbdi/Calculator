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
    
  }
  
  @Test // Test 2
  public void test() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("22 2 +"), 24f);
  }
}