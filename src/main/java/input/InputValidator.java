package input;

import output.message.MessagePrinter;
import output.message.Messages;

public class InputValidator {
  
  public static boolean checkInput(String nextLine) {
    
    boolean isGreaterThanZero = false;
    try {
      isGreaterThanZero = Integer.parseInt(nextLine) >= 0;
    } catch (NumberFormatException e) {
      MessagePrinter.printMessage(nextLine + " is not a number!");
      e.printStackTrace();
      return isGreaterThanZero;
    }
    if (!isGreaterThanZero) {
      MessagePrinter.printMessage(nextLine + " must be greater than 0! Please enter again: ");
    }
    return isGreaterThanZero;
  }
}
