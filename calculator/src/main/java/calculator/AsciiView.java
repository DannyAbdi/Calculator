package calculator;

import java.util.Observer;
import java.util.Scanner;

/**
 * Allows user to use calculator through command line.
 * 
 * @author Dave Cohen
 *
 */
public class AsciiView implements ViewInterface {
  private String question;
  private String expression;
  private String answer;
  Observer calc = null;
  Observer type = null;
  Observer reset = null;

  /**
   * Reads user input and notifies observers.
   */
  public void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();
    
    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.toUpperCase().charAt(0)) {
        case 'C':
          if (calc != null) {
            calc.notify();
          }
          break;
        case 'R':
          if (reset != null) {
            reset.notify();
          }
          break;
        case '?':
          question = t.substring(1);
          System.out.println("Question set to: " + question);
          break;
        case 'Q':
          System.out.println("Bye");
          finished = true;
          break;
        default:
          help();
      }
    }
    s.close();
  }
  
  /**
   * Gives a series of options for the user to take.
   */
  public void help() {
    System.out.println("Use one of the following:");
    System.out.println("  ?Expression - to set expression");
    System.out.println("  C - to calculate");
    System.out.println("  R - to reset the calculator");
    System.out.println("  Q - to exit");
  }

  @Override
  public String getExpression() {
    return this.expression;
  }

  @Override
  public void setAnswer(String str) {
    this.answer = str;

  }

  @Override
  public void addCalcObserver(Observer f) {
    calc = f;
  }

  @Override
  public void addTypeObserver(Observer l) {
    type = l;
  }
  
  @Override
  public void addResetObserver(Observer x) {
    reset = x;
  }
}
