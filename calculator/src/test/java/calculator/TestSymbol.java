package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestSymbol {

  @Test
  // Tests if Symbol enum is printable and in the correct format
  void testPrintableSymbol() {
    assertEquals(Symbol.LEFT_BRACKET.toString(), "(");
    assertEquals(Symbol.PLUS.toString(), "+");
    assertEquals(Symbol.INVALID.toString(), "Invalid");
  }

}
