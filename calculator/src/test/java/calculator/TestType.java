package calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestType {

  @Test
  // Tests if the enum Type is printable and in the correct format
  void testPrintableType() {
    assertEquals(Type.STRING.toString(), "String");
    assertEquals(Type.SYMBOL.toString(), "Symbol");
    assertEquals(Type.INVALID.toString(), "Invalid");
  }

}
