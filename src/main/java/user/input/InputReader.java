package user.input;

import user.input.valid.Valid;
import user.input.valid.ValidNumber;

import java.util.Scanner;
import java.util.function.Supplier;

public class InputReader {
  
  public static int readLine(Supplier<String> supplier) {
    
    String nextLine;
    Valid validState = null;
    do {
      nextLine = supplier.get();
      validState = InputValidator.checkInput(nextLine);
      
    } while (isNotValid(validState));
    
    return Integer.parseInt(nextLine);
  }
  
  public static boolean isNotValid(Valid validState) {
    return validState.getClass() != ValidNumber.class;
  }
  
}
