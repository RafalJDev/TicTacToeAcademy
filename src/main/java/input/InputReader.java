package input;

import javafx.scene.Scene;

import java.util.Scanner;
import java.util.function.Supplier;

public class InputReader {
  
  private static Scanner scanner = new Scanner(System.in);
  
  public static String readLine() {
    
    String nextLine;
    boolean isValid = true;
    do {
      nextLine = scanner.nextLine();
      isValid = InputValidator.checkInput(nextLine);
    } while (!isValid);
    return nextLine;
  }
}
